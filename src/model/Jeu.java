package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	public List<Pieces> pieces = null;
	
	
	public Jeu(Couleur couleur)
	{
		pieces= ChessPiecesFactory.newPieces(couleur);

	}
	

}
