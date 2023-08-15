package me.fortibrine.justapi.main

import me.fortibrine.justapi.utils.block.BlockUtil
import me.fortibrine.justapi.utils.inventory.InventoryUtils
import me.fortibrine.justapi.utils.block.LocationUtils
import me.fortibrine.justapi.utils.bossbar.BossbarUtils
import me.fortibrine.justapi.utils.bungeecord.BungeecordUtils
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class JustAPI: JavaPlugin() {

    companion object {
        var instance: JustAPI? = null
            private set
    }

    var blockUtil: BlockUtil? = null
        private set

    var inventoryUtils: InventoryUtils? = null
        private set

    var locationUtils: LocationUtils? = null
        private set

    var bossbarUtils: BossbarUtils? = null
        private set

    var bungeecordUtils: BungeecordUtils? = null
        private set

    override fun onEnable() {
        super.onEnable()

        instance = this
        this.blockUtil = BlockUtil(this)
        this.locationUtils = LocationUtils(this)
        this.inventoryUtils = InventoryUtils(this)
        this.bossbarUtils = BossbarUtils(this)

        if (Bukkit.spigot().config.getBoolean("settings.bungeecord")) {
            this.bungeecordUtils = BungeecordUtils(this)
            Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord")
        }
    }

    override fun onDisable() {
        super.onDisable()

        instance = null

        this.blockUtil = null
        this.locationUtils = null
        this.inventoryUtils = null
        this.bossbarUtils = null
        this.bungeecordUtils = null
    }
}