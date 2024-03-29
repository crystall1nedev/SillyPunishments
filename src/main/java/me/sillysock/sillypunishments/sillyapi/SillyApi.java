package me.sillysock.sillypunishments.sillyapi;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class SillyApi {

  private static Inventory menu;
  private String title = "Punish ";

  public Inventory createPunishMenu(final OfflinePlayer target) {
    title += target.getName();

    menu = Bukkit.createInventory(
        null, 36, title); // Create an inventory with the size 36.

    final ItemStack head =
        getHead(target); // Create head by getting head [in. method]

    menu.setItem(4, head); // Add head to the menu at the 4th slot.

    createMenuItem(Material.TERRACOTTA, "BAN", "",
                   "Exclude " + target.getName(), "From the server.", "[BETA]",
                   17, menu);

    return menu;
  }

  private static void createMenuItem(final Material material, final String name,
                                     final String lore1, final String lore2,
                                     final String lore3, final String lore4,
                                     final int slot,
                                     final @NotNull Inventory menu) {
    ItemStack item = new ItemStack(material);
    ItemMeta meta = item.getItemMeta();

    List<String> lore = new ArrayList<>();

    if (lore1 != null)
      lore.add(lore1);

    if (lore2 != null)
      lore.add(lore2);

    if (lore3 != null)
      lore.add(lore3);

    if (lore4 != null)
      lore.add(lore4);

    meta.setLore(lore);
    meta.setLocalizedName(name);

    item.setItemMeta(meta);

    menu.setItem(slot, item);
  }

  private static ItemStack getHead(final OfflinePlayer target) {
    ItemStack head = new ItemStack(Material.PLAYER_HEAD);

    final SkullMeta meta = (SkullMeta)head.getItemMeta();
    meta.setOwningPlayer(target);

    head.setItemMeta(meta);

    return head;
  }
}
