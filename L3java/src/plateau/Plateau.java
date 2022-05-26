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

		
		//Cases camp A (haut gauche)
		cases[0][0] = new CaseCamp(0, 0, );
		cases[0][1] = new CaseCamp(0, 1, );
		cases[0][2] = new CaseCamp(0, 2, );
		cases[1][0] = new CaseCamp(1, 0, );
		cases[1][1] = new CaseCamp(1, 1, );
		cases[2][0] = new CaseCamp(2, 0, );
		
		//Cases camp B (bas droite)
		cases[12][14] = new CaseCamp(12, 14, );
		cases[13][13] = new CaseCamp(13, 13, );
		cases[13][14] = new CaseCamp(13, 14, );
		cases[14][12] = new CaseCamp(14, 12, );
		cases[14][13] = new CaseCamp(14, 13, );
		cases[14][14] = new CaseCamp(14, 14, );
		
		//Cases obstacles
		cases[1][10] = new CaseMur(1, 10);
		cases[2][9] = new CaseMur(2, 9);
		cases[4][13] = new CaseMur(4, 13);
		cases[5][6] = new CaseMur(5, 6);
		cases[5][8] = new CaseMur(5, 8);
		cases[5][12] = new CaseMur(5, 12);
		cases[6][5] = new CaseMur(6, 5);
		cases[6][9] = new CaseMur(6, 9);
		cases[7][4] = new CaseMur(7, 4);
		cases[7][10] = new CaseMur(7, 10);
		cases[8][5] = new CaseMur(8, 5);
		cases[8][9] = new CaseMur(8, 9);
		cases[9][2] = new CaseMur(9, 2);
		cases[9][6] = new CaseMur(9, 6);
		cases[9][8] = new CaseMur(9, 8);
		cases[10][1] = new CaseMur(10, 1);
		cases[12][5] = new CaseMur(12, 5);
		cases[13][4] = new CaseMur(13, 4);
		
		//Cases bonus
		cases[1][13] = new CaseBonus(1, 13);
		cases[13][1] = new CaseBonus(13, 1);
		
		//Case oeufs
		cases[7][]

	

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
