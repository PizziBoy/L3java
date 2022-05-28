package personnages;

import java.awt.Color;

import javax.swing.ImageIcon;

import armes.Arme;
import combat.Combat;
import joueur.Joueur;




/**
 * 
 * Classe représentant un personnage jouable sur le plateau, Personnage héritant de ImageIcon
 * 
 * 
 *
 */
public class Personnage extends ImageIcon {
	Color couleur;
	private int vie;
	public String img;
	private Arme arme;
	private int nbCasesDeplacement;
	private boolean estPorteurDunOeuf;
	
	
	
	
	/**
	 * 
	 * 
	 * @param vie entier représentant les points de vie
	 * @param arme Arme du personnage
	 * @param type 'Archer' ou 'Villageois' ou 'Barbare'
	 * @param equipe 'dark' ou 'light'
	 */
	public Personnage(int vie, Arme arme, String type, String equipe) {
		super("./src/icones_L3JAVA/"+ equipe + type + ".png");
		this.img = "./src/icones_L3JAVA/"+ equipe + type + ".png";
		this.vie = vie;
		this.arme = arme;
		//Différenciation au niveau des 2 joueurs
		if (equipe == "light") this.couleur = Color.white;
		if (equipe == "dark") this.couleur = Color.black;
	}
	
	
	//Personnages prédéfinis 
	public static Personnage villageois = new Villageois(100, null, "light");
	public static Personnage archer = new Archer(100, null, "light");
	public static Personnage archer1 = new Archer(100, null, "light");
	


	public static Personnage barbare = new Barbare(100, null, "light");
	public static Personnage barbare1 = new Barbare(100, null, "light");
	public static Personnage barbare2 = new Barbare(100, null, "light");
	
	public static Personnage darkVillageois = new Villageois(100, null, "dark");
	public static Personnage darkArcher = new Archer(100, null, "dark");
	public static Personnage darkArcher1 = new Archer(100, null, "dark");
	public static Personnage darkBarbare = new Barbare(100, null, "dark");
	public static Personnage darkBarbare1 = new Barbare(100, null, "dark");
	public static Personnage darkBarbare2 = new Barbare(100, null, "dark");
	
	
	
	/**
	 * Recevoir un coup en affectant les points de vie du personnage
	 * 
	 * @param degat nombre de points de vie à enlever
	 */
	public void recevoirCoup(int degat) {
		//Si les dégats reçus ne mettent pas la vie à 0
		if (this.getVie() - degat > 0) {
			this.setVie(this.getVie() - degat);
		} 
		//Si les dégats reçus mettent la vie <= à 0
		else {
			this.setVie(0);
		}
		
		}
	


	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public Arme getArme() {
		return arme;
	}
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	public int getNbCasesDeplacement() {
		return nbCasesDeplacement;
	}
	public void setNbCasesDeplacement(int nbCasesDeplacement) {
		this.nbCasesDeplacement = nbCasesDeplacement;
	}
	public boolean isEstPorteurDunOeuf() {
		return estPorteurDunOeuf;
	}
	public void setEstPorteurDunOeuf(boolean estPorteurDunOeuf) {
		this.estPorteurDunOeuf = estPorteurDunOeuf;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public String toString() {
		return "" + this.img;
	}
	
	
}
