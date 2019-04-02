package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ThirdTab extends BorderPane {

	private TextArea results;
	private Button btnSaveOverview;
	
	@SuppressWarnings("static-access")
	public ThirdTab() {

		results = new TextArea("Overview will appear here...");
		results.setEditable(false);
		this.setPadding(new Insets(30, 30, 30, 30));
		
		btnSaveOverview = new Button("Save Overview");
		btnSaveOverview.setStyle("-fx-background-color: #00008B;");
		btnSaveOverview.setTextFill(Color.WHITESMOKE);
		HBox button = new HBox();
		button.setAlignment(Pos.CENTER);
		button.setPadding(new Insets(20, 20, 20, 20));
		button.getChildren().add(btnSaveOverview);
		this.setCenter(results);
		this.setBottom(button);
		this.setAlignment(button, Pos.BOTTOM_CENTER);
		this.setStyle("-fx-background-color: #00BFFF;");
	}
	
	public void setResults(String overview) {
		results.setText(overview);
	}
	
	public String getResults() {
		return results.getText();
	}
	
	public void addSaveListener(EventHandler <ActionEvent> handler) {
		btnSaveOverview.setOnAction(handler);
	}
}
