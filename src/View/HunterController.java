package View;

import Accessory.Bag;
import Accessory.FishingEat;
import Accessory.FishingRod;
import Accessory.Knife;
import Accessory.Pistol;
import Accessory.Rifle;
import Accessory.Tent;
import File.ReadFile;
import File.WriteFile;
import Hunter.Hunter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HunterController {

	@FXML
	private TableView<Hunter> hunterTable;
	@FXML
	private TableColumn<Hunter, Integer> hunterIdColumn;
	@FXML
	private TableColumn<Hunter, String> hunterNameColumn;
	
	

	@FXML
	private Label Hunter_SinginDate;
	@FXML
	private Label Hunter_Id;
	@FXML
	private Label Hunter_Name;
	@FXML
	private Label Hunter_Number;
	@FXML
	private Label Hunter_Adress;
	@FXML
	private Label Hunter_Criminal;

	@FXML
	private Label Rifle_FPS;
	@FXML
	private Label Rifle_Ammo;
	@FXML
	private Label Rifle_Weight;
	@FXML
	private Label Rifle_Range;
	@FXML
	private Label Rifle_Brand;
	@FXML
	private Label Rifle_Calibrer;
	@FXML
	private Label Rifle_Bullet_Type;

	@FXML
	private Label Pistol_Brand;
	@FXML
	private Label Pistol_Weight;
	@FXML
	private Label Pistol_Range;
	@FXML
	private Label Pistol_Bullet_Capacity;
	@FXML
	private Label Pistol_Calibrer;
	@FXML
	private Label Pistol_FPS;
	@FXML
	private Label Pistol_Bullet_Type;
	@FXML
	private Label Bag_Capacity;
	@FXML
	private Label Bag_Pocket_Capacity;
	@FXML
	private Label Bag_Weight;
	@FXML
	private Label Bag_Brand;
	@FXML
	private Label Bag_UsingLife;
	@FXML
	private Label Bag_Water_Proof;

	@FXML
	private Label Tent_Brand;
	@FXML
	private Label Tent_UsingLife;
	@FXML
	private Label Tent_Lenght;
	@FXML
	private Label Tent_Height;
	@FXML
	private Label Tent_Prodect_Temp;
	@FXML
	private Label Tent_Person_Amount;
	@FXML
	private Label Tent_Water_Proof;
	@FXML
	private Label Tent_Season_Amount;

	@FXML
	private Label Knife_Lenght;
	@FXML
	private Label Knife_Weight;
	@FXML
	private Label Knife_Thickness;
	@FXML
	private Label Knife_Band;
	@FXML
	private Label Knife_Type;

	@FXML
	private Label Rotation_Rate;
	@FXML
	private Label Number_Of_Ball;
	@FXML
	private Label F_Rod_Brand;
	@FXML
	private Label F_Rod_Type;

	@FXML
	private Label Eat_Type;
	@FXML
	private Label Total_Eat;
	@FXML
	private Label isLive_Eat;

	private MainApp mainApp;

	public HunterController() {

	}

	private void hunterDetails(Hunter hunter) {
		if (hunter != null) {
			Hunter_Name.setText(hunter.gethunter_Name());
			Hunter_Number.setText(hunter.getHunter_Number());
			Hunter_Id.setText(Integer.toString(hunter.getHunter_id()));
			Hunter_Adress.setText(hunter.getAdress());
			if (hunter.isCrime()) {
				Hunter_Criminal.setText("Sabýka Var");
			} else {
				Hunter_Criminal.setText("Temiz");
			}
			Rifle_FPS.setText(Integer.toString(hunter.getAccessory().getRifle().getFPS()));
			Rifle_Ammo.setText(Integer.toString(hunter.getAccessory().getRifle().getBulletCapacity()));
			Rifle_Weight.setText(Float.toString(hunter.getAccessory().getRifle().getWeight()));
			Rifle_Range.setText(Integer.toString(hunter.getAccessory().getRifle().getRange()));
			Rifle_Brand.setText(hunter.getAccessory().getRifle().getBrand());
			Rifle_Calibrer.setText(Float.toString(hunter.getAccessory().getRifle().getCalibrer()));
			Rifle_Bullet_Type.setText(hunter.getAccessory().getRifle().getBullet_Type());
			Pistol_Brand.setText(hunter.getAccessory().getPistol().getBrand());
			Pistol_FPS.setText(Integer.toString(hunter.getAccessory().getPistol().getFPS()));
			Pistol_Range.setText(Integer.toString(hunter.getAccessory().getPistol().getRange()));
			Pistol_Weight.setText(Float.toString(hunter.getAccessory().getPistol().getWeight()));
			Pistol_Calibrer.setText(Float.toString(hunter.getAccessory().getPistol().getCalibrer()));
			Pistol_Bullet_Capacity.setText(Integer.toString(hunter.getAccessory().getPistol().getBulletCapacity()));
			Pistol_Bullet_Type.setText(hunter.getAccessory().getPistol().getbullet_Type());
			Knife_Band.setText(hunter.getAccessory().getKnife().getOrigin());
			Knife_Lenght.setText(Float.toString(hunter.getAccessory().getKnife().getLengt()));
			Knife_Type.setText(hunter.getAccessory().getKnife().getKnife_Type());
			Tent_Brand.setText(hunter.getAccessory().getTent().getBrand());
			Tent_UsingLife.setText(Integer.toString(hunter.getAccessory().getTent().getUsingLife()));
			Tent_Lenght.setText(Float.toString(hunter.getAccessory().getTent().getLenght()));
			Tent_Height.setText(Float.toString(hunter.getAccessory().getTent().getheight()));
			Tent_Prodect_Temp.setText(Integer.toString(hunter.getAccessory().getTent().getProtection_Tempature()));
			Tent_Person_Amount.setText(Integer.toString(hunter.getAccessory().getTent().getPerson_Amount()));
			Tent_Season_Amount.setText(hunter.getAccessory().getTent().getSeason());
			if (hunter.getAccessory().getTent().isWaterProof()) {
				Tent_Water_Proof.setText("Evet");
			} else {
				Tent_Water_Proof.setText("Hayýr");
			}
			Bag_UsingLife.setText(Integer.toString(hunter.getAccessory().getBag().getUsingLife()));
			Bag_Capacity.setText(Integer.toString(hunter.getAccessory().getBag().getCapacity()));
			Bag_Brand.setText(hunter.getAccessory().getBag().getBrand());
			Bag_Pocket_Capacity.setText(Integer.toString(hunter.getAccessory().getBag().getPocket_Total()));
			Bag_Weight.setText(Float.toString(hunter.getAccessory().getBag().getWeight()));
			if (hunter.getAccessory().getBag().isWaterProof()) {
				Bag_Water_Proof.setText("Evet");
			} else {
				Bag_Water_Proof.setText("Hayýr");
			}
			F_Rod_Brand.setText(hunter.getAccessory().getFishing_Rod().getBrand());
			Number_Of_Ball.setText(Integer.toString(hunter.getAccessory().getFishing_Rod().getNumber_Of_Ball()));
			Rotation_Rate.setText(Float.toString(hunter.getAccessory().getFishing_Rod().getRotation_Rate()));
			F_Rod_Type.setText(hunter.getAccessory().getFishing_Rod().getRod_Type());
			Total_Eat.setText(Integer.toString(hunter.getAccessory().getFishing_Eat().getTotal_Eat()));
			Eat_Type.setText(hunter.getAccessory().getFishing_Eat().geteat_Type());
			if (hunter.getAccessory().getFishing_Eat().getIsLive()) {
				isLive_Eat.setText("Evet");
			} else {
				isLive_Eat.setText("Hayýr");
			}
		} else {
			Hunter_Id.setText(" ");
			Hunter_Name.setText(" ");
			Hunter_Number.setText(" ");
			Hunter_Adress.setText(" ");
			Hunter_Criminal.setText(" ");
			Rifle_FPS.setText(" ");
			Rifle_Ammo.setText(" ");
			Rifle_Weight.setText(" ");
			Rifle_Range.setText(" ");
			Rifle_Brand.setText(" ");
			Rifle_Calibrer.setText(" ");
			Rifle_Bullet_Type.setText(" ");

			Pistol_FPS.setText(" ");
			Pistol_Bullet_Capacity.setText(" ");
			Pistol_Weight.setText(" ");
			Pistol_Range.setText(" ");
			Pistol_Brand.setText(" ");
			Pistol_Calibrer.setText(" ");
			Pistol_Bullet_Type.setText(" ");

			Knife_Band.setText(" ");
			Knife_Lenght.setText(" ");
			Knife_Type.setText(" ");

			Tent_Lenght.setText(" ");
			Tent_Height.setText(" ");
			Tent_Person_Amount.setText(" ");
			Tent_Prodect_Temp.setText(" ");
			Tent_Season_Amount.setText(" ");
			Tent_Water_Proof.setText(" ");
			Bag_Capacity.setText(" ");
			Bag_Brand.setText(" ");
			Bag_Pocket_Capacity.setText(" ");
			Bag_Weight.setText(" ");

			F_Rod_Brand.setText(" ");
			F_Rod_Type.setText(" ");
			Number_Of_Ball.setText(" ");
			Rotation_Rate.setText(" ");

			Total_Eat.setText(" ");
			Eat_Type.setText(" ");
			isLive_Eat.setText(" ");

		}
	}

	@FXML
	private void initialize() {
		
		hunterNameColumn.setCellValueFactory(cellData -> cellData.getValue().getHunter_Name());

		hunterIdColumn.setCellValueFactory(cellData -> cellData.getValue().getHunter_Id().asObject());

		hunterDetails(null);
		hunterTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> hunterDetails(newValue));

	}

	public MainApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		hunterTable.setItems(mainApp.getHunterData());

	}

	@FXML
	private void Close() {
		mainApp.LoginControl();
	}

	@FXML
	private void newHunter() {
		if (WriteFile.totalRecord == 0 && this.mainApp.isEmpty()) {
			Hunter.hunter_id = 0;
			ReadFile.highId = 0;
		}
		Hunter tempHunter = new Hunter();
		boolean okClicked = mainApp.showHunterRecordDialog(tempHunter);
		if (okClicked) {
			mainApp.getHunterData().add(tempHunter);
		}
	}

	@FXML
	private void deleteHunter() {
		int selectedIndex = hunterTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			hunterTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Herhangi Bir Secim Yapýlmadý");
			alert.setHeaderText("Bir Avci Secilmedi");
			alert.setContentText("Lutfen tablodan bir avcý secin");

			alert.showAndWait();
		}
	}

	@FXML
	private void editHunter() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			boolean okClicked = mainApp.showEditHunterDialog(selectedHunter);
			if (okClicked) {
				hunterDetails(selectedHunter);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Avci Secilmedi");
			alert.setContentText("Lutfen tablodan bir avci sec.");

			alert.showAndWait();
		}
	}

	@FXML
	private void changeRifle() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			Rifle rifle = hunterTable.getSelectionModel().getSelectedItem().getAccessory().getRifle();
			boolean okClicled = mainApp.showEditAccessory(rifle);
			if (okClicled) {
				selectedHunter.getAccessory().setRifle(rifle);
				hunterDetails(selectedHunter);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Tüfek Secilmedi");
			alert.setContentText("Herhangi bir avciya ait tüfek Secilmedi");

			alert.showAndWait();
		}
	}

	@FXML
	private void changePistol() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			Pistol pistol = hunterTable.getSelectionModel().getSelectedItem().getAccessory().getPistol();
			boolean okClicled = mainApp.showEditAccessory(pistol);
			if (okClicled) {
				selectedHunter.getAccessory().setPistol(pistol);
				hunterDetails(selectedHunter);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Tabanca Secilmedi");
			alert.setContentText("Herhangi bir avciya ait tabanca Secilmedi");

			alert.showAndWait();
		}
	}

	@FXML
	private void changeTent() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			Tent tent = hunterTable.getSelectionModel().getSelectedItem().getAccessory().getTent();
			boolean okClicked = mainApp.showEditAccessory(tent);
			if (okClicked) {
				selectedHunter.getAccessory().setTent(tent);
				hunterDetails(selectedHunter);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Çadýr Secilmedi");
			alert.setContentText("Herhangi bir avciya ait Çadýr Secilmedi");

			alert.showAndWait();
		}
	}

	@FXML
	private void changeBag() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			Bag bag = hunterTable.getSelectionModel().getSelectedItem().getAccessory().getBag();
			boolean okClicked = mainApp.showEditAccessory(bag);
			if (okClicked) {
				selectedHunter.getAccessory().setBag(bag);
				hunterDetails(selectedHunter);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Çanta Secilmedi");
			alert.setContentText("Herhangi bir avciya ait Çanta Secilmedi");

			alert.showAndWait();
		}
	}

	@FXML
	private void changeFishingRod() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			FishingRod fishing_Rod = hunterTable.getSelectionModel().getSelectedItem().getAccessory().getFishing_Rod();
			boolean okClicked = mainApp.showEditAccessory(fishing_Rod);
			if (okClicked) {
				selectedHunter.getAccessory().setFishing_Rod(fishing_Rod);
				hunterDetails(selectedHunter);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Olta Secilmedi");
			alert.setContentText("Herhangi bir avciya ait Olta Secilmedi");

			alert.showAndWait();
		}
	}

	@FXML
	private void changeKnife() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			Knife knife = hunterTable.getSelectionModel().getSelectedItem().getAccessory().getKnife();
			boolean okClicked = mainApp.showEditAccessory(knife);
			if (okClicked) {
				selectedHunter.getAccessory().setKnife(knife);
				hunterDetails(selectedHunter);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Býçak Secilmedi");
			alert.setContentText("Herhangi bir avciya ait Býçak Secilmedi");

			alert.showAndWait();
		}
	}

	@FXML
	private void changeFishingEat() {
		Hunter selectedHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selectedHunter != null) {
			FishingEat fishingEat = hunterTable.getSelectionModel().getSelectedItem().getAccessory().getFishing_Eat();
			boolean okClicked = mainApp.showEditAccessory(fishingEat);
			if (okClicked) {
				selectedHunter.getAccessory().setFishing_Eat(fishingEat);
				hunterDetails(selectedHunter);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Yem Secilmedi");
			alert.setContentText("Herhangi bir avciya ait OltaYemi Secilmedi");

			alert.showAndWait();
		}
	}
	
	@FXML
	private void SaveHunter () {
		Hunter selecHunter = hunterTable.getSelectionModel().getSelectedItem();
		if (selecHunter != null) {
			boolean okClicked = this.mainApp.SaveFile(selecHunter);
			if (okClicked) {
				System.out.println("--------------------------");
				System.out.println("Dosya kaydetme basarili!!!");
				System.out.println("--------------------------");
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("Hata");
				alert.setHeaderText("Giris Kontrolu");
				alert.setContentText("Girislerinize dikkat edin!!!!");
				alert.showAndWait();
				System.out.println("--------------------------");
				System.out.println("Hata1");
				System.out.println("--------------------------");
			}
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Secim Yok");
			alert.setHeaderText("Avcý Secilmedi");
			alert.setContentText("Herhangi bir avci secilmedi");
			alert.showAndWait();
			System.out.println("--------------------------");
			System.out.println("Hata2");
			System.out.println("--------------------------");
		}
	}
	
	@FXML
	private void OpenHunter () {
		Hunter fileHunter = this.mainApp.openFile();
		if (fileHunter != null) {
				this.mainApp.getHunterData().add(fileHunter);
				System.out.println("--------------------------");
				System.out.println("Dosya acma basarili");
				System.out.println("--------------------------");	
		} else if (fileHunter == null && !ReadFile.isOk) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Hata");
			alert.setHeaderText("Giris Kontrolu");
			alert.setContentText("Olmayan bir avcý!!!!");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void delete () {
		boolean isdelelete = this.mainApp.deleteFile();
		if (isdelelete) {
			System.out.println("--------------------------");
			System.out.println("Dosya basariyla silindi!!!!!");
			System.out.println("--------------------------");	
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Hata");
			alert.setHeaderText("Giris Kontrolu");
			alert.setContentText("Olmayan bir avcý!!!!");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void aboutUs () {
		this.mainApp.aboutUs();
	}
	
}
