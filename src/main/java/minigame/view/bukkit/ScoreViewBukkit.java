package minigame.view.bukkit;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import minigame.view.ScoreView;
import minigame.view.ScoreViewModel;

public class ScoreViewBukkit implements ScoreView {

	@Override
	public void display(ScoreViewModel viewModel) {
		Player player = Bukkit.getPlayer(viewModel.getViewer());
		ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("aaa", "bbb", viewModel.getTitle());
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		List<String> items = viewModel.getItems();
		for (int i = 0; i < items.size(); i++)
			objective.getScore(items.get(i)).setScore(items.size() - i);
		player.setScoreboard(scoreboard);
	}

	@Override
	public void hide(UUID viewer) {
		Player player = Bukkit.getPlayer(viewer);
		ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
		player.setScoreboard(scoreboard);
	}

}
