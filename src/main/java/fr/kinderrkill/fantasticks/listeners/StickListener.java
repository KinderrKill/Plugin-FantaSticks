package fr.kinderrkill.fantasticks.listeners;

import fr.kinderrkill.fantasticks.FantaSticks;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class StickListener implements Listener {

    private final FantaSticks plugin;

    public StickListener(FantaSticks plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        player.sendMessage("Using " + item.getType() + " item with action " + event.getAction() + " (" + event.getPlayer().isSneaking() + ")");
    }

}
