package armes;

public class Arc extends Arme {
	
	private static final int nbFlechesMax = 4;
	
	private int portee;

	

	public Arc(int degats, int portee) {
		super(degats, Arc.nbFlechesMax);
		this.portee = portee;
		// TODO Auto-generated constructor stub
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}
	
	public int getNbFleches() {
		return this.getDurabiliteCourante();
	}
	
	public void setNbFleches(int nbFleches) {
		this.setDurabiliteCourante(nbFleches);
	}
	
	
	
	

}
