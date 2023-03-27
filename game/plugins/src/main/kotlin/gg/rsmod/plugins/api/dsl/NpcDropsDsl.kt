package gg.rsmod.plugins.api.dsl

import gg.rsmod.game.model.Tile
import gg.rsmod.game.model.World
import gg.rsmod.game.model.entity.GroundItem
import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.plugin.KotlinPlugin
import gg.rsmod.plugins.api.cfg.Items
import java.lang.Exception
import kotlin.random.Random



data class ItemDrop(val id: Int, val dropChance: Double, val countLower: Int = 1, val countUpper: Int = 1)

enum class DropMode { SINGLE, ALL }
data class DropTableDrop(val dropTable: DropTable, val dropChance: Double, val dropMode: DropMode)


data class DropTable(val items: MutableList<ItemDrop>, val subTables: MutableList<DropTableDrop>) {
    fun drop(dropMode: DropMode): Sequence<ItemDrop> = sequence<ItemDrop> {
        if(dropMode == DropMode.ALL) {
            yieldAll(dropAll())
        }
        else {
            var item = dropSingle()
            if(item != null) {
                yield(item)
            }
        }
    }

    fun dropAll(): Sequence<ItemDrop> = sequence<ItemDrop> {
        items.forEach {
            var rand = Random.nextDouble()
            if(rand <= it.dropChance) {
                yield(it)
            }
        }
        subTables.forEach {
            var rand = Random.nextDouble()
            if(rand <= it.dropChance) {
                yieldAll(it.dropTable.drop(it.dropMode))
            }
        }
    }

    fun dropSingle(): ItemDrop? {
        var rand = Random.nextDouble()
        var aggregate = 0.0
        items.forEach {
            aggregate += it.dropChance
            if(rand < aggregate) {
                return it
            }
        }
        subTables.forEach {
            if(it.dropMode != DropMode.SINGLE) {
                throw Exception("Drop mode of subtable in single mode drop table is not single!")
            }
            aggregate += it.dropChance
            if(rand < aggregate) {
                return it.dropTable.dropSingle()
            }
        }
        return null
    }

    fun dropAll(tile: Tile, world: World, player: Player?) {
        dropAll().forEach {
            var count = it.countLower;
            if(it.countLower < it.countUpper) {
                count = Random.nextInt(it.countLower, it.countUpper);
            }
            world.spawn(GroundItem(it.id, count, tile, player))
        }
    }
}

class DropTableBuilder() {
    val items = mutableListOf<ItemDrop>()
    val subTables = mutableListOf<DropTableDrop>()

    fun item(id: Int, dropChance: Double) {
        items.add(ItemDrop(id, dropChance))
    }

    fun item(id: Int, dropChance: Double, countLower: Int, countUpper: Int) {
        items.add(ItemDrop(id, dropChance, countLower, countUpper))
    }

    fun item(id: Int, dropChance: Double, count: Int) {
        items.add(ItemDrop(id, dropChance, count, count))
    }

    fun subTable(table: DropTable) {
        subTables.add(DropTableDrop(table, 1.0, DropMode.SINGLE))
    }

    fun subTable(table: DropTable, dropChance: Double) {
        subTables.add(DropTableDrop(table, dropChance, DropMode.SINGLE))
    }

    fun subTable(block: DropTableBuilder.() -> Unit = {}) {
        val builder = DropTableBuilder()
        builder.block()
        subTables.add(DropTableDrop(builder.build(), 1.0, DropMode.SINGLE))
    }

    fun subTable(dropChance: Double, block: DropTableBuilder.() -> Unit = {}) {
        val builder = DropTableBuilder()
        builder.block()
        subTables.add(DropTableDrop(builder.build(), dropChance, DropMode.SINGLE))
    }

    fun dropChanceCount() {
        var chance = 0.0
        items.forEach {
            chance += it.dropChance
        }
        subTables.forEach {
            chance += it.dropChance
        }
    }

    fun build(): DropTable {
        return DropTable(items, subTables)
    }
}

fun dropTable(block: DropTableBuilder.() -> Unit): DropTable {
    val builder = DropTableBuilder()
    builder.block()
    return builder.build()
}


var herbDropTable = dropTable {
    item(Items.GRIMY_GUAM_LEAF, 32/128.0)
    item(Items.GRIMY_MARRENTILL, 24/128.0)
    item(Items.GRIMY_TARROMIN, 18/128.0)
    item(Items.GRIMY_HARRALANDER, 14/128.0)
    item(Items.GRIMY_RANARR_WEED, 11/128.0)
    item(Items.GRIMY_IRIT_LEAF, 8/128.0)
    item(Items.GRIMY_AVANTOE, 6/128.0)
    item(Items.GRIMY_KWUARM, 5/128.0)
    item(Items.GRIMY_CADANTINE, 4/128.0)
    item(Items.GRIMY_LANTADYME, 3/128.0)
    item(Items.GRIMY_DWARF_WEED, 3/128.0)
}