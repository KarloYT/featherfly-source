package me.karlodevelopingstudios.featherfly.commands;

import me.karlodevelopingstudios.featherfly.FeatherFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class flyCommand implements CommandExecutor {

    private FeatherFly plugin;

    public flyCommand(FeatherFly plugin) {
        this.plugin = plugin;
    }

    private ArrayList<Player> flying_people = new ArrayList<>();



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0){
                flyMethod(player);
            }else if(args.length == 1){
                if(player.hasPermission("flyplugin.others")){
                    Player target = Bukkit.getPlayer(args[0]);
                    flyMethod(target);
                }

            }
        }

        return true;
    }

    private void flyMethod(Player player){
        if(player.hasPermission("featherfly.fly")){
            if(flying_people.contains(player)){
                flying_people.remove(player);
                System.out.println("Disabled fly mode for " + player.getDisplayName());
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("on-message")));
            }else if(!flying_people.contains(player)){
                flying_people.add(player);
                System.out.println("Enabled fly mode for " + player.getDisplayName());
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("off-message")));
            }
        }
    }
}
