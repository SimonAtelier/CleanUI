package minigame.view;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DefaultMenuViewModel implements MenuViewModel {

	private int numberOfSlots;
	private String title;
	private UUID viewer;
	private List<MenuItem> menuItems;
	
	public DefaultMenuViewModel() {
		menuItems = new ArrayList<MenuItem>();
	}
	
	@Override
	public int getNumberOfSlots() {
		return numberOfSlots;
	}

	@Override
	public void setNumberOfSlots(int numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public UUID getViewer() {
		return viewer;
	}

	@Override
	public void setViewer(UUID viewer) {
		this.viewer = viewer;
	}

	@Override
	public void add(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	@Override
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

}
