package me.fortibrine.justapi.utils.bungeecord

import me.fortibrine.justapi.main.JustAPI
import org.bukkit.entity.Player
import java.io.ByteArrayOutputStream
import java.io.DataOutputStream

class BungeecordUtils(private val plugin: JustAPI) {

    fun sendPlayerToServer(player: Player, server: String) {
        ByteArrayOutputStream().use { b ->
            DataOutputStream(b).use { out ->
                out.writeUTF("Connect")
                out.writeUTF(server)
            }
            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray())
        }
    }

}