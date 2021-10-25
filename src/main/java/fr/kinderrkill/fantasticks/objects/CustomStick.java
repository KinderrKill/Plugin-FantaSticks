package fr.kinderrkill.fantasticks.objects;

import fr.kinderrkill.fantasticks.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CustomStick {

    private final String name;
    private final int id;
    private final String texture;
    private final int durability;
    private final Spell spell;
    private final double amountMin, amountMax;

    public CustomStick(String name, int id, String texture, int durability, Spell spell, String amount) {
        this.name = name;
        this.id = id;
        this.texture = texture;
        this.durability = durability;
        this.spell = spell;
        if (amount.contains(":")) {
            this.amountMin = Double.parseDouble(amount.split(":")[0]);
            this.amountMax = Double.parseDouble(amount.split(":")[1]);
        } else {
            this.amountMin = Double.parseDouble(amount);
            this.amountMax = Double.parseDouble(amount);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getTexture() {
        return texture;
    }

    public int getDurability() {
        return durability;
    }

    public Spell getSpell() {
        return spell;
    }

    public double getAmount() {
        Random random = new Random();
        double finalValue = amountMin + random.nextDouble() * (amountMax - amountMin);
        return amountMin == amountMax ? amountMax : finalValue;
    }

    public ItemStack getItemStack() {
        return new ItemBuilder(Material.STICK)
                .setName(name)
                .getItem();
    }

    public enum Spell {
        FIREBALL("fireball"),
        FROSTBALL("frostball"),
        RAIL("rail"),
        HEAL("heal"),
        POTION("potion"),
        ;

        private final String type;

        Spell(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public static Spell getByType(String type) {
            for (Spell value : values()) {
                if (value.getType().equalsIgnoreCase(type)) return value;
            }
            return null;
        }
    }
}
