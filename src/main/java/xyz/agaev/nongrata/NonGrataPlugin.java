package xyz.agaev.nongrata;

import org.bukkit.plugin.java.JavaPlugin;

public final class NonGrataPlugin extends JavaPlugin {

    private static NonGrataPlugin instance;

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();
        saveResource("messages.yml", false);

        getLogger().info("================================");
        getLogger().info(" NonGrata v1.0 enabled");
        getLogger().info(" LiteBans integration loaded");
        getLogger().info("================================");

    }

    @Override
    public void onDisable() {

        getLogger().info("NonGrata disabled.");

    }

    public static NonGrataPlugin getInstance() {
        return instance;
    }

}
