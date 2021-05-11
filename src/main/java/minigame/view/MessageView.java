package minigame.view;

import java.util.UUID;

public interface MessageView {
	
	void setPrefix(String prefix);

	void displayMessage(UUID uniquePlayerId, String message);
	
	void displayConsoleMessage(String message);
	
}
