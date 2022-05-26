package plateau;

import java.awt.Color;

import javax.swing.JButton;

public class Case extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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



	@Override
	public String toString() {
		return "[ ]";
	}
}
