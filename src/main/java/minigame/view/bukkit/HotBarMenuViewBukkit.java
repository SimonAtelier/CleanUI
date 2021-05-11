package minigame.view.bukkit;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import minigame.view.DefaultEnchantmentViewModel;
import minigame.view.HotBarMenuView;
import minigame.view.HotBarMenuViewModel;
import minigame.view.MenuItem;

public class HotBarMenuViewBukkit implements HotBarMenuView {

	private UUID viewer;
	private HotBarMenuViewModel viewModel;
	private PlayerInventory inventory;
	private HideListener hideListener;
	
	public HotBarMenuViewBukkit(UUID viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void display(HotBarMenuViewModel viewModel) {
		this.viewModel = viewModel;
		this.inventory = Bukkit.getPlayer(viewer).getInventory();
		clearSlots();
		createMenuItems();
	}

	@Override
	public void hide() {
		ViewFactoryBukkit.unregisterHotbar(viewer);
		clearSlots();
		notifyListener();
	}
	
	private void clearSlots() {
		for (int slotIndex = 0; slotIndex < 9; slotIndex++) {
			inventory.setItem(slotIndex, null);
		}
	}
	
	private void notifyListener() {
		if (hideListener == null)
			return;
		hideListener.onHide();
	}
	
	private void createMenuItems() {
		for (MenuItem menuItem : viewModel.getMenuItems())
			inventory.setItem(menuItem.getSlotIndex(), createItemStackFromMenuItem(menuItem));
	}
	
	private ItemStack createItemStackFromMenuItem(MenuItem menuItem) {
		ItemStack itemStack = new ItemStack(Material.matchMaterial(menuItem.getIcon()));
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(menuItem.getName());
		itemMeta.setLore(menuItem.getLore());
		itemStack.setAmount(menuItem.getAmount());
		itemStack.setItemMeta(itemMeta);
		for (DefaultEnchantmentViewModel enchantment : menuItem.getEnchantments())
			itemStack.addUnsafeEnchantment(EnchantmentWrapper.getByKey(NamespacedKey.minecraft(enchantment.getType())),
					enchantment.getLevel());
		return itemStack;
	}
	
	@Override
	public UUID getViewer() {
		return viewer;
	}
	
	public HotBarMenuViewModel getViewModel() {
		return viewModel;
	}
	
	public void setHideListener(HideListener hideListener) {
		this.hideListener = hideListener;
	}
	
	public interface HideListener {
		
		void onHide();
		
	}

}
