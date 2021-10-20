package fr.kinderrkill.fantasticks.objects;

import java.util.Random;

public class CustomStick {

    private final String name;
    private final String texture;
    private final int durability;
    private final Spell type;
    private final double amountMin, amountMax;

    public CustomStick(String name, String texture, int durability, Spell type, String amount) {
        this.name = name;
        this.texture = texture;
        this.durability = durability;
        this.type = type;
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

    public String getTexture() {
        return texture;
    }

    public int getDurability() {
        return durability;
    }

    public Spell getType() {
        return type;
    }

    public double getAmount() {
        Random random = new Random();
        double finalValue = amountMin + random.nextDouble() * (amountMax - amountMin);
        return amountMin == amountMax ? amountMax : finalValue;
    }

    //Do getItemStack()

    public enum Spell {
        DAMAGE("damage"),
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
