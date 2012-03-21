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
public class repairdiamond extends MagePluginEvent {

    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if (item != null) {
                Material itype = item.getType();
                if (itype == Material.DIAMOND_AXE) {
                    item.setDurability((short) 0);
                    event.getPlayer().setItemInHand(item);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    return true;
                } else if (itype == Material.DIAMOND_HOE) {
                    item.setDurability((short) 0);
                    event.getPlayer().setItemInHand(item);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    return true;
                } else if (itype == Material.DIAMOND_PICKAXE) {
                    item.setDurability((short) 0);
                    event.getPlayer().setItemInHand(item);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    return true;
                } else if (itype == Material.DIAMOND_SPADE) {
                    item.setDurability((short) 0);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    event.getPlayer().setItemInHand(item);
                    return true;
                } else if (itype == Material.DIAMOND_SWORD) {
                    item.setDurability((short) 0);
                    event.getPlayer().setItemInHand(item);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    return true;
                }
            }
        }
        return false;
    }
}
