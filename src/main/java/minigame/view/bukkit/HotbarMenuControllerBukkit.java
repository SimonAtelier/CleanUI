package minigame.view.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import minigame.view.ActionEvent;
import minigame.view.ActionHandler;
import minigame.view.MenuItem;
import minigame.view.bukkit.HotBarMenuViewBukkit.HideListener;

public class HotbarMenuControllerBukkit implements Listener, HideListener {

	private HotBarMenuViewBukkit menuView;
	private PlayerInteractEvent interactEvent;

	public HotbarMenuControllerBukkit(HotBarMenuViewBukkit menuView) {
		this.menuView = menuView;
	}

	@EventHandler
	public void onInventoryClicked(InventoryClickEvent e) {
		if (!(e.getWhoClicked() instanceof Player))
			return;
		
		Player player = (Player) e.getWhoClicked();
		if (!player.getUniqueId().equals(menuView.getViewer()))
			return;

		e.setCancelled(true);

		player.closeInventory();

		ActionHandler actionHandler = findClickedItem(e.getSlot()).getActionHandler();
		if (actionHandler != null)
			actionHandler.onActionPerformed(new ActionEvent(e.isShiftClick()));
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		this.interactEvent = event;

		if (!isRightClick())
			return;

		if (viewerNotClicked())
			return;

		if (noItemClicked())
			return;

		cancelEvent();

		handleClick();
	}

	private void handleClick() {
		int slotIndex = getSlotIndex();
		MenuItem menuItem = findClickedItem(slotIndex);

		if (menuItem == null)
			return;

		ActionHandler actionHandler = menuItem.getActionHandler();

		if (actionHandler == null)
			return;
		
		actionHandler.onActionPerformed(new ActionEvent(false));
	}

	private void cancelEvent() {
		interactEvent.setCancelled(true);
	}

	private MenuItem findClickedItem(int slotIndex) {
		for (MenuItem menuItem : menuView.getViewModel().getMenuItems()) {
			if (menuItem.getSlotIndex() == slotIndex)
				return menuItem;
		}
		return null;
	}

	private boolean isRightClick() {
		return interactEvent.getAction() == Action.RIGHT_CLICK_AIR
				|| interactEvent.getAction() == Action.RIGHT_CLICK_BLOCK;
	}

	private boolean noItemClicked() {
		return interactEvent.getItem() == null;
	}

	private boolean viewerNotClicked() {
		return !interactEvent.getPlayer().getUniqueId().equals(menuView.getViewer());
	}

	private int getSlotIndex() {
		return interactEvent.getPlayer().getInventory().getHeldItemSlot();
	}

	@Override
	public void onHide() {
		HandlerList.unregisterAll(this);
	}

}
