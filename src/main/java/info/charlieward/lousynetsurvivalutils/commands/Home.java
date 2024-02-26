package info.charlieward.lousynetsurvivalutils.commands;

import info.charlieward.lousynetsurvivalutils.LousyNetSurvivalUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Home implements CommandExecutor {
    static LousyNetSurvivalUtils plugin;

    public Home(LousyNetSurvivalUtils plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            UUID playerUIID = player.getUniqueId();
            String jedisKey = playerUIID + "_Home_Coords";
            String homeCoords = plugin.jedis.get(jedisKey);
            if (homeCoords == null) {
                player.sendMessage(ChatColor.BLUE + "[LousyNet] " + ChatColor.WHITE + "You need to set a home first use /setHome to do this");
                System.out.println(playerUIID); //Debug need to remove
            } else {
                String[] splitCoords = homeCoords.split(",");
                Location homeLoc = new Location(Bukkit.getWorld("world"), getCoordInt(splitCoords[0]), getCoordInt(splitCoords[1]), getCoordInt(splitCoords[2]));
                player.sendMessage(ChatColor.BLUE + "[LousyNet] " + ChatColor.WHITE + "Teleporting to your home");
                System.out.println(homeLoc);
                player.teleport(homeLoc);
            }
        }
        return true;
    }

    public static int getCoordInt(String input) {
        try{
            int number = Integer.parseInt(input);
            System.out.println(number);
            return number;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
