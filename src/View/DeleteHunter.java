package View;

import File.WriteFile;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteHunter {
	
	@FXML
	private TextField ID;
	
	private WriteFile writeFile;
	private Stage dialogStage;
	private boolean isDelete = true;
	
	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@FXML
	private void initialize() {

		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	private void delete () {
		this.isDelete = this.writeFile.deleteFile(this.ID);
	}
	
	public DeleteHunter () {
		this.writeFile = new WriteFile();
	}
	
	@FXML
	private void okDelete () {
		delete();
		dialogStage.close();
	}
	
	@FXML
	private void Cancel () {
		isDelete = true;
		dialogStage.close();
	}
	
}
