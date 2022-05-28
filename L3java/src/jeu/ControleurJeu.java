package jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import combat.Combat;
import personnages.Personnage;
import plateau.Case;
import plateau.CaseMur;
import plateau.Plateau;

public class ControleurJeu implements MouseListener{
	
	private enum etatControleur{
		J1, J2
	}
	
	//plateau est la vue + le modèle combiné pour l'instant
	private Plateau plateau;
	private etatControleur etat;
	private boolean estPartieFinie;
	
	
	//INIT de partie
	public ControleurJeu(Plateau plateau) {
		super();
		this.plateau = plateau;
		this.etat = etatControleur.J1;
		this.estPartieFinie = false;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
		int x = ((Case) e.getSource()).getX();
		int y = ((Case) e.getSource()).getY();
		System.out.println(this.plateau.getCases(x, y).getPersonnage());
		
		
		//COMBAT
		if (this.plateau.getSelection() != null && this.plateau.getCases(x, y).getPersonnage() instanceof Personnage &&
				this.plateau.getSelection().getPersonnage().getCouleur() != this.plateau.getCases(x, y).getPersonnage().getCouleur()) {
			//Setup combat
			Combat combat = new Combat(this.plateau.getSelection().getPersonnage(), this.plateau.getCases(x, y).getPersonnage(), this.plateau);
			
			//Lancer combat
			
			System.out.println(combat.getGagnant());
			
			
		}
		
		
		//DEPLACEMENT
		//Si la case cliquée contient un personnage alors on MAJ la selection du plateau
		else if (this.plateau.getCases(x, y).getPersonnage() instanceof Personnage ) {
			System.out.println(this.plateau.getCases(x, y).getPersonnage());
				//MAJ selection de la case cliquée
				this.plateau.setSelection(this.plateau.getCases(x, y));
				System.out.println(this.plateau.getCases(x, y).getPersonnage().img);
			} 
		//Si la case cliquée n'est pas une instance de mur et que selection est non nulle ALORS déplacement
			else if (!(this.plateau.getCases(x, y) instanceof CaseMur) && this.plateau.getSelection() != null) {
			//Déplacement
			this.plateau.positionnerPersonnage(this.plateau.getSelection().getPersonnage(), x, y, false);
			//Reset selection plateau
			this.plateau.setSelection(null);
		}
		//Si la case de destination contient déja un personnage 
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
