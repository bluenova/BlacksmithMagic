/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blacksmithmagic.magics.enchant.destroy;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Sven
 */
public class destroymagic extends MagePluginEvent{

    @Override
    public boolean callEntityDamageByEntityEvent(EntityDamageByEntityEvent event, Integer level) {
        if(event.getEntity() instanceof Player) {
            Player pl = (Player) event.getEntity();
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
