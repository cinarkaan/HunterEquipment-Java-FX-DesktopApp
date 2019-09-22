package View;

import Accessory.Bag;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangeBag {

	@FXML
	private TextField Bag_Capacity;
	@FXML
	private TextField Bag_Brand;
	@FXML
	private TextField Bag_Pocket_Capacity;
	@FXML
	private TextField Bag_Weight;
	@FXML
	private TextField Bag_UsingLife;
	@FXML
	private CheckBox Bag_Water_Proof1;
	@FXML
	private CheckBox Bag_Water_Proof2;

	private boolean okClicked = false;
	private Stage dialogStage;
	private Bag bag = new Bag();

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
	private void Bag_Yes_Check() {

		if (Bag_Water_Proof1.isSelected()) {
			Bag_Water_Proof2.setSelected(false);
			this.bag.setWaterProof(true);
		}

	}

	@FXML
	private void Bag_No_Check() {

		if (Bag_Water_Proof2.isSelected()) {
			Bag_Water_Proof1.setSelected(false);
			this.bag.setWaterProof(false);
		}

	}

	public void changeAccessory(Object object) {
		((Bag) object).setBrand(Bag_Brand.getText());
		((Bag) object).setCapacity(Integer.parseInt(Bag_Capacity.getText()));
		((Bag) object).setPocket_Total(Integer.parseInt(Bag_Pocket_Capacity.getText()));
		((Bag) object).setUsingLife(Integer.parseInt(Bag_UsingLife.getText()));
		((Bag) object).setWeight(Float.parseFloat(Bag_Weight.getText()));
	}

	private boolean isErrorBag() {
		String errorMessage = "";
		if (Bag_Brand.getText() == null || Bag_Brand.getText().length() == 0) {
			errorMessage += "Kullandýðýnýz çantanýn markasý olmak zorundadýr!!!!";
		}
		try {
			Integer.parseInt(Bag_UsingLife.getText());
			if (Integer.parseInt(Bag_UsingLife.getText()) < 2 || Integer.parseInt(Bag_UsingLife.getText()) > 6) {
				errorMessage += "Kullandýðýnýz çantanýn ömrü 2 ile 6 yýl arasýnda olmalýdýr!!!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Kullaným ömrünü lütfen Tamsayý giriniz!\n";
		}
		try {
			Integer.parseInt(Bag_Capacity.getText());
			if (Integer.parseInt(Bag_Capacity.getText()) < 10 || Integer.parseInt(Bag_Capacity.getText()) > 20) {
				errorMessage += "Çantanýzýn kapasitesi 10 ile 20 L arasýnda olmalýdýr.";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Çanta kapasitesini lütfen Tamsayý giriniz!\n";
		}
		if (Bag_Brand.getText() == null || Bag_Brand.getText().length() == 0) {
			errorMessage += "Lütfen çantanizin markasini giriniz";
		}
		try {
			Integer.parseInt(Bag_Pocket_Capacity.getText());
			if (Integer.parseInt(Bag_Pocket_Capacity.getText()) < 6
					|| Integer.parseInt(Bag_Pocket_Capacity.getText()) > 9) {
				errorMessage += "Çantanýzýn cep bölmesi 6 ile 9 bolme arasýnda olmalýdýr!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Çanta cep bölmesini lütfen Tamsayý giriniz!\n";
		}
		try {
			Float.parseFloat(Bag_Weight.getText());
			if (Float.parseFloat(Bag_Weight.getText()) < 2.2 || Float.parseFloat(Bag_Weight.getText()) > 4.0) {
				errorMessage += "Çantanýzýn aðýrlýðý 2 ile 4 kg arasýnda olmalýdýr!!!";
			}
		} catch (NumberFormatException e) {
			errorMessage += "Çanta aðýrlýðýný lütfen gerçek sayý giriniz!\n";
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
	private void OkBag() {
		if (isErrorBag()) {
			changeAccessory(this.bag);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		dialogStage.close();
	}

	public void setChange(Object object) {
		this.bag = (Bag) object;

	}

}
