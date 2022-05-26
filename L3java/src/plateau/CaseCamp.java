package plateau;

import java.awt.Color;

import joueur.Joueur;

public class CaseCamp extends Case {

	private Joueur joueur;
	
	public CaseCamp(int x, int y, Joueur joueur, Color couleur) {
		super(x, y, couleur);
		// TODO Auto-generated constructor stub
		this.joueur = joueur;
	}

	@Override
	public String toString() {
		return "[C]";
	}
	
}
