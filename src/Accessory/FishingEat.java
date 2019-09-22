package Accessory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;

public class FishingEat {

	private HashMap<Integer, String> Eat_Type;
	private int Total_Eat;
	private Boolean isLive;
	private String eat_Type;

	public FishingEat() {
		this(0, "null");
	}
	
	public FishingEat (int Total_Eat,String eat_Type) {
		this.Total_Eat = Total_Eat;
		this.eat_Type = eat_Type;
		this.isLive = true;
	}
	
	public HashMap<Integer, String> getEat_Type() {
		if (this.Eat_Type == null) {
			this.Eat_Type = new HashMap<>();
		}
		Eat_Type.put(1, "Tip1");
		Eat_Type.put(2, "Tip2");
		Eat_Type.put(3, "Tip3");
		Eat_Type.put(4, "Tip4");
		Eat_Type.put(5, "Tip5");
		return Eat_Type;
	}

	public void setEat_Type(HashMap<Integer, String> eat_Type) {
		Eat_Type = eat_Type;
	}

	public int getTotal_Eat() {
		return Total_Eat;
	}

	public void setTotal_Eat(int total_Eat) {
		Total_Eat = total_Eat;
	}

	public Boolean getIsLive() {
		return isLive;
	}

	public void setIsLive(Boolean isLive) {
		this.isLive = isLive;
	}

	public String geteat_Type() {
		return eat_Type;
	}

	public void setEat_Type(String eat_Type) {
		this.eat_Type = eat_Type;
	}
	
	public void fileRecord (BufferedWriter writer) {
		try {
			writer.write("--------Olta Yemi Bilgileri--------");
			writer.newLine();
			writer.write(Integer.toString(this.Total_Eat));
			writer.newLine();
			writer.write(this.eat_Type);
			writer.newLine();
			writer.write(Boolean.toString(this.isLive));
			writer.newLine();
			writer.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
 	}
	
	public void getFile (BufferedReader bufferedReader) {
		try {
			bufferedReader.readLine();
			this.setTotal_Eat(Integer.parseInt(bufferedReader.readLine()));
			this.setEat_Type(bufferedReader.readLine());
			this.setIsLive(Boolean.parseBoolean(bufferedReader.readLine()));
			bufferedReader.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
