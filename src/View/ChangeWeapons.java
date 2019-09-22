package View;

import Accessory.Weapons;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public abstract class ChangeWeapons {

	@FXML
	protected TextField FPS;
	@FXML
	protected TextField Ammo;
	@FXML
	protected TextField Weight;
	@FXML
	protected TextField Range;
	@FXML
	protected TextField Brand;
	@FXML
	protected TextField Calibrer;
	@FXML
	protected ComboBox<String> Rifle_Bullet_Type = new ComboBox<>();
	@FXML
	protected ComboBox<String> Pistol_Bullet_Type = new ComboBox<>();
	
	protected boolean okClicked = false;
	protected Stage dialogStage;
	protected abstract void setChange(Object object);
	
	protected void changeWeapons (Weapons weapons) {
		weapons.setFPS((Integer.parseInt(FPS.getText())));
		weapons.setBulletCapacity(Integer.parseInt(Ammo.getText()));
		weapons.setWeight(Float.parseFloat(Weight.getText()));
		weapons.setRange(Integer.parseInt(Range.getText()));
		weapons.setBrand(Brand.getText());
		weapons.setCalibrer(Float.parseFloat(Calibrer.getText()));
	}
	

}
