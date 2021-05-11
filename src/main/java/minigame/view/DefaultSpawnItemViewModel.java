package minigame.view;

public class DefaultSpawnItemViewModel implements SpawnItemViewModel {

	private int amount;
	private double x;
	private double y;
	private double z;
	private String world;
	private String itemType;

	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String getWorld() {
		return world;
	}

	@Override
	public void setWorld(String world) {
		this.world = world;
	}

	@Override
	public String getItemType() {
		return itemType;
	}

	@Override
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}