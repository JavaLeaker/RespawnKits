package pikzstudios.respawkits.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pikzstudios.respawkits.RespawKits;

public class ReloadCommand implements CommandExecutor {

    private RespawKits main;

    public ReloadCommand(RespawKits main) {
        this.main = main;

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            main.reloadConfig();
            main.saveConfig();
            p.sendMessage(ChatColor.GREEN + "Reloaded config");
        }
    return true;}
}
