package minigame.view;

import java.util.UUID;

public interface ColoredTeamArmourView {

	int getColorRGB();
	
	void setColorRGB(int color);
	
	void displayTeamArmour(UUID uniquePlayerId);
	
	void hideTeamArmour(UUID uniquePlayerId);
	
}
