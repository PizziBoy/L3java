package jeu;

import joueur.Joueur;
import plateau.Plateau;

/*
 * Classe étant le point d'entrée de notre jeu (pas totalement implémenté)
 */
public class Jeu {
	private Plateau plateau;
	private Joueur J1;
	private Joueur J2;
	
	/**
	 * Construit notre jeu CToeuf JAVA
	 * @param plateau Plateau du jeu
	 * @param j1	Joueur1
	 * @param j2	Joueur2
	 */
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
