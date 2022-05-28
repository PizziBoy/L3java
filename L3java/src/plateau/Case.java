package plateau;

import java.awt.Color;

import javax.swing.JButton;

import personnages.Personnage;


/**
 * Classe représentant une Case du Plateau
 * 
 */
public class Case extends JButton {
	//Classname personnage 
	private Personnage personnage;

	//tuple x,y
	private int x;
	private int y;
	private Color couleur;
	
	/**
	 * Construit une case à l'aide de ses coordonnées sur le plateau ainsi que sa couleur de fond
	 * @param x	coordonnée x
	 * @param y coordonnée y
	 * @param couleur	Color
	 */
	public Case(int x, int y, Color couleur) {
		super();
		this.x = x;
		this.y = y;
		this.setBackground(couleur);
	}
	
	
	
	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}
	
	public Personnage getPersonnage() {
		return this.personnage;
	}



	public void setPersonnage(Personnage piece) {
		this.personnage = piece;
	}



	@Override
	public String toString() {
		return "[ ]";
	}
}
