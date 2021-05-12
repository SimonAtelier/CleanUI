package minigame.view.bukkit;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import minigame.view.ColoredTeamArmourView;

public class ColoredTeamArmourViewBukkit implements ColoredTeamArmourView {

	private int color;
	
	private void addLeatherArmour(PlayerInventory inventory, Color color) {
		ItemStack leatherHelmet = createColoredLeatherArmour(
				Material.LEATHER_HELMET, color);
		ItemStack leatherChestplate = createColoredLeatherArmour(
				Material.LEATHER_CHESTPLATE, color);
		ItemStack leatherLeggins = createColoredLeatherArmour(
				Material.LEATHER_LEGGINGS, color);
		ItemStack leatherBoots = createColoredLeatherArmour(
				Material.LEATHER_BOOTS, color);

		inventory.setHelmet(leatherHelmet);
		inventory.setChestplate(leatherChestplate);
		inventory.setLeggings(leatherLeggins);
		inventory.setBoots(leatherBoots);
	}

	private ItemStack createColoredLeatherArmour(Material material,
			Color color) {
		ItemStack itemStack = new ItemStack(material, 1);
		LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
		itemMeta.setColor(color);
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
	
	@Override
	public void displayTeamArmour(UUID uniquePlayerId) {
		Color bukkitColor = Color.fromRGB(color);
		Player player = Bukkit.getServer().getPlayer(uniquePlayerId);
		PlayerInventory inventory = (PlayerInventory) player.getInventory();
		addLeatherArmour(inventory, bukkitColor);
	}
	
	@Override
	public void hideTeamArmour(UUID uniquePlayerId) {
		Player bukkitPlayer = Bukkit.getPlayer(uniquePlayerId);
		PlayerInventory inventory = bukkitPlayer.getInventory();
		inventory.setArmorContents(new ItemStack[] {});
	}

	@Override
	public int getColorRGB() {
		return color;
	}

	@Override
	public void setColorRGB(int color) {
		this.color = color;
	}

}
