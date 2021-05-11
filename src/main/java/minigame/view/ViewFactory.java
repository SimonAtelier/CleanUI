package minigame.view;

import java.util.UUID;

public interface ViewFactory {
	
	MessageView createMessageView();
	
	TitleView createTitleView();
	
	ActionBarView createActionBarView();
	
	MenuView createMenuView();
	
	MenuViewModel createMenuViewModel();
	
	TitleViewModel createTitleViewModel();
	
	MenuItem createMenuItem();
	
	MenuItem createMenuItem(String name, String icon, int slotIndex);
	
	ScoreView createScoreView();
	
	ScoreViewModel createScoreViewModel();
	
	SpawnItemView createSpawnItemView();
	
	SpawnItemViewModel createSpawnItemViewModel();
	
	HotBarMenuView createHotBarMenuView(UUID viewer);
	
	HotBarMenuViewModel createHotBarMenuViewModel();

}
