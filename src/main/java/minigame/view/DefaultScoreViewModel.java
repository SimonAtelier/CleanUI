package minigame.view;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DefaultScoreViewModel implements ScoreViewModel {

	private UUID viewer;
	private String title;
	private List<String> items;
	
	public DefaultScoreViewModel() {
		items = new ArrayList<String>();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public UUID getViewer() {
		return viewer;
	}

	@Override
	public void setViewer(UUID viewer) {
		this.viewer = viewer;	
	}

	@Override
	public void addItem(String item) {
		items.add(item);
	}

	@Override
	public List<String> getItems() {
		return items;
	}
	
}
