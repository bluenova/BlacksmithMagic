package blacksmithmagic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import blacksmithmagic.commands.blacksmithCommands;
import blacksmithmagic.magics.enchant.bigenchant;
import blacksmithmagic.magics.destroy.destroymagic;
import blacksmithmagic.magics.enchant.mediumEnchant;
import blacksmithmagic.magics.enchant.simpleEnchant;
import blacksmithmagic.magics.repair.repairdiamond;
import blacksmithmagic.magics.repair.repairgold;
import blacksmithmagic.magics.repair.repairiron;
import blacksmithmagic.magics.repair.repairstone;
import blacksmithmagic.magics.repair.repairwood;
import bluenova.fairytailcraft.event.MageEventType;
import bluenova.fairytailcraft.plugin.MagePlugin;
import bluenova.fairytailcraft.plugin.MagePluginManager;
import java.util.HashMap;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

/**
 *
 * @author Sven
 */
public class BlacksmithMagic implements MagePlugin {

    private String magicName = "BlacksmithMagic";
    public static MagePluginManager manager;
    public static HashMap<String, Enchantment> simpleEnchants = new HashMap<String, Enchantment>();
    public static HashMap<String, Enchantment> mediumEnchants = new HashMap<String, Enchantment>();
    public static HashMap<String, Enchantment> bigEnchants = new HashMap<String, Enchantment>();
    public static HashMap<Player, Enchantment> activeSEnchants = new HashMap<Player, Enchantment>();
    public static HashMap<Player, Enchantment> activeMEnchants = new HashMap<Player, Enchantment>();
    public static HashMap<Player, Enchantment> activeBEnchants = new HashMap<Player, Enchantment>();

    public void setPluginManager(MagePluginManager manager) {
        BlacksmithMagic.manager = manager;
    }

    public void loadPlugin() {
        setupEnchants();
        BlacksmithMagic.manager.registerCommandListener(blacksmithCommands.class, this);
        setupMagics();

        System.out.println("BlacksmithMagic Successfully Load!");
    }

    private void setupMagics() {
        BlacksmithMagic.manager.registerMagic("repairwood", magicName, 1, 10, new repairwood(), MageEventType.INTERACT, false, new Long(100));
        BlacksmithMagic.manager.registerMagic("simpleenchant", magicName, 4, 17, new simpleEnchant(), MageEventType.INTERACT, false, new Long(100));
        BlacksmithMagic.manager.registerMagic("repairstone", magicName, 5, 20, new repairstone(), MageEventType.INTERACT, false, new Long(100));
        BlacksmithMagic.manager.registerMagic("repairiron", magicName, 10, 30, new repairiron(), MageEventType.INTERACT, false, new Long(100));
        BlacksmithMagic.manager.registerMagic("mediumenchant", magicName, 14, 39, new mediumEnchant(), MageEventType.INTERACT, false, new Long(100));
        BlacksmithMagic.manager.registerMagic("repairgold", magicName, 15, 40, new repairgold(), MageEventType.INTERACT, false, new Long(100));
        BlacksmithMagic.manager.registerMagic("destroyweapon", magicName, 17, 40, new destroymagic(), MageEventType.INTERACT, false, new Long(10000));
        BlacksmithMagic.manager.registerMagic("repairdiamond", magicName, 20, 50, new repairdiamond(), MageEventType.INTERACT, false, new Long(100));
        BlacksmithMagic.manager.registerMagic("bigenchant", magicName, 22, 54, new bigenchant(), MageEventType.INTERACT, false, new Long(100));
    }

    private void setupEnchants() {
        simpleEnchants.put("aquaaffinity", Enchantment.WATER_WORKER);
        simpleEnchants.put("protection", Enchantment.PROTECTION_ENVIRONMENTAL);
        simpleEnchants.put("sharpness", Enchantment.DAMAGE_ALL);
        simpleEnchants.put("power", Enchantment.ARROW_DAMAGE);
        simpleEnchants.put("efficiency", Enchantment.DIG_SPEED);

        mediumEnchants.put("featherfalling", Enchantment.PROTECTION_FALL);
        mediumEnchants.put("fireprotection", Enchantment.PROTECTION_FIRE);
        mediumEnchants.put("blastprotection", Enchantment.PROTECTION_EXPLOSIONS);
        mediumEnchants.put("projectileprotection", Enchantment.PROTECTION_PROJECTILE);
        mediumEnchants.put("respiration", Enchantment.OXYGEN);
        mediumEnchants.put("arthropods", Enchantment.DAMAGE_ARTHROPODS);
        mediumEnchants.put("smite", Enchantment.DAMAGE_UNDEAD);
        mediumEnchants.put("fireaspect", Enchantment.FIRE_ASPECT);
        mediumEnchants.put("knockback", Enchantment.KNOCKBACK);
        mediumEnchants.put("punch", Enchantment.ARROW_KNOCKBACK);
        mediumEnchants.put("unbreaking", Enchantment.DURABILITY);

        bigEnchants.put("flame", Enchantment.ARROW_FIRE);
        bigEnchants.put("infinity", Enchantment.ARROW_INFINITE);
        bigEnchants.put("fortune", Enchantment.LOOT_BONUS_BLOCKS);
        bigEnchants.put("looting", Enchantment.LOOT_BONUS_MOBS);
        bigEnchants.put("silktouch", Enchantment.SILK_TOUCH);
    }

    public void unloadPlugin() {
        System.out.println("BlacksmithMagic Successfully Unload!");
    }

    public String getMagicName() {
        return magicName;
    }
}
