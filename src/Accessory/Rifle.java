package Accessory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;

public class Rifle extends Weapons {

	private HashMap<Integer, String> Bullet_Type;
	private String bullet_Type;

	public Rifle() {
		Bullet_Type = new HashMap<>();
		Bullet_Type.put(1, "Tip1");
		Bullet_Type.put(2, "Tip2");
		Bullet_Type.put(3, "Tip3");
		Bullet_Type.put(4, "Tip4");
		this.bullet_Type = "null";
	}

	public Rifle (String Brand,int Range,int BulletCapacity,float Weight,float Calibrer,int FPS,String bullet_Type) {
		this.Brand = Brand;
		this.Range = Range;
		this.BulletCapacity = BulletCapacity;
		this.Weight = Weight;
		this.Calibrer = Calibrer;
		this.FPS = FPS;
		Bullet_Type = new HashMap<>();
		Bullet_Type.put(1, "Tip1");
		Bullet_Type.put(2, "Tip2");
		Bullet_Type.put(3, "Tip3");
		Bullet_Type.put(4, "Tip4");
		this.bullet_Type = bullet_Type;
	}

	public HashMap<Integer, String> getbullet_Type() {
		return Bullet_Type;
	}

	public void setBullet_Type(HashMap<Integer, String> bullet_Type) {
		Bullet_Type = bullet_Type;
	}

	public String getBullet_Type() {
		return bullet_Type;
	}

	public void setBullet_Type(String bullet_Type) {
		this.bullet_Type = bullet_Type;
	}
	
	public void recordingFile (BufferedWriter writer) {
		try {
			writer.write("--------Tüfek Bilgileri--------");
			writer.newLine();
			writer.write(this.getBrand());
			writer.newLine();
			writer.write(Float.toString(this.getWeight()));
			writer.newLine();
			writer.write(Integer.toString(this.getRange()));
			writer.newLine();
			writer.write(Integer.toString(this.getBulletCapacity()));
			writer.newLine();
			writer.write(Float.toString(this.getCalibrer()));
			writer.newLine();
			writer.write(Integer.toString(this.getFPS()));
			writer.newLine();
			writer.write(this.getBullet_Type());
			writer.newLine();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getFile (BufferedReader bufferedReader) {
		try {
			bufferedReader.readLine();
			this.setBrand(bufferedReader.readLine());
			this.setWeight(Float.parseFloat(bufferedReader.readLine()));
			this.setRange(Integer.parseInt(bufferedReader.readLine()));
			this.setBulletCapacity(Integer.parseInt(bufferedReader.readLine()));
			this.setCalibrer(Float.parseFloat(bufferedReader.readLine()));
			this.setFPS(Integer.parseInt(bufferedReader.readLine()));
			this.setBullet_Type(bufferedReader.readLine());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
