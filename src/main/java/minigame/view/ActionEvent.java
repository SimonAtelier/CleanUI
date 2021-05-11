package minigame.view;

public class ActionEvent {

	private boolean shiftDown;
	
	public ActionEvent(boolean shiftDown) {
		this.shiftDown = shiftDown;
	}

	public boolean isShiftDown() {
		return shiftDown;
	}
		
}
