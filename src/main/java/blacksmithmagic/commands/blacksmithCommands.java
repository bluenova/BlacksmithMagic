/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blacksmithmagic.commands;

import bluenova.fairytailcraft.Util.Util;
import bluenova.fairytailcraft.commands.Util.Command;
import bluenova.fairytailcraft.commands.Util.CommandInfo;
import java.util.Set;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import blacksmithmagic.*;
import org.bukkit.ChatColor;

/**
 *
 * @author Sven
 */
public class blacksmithCommands {

    @Command(cmd = {"ftc", "fairytailcraft", "ft", "fairytail"},
    firstArg = {"simpleenchant"})
    @CommandInfo(mageType = "BlacksmithMagic", info = "/ft simpleenchant <enchant> - Sets enchant for Simpleenchant Magic")
    public boolean simpleEnchant(CommandSender sender, String cmd, String[] args) {
        if (sender instanceof Player) {
            Player sent = (Player) sender;
            if (Util.hasPermission(sent, "fairytail.blacksmithmagic.simpleenchant")) {
                if (args.length != 2) {
                    return true;
                }
                if (BlacksmithMagic.simpleEnchants.containsKey(args[1])) {
                    sent.sendMessage(ChatColor.GREEN + "Enchant set: " + args[1]);
                    BlacksmithMagic.activeSEnchants.put(sent, BlacksmithMagic.simpleEnchants.get(args[1]));
                } else {
                    sent.sendMessage(ChatColor.RED + "Enchant not in Enchant list!");
                    return true;
                }
            } else {
                return false;
            }
        } else {
            sender.sendMessage("Don't run this Command from Console!");
            return true;
        }
        return true;
    }

    @Command(cmd = {"ftc", "fairytailcraft", "ft", "fairytail"},
    firstArg = {"mediumenchant"})
    @CommandInfo(mageType = "BlacksmithMagic", info = "/ft mediumenchant <enchant> - Sets enchant for Mediumenchant Magic")
    public boolean mediumEnchant(CommandSender sender, String cmd, String[] args) {
        if (sender instanceof Player) {
            Player sent = (Player) sender;
            if (Util.hasPermission(sent, "fairytail.blacksmithmagic.mediumenchant")) {
                if (args.length != 2) {
                    return true;
                }
                if (BlacksmithMagic.mediumEnchants.containsKey(args[1])) {
                    sent.sendMessage(ChatColor.GREEN + "Enchant set: " + args[1]);
                    BlacksmithMagic.activeMEnchants.put(sent, BlacksmithMagic.mediumEnchants.get(args[1]));
                } else {
                    sent.sendMessage(ChatColor.RED + "Enchant not in Enchant list!");
                    return true;
                }
            } else {
                return false;
            }
        } else {
            sender.sendMessage("Don't run this Command from Console!");
            return true;
        }
        return true;
    }

    @Command(cmd = {"ftc", "fairytailcraft", "ft", "fairytail"},
    firstArg = {"bigenchant"})
    @CommandInfo(mageType = "BlacksmithMagic", info = "/ft bigenchant <enchant> - Sets enchant for Bigenchant Magic")
    public boolean bigEnchant(CommandSender sender, String cmd, String[] args) {
        if (sender instanceof Player) {
            Player sent = (Player) sender;
            if (Util.hasPermission(sent, "fairytail.blacksmithmagic.bigenchant")) {
                if (args.length != 2) {
                    return true;
                }
                if (BlacksmithMagic.bigEnchants.containsKey(args[1])) {
                    sent.sendMessage(ChatColor.GREEN + "Enchant set: " + args[1]);
                    BlacksmithMagic.activeBEnchants.put(sent, BlacksmithMagic.bigEnchants.get(args[1]));
                } else {
                    sent.sendMessage(ChatColor.RED + "Enchant not in Enchant list!");
                    return true;
                }
            } else {
                return false;
            }
        } else {
            sender.sendMessage("Don't run this Command from Console!");
            return true;
        }
        return true;
    }

    @Command(cmd = {"ftc", "fairytailcraft", "ft", "fairytail"},
    firstArg = {"listenchant"})
    @CommandInfo(mageType = "BlacksmithMagic", info = "/ft listenchant - Lists all Enchants")
    public boolean listEnchant(CommandSender sender, String cmd, String[] args) {
        if (sender instanceof Player) {
            Player sent = (Player) sender;
            if (Util.hasPermission(sent, "fairytail.blacksmithmagic.getenchants")) {
                String enchantMsgS = "";
                String enchantMsgM = "";
                String enchantMsgB = "";
                Set<String> simpleKeys = BlacksmithMagic.simpleEnchants.keySet();
                for (String key : simpleKeys) {
                    enchantMsgS += ChatColor.GREEN + key + " ";
                }
                Set<String> mediumKeys = BlacksmithMagic.mediumEnchants.keySet();
                for (String key : mediumKeys) {
                    enchantMsgM += ChatColor.YELLOW + key + " ";
                }
                Set<String> bigKeys = BlacksmithMagic.bigEnchants.keySet();
                for (String key : bigKeys) {
                    enchantMsgB += ChatColor.RED + key + " ";
                }
                sent.sendMessage(ChatColor.GREEN + "Simple, " + ChatColor.YELLOW + "Medium " + ChatColor.WHITE + "and " + ChatColor.RED + "Big " + ChatColor.WHITE + "Enchants are:");
                sent.sendMessage(enchantMsgS);
                sent.sendMessage(enchantMsgM);
                sent.sendMessage(enchantMsgB);
            } else {
                return false;
            }
        } else {
            sender.sendMessage("Don't run this Command from Console!");
            return true;
        }
        return false;
    }
}
