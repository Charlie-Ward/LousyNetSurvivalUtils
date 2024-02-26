package info.charlieward.lousynetsurvivalutils.commands;

import info.charlieward.lousynetsurvivalutils.LousyNetSurvivalUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class setHome implements CommandExecutor {
    static LousyNetSurvivalUtils plugin;
    public setHome(LousyNetSurvivalUtils plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            UUID playerUUID = player.getUniqueId();
            String jedisKey = playerUUID + "_Home_Coords";
            Location playerCoords = player.getLocation();
            int posX = (int) playerCoords.getX();
            int posZ = (int) playerCoords.getZ();
            int posY = (int) playerCoords.getY();
            String jedisPosition = posX + "," + posZ + "," + posY;
            plugin.jedis.set(jedisKey, jedisPosition);
            player.sendMessage(ChatColor.BLUE + "[LousyNet] " + ChatColor.WHITE + "Home warp has been updated. This has overwritten the last home position.");
        }

        return true;
    }
}
