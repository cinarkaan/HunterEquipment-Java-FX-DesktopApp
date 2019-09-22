package View;

import File.ReadFile;
import File.WriteFile;
import Hunter.Hunter;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

	String Id = "123";
	String Pass = "123";
	private MainApp mainApp;
	private ReadFile readFile = new ReadFile();
	

	@FXML
	private Text isRecord;
	@FXML
	private CheckBox yesloadrecord;
	@FXML
	private CheckBox noloadrecord;

	@FXML
	private TextField IdText;
	@FXML
	private TextField PassText;

	@FXML
	private void initialize() {
		this.isRecord.setText(WriteFile.totalRecord+" adet Kayýt bulundu bulunan kayýtlar yüklensinmi?");
		if (WriteFile.totalRecord == 0) {
			yesloadrecord.setVisible(false);
			noloadrecord.setVisible(false);
			isRecord.setVisible(false);
			ReadFile.highId = 0;
			Hunter.hunter_id = 0;
		}
	}

	@FXML
	private void yesLoadRecord() {
		if (yesloadrecord.isSelected()) {
			noloadrecord.setSelected(false);
		}
	}

	@FXML
	private void noLoadRecord() {
		if (noloadrecord.isSelected()) {
			yesloadrecord.setSelected(false);
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public LoginController() {
		this.mainApp = new MainApp();
	}

	@FXML
	private void OpenSaveHunter() {
		if (IdText.getText().equals(Id) && PassText.getText().equals(Pass)) {
			if (yesloadrecord.isSelected() && this.mainApp.isEmpty()) {
				readFile.showFile(this.mainApp, 1);
			}
			mainApp.hunterDetail();
		}
	}
}
