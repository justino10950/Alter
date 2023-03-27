import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.plugins.content.npcs.farm.ram.Farm


Farm.RAM_NPCS.forEach { ram ->

    set_combat_def(ram) {
        configs {
            attackSpeed = 4
            respawnDelay = 50
            attackStyle = CombatStyle.CRUSH
        }

        stats {
            hitpoints = 8
            attack = 1
            strength = 1
            defence = 1
            magic = 1
            ranged = 1
        }

        bonuses {
            attackCrush = -15
            strengthBonus = -15
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
            attack = 5338
            block = 5337
            death = 5336
        }

        slayerData {
            levelRequirement = 10
            xp = 10.0
        }
    }
}