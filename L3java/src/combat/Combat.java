package combat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personnages.Personnage;
import plateau.Plateau;

public class Combat extends JFrame implements ActionListener{ //Utilisation de la classe JFrame afin de lancer un combat par le biais d'une interface graphique
	
	private Personnage gagnant;
	
	private Personnage p1;
	private Personnage p2;
	private Plateau plateau;
	private JLabel labelNbRound;
	private int nbRound;
	
// Initialisation des attributs de l'interface graphique
	private JPanel panneauWrapper;
	private JPanel panneauControle;
	private JPanel panneauInfosPersonnages;
	
	private JLabel nomP1;
	private JLabel vieP1;
	private JLabel nomP2;
	private JLabel vieP2;
	
	
	private JLabel instructionsCombat;
	private JLabel infoCombat;
	private JTextField inputJ1;
	private JTextField inputJ2;
	private JButton button;
	
	
// Initialisation du constructeur combat en récupérant les paramètres des personnages de chaque joueur en entrée
	public Combat(Personnage p1, Personnage p2, Plateau plateau) {
		
		//Setup fenêtre combat
		super("" + p1 + " vs " + p2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		
		
		this.p1 = p1;
		this.p2 = p2;
		this.plateau = plateau;
		
		//Partie INFOS PERSONNAGES
		this.panneauInfosPersonnages = new JPanel(new GridLayout(2, 3));
		
		//Personnage 1
		this.nomP1 = new JLabel(new ImageIcon(p1.img));
		this.vieP1 = new JLabel("Vie : " + p1.getVie());
		
		//Personnage 2
		this.nomP2 = new JLabel(new ImageIcon(p2.img));
		this.vieP2 = new JLabel("Vie : " + p2.getVie());
		
		//Ajout dans le panneau
		this.panneauInfosPersonnages.add(this.nomP1);
		this.panneauInfosPersonnages.add(this.nomP2);
		//JLabel null
		this.panneauInfosPersonnages.add(new JLabel());
		this.panneauInfosPersonnages.add(this.vieP1);
		this.panneauInfosPersonnages.add(this.vieP2);
		
		
		//Partie INTERACTIONS UTILISATEUR
		//Création d'une zone de texte pour le joueur 1
		this.panneauControle = new JPanel(new GridLayout(2, 3));
		
		//Nombres de round
		this.nbRound = 0;
		this.labelNbRound = new JLabel("Nombres de tours : "+this.nbRound);
		
		//Instructions
		this.instructionsCombat = new JLabel("<html>Joueurs, devinez le nombre aléatoire généré entre 0 et 100. "
				+ "<br>La saisie la plus proche l'emporte"
				+ "<br>Plus la saisie est proche du nombre caché plus le joueur va mettre de dégat</html>");
		
		this.infoCombat = new JLabel("");
		
		//J1
		this.inputJ1 = new JTextField();
		this.inputJ1.setPreferredSize(new Dimension(50, 25));
		
		//J2
		this.inputJ2 = new JTextField();
		this.inputJ2.setPreferredSize(new Dimension(50, 25));
		
		//Submit button
		this.button = new JButton("Jouer round");
		//Ajout écouteur button
		this.button.addActionListener(this);
		
		//Ajout dans le panneau
		
		this.panneauControle.add(this.inputJ1);
		this.panneauControle.add(this.inputJ2);
		this.panneauControle.add(this.instructionsCombat);
		this.panneauControle.add(this.labelNbRound);
		this.panneauControle.add(this.infoCombat);
		this.panneauControle.add(this.button);
		
		
		//ASSEMBLAGE
		this.panneauWrapper = new JPanel(new GridLayout(2, 1));
		this.panneauWrapper.add(this.panneauInfosPersonnages);
		this.panneauWrapper.add(this.panneauControle);
		
		this.add(panneauWrapper);
		
		this.pack();
		this.setVisible(true);
		
		
		
		
	}
	public void verifierCombat() {
		
		if (this.p1.getVie() == 0 || this.p2.getVie() == 0) {
			this.labelNbRound.setText("COMBAT FINI EN : "+this.nbRound);
			this.button.setVisible(false);	
		} 
		
		if (this.p2.getVie() == 0) {
			int xPerdant = this.plateau.getxyByPersonnage(p2)[0];
			int yPerdant = this.plateau.getxyByPersonnage(p2)[1];
			System.out.println(xPerdant);
			this.setGagnant(p1);
			this.plateau.retirerPersonnage(p2, xPerdant, yPerdant);
			this.plateau.positionnerPersonnage(p1, xPerdant, yPerdant, false);
		}
		else {
			int xPerdant = this.plateau.getxyByPersonnage(p1)[0];
			int yPerdant = this.plateau.getxyByPersonnage(p1)[1];
			System.out.println(xPerdant);
			this.setGagnant(p2);
			this.plateau.retirerPersonnage(p1, xPerdant, yPerdant);
			this.plateau.positionnerPersonnage(p2, xPerdant, yPerdant, false);
		}
		
		
	}
	
	
	public void jouerRound() {
		
		//Maj nb round
		this.nbRound ++;
		this.labelNbRound.setText("Nombres de tours : " + this.nbRound);
		
		//Si les entrées sont données
		if (!(inputJ1.getText() == null || inputJ2.getText() == null)) {
			
			//On stocke les valeurs saisies par J1 et J2
			int nombreJ1 = Integer.parseInt(inputJ1.getText());
			
			int nombreJ2 = Integer.parseInt(inputJ2.getText());
			
			
			//Lancement de la génération du nombre aléatoire
			int nbRef = new Random().nextInt(101);

			//Chaine info combat
			String infoCombat = new String("Nombre aléatoirement généré : " + nbRef);
			
			//Voir quel joueur est le plus proche du nombre généré
			int diffJ1 = Math.abs(nbRef - nombreJ1);
			int diffJ2 = Math.abs(nbRef - nombreJ2);
			

			//Désignation du gagnant du round
			if(diffJ1 < diffJ2){
				//J1 GAGNE LE ROUND
				//Calcul du dégat selon la distance entre le nombre généré et le nombre saisi du perdant
				int degats = Math.abs(nbRef - diffJ2);
				
				//Chaine info combat
				infoCombat += " <br> " + "J1 a gagné le round et infligera " + degats + " points de dégats";
				
				//Recevoir le coup
				this.p2.recevoirCoup(degats);
				
				//Maj vie GUI
				this.vieP2.setText("Vie : " + this.p2.getVie());
				
			}
			else {
				//J2 GAGNE LE ROUND
				//Calcul du dégat selon la distance entre le nombre généré et le nombre saisi du perdant
				int degats = Math.abs(nbRef - diffJ1);
				infoCombat += " <br> " + "J2 a gagné le round et infligera " + degats + " points de dégats";
				
				this.p1.recevoirCoup(degats);
				
				//Maj vie GUI
				this.vieP1.setText("Vie : " + this.p1.getVie());
				
			}
			this.infoCombat.setText("<html>" + infoCombat + "</html>");
			this.inputJ1.setText("");
			this.inputJ2.setText("");
			this.verifierCombat();
			
		}

		
		
	}
	
	
	public static void main(String[] args) {
		
		
		//Création d'une interface graphique dédiée au combat
		Combat interfaceCombat = new Combat(Personnage.archer, Personnage.darkArcher, null);
		interfaceCombat.pack();
		interfaceCombat.setVisible(true);
		interfaceCombat.verifierCombat();
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//COMBATTRE
		if (e.getActionCommand().equals("Jouer round"))
		  {
			
			this.jouerRound();
			
		  }
 
		
		
	}

	public Personnage getGagnant() {
		return gagnant;
	}

	public void setGagnant(Personnage gagnant) {
		this.gagnant = gagnant;
	}
	
}		
		
		
		/*Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
	            int i = 5;

	            public void run() {
	                
	            	texte.setText("Préparez vous : " + i);
	                i--;

	                if (i < 0) {
	                    timer.cancel();
	                    texte.setText("Cliquez sur le bouton vite !");
	                    JButton bouton = new JButton();
	                    fenetre.add(bouton);
	                    bouton.addActionListener(new ActionListener()
	                    {
	                      public void actionPerformed(ActionEvent e)
	                      {
	                    	  fenetre.add(new JButton());
	                      }
	                });
	            }
	          }
	        }, 0, 1000);*/


