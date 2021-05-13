package minigame.view;

public class ViewFactoryProvider {

	private static ViewFactoryProvider instance;
	private ViewFactory viewFactory;

	private ViewFactoryProvider() {
		
	}
	
	public static ViewFactoryProvider getInstance() {
		if (instance == null)
			instance = new ViewFactoryProvider();
		return instance;
	}

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public void setViewFactory(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}
	
}
