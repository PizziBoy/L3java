package plateau;

import java.awt.Color;

import javax.swing.JButton;

import personnages.Personnage;

public class Case extends JButton {
	//Classname personnage 
	private Personnage personnage;

	//tuple x,y
	private int x;
	private int y;
	private Color couleur;
	
	public Case(int x, int y, Color couleur) {
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
