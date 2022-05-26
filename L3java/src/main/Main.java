package main;

import java.awt.GridLayout;

import javax.swing.JFrame;

import plateau.Plateau;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(1, 1));
		f.add(new Plateau());
		f.pack();
		f.setVisible(true);
		f.setSize(300, 300);
		
		
		Plateau plateauTest = new Plateau();
		
		System.out.println(plateauTest);

	}

}
