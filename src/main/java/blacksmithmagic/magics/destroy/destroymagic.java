/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blacksmithmagic.magics.destroy;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Sven
 */
public class destroymagic extends MagePluginEvent{

    @Override
    public boolean callPlayerInteractEntityEvent(PlayerInteractEntityEvent event, Integer integer) {
        if(event.getRightClicked() instanceof Player) {
            Player pl = (Player) event.getRightClicked();
            ItemStack itemInHand = pl.getItemInHand();
            if(itemInHand != null) {
                if(itemInHand.getType().getMaxDurability() < 1)
                    return false;
                
                itemInHand.setDurability(itemInHand.getType().getMaxDurability());
                pl.setItemInHand(itemInHand);
            }
        }
        return false;
    } 
}
