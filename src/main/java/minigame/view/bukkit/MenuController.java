package minigame.view.bukkit;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import minigame.view.ActionEvent;
import minigame.view.ActionHandler;

public class MenuController implements Listener {
	
	private MenuViewBukkit menuView;
	
	public MenuController(MenuViewBukkit menuView) {
		this.menuView = menuView;
	}
	
	@EventHandler
	public void onInventoryClicked(InventoryClickEvent e) {
		if (!(e.getWhoClicked() instanceof Player))
			return;
		if (!e.getInventory().equals(getInventory()))
			return;
		Player player = (Player) e.getWhoClicked();
		if (player.getUniqueId() != getViewer())
			return;
		fireSlotClicked(e.getRawSlot(), e.isShiftClick());
		e.setCancelled(true);
	}
	
	private void fireSlotClicked(int slotIndex, boolean shifClick) {
		ActionHandler clickHandler = menuView.getClickHandler(slotIndex);
		if (clickHandler == null)
			return;
		ActionEvent actionEvent = new ActionEvent(shifClick);
		clickHandler.onActionPerformed(actionEvent);
	}
	
	@EventHandler
	public void onCloseInventory(InventoryCloseEvent e) {
		if (!e.getPlayer().getUniqueId().equals(getViewer()))
			return;
		if (!e.getInventory().equals(getInventory()))
			return;
		HandlerList.unregisterAll(this);
	}
	
	private UUID getViewer() {
		return menuView.getViewer();
	}
	
	private Inventory getInventory() {
		return menuView.getInventory();
	}

}
