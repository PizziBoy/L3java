package joueur;


/**
 * 
 * Classe caractérisant un Joueur
 *
 */
public class Joueur {
	private String nom;
	//Nombre d'oeufs remportés
	private int score;
	
	/**
	 * Construit un joueur à l'aide de son nom
	 * @param nom nom du joueur
	 */
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.score = 0;
	}
	
	public static Joueur J1 = new Joueur("joueur 1");
	public static Joueur J2 = new Joueur("joueur 2");


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getNom() {
		return nom;
	}
	
	
	
	
}
