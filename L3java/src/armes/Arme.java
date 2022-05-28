package armes;

/**
 * 
 * Classe repr�sentant une arme qu'un Personnage peut porter
 *
 */
public class Arme {

	private int degats;
	private int durabiliteCourante;
	
	/**
	 * 
	 * @param degats D�gats brut de l'arme (points de vie inflig�s)
	 * @param durabiliteCourante Nombre de coups pouvant �tre tir�s ou mis
	 */
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
