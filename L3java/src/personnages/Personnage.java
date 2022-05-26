package personnages;

import java.awt.Color;

import javax.swing.ImageIcon;

import armes.Arme;
import combat.Combat;
import joueur.Joueur;

public class Personnage extends ImageIcon {
	Color couleur;
	private int vie;
	private Arme arme;
	private int nbCasesDeplacement;
	private boolean estPorteurDunOeuf;
	
	
	
	
	
	public Personnage(int vie, Arme arme, String type, Color couleur) {
		super("./src/icones_L3JAVA/"+ type + ".png");
		this.vie = vie;
		this.arme = arme;
		this.couleur = couleur;
	}
	
	
	
	public static Personnage villageois = new Villageois(100, null, Color.white);
	public static Personnage archer = new Archer(100, null, Color.white);
	public static Personnage archer1 = new Archer(100, null, Color.white);
	public static Personnage barbare = new Barbare(100, null, Color.white);
	public static Personnage barbare1 = new Barbare(100, null, Color.white);
	public static Personnage barbare2 = new Barbare(100, null, Color.white);
	
	public static Personnage darkVillageois = new Villageois(100, null, Color.black);
	public static Personnage darkArcher = new Archer(100, null, Color.black);
	public static Personnage darkArcher1 = new Archer(100, null, Color.black);
	public static Personnage darkBarbare = new Barbare(100, null, Color.black);
	public static Personnage darkBarbare1 = new Barbare(100, null, Color.black);
	public static Personnage darkBarbare2 = new Barbare(100, null, Color.black);
	
	public void entrerEnCombat(Personnage y) {
			Combat.combattre(this, y);
		}
	
	public void donnerCoup(Personnage y, int degat) {
		y.setVie(this.getVie() - degat);
	}
	
	public void recevoirCoup(int degat) {
		this.setVie(this.getVie() - degat);
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
	
	
}
