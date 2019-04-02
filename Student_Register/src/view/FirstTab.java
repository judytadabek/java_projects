package view;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Course;

public class FirstTab extends GridPane {

	private ComboBox<Course> cboCourses;
	private TextField pnumber, fname, lname, email;
	private Button btnCreateProfile;
	private DatePicker dateInput;
	

	public FirstTab() {
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(30);
		this.setHgap(70);
		this.setAlignment(Pos.CENTER);
		this.setGridLinesVisible(false);
		this.setStyle("-fx-background-color: #00BFFF;");
		
		Label lblCourse = new Label("Select course: ");
		lblCourse.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		Label lblPNumber = new Label("Input P Number: ");
		lblPNumber.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		Label lblFName = new Label("Input first name: ");
		lblFName.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		Label lblLName = new Label("Input surname: ");
		lblLName.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		Label lblEmail = new Label("Input email: ");
		lblEmail.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		Label lblDate = new Label("Input date: ");
		lblDate.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		
		cboCourses = new ComboBox<Course>();
		cboCourses.setStyle("-fx-background-color: #FFEBCD;");
		
		pnumber = new TextField();
		pnumber.setStyle("-fx-background-color: #F0F8FF;");
		fname = new TextField();
		fname.setStyle("-fx-background-color: #F0F8FF;");
		lname = new TextField();
		lname.setStyle("-fx-background-color: #F0F8FF;");
		email = new TextField();
		email.setStyle("-fx-background-color: #F0F8FF;");
		dateInput = new DatePicker();
		dateInput.setStyle("-fx-background-color: #F0F8FF;");
		
		
		btnCreateProfile = new Button("Create Profile");
		btnCreateProfile.setStyle("-fx-background-color: #00008B;");
		btnCreateProfile.setTextFill(Color.WHITESMOKE);
		btnCreateProfile.setDefaultButton(true);

		this.add(lblCourse, 0, 0);
		this.add(cboCourses, 1, 0);

		this.add(lblPNumber, 0, 1);
		this.add(pnumber, 1, 1);

		this.add(lblFName, 0, 2);
		this.add(fname, 1, 2);
		
		this.add(lblLName, 0, 3);
		this.add(lname, 1, 3);
		
		this.add(lblEmail, 0, 4);
		this.add(email, 1, 4);
		
		this.add(lblDate, 0, 5);
		this.add(dateInput, 1, 5);
					
		this.add(new HBox(), 0, 6);
		this.add(btnCreateProfile, 1, 6);
	}
	
	public void populateComboBox(Course[] courses) {
		cboCourses.getItems().addAll(courses);
		cboCourses.getSelectionModel().select(0); //select first opponent by default
	}
	
	public Course getSelectedCourse() {
		return cboCourses.getSelectionModel().getSelectedItem();
	}
	
	public void setCourse(Course course) {
		this.cboCourses.setValue(course);
	}
	
	
	public String getPNumber() {
		return pnumber.getText();
		
	}
	
	public void setPNumber(String pnumber) {
		this.pnumber.setText(pnumber);
	}
	
	
	public String getFNameInput() {
		return fname.getText();
	}
	
	public void setFNameImput(String fname) {
		this.fname.setText(fname);
	}
	
	public String getLNameInput() {
		return lname.getText();
	}
	
	public void setLNameImput(String lname) {
		this.lname.setText(lname);
	}
	
	public String getEmail() {
		return email.getText();
	}
	
	public void setEmail (String email) {
		this.email.setText(email);
	}
		
	public LocalDate getDate() {
		return dateInput.getValue();
		
	}
	
	public void setDate(LocalDate value) {
		this.dateInput.setValue(value);
	}
	

	public void addCreateProfileListener(EventHandler<ActionEvent> handler) {
		btnCreateProfile.setOnAction(handler);
		}
	
	public void createProfileButtonFire() {
		if (btnCreateProfile.getOnAction() != null) {
			btnCreateProfile.fire();
		}
	}
}
