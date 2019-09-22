package View;

import Accessory.Knife;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangeKnife {

	@FXML
	private TextField Knife_Lenght;
	@FXML
	private TextField Knife_Brand;
	@FXML
	private ComboBox<String> Knife_Type = new ComboBox<>();

	private boolean okClicked = false;
	private Stage dialogStage;
	private Knife knife = new Knife();

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private boolean isErrorKnife() {
		String errorMessage = "";
		if (Knife_Brand.getText() == null || Knife_Brand.getText().length() == 0) {
			errorMessage += "Kullanilan bircagin bir markasi olmak zorundadir";
		}
		try {
			Float.parseFloat(Knife_Lenght.getText());
			if (Float.parseFloat(Knife_Lenght.getText()) < 4 || Float.parseFloat(Knife_Lenght.getText()) > 10) {
				errorMessage += "Kullandiginiz bicaðin uzunluðu 4 ile 10 cm arasinda olmak zorundadir";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Býçaðýn uzunluðunu lütfen gerçek sayý giriniz!\n";
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
	private void OkKnife() {
		if (isErrorKnife()) {
			this.knife.setKnife_Type(Knife_Type.getSelectionModel().getSelectedItem().toString());
			changeAccessory(this.knife);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	public void changeAccessory(Object object) {
		((Knife) object).setLengt(Float.parseFloat(Knife_Lenght.getText()));
		((Knife) object).setOrigin(Knife_Brand.getText());
	}

	public void setChange(Object object) {
		Knife_Type.setPromptText("Kullandýðýnýz Býçak türünü seçiniz");
		Knife_Type.getItems().addAll(knife.getType().get(1), knife.getType().get(2), knife.getType().get(3),
				knife.getType().get(4), knife.getType().get(5));
		this.knife = (Knife) object;
	}
}
