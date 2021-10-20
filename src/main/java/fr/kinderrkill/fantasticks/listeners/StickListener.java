package fr.kinderrkill.fantasticks.listeners;

import fr.kinderrkill.fantasticks.FantaSticks;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class StickListener implements Listener {

    private final FantaSticks plugin;

    public StickListener(FantaSticks plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.STICK) {
            Fireball fireball = player.launchProjectile(Fireball.class);
            fireball.setIsIncendiary(false);
            fireball.setBounce(false);
            fireball.setMetadata("damageBlock", new FixedMetadataValue(plugin, false));
        }
    }

    @EventHandler
    public void onProjectileExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Fireball) {
            Fireball fireball = (Fireball) event.getEntity();
            if (fireball.getShooter() instanceof Player) {
                event.getEntity().getWorld().createExplosion(event.getLocation(), 1f, false, !fireball.hasMetadata("damageBlock"));
                event.setCancelled(true);
            }
        }
    }

}
