package view;

import javafx.animation.FadeTransition;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

public class ViewPane extends TabPane{
	private FirstTab first;
	private SecondTab second;
	private ThirdTab third;
	
	public ViewPane() {
		
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		first = new FirstTab();
		second = new SecondTab();
		third = new ThirdTab();
		
		//create tabs with panes added
		Tab t1 = new Tab("Create Profile", first);
		Tab t2 = new Tab("Input Marks", second);
		Tab t3 = new Tab("Overview Results", third);
		
		this.getTabs().addAll(t1, t2, t3);
	}

	/* These methods provide a public interface for the root pane and allow
	 * each of the sub-containers to be accessed by the controller. */
	public FirstTab getFirstTab() {
		return first;
	}

	public SecondTab getSecondTab() {
		return second;
	}
	
	public ThirdTab getThirdTab() {
		return third;
	}
	
	//method to allow the controller to change tabs
	public void changeTab(int index) {
		this.getSelectionModel().select(index);
	}
	
	public void fadeAnimation() {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), this);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);
		ft.play();
	}

}
