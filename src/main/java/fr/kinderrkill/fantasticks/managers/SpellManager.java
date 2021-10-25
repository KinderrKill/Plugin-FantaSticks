package fr.kinderrkill.fantasticks.managers;

import fr.kinderrkill.fantasticks.FantaSticks;
import fr.kinderrkill.fantasticks.objects.CustomStick;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class SpellManager {

    private final FantaSticks plugin;

    public SpellManager(FantaSticks plugin) {
        this.plugin = plugin;
    }

    public void fireball(Player player, CustomStick stick, boolean selfCast) {
        Fireball fireball = player.launchProjectile(Fireball.class);
        fireball.setMetadata("damageBlock", new FixedMetadataValue(plugin, false));
        fireball.setIsIncendiary(false);
        fireball.setBounce(false);
    }

    public void frostball(Player player, CustomStick stick, boolean selfCast) {
        Snowball snowball = player.launchProjectile(Snowball.class);
    }
}
