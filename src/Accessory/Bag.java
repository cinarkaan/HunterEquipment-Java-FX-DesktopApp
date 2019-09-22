package Accessory;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Bag {

	private int Capacity;
	private int pocket_Total;
	private float Weight;
	private boolean WaterProof;
	private String Brand;
	private int usingLife;

	public Bag() {
		this("null", 0, 0, 0, (float) 0.0);
		this.Brand = "null";
	}

	public Bag(String Brand, int usingLife, int Capacity, int pocket_Total, float Weight) {
		this.Brand = Brand;
		this.usingLife = usingLife;
		this.Capacity = Capacity;
		this.pocket_Total = pocket_Total;
		this.Weight = Weight;
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

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int getPocket_Total() {
		return pocket_Total;
	}

	public void setPocket_Total(int pocket_Total) {
		this.pocket_Total = pocket_Total;
	}

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float weight) {
		Weight = weight;
	}

	public boolean isWaterProof() {
		return WaterProof;
	}

	public void setWaterProof(boolean waterProof) {
		WaterProof = waterProof;
	}

	public void fileRecord(BufferedWriter bufferedWriter) {
		try {
			bufferedWriter.write("--------Çanta Bilgileri--------");
			bufferedWriter.newLine();
			bufferedWriter.write(this.getBrand());
			bufferedWriter.newLine();
			bufferedWriter.write(Integer.toString(this.getUsingLife()));
			bufferedWriter.newLine();
			bufferedWriter.write(Integer.toString(this.getCapacity()));
			;
			bufferedWriter.newLine();
			bufferedWriter.write(Integer.toString(this.getPocket_Total()));
			bufferedWriter.newLine();
			bufferedWriter.write(Boolean.toString(this.isWaterProof()));
			bufferedWriter.newLine();
			bufferedWriter.write(Float.toString(this.getWeight()));
			bufferedWriter.newLine();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void getFile(BufferedReader bufferedReader) {
		try {
			bufferedReader.readLine();
			this.setBrand(bufferedReader.readLine());
			this.setUsingLife(Integer.parseInt(bufferedReader.readLine()));
			this.setCapacity(Integer.parseInt(bufferedReader.readLine()));
			this.setPocket_Total(Integer.parseInt(bufferedReader.readLine()));
			this.setWaterProof(Boolean.parseBoolean(bufferedReader.readLine()));
			this.setWeight(Float.parseFloat(bufferedReader.readLine()));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
