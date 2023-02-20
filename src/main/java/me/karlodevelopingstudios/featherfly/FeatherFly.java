package me.karlodevelopingstudios.featherfly;

import org.bukkit.plugin.java.JavaPlugin;
import me.karlodevelopingstudios.featherfly.commands.flyCommand;

public final class FeatherFly extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // load the commands
        getCommand("fly").setExecutor(new flyCommand(this));

        // console output (onStart)
        System.out.println("==================================================================================");
        System.out.println("[FeatherFly] Starting plugin...");
        System.out.println("[FeatherFly] Loading config.yml");
        System.out.println("[FeatherFly] Fetching the KarloDevelopingStudios package...");
        System.out.println("[FeatherFly] Successfully ran the plugin");
        System.out.println("[FeatherFly] The plugin successfully has loaded.");
        System.out.println("==================================================================================");

        // load the config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
