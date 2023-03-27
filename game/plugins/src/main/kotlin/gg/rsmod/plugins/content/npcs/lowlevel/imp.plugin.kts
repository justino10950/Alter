import gg.rsmod.game.model.combat.CombatStyle
import kotlin.random.Random


arrayOf(5007).forEach { id ->
    set_combat_def(id) {
        configs {
            attackSpeed = 4
            respawnDelay = 50
            attackStyle = CombatStyle.STAB
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
            attackStab = -42
            strengthBonus = -37
            attackMagic = 0
            magicDamageBonus = 0
            attackRanged = 0
            rangedStrengthBonus = 0
            defenceStab = -42
            defenceSlash = -42
            defenceCrush = -42
            defenceMagic = -42
            defenceRanged = -42
        }
        anims {
            attack = 169
            block = 170
            death = 172
        }
    }
    on_npc_death(id) {
        table.dropAll(npc.tile, world, null)
    }
}
arrayOf(3134).forEach { id ->
    set_combat_def(id) {
        configs {
            attackSpeed = 4
            respawnDelay = 60
            attackStyle = CombatStyle.STAB
        }
        stats {
            hitpoints = 10
            attack = 5
            strength = 5
            defence = 6
            magic = 1
            ranged = 1
        }
        bonuses {
            attackStab = -42
            strengthBonus = -37
            attackMagic = 0
            magicDamageBonus = 0
            attackRanged = 0
            rangedStrengthBonus = 0
            defenceStab = -42
            defenceSlash = -42
            defenceCrush = -42
            defenceMagic = -42
            defenceRanged = -42
        }
        anims {
            attack = 169
            block = 170
            death = 172
        }
    }
    on_npc_death(id) {
        table.dropAll(npc.tile, world, null)
    }
}

val table = dropTable {
    item(Items.FIENDISH_ASHES, 1.0)
    subTable {
        item(Items.BLACK_BEAD, 5/128.0)
        item(Items.RED_BEAD, 5/128.0)
        item(Items.WHITE_BEAD, 5/128.0)
        item(Items.YELLOW_BEAD, 5/128.0)
        item(Items.BRONZE_BOLTS, 8/128.0)
        item(Items.BLUE_WIZARD_HAT, 8/128.0)
        item(Items.EGG, 5/128.0)
        item(Items.RAW_CHICKEN, 5/128.0)
        item(Items.BURNT_BREAD, 4/128.0)
        item(Items.BURNT_MEAT, 4/128.0)
        item(Items.CABBAGE, 2/128.0)
        item(Items.BREAD_DOUGH, 2/128.0)
        item(Items.BREAD, 1/128.0)
        item(Items.COOKED_MEAT, 1/128.0)
        item(Items.HAMMER, 8/128.0)
        item(Items.TINDERBOX, 5/128.0)
        item(Items.SHEARS, 4/128.0)
        item(Items.BUCKET, 4/128.0)
        item(Items.BUCKET_OF_WATER, 2/128.0)
        item(Items.JUG, 2/128.0)
        item(Items.JUG_OF_WATER, 2/128.0)
        item(Items.POT, 2/128.0)
        item(Items.POT_OF_FLOUR, 2/128.0)
        item(Items.BALL_OF_WOOL, 8/128.0)
        item(Items.MIND_TALISMAN, 7/128.0)
        item(Items.ASHES, 6/128.0)
        item(Items.CLAY, 4/128.0)
        item(Items.CADAVA_BERRIES, 4/128.0)
        item(Items.GRAIN, 3/128.0)
        item(Items.CHEFS_HAT, 2/128.0)
        item(Items.FLYER, 2/128.0)
        item(Items.POTION, 1/128.0)
    }
}

// North of [[Kourend Castle]]
spawn_npc(5007, 1616, 3704, 0, 5)
// West of [[Tithe Farm]]
spawn_npc(5007, 1798, 3491, 0, 5)
spawn_npc(5007, 1750, 3506, 0, 5)
spawn_npc(5007, 1758, 3510, 0, 5)
spawn_npc(5007, 1734, 3511, 0, 5)
spawn_npc(5007, 1740, 3480, 0, 5)
spawn_npc(5007, 1744, 3484, 0, 5)
spawn_npc(5007, 1748, 3480, 0, 5)
spawn_npc(5007, 1759, 3481, 0, 5)
spawn_npc(5007, 1762, 3476, 0, 5)
spawn_npc(5007, 1770, 3478, 0, 5)
// Outside the [[Chasm of Fire]]
spawn_npc(5007, 1429, 3663, 0, 5)
spawn_npc(5007, 1431, 3675, 0, 5)
spawn_npc(5007, 1432, 3672, 0, 5)
spawn_npc(5007, 1435, 3660, 0, 5)
spawn_npc(5007, 1439, 3680, 0, 5)
spawn_npc(5007, 1442, 3672, 0, 5)
// South of [[Port Piscarilius]]
spawn_npc(5007, 1792, 3648, 0, 5)
spawn_npc(5007, 1794, 3654, 0, 5)
// [[Draynor Village]]
spawn_npc(5007, 3073, 3250, 0, 5)
// [[Rimmington]]
spawn_npc(5007, 2941, 3236, 0, 5)
// Scattered around [[Varrock]]
spawn_npc(5007, 3261, 3514, 0, 5)
spawn_npc(5007, 3246, 3458, 0, 5)
spawn_npc(5007, 3177, 3405, 0, 5)
spawn_npc(5007, 3205, 3355, 0, 5)
spawn_npc(5007, 3234, 3506, 0, 5)
spawn_npc(5007, 3134, 3487, 0, 5)
spawn_npc(5007, 3238, 3390, 0, 5)
spawn_npc(5007, 3213, 3502, 0, 5)
// [[Edgeville]]
spawn_npc(5007, 3073, 3498, 0, 5)
spawn_npc(5007, 3078, 3499, 0, 5)
spawn_npc(5007, 3078, 3461, 0, 5)
// East of [[Ardougne Monastery]]
spawn_npc(5007, 2625, 3203, 0, 5)
spawn_npc(5007, 2625, 3217, 0, 5)
spawn_npc(5007, 2629, 3233, 0, 5)
spawn_npc(5007, 2630, 3210, 0, 5)
spawn_npc(5007, 2632, 3202, 0, 5)
spawn_npc(5007, 2633, 3222, 0, 5)
spawn_npc(5007, 2633, 3243, 0, 5)
spawn_npc(5007, 2639, 3206, 0, 5)
spawn_npc(5007, 2639, 3230, 0, 5)
// [[Lumbridge Castle]]
spawn_npc(5007, 3217, 3226, 0, 5)
// North of [[Lumbridge]]
spawn_npc(5007, 3214, 3281, 0, 5)
spawn_npc(5007, 3240, 3307, 0, 5)
// Western [[Falador]]
spawn_npc(5007, 2951, 3360, 0, 5)
spawn_npc(5007, 2947, 3329, 0, 5)
// East of [[Kingstown]]
spawn_npc(5007, 1734, 3700, 0, 5)
spawn_npc(5007, 1749, 3702, 0, 5)
spawn_npc(5007, 1750, 3708, 0, 5)
spawn_npc(5007, 1696, 3683, 0, 5)
spawn_npc(5007, 1703, 3688, 0, 5)
// [[Farming Guild]]
spawn_npc(5007, 1283, 3720, 0, 5)
// [[Al Kharid mine]]
spawn_npc(5007, 3299, 3273, 0, 5)
// South of [[Falador]]
spawn_npc(5007, 3009, 3307, 0, 5)
spawn_npc(5007, 3011, 3314, 0, 5)
spawn_npc(5007, 3015, 3314, 0, 5)
// North of the [[Woodcutting Guild]]
spawn_npc(5007, 1623, 3527, 0, 5)
spawn_npc(5007, 1639, 3524, 0, 5)
spawn_npc(5007, 1634, 3553, 0, 5)
// [[Karamja Volcano]]
spawn_npc(5007, 2832, 3170, 0, 5)
spawn_npc(5007, 2832, 3177, 0, 5)
spawn_npc(5007, 2837, 3184, 0, 5)
spawn_npc(5007, 2841, 3163, 0, 5)
spawn_npc(5007, 2849, 3186, 0, 5)
spawn_npc(5007, 2850, 3165, 0, 5)
spawn_npc(5007, 2857, 3179, 0, 5)
spawn_npc(5007, 2859, 3177, 0, 5)
// North of [[Yanille]]
spawn_npc(5007, 2595, 3131, 0, 5)
spawn_npc(5007, 2597, 3120, 0, 5)
spawn_npc(5007, 2606, 3126, 0, 5)
spawn_npc(5007, 2608, 3134, 0, 5)
spawn_npc(5007, 2614, 3116, 0, 5)
spawn_npc(5007, 2616, 3126, 0, 5)
spawn_npc(5007, 2621, 3133, 0, 5)
spawn_npc(5007, 2622, 3118, 0, 5)
// [[God Wars Dungeon]]
spawn_npc(3134, 2839, 5344, 0, 5)
spawn_npc(3134, 2886, 5313, 0, 5)
spawn_npc(3134, 2898, 5313, 0, 5)
spawn_npc(3134, 2902, 5357, 0, 5)
spawn_npc(3134, 2907, 5348, 0, 5)
spawn_npc(3134, 2920, 5356, 0, 5)
spawn_npc(3134, 2925, 5352, 0, 5)
// [[Isle of Souls]]
spawn_npc(5007, 2269, 2853, 0, 5)
spawn_npc(5007, 2267, 2842, 0, 5)
spawn_npc(5007, 2275, 2833, 0, 5)
spawn_npc(5007, 2258, 2831, 0, 5)
// [[Wilderness God Wars Dungeon]]
spawn_npc(3134, 2960, 10102, 0, 5)
spawn_npc(3134, 2966, 10104, 0, 5)
spawn_npc(3134, 2973, 10101, 0, 5)



