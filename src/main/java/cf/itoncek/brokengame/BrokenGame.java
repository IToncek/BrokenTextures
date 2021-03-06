package cf.itoncek.brokengame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class BrokenGame extends JavaPlugin {
    public int i = 0;

    @Override
    public void onEnable() {
        getCommand("start").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("start")) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "We're starting, please accept all resourcepacks!");
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("Starting", "Please accept all resourcepacks!", 1, 5, 1);
            }
            new BukkitRunnable() {
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setResourcePack("https://github.com/IToncek/brokentextures/raw/main/rsrcs/" + i + ".zip");
                        player.sendTitle("Updating", "Please accept all resourcepacks!", 1, 5, 1);
                        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "PLEASE ACCEPT ALL RESOURCEPACK REQUESTS!");
                        player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "This is resourcepack update #" + i);
                    }
                    i++;
                }
            }.runTaskTimer(this, 20L*5, 20L * 120);
            return false;
        }
        return false;
    }
}
