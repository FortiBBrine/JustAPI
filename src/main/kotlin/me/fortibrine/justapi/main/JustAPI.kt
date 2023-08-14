package me.fortibrine.justapi.main

import org.bukkit.plugin.java.JavaPlugin

class JustAPI: JavaPlugin() {

    companion object {
        var instance: JustAPI? = null
            private set
    }

    override fun onEnable() {
        super.onEnable()

        instance = this

        println("hello")

    }

    override fun onDisable() {
        super.onDisable()

        instance = null
    }
}