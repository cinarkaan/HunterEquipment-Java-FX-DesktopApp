package Accessory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;

public class FishingRod{

	private float Rotation_Rate;
	private HashMap<Integer, String> F_Rod_Type;
	private int Number_Of_Ball;
	private String Rod_Type;
	private String Brand;
	private int usingLife;
	
	public FishingRod() {
		this("null", 0,(float) 0.0, 0, "null");
		this.Brand = null;
	}
	
	public FishingRod (String Brand,int usingLife,float Rotation_Rate,int Number_Of_Ball,String Rod_Type) {
		this.Brand = Brand; 
		this.usingLife = usingLife;
		this.Rotation_Rate = Rotation_Rate;
		this.Number_Of_Ball = Number_Of_Ball;
		this.Rod_Type = Rod_Type;
	}
	
	public float getRotation_Rate() {
		return Rotation_Rate;
	}

	public void setRotation_Rate(float rotation_Rate) {
		Rotation_Rate = rotation_Rate;
	}

	public HashMap<Integer, String> getF_Rod_Type() {
		if (this.F_Rod_Type == null) {
			this.F_Rod_Type = new HashMap<>();
		}
		F_Rod_Type.put(1, "Tip1");
		F_Rod_Type.put(2, "Tip2");
		F_Rod_Type.put(3, "Tip3");
		F_Rod_Type.put(4, "Tip4");
		F_Rod_Type.put(5, "Tip5");
		return F_Rod_Type;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getUsingLife() {
		return usingLife;
	}

	public void setUsingLife(int usingLife) {
		this.usingLife = usingLife;
	}
	
	public void setF_Rod_Type(HashMap<Integer, String> f_Rod_Type) {
		F_Rod_Type = f_Rod_Type;
	}

	public int getNumber_Of_Ball() {
		return Number_Of_Ball;
	}

	public void setNumber_Of_Ball(int number_Of_Ball) {
		Number_Of_Ball = number_Of_Ball;
	}

	public String getRod_Type() {
		return Rod_Type;
	}

	public void setRod_Type(String rod_Type) {
		Rod_Type = rod_Type;
	}
	
	public void recordFile (BufferedWriter writer) {
		try {
			writer.write("--------Olta Bilgileri--------");
			writer.newLine();
			writer.write(this.getBrand());
			writer.newLine();
			writer.write(Integer.toString(this.getUsingLife()));
			writer.newLine();
			writer.write(Float.toString(this.getRotation_Rate()));
			writer.newLine();
			writer.write(Integer.toString(this.getNumber_Of_Ball()));
			writer.newLine();
			writer.write(this.getRod_Type());
			writer.newLine();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getFile (BufferedReader bufferedReader) {
		try {
			bufferedReader.readLine();
			this.setBrand(bufferedReader.readLine());
			this.setUsingLife(Integer.parseInt(bufferedReader.readLine()));
			this.setRotation_Rate(Float.parseFloat(bufferedReader.readLine()));
			this.setNumber_Of_Ball(Integer.parseInt(bufferedReader.readLine()));
			this.setRod_Type(bufferedReader.readLine());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
