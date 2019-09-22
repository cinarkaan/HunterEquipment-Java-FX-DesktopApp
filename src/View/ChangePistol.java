package View;

import Accessory.Pistol;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangePistol extends ChangeWeapons {


	private Pistol pistol = new Pistol();

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private boolean isErrorPistol() {
		String errorMessage = "";
		if (Brand.getText() == null || Brand.getText().length() == 0) {
			errorMessage += "Girdiginiz Tabancanýn bir markasý olmak zorundadýr!!!";
		}
		try {
			Integer.parseInt(Range.getText());
			if (Integer.parseInt(Range.getText()) < 50 || Integer.parseInt(Range.getText()) > 200) {
				errorMessage += "Tabancanýn menzili 50 ile 200 m arasinda olmalidir!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancanýn menzilini lütfen Tamsayý giriniz!\n";
		}
		try {
			Float.parseFloat(Weight.getText());
			if (Float.parseFloat(Weight.getText()) < 1.5 || Float.parseFloat(Weight.getText()) > 2.5) {
				errorMessage += "Tabancanýn aðýrlýðý 1.5 ile 2.5 kg arasinda olmalidir!!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancanýn aðýrlýðýný lütfen gerçek sayý giriniz!\n";
		}
		try {
			Integer.parseInt(Ammo.getText());
			if (Integer.parseInt(Ammo.getText()) < 6 || Integer.parseInt(Ammo.getText()) > 14) {
				errorMessage += "Tabancanýn þarjor kapasitesi 6 ile 14 mermi arasinda deðismelidir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancanýn þarjor kapasitesini lütfen Tamsayý giriniz!\n";
		}
		try {
			Integer.parseInt(FPS.getText());
			if (Integer.parseInt(FPS.getText()) < 400 || Integer.parseInt(FPS.getText()) > 650) {
				errorMessage += "Tabancanýn namlu çýkýþ hýzý 400 m/sn ile 650 m/sn arasinda deðerler almalýdýr!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancanýn namlu çýkýþ hýzýný lütfen Tamsayý giriniz!\n";
		}
		try {
			Float.parseFloat(Calibrer.getText());
			if (Float.parseFloat(Calibrer.getText()) < 9 || Float.parseFloat(Calibrer.getText()) > 50) {
				errorMessage += "Tabancanýzýn mermi kalibresi 9 ile 50 cal arasýnda olmak zorundadir!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Tabancanýzýn mermi kalibresini lütfen gerçek sayý giriniz!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Gecersiz Alanlar");
			alert.setHeaderText("Lutfen gecersiz alanlarý duzeltin");
			alert.setContentText(errorMessage);

			alert.showAndWait();
			return false;
		}
	}

	@FXML
	private void OkPistol() {
		if (isErrorPistol()) {
			this.pistol.setBullet_Type(Pistol_Bullet_Type.getSelectionModel().getSelectedItem().toString());
			changeWeapons(this.pistol);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	@Override
	public void setChange(Object object) {
		Pistol_Bullet_Type.setPromptText("Kullandýðýnýz mühimmat türünü seçiniz");
		Pistol_Bullet_Type.getItems().addAll(pistol.getBullet_Type().get(1), pistol.getBullet_Type().get(2),
				pistol.getBullet_Type().get(3), pistol.getBullet_Type().get(4));
		this.pistol = (Pistol) object;
	}

}
