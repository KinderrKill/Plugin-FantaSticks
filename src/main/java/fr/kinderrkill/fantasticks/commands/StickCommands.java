package fr.kinderrkill.fantasticks.commands;

import fr.kinderrkill.fantasticks.FantaSticks;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class StickCommands implements CommandExecutor, TabCompleter {

    private final FantaSticks plugin;

    public StickCommands(FantaSticks plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int stickID = Integer.parseInt(args[0]);
        Player player = ((Player)sender);
        player.getInventory().addItem(plugin.stickManager.getStickById(stickID).getItemStack());
        player.sendMessage("Give the magic stick !");
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
