package minigame.view;

import java.util.UUID;

public interface TitleView {

	void display(UUID viewer);
	
	TitleViewModel getTitleViewModel();
	
	void setTitleViewModel(TitleViewModel model);
	
}
