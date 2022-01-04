package application.enrollmentintellij_idea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EnrollmentForm {
	
	public static void enrollmentMenu(String studentnumber) {
		Stage primaryStage = new Stage();
		
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(10);
		//grid.setPadding(new Insets(20, 30, 30, 47));
		
		// imagine this as a table
		// row #1
		Label title = new Label("STUDENT ENROLLMENT FORM");
		grid.add(title, 0, 0, 4, 1);
		GridPane.setHalignment(title, HPos.CENTER);
		// row #2
		Label title2 = new Label("Student Information");
		grid.add(title2, 0, 1, 4, 1);
		GridPane.setHalignment(title2, HPos.CENTER);
		// row #3
		Label StudentName = new Label("Student's Name:");
		grid.add(StudentName, 0, 2);
		TextField firstnameField = new TextField();
		firstnameField.setMinWidth(250);
		grid.add(firstnameField, 1, 2);
		TextField middlenameField = new TextField();
		middlenameField.setMinWidth(250);
		grid.add(middlenameField, 2, 2);
		TextField lastnameField = new TextField();
		lastnameField.setMinWidth(250);
		grid.add(lastnameField, 3, 2);
		// row #4
		Label firstname = new Label("(First Name)");
		grid.add(firstname, 1, 3);
		GridPane.setHalignment(firstname, HPos.CENTER);
		Label middlename = new Label("(Middle Name)");
		grid.add(middlename, 2, 3);
		GridPane.setHalignment(middlename, HPos.CENTER);
		Label lastname = new Label("(Last Name)");
		grid.add(lastname, 3, 3);
		GridPane.setHalignment(lastname, HPos.CENTER);
		// row #5
		Label address = new Label("Address:");
		grid.add(address, 0, 4);
		TextField addressField = new TextField();
		addressField.setMinWidth(250);
		grid.add(addressField, 1, 4);
		// row #6
		Label dateOfBirth = new Label("Date of Birth:");
		grid.add(dateOfBirth, 0, 5);
		TextField dateOfBirthField = new TextField();
		addressField.setMinWidth(250);
		grid.add(dateOfBirthField, 1, 5);
		// row #7
		Label emailAddress = new Label("Email Address:");
		grid.add(emailAddress, 0, 6);
		TextField emailAddressField = new TextField();
		addressField.setMinWidth(250);
		grid.add(emailAddressField, 1, 6);
		// row #8
		Label contactNumber = new Label("Contact Number:");
		grid.add(contactNumber, 0, 7);
		TextField contactNumberField = new TextField();
		addressField.setMinWidth(250);
		grid.add(contactNumberField, 1, 7);
		// row #9
		Label preferredCourses = new Label("Preferred Courses:");
		grid.add(preferredCourses, 0, 8);
		ComboBox<String> firstChoiceBox = new ComboBox<>();
		firstChoiceBox.setMinWidth(250);
		firstChoiceBox.getItems().add("Choice 1");
		firstChoiceBox.getItems().add("Choice 2");
		firstChoiceBox.getItems().add("Choice 3");
		grid.add(firstChoiceBox, 1, 8);
		ComboBox<String> secondChoiceBox = new ComboBox<>();
		secondChoiceBox.setMinWidth(250);
		secondChoiceBox.getItems().add("Choice 1");
		secondChoiceBox.getItems().add("Choice 2");
		secondChoiceBox.getItems().add("Choice 3");
		grid.add(secondChoiceBox, 2, 8);
		// row #10
		Label firstChoice = new Label("First Choice");
		grid.add(firstChoice, 1, 9);
		GridPane.setHalignment(firstChoice, HPos.CENTER);
		Label secondChoice = new Label("Second Choice");
		grid.add(secondChoice, 2, 9);
		GridPane.setHalignment(secondChoice, HPos.CENTER);
		// row #11
		Label genAveJHS = new Label("General Ave. for JHS:");
		grid.add(genAveJHS, 0, 10);
		TextField genAveJHSField = new TextField();
		genAveJHSField.setMinWidth(250);
		grid.add(genAveJHSField, 1, 10);
		// row #12
		Label genAveSHS = new Label("General Ave. for SHS:");
		grid.add(genAveSHS, 0, 11);
		TextField genAveSHSField = new TextField();
		genAveSHSField.setMinWidth(250);
		grid.add(genAveSHSField, 1, 11);
		// row #13
		Button submitBtn = new Button("Submit");
		submitBtn.setMinWidth(80);
		grid.add(submitBtn, 0, 12, 4, 1);
		GridPane.setHalignment(submitBtn, HPos.CENTER);
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setMinWidth(80);
		grid.add(cancelBtn, 3, 12);
		GridPane.setHalignment(cancelBtn, HPos.CENTER);
		
		submitBtn.setOnAction(e -> {
			String fullname = firstnameField.getText() + " " + middlenameField.getText() + " " + lastnameField.getText();
			String addressdata = addressField.getText();
			String dateOfBirthdata = dateOfBirthField.getText();
			String emailAddressdata = emailAddressField.getText();
			String contactNumberdata = contactNumberField.getText();
			String firstChoicedata = firstChoiceBox.getValue();
			String secondChoicedata = secondChoiceBox.getValue();
			String genAveJHSdata = genAveJHSField.getText();
			String genAveSHSdata = genAveSHSField.getText();
			
			if (fullname == "" || addressField.getText() == null || dateOfBirthField.getText() == null ||
					emailAddressField.getText() == null || contactNumberField.getText() == null ||
					firstChoiceBox.getValue() == null || secondChoiceBox.getValue() == null) {
				System.out.println("Invalid");
			} else {
				try {
					Scanner scanner = new Scanner(new File("src\\main\\java\\application\\enrollmentintellij_idea\\studentdata.dat"));
					StringBuffer buffer = new StringBuffer();
					
					while (scanner.hasNextLine()) {
						buffer.append(scanner.nextLine() + System.lineSeparator());
					}
					String fileContents = buffer.toString();
					scanner.close();
					
					FileWriter filewriter = new FileWriter("src\\main\\java\\application\\enrollmentintellij_idea\\studentdata.dat");
					PrintWriter output = new PrintWriter(filewriter);
					
					if (!fileContents.replaceAll("[^0-9a-zA-Z]", "").matches("")) {
						output.print(fileContents);
					}
					output.println(studentnumber);
					output.println(fullname);
					output.println(addressdata);
					output.println(dateOfBirthdata);
					output.println(emailAddressdata);
					output.println(contactNumberdata);
					output.println(firstChoicedata);
					output.println(secondChoicedata);
					output.println(genAveJHSdata);
					output.print(genAveSHSdata);
					
					output.flush();
					output.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				primaryStage.close();
			}
			DocumentSubmission.documentsubmissionmenu(studentnumber);
		});
		
		Scene scene = new Scene(grid, 950, 450);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Student Enrollment Form");
		primaryStage.show();
	}
}
