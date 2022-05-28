package Bonus;

import java.util.Random;

import personnages.Personnage;

public class Bonus {

	
	public Bonus (Personnage perso) {
		
	}
	
	// Méthode permettant d'ajouter de la vie à un personnage 
	public void ajoutVie(Personnage perso) {
		//Initialisation d'une variable vie qui va ajouter 50 points de vie au personnage
		int vie = perso.getVie() + 50;
		// On attribue la variable vie à la méthode setVie implémentée dans la classe Personnage
		perso.setVie(vie);
		System.out.println(perso + "gagne 50 points de vie, il a " + vie + "points de vie");
	}
	
	// Méthode permettant de diminuer la vie à un personnage 
	public void diminuerVie(Personnage perso) {
		//Initialisation d'une variable vie qui va diminuer de 50 points la vie du personnage
		int vie = perso.getVie() - 50;
		// On attribue la variable vie à la méthode setVie implémentée dans la classe Personnage
		perso.setVie(vie);
		System.out.println(perso + "perd 50 points de vie, il a " + vie + "points de vie");
	}
	
	// Méthode qui va déterminer quel avantage ou incovénient aura le personnage 
	public void choixBonus (Personnage perso) {
		// Création d'un nombre aléatoire en 0 et 1
		int nb_aleatoire = new Random().nextInt(2);
		
		// Utilisation d'une condition switch/case qui va ajouter ou diminuer de la vie en fonction du nombre aléatoire tiré
		switch(nb_aleatoire) {
		
		case 0:
			this.ajoutVie(perso);
			break;
		
		case 1 :
			this.diminuerVie(perso);
			
		}
		
	}
}
