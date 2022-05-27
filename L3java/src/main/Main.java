package main;

import java.awt.GridLayout;

import javax.swing.JFrame;

import plateau.Plateau;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.add(new Plateau());
		f.repaint();
		f.pack();
		f.setVisible(true);
		f.setSize(1920, 1080);
		
		

	}

}
