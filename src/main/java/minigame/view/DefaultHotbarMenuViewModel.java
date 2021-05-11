package minigame.view;

import java.util.ArrayList;
import java.util.List;

public class DefaultHotbarMenuViewModel implements HotBarMenuViewModel {

	private List<MenuItem> menuItems;
	
	public DefaultHotbarMenuViewModel() {
		menuItems = new ArrayList<MenuItem>();
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
