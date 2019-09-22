package Hunter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import File.ReadFile;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hunter {

	public static int hunter_id = 0;
	private final StringProperty hunter_Name;
	private final IntegerProperty hunter_Id;
	private Accessory accessory;
	private String hunter_Number;
	private String Adress;
	private boolean Crime;

	public Hunter() {
		this("null","null","null");
		this.accessory = new Accessory();
	}

	public Hunter(String hunter_Name,String hunter_Number,String Adress) {
		this.hunter_Name = new SimpleStringProperty(hunter_Name);
		this.hunter_Number = hunter_Number;
		++Hunter.hunter_id;
		this.hunter_Id = new SimpleIntegerProperty(Hunter.hunter_id);
		this.Adress = Adress;
		this.Crime = true;
		this.accessory = new Accessory(true);
		ReadFile.highId = Hunter.hunter_id;
	}

	public String getHunter_Number() {
		return hunter_Number;
	}

	public void setHunter_Number(String hunter_Number) {
		this.hunter_Number = hunter_Number;
	}

	public StringProperty getHunter_Name() {
		return hunter_Name;
	}

	public String gethunter_Name() {
		return hunter_Name.get();
	}

	public void sethunter_Name(String hunter_Name) {
		this.hunter_Name.set(hunter_Name);
	}

	public IntegerProperty getHunter_Id() {
		return hunter_Id;
	}

	public int getHunter_id() {
		return hunter_Id.get();
	}

	public void setHunter_id(Integer hunter_id) {
		this.hunter_Id.set(hunter_id);
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public boolean isCrime() {
		return Crime;
	}

	public void setCrime(boolean crime) {
		Crime = crime;
	}
	
	public void fileRecord (BufferedWriter bufferedWriter) {
		try {
			bufferedWriter.write("--------Avcý Bilgileri--------");
			bufferedWriter.newLine();
			bufferedWriter.write(Integer.toString(this.getHunter_id()));
			bufferedWriter.newLine();
			bufferedWriter.write(this.gethunter_Name());
			bufferedWriter.newLine();
			bufferedWriter.write(this.getHunter_Number().toString());
			bufferedWriter.newLine();
			bufferedWriter.write(Boolean.toString(this.isCrime()));
			bufferedWriter.newLine();
			bufferedWriter.write(this.getAdress().toString());
			bufferedWriter.newLine();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getFile (BufferedReader bufferedReader) {
		try {
			bufferedReader.readLine();
			this.setHunter_id(Integer.parseInt(bufferedReader.readLine()));
			this.sethunter_Name(bufferedReader.readLine());
			this.setHunter_Number(bufferedReader.readLine());
			this.setCrime(Boolean.parseBoolean(bufferedReader.readLine()));
			this.setAdress(bufferedReader.readLine());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	
	
	
}
