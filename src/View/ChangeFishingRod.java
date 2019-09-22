package View;

import Accessory.FishingRod;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangeFishingRod {

	@FXML
	private ComboBox<String> F_Rod_Type;
	@FXML
	private TextField Rotation_Rate;
	@FXML
	private TextField Number_Of_Ball;
	@FXML
	private TextField Rod_Brand;

	private boolean okClicked = false;
	private Stage dialogStage;
	private FishingRod fishingRod = new FishingRod();

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void changeAccessory(Object object) {
		((FishingRod) object).setNumber_Of_Ball(Integer.parseInt(Number_Of_Ball.getText()));
		((FishingRod) object).setRotation_Rate(Float.parseFloat(Rotation_Rate.getText()));
	}

	private boolean isErrorFishingRod() {
		String errorMessage = "";
		if (Rod_Brand.getText() == null || Rod_Brand.getText().length() == 0) {
			errorMessage += "Kullandýðýnýz oltanýn markasý olmak zorundadýr!!!!";
		}
		try {
			Integer.parseInt(Number_Of_Ball.getText());
			if (Integer.parseInt(Number_Of_Ball.getText()) < 6 || Integer.parseInt(Number_Of_Ball.getText()) > 11) {
				errorMessage += "Kullandýðýnýz oltanýn bilye sayisi 6 ile 11 arasinda olmalýdýr!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullandýðýnýz oltanýn bilye sayisýný lütfen Tamsayý giriniz!\n";
		}
		try {
			Float.parseFloat(Rotation_Rate.getText());
			if (Float.parseFloat(Rotation_Rate.getText()) < 5.5 || Float.parseFloat(Rotation_Rate.getText()) > 9.4) {
				errorMessage += "Kullandýðýnýz oltanýn devir oraný 5.5 ile 9.4 w arasinda olmalýdýr!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullandýðýnýz oltanýn dönme oranýný lütfen gerçek sayi giriniz!\n";
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
	private void OkFishingRod() {
		if (isErrorFishingRod()) {
			this.fishingRod.setRod_Type(F_Rod_Type.getSelectionModel().getSelectedItem().toString());
			changeAccessory(this.fishingRod);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	public void setChange(Object object) {
		F_Rod_Type.setPromptText("Olta türü seçiniz");
		F_Rod_Type.getItems().addAll(fishingRod.getF_Rod_Type().get(1), fishingRod.getF_Rod_Type().get(2),
				fishingRod.getF_Rod_Type().get(3), fishingRod.getF_Rod_Type().get(4),
				fishingRod.getF_Rod_Type().get(5));
		this.fishingRod = (FishingRod) object;
	}
}
