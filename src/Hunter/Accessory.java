package Hunter;

import Accessory.Bag;
import Accessory.FishingEat;
import Accessory.FishingRod;
import Accessory.Knife;
import Accessory.Pistol;
import Accessory.Rifle;
import Accessory.Tent;

public class Accessory {

	private Bag bag;
	private Rifle rifle;
	private Pistol pistol;
	private Knife knife;
	private Tent tent;
	private FishingRod fishing_Rod;
	private FishingEat fishing_Eat;

	public Accessory() {
		this.bag = new Bag();
		this.rifle = new Rifle();
		this.pistol = new Pistol();
		this.knife = new Knife();
		this.tent = new Tent();
		this.fishing_Eat = new FishingEat();
		this.fishing_Rod = new FishingRod();
	}
	
	public Accessory (boolean doldur) {
		this.bag = new Bag ("Decathlon",2,14,7,3);
		this.rifle = new Rifle("Husan",250,5,2,36,650,"Fiþek");
		this.pistol = new Pistol("Colt",50,10,2,9,450,"9mm");
		this.knife = new Knife(8,"AACF","Acvý Býçaðý");
		this.tent = new Tent("Decathlon",2,(float)17.5,(float)18.6,-25,7,"Kýþ");
		this.fishing_Eat = new FishingEat(80,"Balik");
		this.fishing_Rod = new FishingRod("FFishR",2,(float) 5.8,7,"Rat");
	}
	
	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}

	public Rifle getRifle() {
		return rifle;
	}

	public void setRifle(Rifle rifle) {
		this.rifle = rifle;
	}

	public Pistol getPistol() {
		return pistol;
	}

	public void setPistol(Pistol pistol) {
		this.pistol = pistol;
	}

	public Knife getKnife() {
		return knife;
	}

	public void setKnife(Knife knife) {
		this.knife = knife;
	}

	public Tent getTent() {
		return tent;
	}

	public void setTent(Tent tent) {
		this.tent = tent;
	}

	public FishingRod getFishing_Rod() {
		return fishing_Rod;
	}

	public void setFishing_Rod(FishingRod fishing_Rod) {
		this.fishing_Rod = fishing_Rod;
	}

	public FishingEat getFishing_Eat() {
		return fishing_Eat;
	}

	public void setFishing_Eat(FishingEat fishing_Eat) {
		this.fishing_Eat = fishing_Eat;
	}
	
}
