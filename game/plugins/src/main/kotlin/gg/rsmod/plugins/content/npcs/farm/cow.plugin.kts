import gg.rsmod.plugins.content.npcs.farm.ram.Farm

val cowTable = dropTable {
    item(Items.BONES, 1.0)
    item(Items.RAW_BEEF, 1.0)
    item(Items.COWHIDE, 1.0)
}
Farm.COW_NPCS.forEach { cow ->

    set_combat_def(cow) {
        configs {
            attackSpeed = 4
            respawnDelay = 50
        }

        stats {
            hitpoints = 8
            magic = 1
            defence = 1
        }

        anims {
            attack = 5849
            block = 5850
            death = 5851
        }
    }
    on_npc_death(cow) {
        cowTable.dropAll(npc.tile, world, null)
    }
}