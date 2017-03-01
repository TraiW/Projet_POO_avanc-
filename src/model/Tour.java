package model;

public class Tour extends AbstractPiece {

	

	public Tour(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	
	public boolean isMoveOk(int xFinal,int yFinal){
		
		if(coord.x == xFinal  || coord.y == yFinal  )
			return true;
		else 
			return false;		
	}
}
