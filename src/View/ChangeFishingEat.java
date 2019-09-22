package View;

import Accessory.FishingEat;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangeFishingEat{

	@FXML
	private ComboBox<String> Eat_Type = new ComboBox<>();
	@FXML
	private TextField Total_Eat;
	@FXML
	private CheckBox LiveEat_Yes_Check;
	@FXML
	private CheckBox EatLive_NoCheck;

	private boolean okClicked = false;
	private Stage dialogStage;
	private FishingEat fishingEat = new FishingEat();

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void isLiveEat_YesCheck() {

		if (LiveEat_Yes_Check.isSelected()) {
			EatLive_NoCheck.setSelected(false);
			this.fishingEat.setIsLive(true);
		}

	}

	@FXML
	private void isLiveEat_NoCheck() {

		if (EatLive_NoCheck.isSelected()) {
			LiveEat_Yes_Check.setSelected(false);
			this.fishingEat.setIsLive(false);
		}

	}

	
	public void changeAccessory(Object object) {
		((FishingEat) object).setTotal_Eat(Integer.parseInt(Total_Eat.getText()));
	}
	
	private boolean isErrorFishingEat () {
		String errorMessage = "";
		try {
			Integer.parseInt(Total_Eat.getText());
			if (Integer.parseInt(Total_Eat.getText()) < 0 || Integer.parseInt(Total_Eat.getText()) > 150) {
				errorMessage += "Yem miktarýnýz en az 0 en fazla 150 arasýnda olmalýdýr";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Yem miktarýný lütfen Tamsayý giriniz!\n";
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
	private void OkFishingEat() {
		if (isErrorFishingEat()) {
			this.fishingEat.setEat_Type(Eat_Type.getSelectionModel().getSelectedItem().toString());
			changeAccessory(this.fishingEat);
			okClicked = true;
			dialogStage.close();
		}
	}
	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	public void setChange(Object object) {
		Eat_Type.setPromptText("Yem türü seciniz!!");
		Eat_Type.getItems().addAll(fishingEat.getEat_Type().get(1), fishingEat.getEat_Type().get(2),
				fishingEat.getEat_Type().get(3), fishingEat.getEat_Type().get(4), fishingEat.getEat_Type().get(5));
		this.fishingEat = (FishingEat) object;
	}
}
