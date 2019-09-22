package File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import Hunter.Hunter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WriteFile {

	@FXML
	private Text FileName;
	private boolean okClicked = true;
	private Stage dialogStage;
	private Hunter hunter = new Hunter();
	public static int totalRecord;

	BufferedWriter writer;

	@FXML
	private void initialize() {

	}

	public boolean isokClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setHunter(Hunter hunter) {
		this.hunter = hunter;
		this.FileName.setText(Integer.toString(this.hunter.getHunter_id()));
	}

	private boolean writeFile() {
		Path path = Paths.get(FileName.getText() + ".txt");
		File file = new File(path.toString());
		try {
			if (file.exists()) {
				file.delete();
				System.out.println("Dosya silindi!!!!");
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				this.writer = new BufferedWriter(fileWriter);
				recordingFile();
				System.out.println("Tekrar yazýldý!!!!!!");
				fileWriter.close();
				totalFile(Integer.parseInt(FileName.getText()));
				return true;
			} else {
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				this.writer = new BufferedWriter(fileWriter);
				recordingFile();
				fileWriter.close();
				++WriteFile.totalRecord;
				totalFile(Integer.parseInt(FileName.getText()));
				return true;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	private void totalFile(int id) {
		Path path = Paths.get("totalHunter.txt");
		File file = new File(path.toString());
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.writer = new BufferedWriter(fileWriter);
			this.writer.write("--------Toplam Kayýt--------");
			this.writer.newLine();
			this.writer.write(Integer.toString(WriteFile.totalRecord));
			this.writer.newLine();
			this.writer.write("--------Id Baslangýc--------");
			this.writer.newLine();
			if (id > ReadFile.highId) {
				this.writer.write(Integer.toString(id));
				ReadFile.highId = id;
			} else {
				this.writer.write(Integer.toString(ReadFile.highId));
			} 
			this.writer.close();
			fileWriter.close();
			System.out.println("Toplam kayýt ---->>>>>> " + WriteFile.totalRecord + " tane bulundu");
			System.out.println("Baslangýç ID'si ------>>>>>" + ReadFile.highId);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public boolean deleteFile(TextField id) {
		this.FileName = new Text();
		this.FileName.setText(id.getText());
		Path path = Paths.get(FileName.getText() + ".txt");
		File file = new File(path.toString());
		try {
			if (file.exists()) {
				System.out.println(FileName.getText() + "ID 'li Dosya silindi!!!!!");
				--WriteFile.totalRecord;
				if (WriteFile.totalRecord == 0) {
					ReadFile.highId = 0;
					Hunter.hunter_id = 0;
				}
				totalFile(ReadFile.highId);
				return file.delete();
			} else {
				System.out.println("Dosya Yok!!!!");
				return false;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	private void recordingFile() {
		this.hunter.fileRecord(writer);
		this.hunter.getAccessory().getRifle().recordingFile(writer);
		this.hunter.getAccessory().getPistol().recordingFile(writer);
		this.hunter.getAccessory().getTent().recordingFile(writer);
		this.hunter.getAccessory().getBag().fileRecord(writer);
		this.hunter.getAccessory().getKnife().recordFile(writer);
		this.hunter.getAccessory().getFishing_Rod().recordFile(writer);
		this.hunter.getAccessory().getFishing_Eat().fileRecord(writer);
	}

	@FXML
	private void OkSaveFile() {
		boolean isSave = writeFile();
		if (isSave) {
			okClicked = true;
			dialogStage.close();
		} else {
			okClicked = false;
			dialogStage.close();
		}
	}

	@FXML
	private void Cancel() {
		okClicked = true;
		dialogStage.close();
	}
}
