import gg.rsmod.game.model.combat.CombatStyle

val cavalier = dropTable {
    item(Items.BONES, 1.0)
}

val table = dropTable {
    item(Items.BONES, 1.0)
    subTable {
        item(Items.BRONZE_MED_HELM, 2/128.0)
        item(Items.IRON_DAGGER, 1/128.0)
        item(Items.BRONZE_BOLTS, 22/128.0, 2, 12)
        item(Items.BRONZE_ARROW, 3/128.0, 7)
        item(Items.EARTH_RUNE, 2/128.0, 4)
        item(Items.FIRE_RUNE, 2/128.0, 6)
        item(Items.MIND_RUNE, 2/128.0, 9)
        item(Items.CHAOS_RUNE, 1/128.0, 2)
        subTable(herbDropTable, 23/128.0)
        item(Items.COINS_995, 38/128.0, 3)
        item(Items.COINS_995, 9/128.0, 5)
        item(Items.COINS_995, 4/128.0, 15)
        item(Items.COINS_995, 1/128.0, 25)
        item(Items.FISHING_BAIT, 5/128.0)
        item(Items.COPPER_ORE, 2/128.0)
        item(Items.EARTH_TALISMAN, 2/128.0)
        item(Items.CABBAGE, 1/128.0)
    }
}
arrayOf(3261).forEach { id ->
    set_combat_def(id) {
        configs {
            attackSpeed = 4
            respawnDelay = 25
            attackStyle = CombatStyle.CRUSH
        }
        stats {
            hitpoints = 7
            attack = 1
            strength = 1
            defence = 1
            magic = 1
            ranged = 1
        }
        bonuses {
            attackCrush = 0
            strengthBonus = 0
            attackMagic = 0
            magicDamageBonus = 0
            attackRanged = 0
            rangedStrengthBonus = 0
            defenceStab = 0
            defenceSlash = 0
            defenceCrush = 0
            defenceMagic = 0
            defenceRanged = 0
        }
        anims {
            attack = 1
            block = 1
            death = 1
        }
    }
    on_npc_death(id) {
        cavalier.dropAll(npc.tile, world, null)
    }
}
arrayOf(3106,6818,6987,8858,3107,6988,3108,6989,3298,3109,6815,3110,3264,3265,3652,3014,11058).forEach { id ->
    set_combat_def(id) {
        configs {
            attackSpeed = 4
            respawnDelay = 25
            attackStyle = CombatStyle.CRUSH
        }
        stats {
            hitpoints = 7
            attack = 1
            strength = 1
            defence = 1
            magic = 1
            ranged = 1
        }
        bonuses {
            attackCrush = 0
            strengthBonus = 0
            attackMagic = 0
            magicDamageBonus = 0
            attackRanged = 0
            rangedStrengthBonus = 0
            defenceStab = -21
            defenceSlash = -21
            defenceCrush = -21
            defenceMagic = -21
            defenceRanged = -21
        }
        anims {
            attack = 422
            block = 424
            death = 836
        }
    }
    on_npc_death(id) {
        table.dropAll(npc.tile, world, null)
    }
}
