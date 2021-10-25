package fr.kinderrkill.fantasticks.managers;

import fr.kinderrkill.fantasticks.FantaSticks;
import fr.kinderrkill.fantasticks.objects.CustomStick;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StickManager {

    private final FantaSticks plugin;
    private final List<CustomStick> customSticks;

    public StickManager(FantaSticks plugin) {
        this.plugin = plugin;
        this.customSticks = new ArrayList<>();
    }

    public void init() {
        loadSticks();
    }

    // Getters
    public CustomStick getStickInHand(ItemStack item) {
        for (CustomStick stick : customSticks) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                if (meta.getDisplayName().equals(stick.getName())) {
                    return stick;
                }
            }
        }
        return null;
    }

    public CustomStick getStickById(int id) {
        for (CustomStick stick : customSticks) {
            if (stick.getId() == id ) {
                return stick;
            }
        }
        return null;
    }

    // Load custom sticks file
    private void loadSticks() {
        File parentFile = new File(plugin.getDataFolder(), "sticks/");
        if (!parentFile.exists()) {
            parentFile.mkdir();

            plugin.saveResource("sticks/stick_1.yml", false);
        }

        File[] sticksFiles = parentFile.listFiles();
        if (sticksFiles == null) {
            plugin.sendMessage(ChatColor.RED + "No custom sticks found in folder plugins/FantaSticks/sticks/ !");
            return;
        }

        for (File f : sticksFiles) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            customSticks.add(new CustomStick(config.getString("name"),
                    config.getInt("id"),
                    config.getString("texture"),
                    config.getInt("durability"),
                    CustomStick.Spell.getByType(config.getString("spell.type")), config.getString("spell.amount")));
        }

        plugin.sendMessage("Loaded " + customSticks.size() + " custom sticks !");
    }


}
