package controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFileChooser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert.AlertType;
import view.FirstTab;
import view.MenuPane;
import view.RootMenuBar;

import view.SecondTab;
import view.ThirdTab;
import view.ViewPane;
import model.*;


public class StudentRegisterController {

	private ViewPane view;
	private FirstTab first_view;
	private SecondTab second_view;
	private ThirdTab third_view;
	private StudentProfile model;
	private RootMenuBar menu;


	public StudentRegisterController (ViewPane view, RootMenuBar menu, StudentProfile model) {
		this.model = model;
		this.view = view;
		this.menu = menu;
		first_view = view.getFirstTab();
		second_view = view.getSecondTab();
		third_view = view.getThirdTab();
		first_view.populateComboBox(setupCourse());
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {

		first_view.addCreateProfileListener(new CreateProfile()); //attaches button handler
		second_view.addClearListener(new ClearData());
		second_view.addSubmitListener(new SubmitProfileData());
		third_view.addSaveListener(new SaveOverview());

		menu.addLoadHandler(new LoadMenuHandler());
		menu.addSaveHandler(new SaveMenuHandler());
		menu.addExitHandler(e -> System.exit(0));
		menu.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Student Profile Mark Submission Tool p15238407"));
	}


	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	private Course[] setupCourse() {

		Module ctec2121 = new Module("CTEC2121", "Organisation, Project Management and Research", true);
		Module ctec2122 = new Module("CTEC2122", "Forensics and Security", false);
		Module ctec2602 = new Module("CTEC2601", "OO Software Design and Development", false);
		Module ctec2701 = new Module("CTEC2701", "Multi-tier Web Applications", true);
		Module ctec2901 = new Module ("CTEC2901", "Data Structures and Algorithms", false);
		Module lawg2003 = new Module("LAWG2003", "Issues in Criminal Justice", false);
		Module ctec2903 = new Module("CTEC2903", "System Defence Strategies", true);

		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec2121);
		compSci.addModule(ctec2602);
		compSci.addModule(ctec2701);
		compSci.addModule(ctec2901);

		Course softEng = new Course("Software Engineering");
		softEng.addModule(ctec2121);
		softEng.addModule(ctec2602);
		softEng.addModule(ctec2701);
		softEng.addModule(ctec2901);

		Course compSec = new Course("Computer Security");
		compSec.addModule(ctec2121);
		compSec.addModule(ctec2122);
		compSec.addModule(ctec2701);
		compSec.addModule(ctec2903);

		Course forenComp = new Course("Forensic Computing");
		forenComp.addModule(ctec2121);
		forenComp.addModule(ctec2122);
		forenComp.addModule(ctec2701);
		forenComp.addModule(lawg2003);

		Course[] courses = new Course[4];
		courses[0] = compSci;
		courses[1] = softEng;
		courses[2] = compSec;
		courses[3] = forenComp;

		return courses;

	}

	private void setModules() {
		Collection<Module> modules = model.getCourse().getModulesOnCourse();

		ArrayList<Module> list = new ArrayList<>(modules);

		second_view.setLblProfile(list.get(0).getModuleCode() + " " + list.get(0).getModuleName());
		second_view.setLblProfile1(list.get(1).getModuleCode() + " " + list.get(1).getModuleName());
		second_view.setLblProfile2(list.get(2).getModuleCode() + " " + list.get(2).getModuleName());
		second_view.setLblProfile3(list.get(3).getModuleCode() + " " + list.get(3).getModuleName());

		second_view.getTxtCwkMark().setText(String.valueOf(list.get(0).getCwkMark()));
		second_view.getTxtCwkMark1().setText(String.valueOf(list.get(1).getCwkMark()));
		second_view.getTxtCwkMark2().setText(String.valueOf(list.get(2).getCwkMark()));
		second_view.getTxtCwkMark3().setText(String.valueOf(list.get(3).getCwkMark()));

		if (list.get(0).isCwkOnly()) {
			second_view.getExamMarkTxtField().setDisable(true);
			second_view.getExamMarkTxtField().setVisible(false);
		} else {
			second_view.getExamMarkTxtField().setText(String.valueOf(list.get(0).getExamMark()));
		}

		if (list.get(1).isCwkOnly()) {
			second_view.getExamMarkTxtField1().setDisable(true);
			second_view.getExamMarkTxtField1().setVisible(false);
		} else {
			second_view.getExamMarkTxtField1().setText(String.valueOf(list.get(1).getExamMark()));
		}

		if (list.get(2).isCwkOnly()) {
			second_view.getExamMarkTxtField2().setDisable(true);
			second_view.getExamMarkTxtField2().setVisible(false);
		} else {
			second_view.getExamMarkTxtField2().setText(String.valueOf(list.get(2).getExamMark()));
		}

		if (list.get(3).isCwkOnly()) {
			second_view.getExamMarkTxtField3().setDisable(true);
			second_view.getExamMarkTxtField3().setVisible(false);
		} else {
			second_view.getExamMarkTxtField3().setText(String.valueOf(list.get(3).getExamMark()));
		}
	}

	private class CreateProfile implements EventHandler<ActionEvent> {
		public void handle (ActionEvent e) {
			//let's retrieve modules
			model.setCourse(first_view.getSelectedCourse());
			model.setpNumber(first_view.getPNumber());
			model.setStudentName(new Name(first_view.getFNameInput(), first_view.getLNameInput()));
			model.setEmail(first_view.getEmail());
			model.setDate(first_view.getDate());

			setModules();
			second_view.fireClearEvent();
			view.changeTab(1);
		}


	}

	private class ClearData implements EventHandler<ActionEvent> {
		public void handle (ActionEvent e) {
			second_view.getTxtCwkMark().clear();
			second_view.getTxtCwkMark1().clear();
			second_view.getTxtCwkMark2().clear();
			second_view.getTxtCwkMark3().clear();

			second_view.getExamMarkTxtField().clear();
			second_view.getExamMarkTxtField1().clear();
			second_view.getExamMarkTxtField2().clear();
			second_view.getExamMarkTxtField3().clear();

		}
	}

	private class SubmitProfileData implements EventHandler<ActionEvent> {
		public void handle (ActionEvent e) {


			Collection<Module> modules = model.getCourse().getModulesOnCourse();
			ArrayList<Module> list = new ArrayList<>(modules);
			list.get(0).setCwkMark(second_view.getCwkMark());
			list.get(1).setCwkMark(second_view.getCwkMark1());
			list.get(2).setCwkMark(second_view.getCwkMark2());
			list.get(3).setCwkMark(second_view.getCwkMark3());

			list.get(0).setExamMark(second_view.getExamMark());
			list.get(1).setExamMark(second_view.getExamMark1());
			list.get(2).setExamMark(second_view.getExamMark2());
			list.get(3).setExamMark(second_view.getExamMark3());

			list.get(0).setModuleCode(second_view.getLblProfile().substring(0, 9));
			list.get(1).setModuleCode(second_view.getLblProfile1().substring(0, 9));
			list.get(2).setModuleCode(second_view.getLblProfile2().substring(0, 9));
			list.get(3).setModuleCode(second_view.getLblProfile3().substring(0, 9));


			view.changeTab(2);

			third_view.setResults("Course : " + model.getCourse() + "\n" +
					"Student Name: " + model.getStudentName().getFullName() + "\n" +
					"Email: " + model.getEmail() + "\n" +
					"Date: " + model.getDate() + "\n" +
					"PNumber: " + model.getpNumber() 

					+ "\n===========================\n" + 
					list.get(0).getModuleCode() + "\tcoursework: " + list.get(0).getCwkMark() + "\tExam: " + list.get(0).getExamMark() + 
					"\tAverage : " + list.get(0).getModuleMark() + "\t Require resit? " + list.get(0).requireResit() + "\n----------------------------------\n" +
					list.get(1).getModuleCode() + "\tcoursework: " + list.get(1).getCwkMark() + "\tExam: " + list.get(1).getExamMark() + 
					"\tAverage : " + list.get(1).getModuleMark() + "\t Require resit? " + list.get(1).requireResit() + "\n----------------------------------\n" +
					list.get(2).getModuleCode() + "\tcoursework: " + list.get(2).getCwkMark() + "\tExam: " + list.get(2).getExamMark() + 
					"\tAverage : " + list.get(2).getModuleMark() + "\t Require resit? " + list.get(2).requireResit() + "\n----------------------------------\n" +	
					list.get(3).getModuleCode() + "\tcoursework: " + list.get(3).getCwkMark() + "\tExam: " + list.get(3).getExamMark() + 
					"\tAverage : " + list.get(3).getModuleMark() + "\t Require resit? " + list.get(3).requireResit() + "\n----------------------------------\n" +
					"\n=====================================================================\n"
					+ "Credits passed: " + model.getCourse().creditsPassed() + 
					"\n Average year: " + model.getCourse().yearAverageMark());
		}

	}

	
	private class SaveOverview implements EventHandler<ActionEvent> {
		public void handle (ActionEvent e) {

			PrintWriter out;
			try {
				String fileName = "sRegister.txt";
				out = new PrintWriter(fileName);
				out.println(third_view.getResults());
				out.flush();
				out.close();
							
				File file = new File(fileName);
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save file");
				fileChooser.setInitialFileName("sRegister.txt");
				fileChooser.getExtensionFilters().addAll(
				         new ExtensionFilter("Text Files", "*.txt"),
				         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
				         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
				         new ExtensionFilter("All Files", "*.*"));
				
				Stage stage = new Stage();
				stage.setUserData(third_view.getResults());
				
				File fileToBeSaved = fileChooser.showSaveDialog(stage);
		

				if (fileToBeSaved != null) {
				    try {
				        Files.copy(file.toPath(), fileToBeSaved.toPath());
				    } catch (IOException ex) {
				       System.out.println("Handle exeption");
				    }
		
				}
				System.out.println(fileToBeSaved);				

				alertDialogBuilder(AlertType.INFORMATION, "", "Save successful!", "Results saved to the file sRegister.txt");
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
				alertDialogBuilder(AlertType.ERROR, "Error Dialog", "Error saving", "Results not saved to sRegister.txt");

			}

		}
	}

	private class SaveMenuHandler implements EventHandler<ActionEvent> {
		public void handle (ActionEvent e) {
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = 
                    new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
            fileChooser.getExtensionFilters().add(extFilter);
			File dest = fileChooser.showSaveDialog(first_view.getScene().getWindow());
			

			if (dest == null) {
				return;
			}
			
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest.getAbsolutePath()));) {

				oos.writeObject(model);
				oos.flush();
				view.fadeAnimation(); 
				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "Profile saved to studentRegisterObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error saving");
				alertDialogBuilder(AlertType.ERROR, "Error Dialog", "Error saving", "Profile not saved to studentRegisterObj.dat");
			}
			catch (NullPointerException np) {
				System.out.println("Data has not been saved in the profile yet");
				alertDialogBuilder(AlertType.WARNING, "WARING", "Null Pointer Exception", "Profile has not been saved yet. Please, first create profile");
			}
		}

	}
	
	private class LoadMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = 
                    new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
			FileChooser.ExtensionFilter extFilter2 = 
					new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().addAll(extFilter2, extFilter);
			File dest = fileChooser.showOpenDialog(first_view.getScene().getWindow());
			
			if (dest == null) {
				return;
			}
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dest.getAbsolutePath()));) {

				model = (StudentProfile) ois.readObject();
				System.out.println(model);
				first_view.setCourse(model.getCourse());
				first_view.setPNumber(model.getpNumber());
				first_view.setFNameImput(model.getStudentName().getFirstName());
				first_view.setLNameImput(model.getStudentName().getFamilyName());
				first_view.setEmail(model.getEmail());
				first_view.setDate(model.getDate());
				first_view.setCourse(model.getCourse());
				view.fadeAnimation();
				view.changeTab(1);
				setModules();
				view.fadeAnimation();
				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Register loaded from studentRegisterObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
				alertDialogBuilder(AlertType.WARNING, "Error", "Class not found!", "Register has not been loaded from studentRegisterObj.dat");
			}
			catch (NullPointerException npe) {
				System.out.println("No data to load");
				alertDialogBuilder(AlertType.ERROR, "Error", "No data to be loaded", "No data has been loaded from file studentRegisterObj.dat");
			}

		}
	}
}
