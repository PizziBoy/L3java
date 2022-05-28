package armes;

/**
 * 
 * Classe représentant une arme qu'un Personnage peut porter
 *
 */
public class Arme {

	private int degats;
	private int durabiliteCourante;
	
	/**
	 * 
	 * @param degats Dégats brut de l'arme (points de vie infligés)
	 * @param durabiliteCourante Nombre de coups pouvant être tirés ou mis
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
