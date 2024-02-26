package info.charlieward.lousynetsurvivalutils;

import info.charlieward.lousynetsurvivalutils.commands.Home;
import info.charlieward.lousynetsurvivalutils.commands.setHome;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;

public final class LousyNetSurvivalUtils extends JavaPlugin {

    private static LousyNetSurvivalUtils plugin;
    public Jedis jedis = new Jedis();

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("LousyNet-SurvivalUtils v." + this.getDescription().getVersion() + " has loaded.");

        getCommand("home").setExecutor(new Home(this));
        getCommand("setHome").setExecutor(new setHome(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("LousyNet-SurvivalUtils v." + this.getDescription().getVersion() + " has been disabled.");
    }

    public static LousyNetSurvivalUtils getPlugin() {
        return plugin;
    }
}
