package info.charlieward.lousynetsurvivalutils;

import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;

public final class LousyNetSurvivalUtils extends JavaPlugin {

    private static LousyNetSurvivalUtils plugin;
    public Jedis jedis = new Jedis();

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("LousyNet-SurvivalUtils v." + this.getDescription().getVersion() + " has loaded.");

    }

    @Override
    public void onDisable() {
        getLogger().info("LousyNet-SurvivalUtils v." + this.getDescription().getVersion() + " has been disabled.");
    }

    public static LousyNetSurvivalUtils getPlugin() {
        return plugin;
    }
}
