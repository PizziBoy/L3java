package plateau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import joueur.Joueur;
import personnages.Personnage;


//Plateau est la vue de l'IHM
public class Plateau extends JPanel {
	//GUI
	private JPanel plateau;
	private JPanel tableauBord;
	
	//PARAM JEU
	private static final int TAILLE_PLATEAU = 15;
	
	//Cases physiques
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
				cases[i][j] = new Case(i, j, Color.LIGHT_GRAY);
			}
		}
		//Set particular cases
		cases[1][13] = new CaseBonus(1, 13, Color.yellow);
		

		
		//Cases camp A (haut gauche)
		cases[0][0] = new CaseCamp(0, 0, Color.gray);
		cases[0][1] = new CaseCamp(0, 1, Color.gray);
		cases[0][2] = new CaseCamp(0, 2, Color.gray);
		cases[1][0] = new CaseCamp(1, 0, Color.gray);
		cases[1][1] = new CaseCamp(1, 1, Color.gray);
		cases[2][0] = new CaseCamp(2, 0, Color.gray);
		
		//Cases camp B (bas droite)
		cases[12][14] = new CaseCamp(12, 14, Color.white);
		cases[13][13] = new CaseCamp(13, 13, Color.white);
		cases[13][14] = new CaseCamp(13, 14, Color.white);
		cases[14][12] = new CaseCamp(14, 12, Color.white);
		cases[14][13] = new CaseCamp(14, 13, Color.white);
		cases[14][14] = new CaseCamp(14, 14, Color.white);
		
		//Cases obstacles
		cases[1][10] = new CaseMur(1, 10, Color.black);
		cases[2][9] = new CaseMur(2, 9, Color.black);
		cases[4][13] = new CaseMur(4, 13, Color.black);
		cases[5][6] = new CaseMur(5, 6, Color.black);
		cases[5][8] = new CaseMur(5, 8, Color.black);
		cases[5][12] = new CaseMur(5, 12, Color.black);
		cases[6][5] = new CaseMur(6, 5, Color.black);
		cases[6][9] = new CaseMur(6, 9, Color.black);
		cases[7][4] = new CaseMur(7, 4, Color.black);
		cases[7][10] = new CaseMur(7, 10, Color.black);
		cases[8][5] = new CaseMur(8, 5, Color.black);
		cases[8][9] = new CaseMur(8, 9, Color.black);
		cases[9][2] = new CaseMur(9, 2, Color.black);
		cases[9][6] = new CaseMur(9, 6, Color.black);
		cases[9][8] = new CaseMur(9, 8, Color.black);
		cases[10][1] = new CaseMur(10, 1, Color.black);
		cases[12][5] = new CaseMur(12, 5, Color.black);
		cases[13][4] = new CaseMur(13, 4, Color.black);
		
		//Cases bonus
		cases[1][13] = new CaseBonus(1, 13, Color.yellow);
		cases[13][1] = new CaseBonus(13, 1, Color.yellow);
		
		//Case oeufs
		cases[7][7] = new CaseOeuf(7, 7, Color.magenta);	
		
		//Add to GUI
				for(int i = 0; i < TAILLE_PLATEAU; i ++) {
					for(int j = 0; j < TAILLE_PLATEAU; j ++) {
						this.plateau.add(cases[i][j]);
					}
				}
				
		//Personnages creation this.
				
		this.cases[0][1].setIcon(new ImageIcon(Personnage.archer.getImage()));
		this.positionnerPiece(Personnage.villageois, 0, 1, Joueur.J1);
		this.positionnerPiece(Personnage.archer, 0, 2);
		this.positionnerPiece(Personnage.barbare, 0, 3);
		this.positionnerPiece(PieceIHM.tourN, 0, 3);

		
		
	}


	public Case getCases(int x, int y) {
		return cases[x][y];
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
	
	public void positionnerPiece(Personnage piece, int i, int j) {

		((Case)this.plateau.getComponent(i + this.TAILLE_PLATEAU + j)).setIcon(piece);
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
