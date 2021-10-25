package fr.kinderrkill.fantasticks.listeners;

import fr.kinderrkill.fantasticks.FantaSticks;
import fr.kinderrkill.fantasticks.objects.CustomStick;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
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

        if (item.getType() == Material.STICK && item.hasItemMeta()) {
            CustomStick stick = plugin.stickManager.getStickInHand(item);

            if (stick.getSpell() == CustomStick.Spell.FIREBALL) {
                System.out.println("Cast fireball...");
                plugin.spellManager.fireball(player, stick, player.isSneaking());

            }
            else if (stick.getSpell() == CustomStick.Spell.FROSTBALL) {
                System.out.println("Cast frostball...");
                plugin.spellManager.frostball(player, stick, player.isSneaking());
            }
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
