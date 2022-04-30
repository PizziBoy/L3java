package armes;

public class Arme {
	private int degats;
	private int durabiliteCourante;
	
	
	public Arme(int degats, int durabiliteCourante) {
		super();
		this.degats = degats;
		this.durabiliteCourante = durabiliteCourante;
	}

	


	public int getDurabiliteCourante() {
		return durabiliteCourante;
	}



	public void setDurabiliteCourante(int durabiliteCourante) {
		this.durabiliteCourante = durabiliteCourante;
	}



	public int getDegats() {
		return degats;
	}
	
	
	
}
