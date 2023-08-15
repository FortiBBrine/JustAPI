package me.fortibrine.justapi.utils.inventory

import me.fortibrine.justapi.main.JustAPI
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class InventoryUtils() {

    private var plugin: JustAPI? = null
    constructor(plugin: JustAPI) : this() {
        this.plugin = plugin
    }

    fun getItemsAmount(inventory: Inventory): MutableMap<ItemStack, Int> {
        var result: MutableMap<ItemStack, Int> = mutableMapOf()

        inventory.contents.forEach { item ->
            run {
                if (item != null) {
                    result[item] = item.amount
                }
            }
        }

        return result

    }

    fun hasItemIgnoreAmount(inventory: Inventory, item: ItemStack): Boolean {
        inventory.contents.forEach { inventoryItem ->
            run {
                if (inventoryItem != null) {
                    if (inventoryItem.isSimilar(item)) {
                        return true
                    }
                }
            }
        }

        return false
    }

}