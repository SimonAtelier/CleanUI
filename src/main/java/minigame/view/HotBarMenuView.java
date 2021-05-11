package minigame.view;

import java.util.UUID;

public interface HotBarMenuView {

	void display(HotBarMenuViewModel viewModel);
	
	void hide();
	
	UUID getViewer();
	
}
