package minigame.view;

public interface TitleViewModel {

	String getTitle();

	void setTitle(String title);

	String getSubtitle();

	void setSubtitle(String subtitle);

	void setFadeInTimeInTicks(int fadeInTimeInTicks);

	void setFadeOutTimeInTicks(int fadeOutTimeInTicks);

	void setStayTimeInTicks(int stayTimeInTicks);
	
	void setFadeInTimeInSeconds(int faceInTimeInSeconds);
	
	void setFadeOutTimeInSeconds(int fadeOutTimeInSeconds);
	
	void setStayTimeInSeconds(int stayTimeInSeconds);

	int getFadeInTimeInTicks();

	int getStayTimeInTicks();

	int getFadeOutTimeInTicks();

}
