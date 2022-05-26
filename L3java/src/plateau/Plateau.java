package plateau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

import personnages.Personnage;


//Plateau est la vue de l'IHM
public class Plateau extends JPanel {
	//GUI
	private JPanel plateau;
	private JPanel tableauBord;
	
	
	private static final int TAILLE_PLATEAU = 15;
	
	private Case[][] cases;
	

	
	
	
	
	public Plateau() {
		
		this.setLayout(new BorderLayout());
		this.plateau = new JPanel(new GridLayout(TAILLE_PLATEAU, TAILLE_PLATEAU));
		this.tableauBord = new JPanel(new GridLayout(1, 2));
		
		this.add(this.plateau, BorderLayout.CENTER);
		this.add(this.tableauBord, BorderLayout.NORTH);
		
		
		
		this.cases = new Case[TAILLE_PLATEAU][TAILLE_PLATEAU];
		
		//Set blank cases
		for(int i = 0; i < TAILLE_PLATEAU; i ++) {
			for(int j = 0; j < TAILLE_PLATEAU; j ++) {
				cases[i][j] = new Case(i, j, null);
				this.plateau.add(cases[i][j]);
			}
		}
		//Set particular cases
		cases[1][13] = new CaseBonus(1, 13, Color.yellow);
		
		//Add to GUI
		for(int i = 0; i < TAILLE_PLATEAU; i ++) {
			for(int j = 0; j < TAILLE_PLATEAU; j ++) {
				this.plateau.add(cases[i][j]);
			}
		}
	}
	

	public Case getCases(int x, int y) {
		return cases[x][y];
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
	
	public void positionnerPiece(Personnage piece, int i, int j) {
		((Personnage)this.plateau.getComponent(i * this.TAILLE_PLATEAU + j)).setIcon(piece);
	}
	
	@Override
	public String toString() {
		String retour = new String();
		for(int i = 0; i < TAILLE_PLATEAU; i ++) {
			for(int j = 0; j < TAILLE_PLATEAU; j ++) {
				retour += this.getCases(i, j).toString();
			}
			retour += "\n";
		}
		return retour;
	}
}
