package minigame.view;

import java.util.List;
import java.util.UUID;

public interface MenuViewModel {
	
	int getNumberOfSlots();
	
	void setNumberOfSlots(int numberOfSlots);
	
	UUID getViewer();
	
	void setViewer(UUID viewer);
	
	String getTitle();
	
	void setTitle(String title);
	
	void add(MenuItem menuItem);
	
	List<MenuItem> getMenuItems();

}
