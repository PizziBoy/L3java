package personnages;

import java.awt.Color;

import javax.swing.ImageIcon;

import armes.Arme;
import combat.Combat;

public class Personnage extends ImageIcon {
	//Couleur représente J1 ou J2
	private Color couleur;
	private int vie;
	private Arme arme;
	private int nbCasesDeplacement;
	private boolean estPorteurDunOeuf;
	
	//tuple x,y
	private int[] position;
	
	
	
	public Personnage(int vie, Arme arme) {
		super("./src/IHM.images/"+ nom + couleur + type + ".gif");
		this.vie = vie;
		this.arme = arme;
	}
	
	public void entrerEnCombat(Personnage y) {
			Combat.combattre(this, y);
		}
	
	public void donnerCoup(Personnage y, int degat) {
		y.setVie(this.getVie() - degat);
	}
	
	public void recevoirCoup(int degat) {
		this.setVie(this.getVie() - degat);
		}
	

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
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
