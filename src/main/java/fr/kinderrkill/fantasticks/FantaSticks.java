package fr.kinderrkill.fantasticks;

import fr.kinderrkill.fantasticks.listeners.StickListener;
import fr.kinderrkill.fantasticks.managers.StickManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FantaSticks extends JavaPlugin {

    private static FantaSticks instance;
    private static String PREFIX = ChatColor.GREEN + "[FantaSticks] " + ChatColor.YELLOW;

    public ConsoleCommandSender console = null;

    // Manager
    private StickManager stickManager;

    public void onEnable() {
        instance = this;
        this.console = Bukkit.getConsoleSender();

        // Init managers
        this.stickManager = new StickManager(this);

        // Init basics
        this.registerListeners();
        this.registerCommands();
        
        // Launch systems
        this.stickManager.init();
        this.console.sendMessage(PREFIX + "Plugin successfully enabled !");
    }

    public void onDisable() {

    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new StickListener(this), this);
    }

    private void registerCommands() {

    }

    // Utils
    public void sendMessage(String message) {
        console.sendMessage(PREFIX + message);
    }

    // Getters
    public static FantaSticks getInstance() {
        return instance;
    }
}
