public class DocumentSubmission {

	static String namedata, addressdata, birthdaydata, emaildata, contactnumberdata, firstchoicedata, secondchoicedata, aveJHSdata, aveSHSdata;
	
	public static void dataretrival(String studentnumber) {
		try {
			File file = new File("src\\main\\java\\application\\enrollmentintellij_idea\\studentdata.dat");
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				if (scanner.nextLine().equals(studentnumber)) {
					namedata = scanner.nextLine();
					addressdata = scanner.nextLine();
					birthdaydata = scanner.nextLine();
					emaildata = scanner.nextLine();
					contactnumberdata = scanner.nextLine();
					firstchoicedata = scanner.nextLine();
					secondchoicedata = scanner.nextLine();
					aveJHSdata = scanner.nextLine();
					aveSHSdata = scanner.nextLine();
				}
			}
			scanner.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	static File newfile;
	
	public static void getfile(String studentnumber) {
		FileChooser fc = new FileChooser();
		File file = fc.showOpenDialog(null);
		
		if (file != null) {
			newfile = new File("src\\main\\java\\application\\enrollmentintellij_idea\\studentfiles\\" + studentnumber + "\\" + file.getName());
			
			FileInputStream inputfile = null;
			FileOutputStream outputfile = null;
			
			try {
				inputfile = new FileInputStream(file);
				outputfile = new FileOutputStream(newfile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				System.out.println(inputfile.available());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int i = 0;
			try {
				while ((i = inputfile.read()) != -1) {
					outputfile.write(i);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			finally {
				if (inputfile != null) {
					try {
						outputfile.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (outputfile != null) {
					try {
						inputfile.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void documentsubmissionmenu(String studentnumber) {
		Stage primaryStage = new Stage();
		
		File filepath = new File("src\\main\\java\\application\\enrollmentintellij_idea\\studentfiles\\" + studentnumber);
		filepath.mkdirs();
		
		dataretrival(studentnumber);
		
		BorderPane border = new BorderPane();
		
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(20);
		grid.setPadding(new Insets(20, 20, 30, 30));
		
		Label name = new Label("Student Name:\t\t" + namedata);
		grid.add(name, 0, 0);
		
		Label address = new Label("Home Address:\t\t" + addressdata);
		grid.add(address, 0, 1);
		
		Label birthday = new Label("Date of Birth:\t\t\t" + birthdaydata);
		grid.add(birthday, 0, 2);
		
		Label email = new Label("Personal Email:\t\t" + emaildata);
		grid.add(email, 0, 3);
		
		Label contactnumber = new Label("Contact Number:\t\t" + contactnumberdata);
		grid.add(contactnumber, 0, 4);
		
		Label firstchoice = new Label("First Course Choice:\t\t" + firstchoicedata);
		grid.add(firstchoice, 0, 5);
		
		Label secondchoice = new Label("Second Course Choice:\t" + secondchoicedata);
		grid.add(secondchoice, 0, 6);
		
		Label aveJHS = new Label("General Ave. for JHS:\t" + aveJHSdata);
		grid.add(aveJHS, 0, 7);
		
		Label aveSHS = new Label("General Ave. for SHS:\t" + aveSHSdata);
		grid.add(aveSHS, 0, 8);
		
		/*
		GridPane grid2 = new GridPane();
		grid2.setAlignment(Pos.TOP_LEFT);
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid2.setPadding(new Insets(20, 20, 30, 30));
		
		Label birthcert = new Label("Birth Certificate:");
		grid2.add(birthcert, 0, 0);
		
		Button addfile = new Button("Add File");
		grid2.add(addfile, 0, 1);
		
		addfile.setOnAction(e -> {
			getfile(studentnumber);
			primaryStage.close();
		});
		*/
		
		border.setLeft(grid);
		//border.setCenter(grid2);
		
		Scene scene = new Scene(border, 950, 450);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Document Verification Form");
		primaryStage.show();
	}

}
