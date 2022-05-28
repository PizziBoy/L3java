package Bonus;

import java.util.Random;

import personnages.Personnage;

public class Bonus {

	
	public Bonus (Personnage perso) {
		
	}
	
	// M�thode permettant d'ajouter de la vie � un personnage 
	public void ajoutVie(Personnage perso) {
		//Initialisation d'une variable vie qui va ajouter 50 points de vie au personnage
		int vie = perso.getVie() + 50;
		// On attribue la variable vie � la m�thode setVie impl�ment�e dans la classe Personnage
		perso.setVie(vie);
		System.out.println(perso + "gagne 50 points de vie, il a " + vie + "points de vie");
	}
	
	// M�thode permettant de diminuer la vie � un personnage 
	public void diminuerVie(Personnage perso) {
		//Initialisation d'une variable vie qui va diminuer de 50 points la vie du personnage
		int vie = perso.getVie() - 50;
		// On attribue la variable vie � la m�thode setVie impl�ment�e dans la classe Personnage
		perso.setVie(vie);
		System.out.println(perso + "perd 50 points de vie, il a " + vie + "points de vie");
	}
	
	// M�thode qui va d�terminer quel avantage ou incov�nient aura le personnage 
	public void choixBonus (Personnage perso) {
		// Cr�ation d'un nombre al�atoire en 0 et 1
		int nb_aleatoire = new Random().nextInt(2);
		
		// Utilisation d'une condition switch/case qui va ajouter ou diminuer de la vie en fonction du nombre al�atoire tir�
		switch(nb_aleatoire) {
		
		case 0:
			this.ajoutVie(perso);
			break;
		
		case 1 :
			this.diminuerVie(perso);
			
		}
		
	}
}
