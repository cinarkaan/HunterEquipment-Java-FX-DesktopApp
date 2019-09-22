package Accessory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;

public class Knife {

	private float Lengt;
	private String Origin;
	private HashMap<Integer, String> Type;
	private String Knife_Type;
	
	public Knife() {
		this.Origin = "null";
		this.Knife_Type = "null";
	}
	
	public Knife (float Lenght,String Origin,String Knife_Type) {
		this.Lengt = Lenght;
		this.Origin = Origin;
		this.Knife_Type = Knife_Type;
	}
	
	public String getKnife_Type() {
		return Knife_Type;
	}

	public void setKnife_Type(String knife_Type) {
		Knife_Type = knife_Type;
	}

	public float getLengt() {
		return Lengt;
	}

	public void setLengt(float lengt) {
		Lengt = lengt;
	}

	public String getOrigin() {
		return Origin;
	}

	public void setOrigin(String origin) {
		Origin = origin;
	}

	public HashMap<Integer, String> getType() {
		if (this.Type == null) {
			this.Type = new HashMap<>();
		}
		Type.put(1, "Kasatura");
		Type.put(2, "Avcý Býçaðý");
		Type.put(3, "Deri Yüzme Býçaðý");
		Type.put(4, "Mini Cep Býçaðý");
		Type.put(5, "Komando Býçaðý");
		return Type;
	}

	public void setType(HashMap<Integer, String> type) {
		Type = type;
	}
	
	public void recordFile (BufferedWriter writer) {
		try {
			writer.write("--------Býçak Bilgileri--------");
			writer.newLine();
			writer.write(this.getOrigin());
			writer.newLine();
			writer.write(this.getKnife_Type());
			writer.newLine();
			writer.write(Float.toString(this.getLengt()));
			writer.newLine();
		} catch (Exception ex) {
		}
	}
	
	public void getFile (BufferedReader bufferedReader) {
		try {
			bufferedReader.readLine();
			this.setOrigin(bufferedReader.readLine());
			this.setKnife_Type(bufferedReader.readLine());
			this.setLengt(Float.parseFloat(bufferedReader.readLine()));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
