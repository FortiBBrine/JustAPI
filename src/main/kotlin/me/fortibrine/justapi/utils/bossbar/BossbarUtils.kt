package me.fortibrine.justapi.utils.bossbar

import me.fortibrine.justapi.main.JustAPI
import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarFlag
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.entity.Player

class BossbarUtils() {

    private var plugin: JustAPI? = null
    constructor(plugin: JustAPI) : this() {
        this.plugin = plugin
    }

    fun sendBossbar(player: Player, title: String?, barColor: BarColor, barStyle: BarStyle, barFlags: Array<BarFlag>) {

        val bossBar: BossBar = Bukkit.createBossBar(title, barColor, barStyle, *barFlags)

        bossBar.players.add(player);
    }

}