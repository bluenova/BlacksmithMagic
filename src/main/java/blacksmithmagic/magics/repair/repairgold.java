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
public class repairgold extends MagePluginEvent {

    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            Material itype = item.getType();
            if (itype == Material.GOLD_AXE) {
                item.setDurability(Material.GOLD_AXE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.GOLD_HOE) {
                item.setDurability(Material.GOLD_HOE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.GOLD_PICKAXE) {
                item.setDurability(Material.GOLD_PICKAXE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.GOLD_SPADE) {
                item.setDurability(Material.GOLD_SPADE.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            } else if (itype == Material.GOLD_SWORD) {
                item.setDurability(Material.GOLD_SWORD.getMaxDurability());
                event.getPlayer().sendMessage("Mana decreesed!");
                event.getPlayer().setItemInHand(item);
                return true;
            }
        }
        return false;
    }
}
