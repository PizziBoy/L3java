package armes;

public class Epee extends Arme {
	
	private static final int nbCoupsMax = 4;
	
	private int sharpness;

	public Epee(int degats) {
		super(degats, Epee.nbCoupsMax);
		this.sharpness = 1;
		// TODO Auto-generated constructor stub
	}

	public int getSharpness() {
		return sharpness;
	}

	public void setSharpness(int sharpness) {
		this.sharpness = sharpness;
	}
	
	
	
	
	
	
	
	
}
