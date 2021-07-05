package cf.itoncek.brokengame.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;


public class StartCommand implements CommandExecutor {
    // This method is called, when somebody uses our command
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "We're starting, please accept all resourcepacks!");

            new BukkitRunnable() {
                public void run() {
                    //loop through the online players, get their helm, check if it isn't null, check if it has an itemmeta and lore, and then check the lore for your string and if so, give regen
                }
            }.runTaskTimer(this., 0L, 20L * 5);
            return false;
        }
    }