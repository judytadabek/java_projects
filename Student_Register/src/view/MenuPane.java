package view;

import javafx.beans.value.ChangeListener;

import javafx.geometry.Insets;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;

public class MenuPane extends SplitPane {

	private TextArea inputArea, outputArea;

	public MenuPane() {
		this.setPadding(new Insets(10,10,10,10));

		inputArea = new TextArea();
		inputArea.setPrefRowCount(20);
		inputArea.setPrefColumnCount(20);
		inputArea.setWrapText(true);
		
		//attaches the listener created in the method below
		inputArea.textProperty().addListener(hexConverterListener()); 

		outputArea = new TextArea();
		outputArea.setPrefRowCount(20);
		outputArea.setPrefColumnCount(20);
		outputArea.setWrapText(true);
		outputArea.setEditable(false);

		this.getItems().addAll(inputArea, outputArea);
	}

	//get/set methods to be used by other methods of this class and the external menu bar
	public String getInputAreaText() {
		return inputArea.getText();
	}

	public void setInputAreaText(String text) {
		inputArea.setText(text);
	}
	
	public void setOutputAreaText(String text) {
		outputArea.setText(text);
	}

	//a method that returns a ChangeListener, which sets the output area to display hex
	public ChangeListener<String> hexConverterListener() {
		return (observable, oldValue, newValue) -> {
			setOutputAreaText(toHex(newValue));
		};
	}

	//accepts an input string and returns a string in corresponding hexadecimal form
	private String toHex(String input) {
		StringBuilder sb = new StringBuilder();
		for (byte b : input.getBytes()) {
			sb.append(String.format("%02X ", b));
		}
		return sb.toString();
	}



}