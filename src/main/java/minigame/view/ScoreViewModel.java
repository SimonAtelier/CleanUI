package minigame.view;

import java.util.List;
import java.util.UUID;

public interface ScoreViewModel {

	String getTitle();
	
	void setTitle(String title);
	
	UUID getViewer();
	
	void setViewer(UUID viewer);
	
	void addItem(String item);
	
	List<String> getItems();
	
}
