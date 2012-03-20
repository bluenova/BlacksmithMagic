/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blacksmithmagic.magics.repair;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Sven
 */
public class repairstone extends MagePluginEvent {

    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            Material itype = item.getType();
            if (itype == Material.STONE_AXE) {
                item.setDurability(Material.STONE_AXE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.STONE_HOE) {
                item.setDurability(Material.STONE_HOE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.STONE_PICKAXE) {
                item.setDurability(Material.STONE_PICKAXE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.STONE_SPADE) {
                item.setDurability(Material.STONE_SPADE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.STONE_SWORD) {
                item.setDurability(Material.STONE_SWORD.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            }
        }
        return false;
    }
}
