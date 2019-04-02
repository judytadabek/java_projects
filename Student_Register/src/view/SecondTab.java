package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SecondTab extends BorderPane {

	private Label lblModule, lblCwkMark, lblExamMark, lblProfile, lblProfile1, lblProfile2, lblProfile3;
	private TextField txtCwkMark, txtCwkMark1, txtCwkMark2, txtCwkMark3, txtExamMark, txtExamMark1, txtExamMark2, txtExamMark3;
	private Button btnClear, btnSubmit;

	
	public SecondTab() {
		
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setStyle("-fx-background-color: #00BFFF;");
		
		lblModule = new Label("Module");
		lblModule.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		
		lblCwkMark = new Label("Cwk Mark");
		lblCwkMark.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		
		lblExamMark = new Label("Exam Mark");
		lblExamMark.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		
		lblProfile = new Label();
		lblProfile.setText("Profile not created");
		lblProfile.setFont(Font.font("Verdana", 14));
		lblProfile.setAlignment(Pos.CENTER);
		
		lblProfile1 = new Label();
		lblProfile1.setText("Profile not created");
		lblProfile1.setFont(Font.font("Verdana", 14));
		lblProfile1.setAlignment(Pos.CENTER);
		
		lblProfile2 = new Label();
		lblProfile2.setText("Profile not create");
		lblProfile2.setFont(Font.font("Verdana", 14));
		lblProfile2.setAlignment(Pos.CENTER);
		
		lblProfile3 = new Label();
		lblProfile3.setText("Profile not created");
		lblProfile3.setAlignment(Pos.CENTER);

		txtCwkMark = new TextField();
		txtCwkMark.setAlignment(Pos.CENTER);
		
		txtCwkMark1 = new TextField();
		txtCwkMark1.setAlignment(Pos.CENTER);
		
		txtCwkMark2 = new TextField();
		txtCwkMark2.setAlignment(Pos.CENTER);
		
		txtCwkMark3 = new TextField();
		txtCwkMark3.setAlignment(Pos.CENTER);
		
		txtExamMark = new TextField();
		txtExamMark.setAlignment(Pos.CENTER);
		
		txtExamMark1 = new TextField();
		txtExamMark1.setAlignment(Pos.CENTER);
		
		txtExamMark2 = new TextField();
		txtExamMark2.setAlignment(Pos.CENTER);
		
		txtExamMark3 = new TextField();
		txtExamMark3.setAlignment(Pos.CENTER);
			

		
		VBox row1 = new VBox();
		row1.setSpacing(20);
		row1.setPadding(new Insets(50, 50, 50, 50));
		row1.setAlignment(Pos.CENTER);
		row1.setStyle("-fx-background-color: #F0F8FF;");
		row1.getChildren().addAll(lblModule, lblProfile, lblProfile1, lblProfile2, lblProfile3);
		
		VBox row2 = new VBox();
		row2.setSpacing(10);
		row2.setPadding(new Insets(50, 50, 50, 50));
		row2.setAlignment(Pos.CENTER);
		row2.setStyle("-fx-background-color: #F0F8FF;");
		row2.getChildren().addAll(lblCwkMark, txtCwkMark, txtCwkMark1, txtCwkMark2, txtCwkMark3);
		
		VBox row3 = new VBox();
		row3.setSpacing(10);
		row3.setPadding(new Insets(50, 50, 50, 50));
		row3.setAlignment(Pos.CENTER);
		row3.setStyle("-fx-background-color: #F0F8FF;");
		row3.getChildren().addAll(lblExamMark, txtExamMark, txtExamMark1, txtExamMark2, txtExamMark3);
		
		HBox labelsAndTextFields = new HBox();
		labelsAndTextFields.setAlignment(Pos.CENTER);
		labelsAndTextFields.setPadding(new Insets(50, 50, 50, 50));
		labelsAndTextFields.getChildren().addAll(row1, row2, row3);
		
		
		
		btnClear = new Button("Clear");
		btnClear.setPrefSize(70, 40);
		btnClear.setStyle("-fx-background-color: #00008B;");
		btnClear.setTextFill(Color.WHITESMOKE);
		btnClear.setCancelButton(true);
		btnSubmit = new Button("Submit");
		btnSubmit.setPrefSize(70, 40);
		btnSubmit.setStyle("-fx-background-color: #00008B;");
		btnSubmit.setTextFill(Color.WHITESMOKE);
				
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(100);
		hbox.getChildren().addAll(btnClear, btnSubmit);
		
		this.setCenter(labelsAndTextFields);
		this.setBottom(hbox);
		
	}

	public String getLblProfile() {
		return lblProfile.getText();
	}

	public void setLblProfile(String lblProfile) {
		this.lblProfile.setText(lblProfile);
	}

	public String getLblProfile1() {
		return lblProfile1.getText();
	}

	public void setLblProfile1(String lblProfile1) {
		this.lblProfile1.setText(lblProfile1);
	}

	public String getLblProfile2() {
		return lblProfile2.getText();
	}

	public void setLblProfile2(String lblProfile2) {
		this.lblProfile2.setText(lblProfile2);
	}

	public String getLblProfile3() {
		return lblProfile3.getText();
	}

	public void setLblProfile3(String lblProfile3) {
		this.lblProfile3.setText(lblProfile3);
	}
	
	public void setCwkMark(String txtCwkMark) {
		this.txtCwkMark.setText(txtCwkMark);
	}
	
	public int getCwkMark() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtCwkMark.getText());
			SecondTab.resetTextFieldError(txtCwkMark);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtCwkMark);
			txtCwkMark.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}
	
	
	
	public int getCwkMark1() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtCwkMark1.getText());
			SecondTab.resetTextFieldError(txtCwkMark1);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtCwkMark1);
			txtCwkMark1.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}
	
	
	
	public void setCwkMark1(String txtCwkMark1) {
		this.txtCwkMark1.setText(txtCwkMark1);
	}
	
	public int getCwkMark2() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtCwkMark2.getText());
			SecondTab.resetTextFieldError(txtCwkMark2);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtCwkMark2);
			txtCwkMark2.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}
	
	public void setCwkMark2(String txtCwkMark2) {
		this.txtCwkMark2.setText(txtCwkMark2);
	}

	
	public int getCwkMark3() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtCwkMark3.getText());
			SecondTab.resetTextFieldError(txtCwkMark3);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtCwkMark3);
			txtCwkMark3.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}

	public void setCwkMark3(String txtCwkMark3) {
		this.txtCwkMark3.setText(txtCwkMark3);
	}
	
	public TextField getTxtCwkMark() {
		return txtCwkMark;
	}

	public TextField getTxtCwkMark1() {
		return txtCwkMark1;
	}

	public TextField getTxtCwkMark2() {
		return txtCwkMark2;
	}

	public TextField getTxtCwkMark3() {
		return txtCwkMark3;
	}

	public TextField getExamMarkTxtField() {
		return txtExamMark;
	}
	
	public TextField getExamMarkTxtField1() {
		return txtExamMark1;
	}
	
	public TextField getExamMarkTxtField2() {
		return txtExamMark2;
	}
	
	public TextField getExamMarkTxtField3() {
		return txtExamMark3;
	}

	
	
	
	
	public void setExamMark(String txtExamMark) {
		this.txtExamMark.setText(txtExamMark);
	}
	
	public int getExamMark() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtExamMark.getText());
			SecondTab.resetTextFieldError(txtExamMark);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtExamMark);
			txtExamMark.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}
	
	
	
	public void setExamMark1(String txtExamMark1) {
		this.txtExamMark1.setText(txtExamMark1);
	}
		
	public int getExamMark1() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtExamMark1.getText());
			SecondTab.resetTextFieldError(txtExamMark1);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtExamMark1);
			txtExamMark1.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}
	
	public void setExamMark2(String txtExamMark2) {
		this.txtExamMark2.setText(txtExamMark2);
	}

	public int getExamMark2() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtExamMark2.getText());
			SecondTab.resetTextFieldError(txtExamMark2);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtExamMark2);
			txtExamMark2.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}
	
	public void setExamMark3(String txtExamMark3) {
		this.txtExamMark3.setText(txtExamMark3);
	}
	
	public int getExamMark3() {
		int mark = 0;		
		try {
			mark = Integer.parseInt(txtExamMark3.getText());
			SecondTab.resetTextFieldError(txtExamMark3);	
		} catch(NumberFormatException nfe) {
			SecondTab.setTextFieldError(txtExamMark3);
			txtExamMark3.setText("Pass Integer");
		}
		
		if ( mark >= 0 && mark <= 100) {
			return mark;
		} else {
			return -1;
		}
	}
	
	public void addClearListener(EventHandler<ActionEvent> handler) {
		btnClear.setOnAction(handler);
	}
	
	
	public void addSubmitListener(EventHandler<ActionEvent> handler) {
		btnSubmit.setOnAction(handler);
	}
	
	public static void setTextFieldError(TextField tf) {
		tf.getStyleClass().add("error");
	}
	
	public static void resetTextFieldError(TextField tf) {
		tf.getStyleClass().remove("error");
	}
	
	public void fireClearEvent() {
		if (btnClear.getOnAction() != null) {
			btnClear.fire();
		}
	}
}
