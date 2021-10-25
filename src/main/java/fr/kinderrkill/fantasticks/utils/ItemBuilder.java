package fr.kinderrkill.fantasticks.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private final Material material;
    private int amount = 1;
    private short data = 0;
    private String name;
    private List<String> lore;

    public ItemBuilder(Material material) {
        this.material = material;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder setData(int data) {
        this.data = (short) data;
        return this;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        this.lore = Arrays.asList(lore);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemStack getItem() {
        ItemStack stack = data != 0 ? new ItemStack(material, amount, data) : new ItemStack(material, amount);
        ItemMeta meta = stack.getItemMeta();
        if(name != null) meta.setDisplayName(name);
        if(lore != null && !lore.isEmpty()) meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }
}