package minigame.view.bukkit;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import minigame.view.ActionEvent;
import minigame.view.ActionHandler;

public class MenuControllerBukkit implements Listener {
	
	private MenuViewBukkit menuView;
	
	public MenuControllerBukkit(MenuViewBukkit menuView) {
		this.menuView = menuView;
	}
	
	@EventHandler
	public void onInventoryMoveItem(InventoryDragEvent e) {	
		if (getInventory() != e.getInventory())
			return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onInventoryClicked(InventoryClickEvent e) {
		if (!(e.getWhoClicked() instanceof Player))
			return;
		
		if (getInventory() != e.getInventory())
			return;
		
		Player player = (Player) e.getWhoClicked();
		
		if (player.getUniqueId() != getViewer())
			return;
		
		if (getMenuView().getMaxSlotIndex() < e.getRawSlot())
			return;
		
		fireSlotClicked(e.getRawSlot(), e.isShiftClick());
		e.setCancelled(true);
	}
	
	private void fireSlotClicked(int slotIndex, boolean shifClick) {
		ActionHandler clickHandler = getMenuView().getClickHandler(slotIndex);
		
		if (clickHandler == null)
			return;
		
		ActionEvent actionEvent = new ActionEvent(shifClick);
		clickHandler.onActionPerformed(actionEvent);
	}
	
	@EventHandler
	public void onCloseInventory(InventoryCloseEvent e) {
		if (!e.getPlayer().getUniqueId().equals(getViewer()))
			return;
		
		if (getInventory() != e.getInventory())
			return;
		
		HandlerList.unregisterAll(this);
	}
	
	private MenuViewBukkit getMenuView() {
		return menuView;
	}
	
	private UUID getViewer() {
		return menuView.getViewer();
	}
	
	private Inventory getInventory() {
		return menuView.getInventory();
	}

}
