package pikzstudios.respawkits;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pikzstudios.respawkits.Commands.ReloadCommand;
import pikzstudios.respawkits.Events.RespawnKit;

public final class RespawKits extends JavaPlugin {
    // When Load
    @Override
    public void onEnable() {
    // Config Save
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    // Events
        Bukkit.getPluginManager().registerEvents(new RespawnKit(this), this);
    // Commands
        getCommand("kitreload").setExecutor(new ReloadCommand(this));
    // Console Logger
        this.getLogger().info("RespawnKits is now Enabled");

    }
     // When Disable
    @Override
    public void onDisable() {
        // Console Logger
        this.getLogger().info("RespawnKits is now disabled");

    }
}
