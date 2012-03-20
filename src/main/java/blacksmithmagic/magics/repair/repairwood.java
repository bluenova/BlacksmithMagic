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
public class repairwood extends MagePluginEvent {

    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            Material itype = item.getType();
            if (itype == Material.WOOD_AXE) {
                item.setDurability(Material.WOOD_AXE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.WOOD_HOE) {
                item.setDurability(Material.WOOD_HOE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.WOOD_PICKAXE) {
                item.setDurability(Material.WOOD_PICKAXE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.WOOD_SPADE) {
                item.setDurability(Material.WOOD_SPADE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.WOOD_SWORD) {
                item.setDurability(Material.WOOD_SWORD.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            }
        }
        return false;
    }
}
