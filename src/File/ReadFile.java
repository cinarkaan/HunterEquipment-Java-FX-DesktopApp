package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import Hunter.Hunter;
import View.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReadFile {

	@FXML
	private TextField fileId;
	private Stage dialogStage;
	private Hunter hunter;
	BufferedReader reader;
	public static boolean isOk = true;
	public static int highId;
	boolean isAllRead;
	
	@FXML
	private void initialize() {

	}

	public Hunter isFileHunter() {
		
		
		
		return this.hunter;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void OkOpenFile() {
		openFile();
		dialogStage.close();
	}

	@FXML
	private void Cancel() {
		isOk = true;
		dialogStage.close();
	}
	
	private void openFile() {
		
		Path path = Paths.get(fileId.getText() + ".txt");
		File file = new File(path.toString());
		try {
			if (file.exists()) {
				this.hunter = new Hunter();
				FileReader fileReader = new FileReader(file);
				this.reader = new BufferedReader(fileReader);
				this.hunter.getFile(reader);
				this.hunter.getAccessory().getRifle().getFile(reader);
				this.hunter.getAccessory().getPistol().getFile(reader);
				this.hunter.getAccessory().getTent().getFile(reader);
				this.hunter.getAccessory().getBag().getFile(reader);
				this.hunter.getAccessory().getKnife().getFile(reader);
				this.hunter.getAccessory().getFishing_Rod().getFile(reader);
				this.hunter.getAccessory().getFishing_Eat().getFile(reader);
				fileReader.close();
				System.out.println("Dosya okundu!!!!");
			} else {
				System.out.println("Dosya mevcut degil!!!!!");
				this.hunter = null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public boolean totalFile() {
		Path path = Paths.get("totalHunter.txt");
		File file = new File(path.toString());
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileReader fileReader = new FileReader(file);
			this.reader = new BufferedReader(fileReader);
			reader.readLine();
			WriteFile.totalRecord = Integer.parseInt(reader.readLine());
			reader.readLine();
			Hunter.hunter_id = Integer.parseInt(reader.readLine());
			ReadFile.highId = Hunter.hunter_id;
			System.out.println("Yeni hunter_id ------->>>>>>"+Hunter.hunter_id);
			reader.close();
			fileReader.close();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public void showFile (MainApp app,int i) {
		if (isAllRead) {
			return;
		} else {
			this.fileId = new TextField();
			this.fileId.setText(Integer.toString(i));
			openFile();
			if (this.hunter != null) {
				app.getHunterData().add(this.hunter);
			}
			if (i == ReadFile.highId) {
				isAllRead = true;
			}
			showFile(app, ++i);
		}
	}
	
}
