package view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;

public class RootMenuBar extends MenuBar {

	//private MenuPane iop; //holds a reference to the root pane
	private MenuItem load, save, exit, about;

	public RootMenuBar() { 
		

		//temp vars for menus and menu items within this MenuBar
		Menu menu;
		//MenuItem menuItem;

		//file menu
		menu = new Menu("_File");

		load = new MenuItem("_Load Student Data");
		load.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		//menuItem.setOnAction(new LoadHandler()); //attach event handler
		menu.getItems().add(load);

		save = new MenuItem("_Save Student Data");
		save.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		//menuItem.setOnAction(new SaveHandler()); //attach event handler
		menu.getItems().add(save);

		menu.getItems().add(new SeparatorMenuItem());

		exit = new MenuItem("E_xit");
		exit.setAccelerator(KeyCombination.keyCombination("SHORTCUT+Q"));
		//menuItem.setOnAction(e -> System.exit(0)); //exits the application
		menu.getItems().add(exit);

		this.getMenus().add(menu);


		//help menu
		menu = new Menu("_Help");

		about = new MenuItem("_About");
		about.setAccelerator(KeyCombination.keyCombination("SHORTCUT+B"));
		//menuItem.setOnAction(new AboutHandler()); //attach event handler
		menu.getItems().add(about);

		this.getMenus().add(menu); 
	}
	
	public void addLoadHandler (EventHandler<ActionEvent> handler) {
		load.setOnAction(handler);
	}
	
	public void addSaveHandler(EventHandler<ActionEvent> handler) {
		save.setOnAction(handler);
	}
	
	public void addExitHandler (EventHandler<ActionEvent> handler) {
		exit.setOnAction(handler);
	}

	public void addAboutHandler(EventHandler<ActionEvent> handler) {
		about.setOnAction(handler);
	}
}

