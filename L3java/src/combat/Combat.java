package combat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personnages.Personnage;

public class Combat extends JFrame{ //Utilisation de la classe JFrame afin de lancer un combat par le biais d'une interface graphique
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1200834109424871485L;
	/*private int pourcentageAttaqueX;
	private int pourcentageAttaqueY;
	private int temps;*/
	
	private Personnage p1;
	private Personnage p2;
	
// Initialisation des attributs de l'interface graphique
	private JPanel contenupanneau;
	private JLabel texteJ1;
	private JLabel texteJ2;
	private JTextField zoneTexteJ1;
	private JTextField zoneTexteJ2;
	private JButton bouton;
	
	
// Initialisation du constructeur combat en récupérant les paramètres des personnages de chaque joueur en entrée
	public Combat(Personnage p1, Personnage p2) {
		super(" Combat ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		
		//Ajout d'un panneau dans l'interface graphique qui va permettre d'insérer des boutons et des zones de texte 
		this.contenupanneau = (JPanel) this.getContentPane();
		contenupanneau.setLayout(new FlowLayout());
		
		//Création d'un champ texte pour indiquer au joueur 1 d'écrire un nombre aléatoire
		this.texteJ1 = new JLabel();
		this.contenupanneau.add(this.texteJ1);
		this.texteJ1.setText("Joueur 1, écrivez un nombre aléatoire : ");
		
		//Création d'une zone de texte pour le joueur 1
		this.zoneTexteJ1 = new JTextField();
		this.zoneTexteJ1.setPreferredSize(new Dimension(50, 25));
		this.contenupanneau.add(this.zoneTexteJ1);
		
		//Création d'un champ texte pour indiquer au joueur 2 d'écrire un nombre aléatoire
		this.texteJ2 = new JLabel();
		this.contenupanneau.add(this.texteJ2);
		this.texteJ2.setText("Joueur 2, écrivez un nombre aléatoire : ");
		
		//Création d'une zone de texte pour le joueur 2
		this.zoneTexteJ2 = new JTextField();
		this.zoneTexteJ2.setPreferredSize(new Dimension(50, 25));
		this.contenupanneau.add(this.zoneTexteJ2);
		
		//Création d'un bouton de validation 
		this.bouton = new JButton("Valider");
		this.contenupanneau.add(this.bouton);
		
		
	}
	
	public static Personnage combattre(Personnage x, Personnage y) {
		return null;
	}
	
	
	public static void main(String[] args) {
		
		
		//Création d'une interface graphique dédiée au combat
		Combat interfaceCombat = new Combat(null, null);
		interfaceCombat.setVisible(true);
		
		// Si le bouton a été cliqué
		interfaceCombat.bouton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// On stocke les valeurs saisies par joueur 1 et 2 dans des variables nombreJ1 et nombreJ2
				String valeurJ1 = interfaceCombat.zoneTexteJ1.getText();
				int nombreJ1 = Integer.parseInt(valeurJ1);
				System.out.println(nombreJ1);
				
				String valeurJ2 = interfaceCombat.zoneTexteJ2.getText();
				int nombreJ2 = Integer.parseInt(valeurJ2);
				System.out.println(nombreJ2);
				
				int nb = new Random().nextInt(101);
				System.out.println(nb);
				
				int diffJ1 = Math.abs(nb - nombreJ1);
				int diffJ2 = Math.abs(nb - nombreJ2);
				
				System.out.println(diffJ1);
				System.out.println(diffJ2);

				if(diffJ1 < diffJ2){
					int pourcentage_degats = ( (nb - diffJ1) / nb);
					System.out.println("Joueur 1 a gagné et infligera " + pourcentage_degats + "% de dégats");
				}
				else {
					int pourcentage_degats = ((nb - diffJ2) / nb);
					System.out.println("Joueur 1 a gagné et infligera " + pourcentage_degats + "% de dégats");
				}
			}
			
		});
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


