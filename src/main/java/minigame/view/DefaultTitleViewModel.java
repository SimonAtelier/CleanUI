package minigame.view;

public class DefaultTitleViewModel implements TitleViewModel {

	private int fadeInTimeInTicks;
	private int stayTimeInTicks;
	private int fadeOutTimeInTicks;
	private String title;
	private String subtitle;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getSubtitle() {
		return subtitle;
	}

	@Override
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	@Override
	public int getFadeInTimeInTicks() {
		return fadeInTimeInTicks;
	}

	@Override
	public void setFadeInTimeInTicks(int fadeInTimeInTicks) {
		this.fadeInTimeInTicks = fadeInTimeInTicks;
	}

	@Override
	public int getStayTimeInTicks() {
		return stayTimeInTicks;
	}

	@Override
	public void setStayTimeInTicks(int stayTimeInTicks) {
		this.stayTimeInTicks = stayTimeInTicks;
	}

	@Override
	public int getFadeOutTimeInTicks() {
		return fadeOutTimeInTicks;
	}

	@Override
	public void setFadeOutTimeInTicks(int fadeOutTimeInTicks) {
		this.fadeOutTimeInTicks = fadeOutTimeInTicks;
	}

}
