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
public class repairiron extends MagePluginEvent {

    @Override
    public boolean callPlayerInteractEvent(PlayerInteractEvent event, Integer level) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if (item != null) {
                Material itype = item.getType();
                if (itype == Material.IRON_AXE) {
                    item.setDurability((short) 0);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    event.getPlayer().setItemInHand(item);
                    return true;
                } else if (itype == Material.IRON_HOE) {
                    item.setDurability((short) 0);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    event.getPlayer().setItemInHand(item);
                    return true;
                } else if (itype == Material.IRON_PICKAXE) {
                    item.setDurability((short) 0);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    event.getPlayer().setItemInHand(item);
                    return true;
                } else if (itype == Material.IRON_SPADE) {
                    item.setDurability((short) 0);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    event.getPlayer().setItemInHand(item);
                    return true;
                } else if (itype == Material.IRON_SWORD) {
                    item.setDurability((short) 0);
                    event.getPlayer().sendMessage("Mana decreesed!");
                    event.getPlayer().setItemInHand(item);
                    return true;
                }
            }
        }
        return false;
    }
}
