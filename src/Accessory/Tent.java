package Accessory;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Tent {

	private float Lenght;
	private float height;
	private int protection_Tempature;
	private int person_Amount;
	private boolean WaterProof;
	private String Season;
	private String Brand;
	private int usingLife;

	public Tent() {
		this.Brand = "null";
		this.Season = "null";
	}

	public Tent(String Brang, int usingLife, float Lenght, float height, int protection_Tempature, int person_Amount,
			String Season) {
		this.Brand = Brang;
		this.usingLife = usingLife;
		this.Lenght = Lenght;
		this.height = height;
		this.protection_Tempature = protection_Tempature;
		this.person_Amount = person_Amount;
		this.Season = Season;
		this.WaterProof = true;
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

	public float getheight() {
		return height;
	}

	public void setheight(float height) {
		this.height = height;
	}

	public float getLenght() {
		return Lenght;
	}

	public void setLenght(float lenght) {
		Lenght = lenght;
	}

	public int getProtection_Tempature() {
		return protection_Tempature;
	}

	public void setProtection_Tempature(int protection_Tempature) {
		this.protection_Tempature = protection_Tempature;
	}

	public int getPerson_Amount() {
		return person_Amount;
	}

	public void setPerson_Amount(int person_Amount) {
		this.person_Amount = person_Amount;
	}

	public boolean isWaterProof() {
		return WaterProof;
	}

	public void setWaterProof(boolean waterProof) {
		this.WaterProof = waterProof;
	}

	public String getSeason() {
		return Season;
	}

	public void setSeason(String season) {
		this.Season = season;
	}

	public void recordingFile(BufferedWriter writer) {
		try {
			writer.write("--------Çadýr Bilgileri--------");
			writer.newLine();
			writer.write(this.getBrand());
			writer.newLine();
			writer.write(Integer.toString(this.getUsingLife()));
			writer.newLine();
			writer.write(Float.toString(this.getLenght()));
			writer.newLine();
			writer.write(Float.toString(this.getheight()));
			writer.newLine();
			writer.write(Boolean.toString(this.isWaterProof()));
			writer.newLine();
			writer.write(Integer.toString(this.getPerson_Amount()));
			writer.newLine();
			writer.write(Integer.toString(this.getProtection_Tempature()));
			writer.newLine();
			writer.write(this.getSeason());
			writer.newLine();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void getFile(BufferedReader bufferedReader) {
		try {
			bufferedReader.readLine();
			this.setBrand(bufferedReader.readLine());
			this.setUsingLife(Integer.parseInt(bufferedReader.readLine()));
			this.setLenght(Float.parseFloat(bufferedReader.readLine()));
			this.setheight(Float.parseFloat(bufferedReader.readLine()));
			this.setWaterProof(Boolean.parseBoolean(bufferedReader.readLine()));
			this.setPerson_Amount(Integer.parseInt(bufferedReader.readLine()));
			this.setProtection_Tempature(Integer.parseInt(bufferedReader.readLine()));
			this.setSeason(bufferedReader.readLine());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
