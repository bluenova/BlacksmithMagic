/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blacksmithmagic.magics.destroy;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockIterator;

/**
 *
 * @author Sven
 */
public class destroymagic extends MagePluginEvent {

    @Override
    public boolean callPlayerInteractEntityEvent(PlayerInteractEntityEvent event, Integer integer) {
        if (event.getRightClicked() instanceof Player) {
            Player pl = event.getPlayer();
            int range = 4;
            Player ent = null;
            List<Entity> nearbyE = pl.getNearbyEntities(range,
                    range, range);
            ArrayList<Player> livingE = new ArrayList<Player>();

            for (Entity e : nearbyE) {
                if (e instanceof Player) {
                    livingE.add((Player) e);
                }
            }

            ent = null;
            BlockIterator bItr = new BlockIterator(pl, range);
            Block block;
            Location loc;
            int bx, by, bz;
            double ex, ey, ez;
            // loop through player's line of sight
            while (bItr.hasNext()) {
                block = bItr.next();
                bx = block.getX();
                by = block.getY();
                bz = block.getZ();
                // check for entities near this block in the line of sight
                for (Player e : livingE) {
                    loc = e.getLocation();
                    ex = loc.getX();
                    ey = loc.getY();
                    ez = loc.getZ();
                    if ((bx - .75 <= ex && ex <= bx + 1.75) && (bz - .75 <= ez && ez <= bz + 1.75) && (by - 1 <= ey && ey <= by + 2.5)) {
                        // entity is close enough, set target and stop
                        ent = e;
                        break;
                    }
                }
            }
            ItemStack itemInHand = ent.getItemInHand();
            if (itemInHand != null) {
                if (itemInHand.getType().getMaxDurability() < 1) {
                    return false;
                }

                itemInHand.setDurability(itemInHand.getType().getMaxDurability());
                ent.setItemInHand(itemInHand);
            }
        }
        return false;
    }
}
