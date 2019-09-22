package Accessory;

public class Weapons {

	protected String Brand;
	protected int Range;
	protected int BulletCapacity;
	protected float Weight;
	protected float Calibrer;
	protected int FPS;

	public Weapons() {
		
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getRange() {
		return Range;
	}

	public void setRange(int range) {
		Range = range;
	}

	public int getBulletCapacity() {
		return BulletCapacity;
	}

	public void setBulletCapacity(int bulletCapacity) {
		BulletCapacity = bulletCapacity;
	}

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float weight) {
		Weight = weight;
	}

	public float getCalibrer() {
		return Calibrer;
	}

	public void setCalibrer(float calibrer) {
		Calibrer = calibrer;
	}

	public int getFPS() {
		return FPS;
	}

	public void setFPS(int fPS) {
		FPS = fPS;
	}

}
