package main;

import controller.StudentRegisterController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.StudentProfile;
import view.RootMenuBar;
import view.ViewPane;


public class ApplicationLoader extends Application {

	private ViewPane root;
	private Parent menuWithRoot;
	
	
	@Override
	public void init() {
		
		StudentProfile model = new StudentProfile();
		root = new ViewPane();
		RootMenuBar menu = new RootMenuBar();
		menuWithRoot = new BorderPane(root, menu, null, null, null);
		
		
		new StudentRegisterController(root, menu, model);	
		}
	
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(menuWithRoot);
		stage.setMinWidth(1000); 
		stage.setMinHeight(400);
		scene.getStylesheets().add(getClass().getResource("text-field-red-border.css").toExternalForm());
		//scene.setFill(Color.DEEPSKYBLUE);
		stage.setTitle("Student Profile Mark Submission Tool");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
