package plateau;

import joueur.Joueur;

public class CaseCamp extends Case {

	private Joueur joueur;
	
	public CaseCamp(int x, int y, Joueur joueur) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.joueur = joueur;
	}

	@Override
	public String toString() {
		return "[C]";
	}
	
}
