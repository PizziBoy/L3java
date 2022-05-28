package plateau;

import java.awt.Color;

import javax.swing.JButton;

import personnages.Personnage;


/**
 * Classe repr�sentant une Case du Plateau
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
	 * Construit une case � l'aide de ses coordonn�es sur le plateau ainsi que sa couleur de fond
	 * @param x	coordonn�e x
	 * @param y coordonn�e y
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
