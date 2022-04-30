package joueur;

public class Joueur {
	private String nom;
	//Nombre d'oeufs remportés
	private int score;
	
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.score = 0;
	}


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
