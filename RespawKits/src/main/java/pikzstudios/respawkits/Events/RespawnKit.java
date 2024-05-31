package pikzstudios.respawkits.Events;
// Imports
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pikzstudios.respawkits.RespawKits;

import java.util.ArrayList;
import java.util.List;

// class
public class RespawnKit implements Listener {
// main pipeline
    private RespawKits plugin;
    private final List<ItemStack> items = new ArrayList<>();

    public RespawnKit(RespawKits plugin) {
        this.plugin = plugin;
        loadStacks();
    }
    // Respawn Event = Give Kit
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {

        ItemStack helmet = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-1")));
        ItemMeta itemMeta = helmet.getItemMeta();
        helmet.setItemMeta(itemMeta);

        e.getPlayer().getInventory().addItem(helmet);

        ItemStack chestplate = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-2")));
        ItemMeta chestMeta = chestplate.getItemMeta();
        chestplate.setItemMeta(chestMeta);

        e.getPlayer().getInventory().addItem(chestplate);

        ItemStack leggings = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-3")));
        ItemMeta leggingsMeta = leggings.getItemMeta();
        leggings.setItemMeta(leggingsMeta);

        e.getPlayer().getInventory().addItem(leggings);

        ItemStack boots = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-4")));
        ItemMeta bootsMeta = boots.getItemMeta();
        boots.setItemMeta(bootsMeta);

        e.getPlayer().getInventory().addItem(boots);

        ItemStack sword = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-5")));
        ItemMeta swordMeta = sword.getItemMeta();
        sword.setItemMeta(swordMeta);

        e.getPlayer().getInventory().addItem(sword);

        ItemStack pickaxe = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-6")));
        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
        sword.setItemMeta(swordMeta);

        e.getPlayer().getInventory().addItem(pickaxe);

        ItemStack shovel = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-7")));
        ItemMeta shovelMeta = shovel.getItemMeta();
        sword.setItemMeta(shovelMeta);

        e.getPlayer().getInventory().addItem(shovel);

        ItemStack axe = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-8")));
        ItemMeta axeMeta = axe.getItemMeta();
        sword.setItemMeta(axeMeta);

        e.getPlayer().getInventory().addItem(axe);

        ItemStack hoe = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-9")));
        ItemMeta hoeMeta = hoe.getItemMeta();
        sword.setItemMeta(hoeMeta);

        e.getPlayer().getInventory().addItem(hoe);

        ItemStack totem = new ItemStack(Material.getMaterial(plugin.getConfig().getString("Kits.Item-10")));
        ItemMeta totemMeta = totem.getItemMeta();
        sword.setItemMeta(totemMeta);

        e.getPlayer().getInventory().setItemInOffHand(totem);

    }

    // this will load stacks from your config and put them into the list
    // just as an example on how to load a stack
    // Now you just have to apply that to all of your stacks above and you're good
    public void loadStacks() {
        ConfigurationSection itemSection = plugin.getConfig().getConfigurationSection("items");

        for (String key : itemSection.getKeys(false)) {
            items.add(getStack(key));
        }
    }

    // this will return a stack from your config entries
    private ItemStack getStack(String path) {
        Material type;
        int amount;
        try {
            type = Material.valueOf(plugin.getConfig().getString(path + ".type"));
            amount = plugin.getConfig().getInt(path + ".amount", 1);
        } catch (IllegalArgumentException e) {
            Bukkit.getLogger().severe("Invalid type: " + path);
            return null;
        }

        return new ItemStack(type, amount);
    }

}
