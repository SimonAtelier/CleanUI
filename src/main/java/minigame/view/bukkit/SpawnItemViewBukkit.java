package minigame.view.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import minigame.view.SpawnItemView;
import minigame.view.SpawnItemViewModel;

public class SpawnItemViewBukkit implements SpawnItemView {

	@Override
	public void display(SpawnItemViewModel viewModel) {
		World world = Bukkit.getWorld(viewModel.getWorld());
		Location location = new Location(world, viewModel.getX(), viewModel.getY(), viewModel.getZ());
		ItemStack itemStack = new ItemStack(Material.matchMaterial(viewModel.getItemType()));
		itemStack.setAmount(viewModel.getAmount());
		world.dropItemNaturally(location, itemStack);	
	}

}
