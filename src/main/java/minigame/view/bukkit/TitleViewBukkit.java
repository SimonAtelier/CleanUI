package minigame.view.bukkit;

import java.util.UUID;

import org.bukkit.Bukkit;

import minigame.view.DefaultTitleViewModel;
import minigame.view.TitleView;
import minigame.view.TitleViewModel;

public class TitleViewBukkit implements TitleView {

	private TitleViewModel titleViewModel;
	
	public TitleViewBukkit() {
		titleViewModel = new DefaultTitleViewModel();
	}

	@Override
	public void display(UUID viewer) {
		displayTitle(viewer);
	}

	@Override
	public TitleViewModel getTitleViewModel() {
		return titleViewModel;
	}

	@Override
	public void setTitleViewModel(TitleViewModel titleViewModel) {
		this.titleViewModel = titleViewModel;
	}
	
	private void displayTitle(UUID viewer) {
		int fadeInTicks = getTitleViewModel().getFadeInTimeInTicks();
		int stayTicks = getTitleViewModel().getStayTimeInTicks();
		int fadeOutTicks = getTitleViewModel().getFadeOutTimeInTicks();
		String title = getTitleViewModel().getTitle();
		String subtitle = getTitleViewModel().getSubtitle();
		Bukkit.getPlayer(viewer).sendTitle(title, subtitle, fadeInTicks, stayTicks, fadeOutTicks);
	}

}
