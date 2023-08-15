package me.fortibrine.justapi.utils.block

import me.fortibrine.justapi.main.JustAPI
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block

class BlockUtil(private val plugin: JustAPI) {
    fun setBlock(x: Int, y: Int, z: Int, world: World, type: Material) {
        world.getBlockAt(x, y, z).type = type
    }

    fun setBlock(blocks: Collection<Block>, type: Material) {
        blocks.forEach{ block ->
            run {
                block.type = type
            }
        }
    }

    fun setBlock(startBlock: Block, endBlock: Block, blockType: Material, newBlockType: Material): Boolean {
        if (startBlock.world.name.equals(endBlock.world.name)) return false
        val world = startBlock.world

        val x1 = startBlock.x.coerceAtMost(endBlock.x)
        val x2 = startBlock.x.coerceAtLeast(endBlock.x)

        val y1 = startBlock.y.coerceAtMost(endBlock.y)
        val y2 = startBlock.y.coerceAtLeast(endBlock.y)

        val z1 = startBlock.z.coerceAtMost(endBlock.z)
        val z2 = startBlock.z.coerceAtLeast(endBlock.z)

        for (x in x1..x2) {
            for (y in y1..y2) {
                for (z in z1..z2) {
                    val block = world.getBlockAt(x, y, z)
                    if (block.type == blockType) {
                        block.type = newBlockType
                    }
                }
            }
        }
        return true
    }

    fun set(startBlock: Block, endBlock: Block, blockType: Material): Boolean {
        if (startBlock.world.name.equals(endBlock.world.name)) return false
        val world = startBlock.world

        val x1 = startBlock.x.coerceAtMost(endBlock.x)
        val x2 = startBlock.x.coerceAtLeast(endBlock.x)

        val y1 = startBlock.y.coerceAtMost(endBlock.y)
        val y2 = startBlock.y.coerceAtLeast(endBlock.y)

        val z1 = startBlock.z.coerceAtMost(endBlock.z)
        val z2 = startBlock.z.coerceAtLeast(endBlock.z)

        for (x in x1..x2) {
            for (y in y1..y2) {
                for (z in z1..z2) {
                    val block = world.getBlockAt(x, y, z)
                    block.type = blockType
                }
            }
        }
        return true
    }
}