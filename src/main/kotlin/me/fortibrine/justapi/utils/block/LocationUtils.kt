package me.fortibrine.justapi.utils.block

import me.fortibrine.justapi.main.JustAPI
import org.bukkit.Location
import org.bukkit.World

class LocationUtils() {

    private var plugin: JustAPI? = null
    constructor(plugin: JustAPI) : this() {
        this.plugin = plugin
    }

    fun getMinLocation(locationFirst: Location, locationSecond: Location): Location? {
        if (locationFirst.world?.name.equals(locationSecond.world?.name)) return null
        val world = locationFirst.world

        val x = locationFirst.x.coerceAtMost(locationSecond.x)
        val y = locationFirst.y.coerceAtMost(locationSecond.y)
        val z = locationFirst.z.coerceAtMost(locationSecond.z)

        return Location(world, x, y, z)
    }

    fun getMaxLocation(locationFirst: Location, locationSecond: Location): Location? {
        if (locationFirst.world?.name.equals(locationSecond.world?.name)) return null
        val world = locationFirst.world

        val x = locationFirst.x.coerceAtLeast(locationSecond.x)
        val y = locationFirst.y.coerceAtLeast(locationSecond.y)
        val z = locationFirst.z.coerceAtLeast(locationSecond.z)

        return Location(world, x, y, z)
    }

    fun getCenter(locationFirst: Location, locationSecond: Location): Location? {
        if (!locationFirst.world?.name.equals(locationSecond.world?.name)) return null;

        val world: World? = locationFirst.world

        val x = (locationFirst.x + locationSecond.x) / 2
        val y = (locationFirst.y + locationSecond.y) / 2
        val z = (locationFirst.z + locationSecond.z) / 2

        return Location(world, x, y, z)
    }

}