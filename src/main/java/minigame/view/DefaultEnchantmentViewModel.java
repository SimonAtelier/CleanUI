package minigame.view;

public class DefaultEnchantmentViewModel {

	private int level;
	private String type;

	public DefaultEnchantmentViewModel(int level, String type) {
		this.level = level;
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}