package jeu;

import joueur.Joueur;
import plateau.Plateau;

public class Jeu {
	private Plateau plateau;
	private Joueur J1;
	private Joueur J2;
	
	
	public Jeu(Plateau plateau, Joueur j1, Joueur j2) {
		super();
		this.plateau = plateau;
		J1 = j1;
		J2 = j2;
	}
	
	
	public void lancerPartie() {
		
	}
	
	public boolean estPartieFinie() {
		return false;
		
	}
	
	public void jouerTour(Joueur joueur) {
		
	}
	
	
	
	
}
