package minigame.view;

import java.util.UUID;

public interface ScoreView {

	void display(ScoreViewModel viewModel);
	
	void hide(UUID viewer);
	
}
