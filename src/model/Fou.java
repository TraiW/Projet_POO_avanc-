package model;


public class Fou extends AbstractPiece {
	


	public Fou(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	
public boolean isMoveOk(int xFinal,int yFinal){
		
		if(Math.abs(coord.x - xFinal) == Math.abs(coord.y - yFinal))
			return true;
		else 
			return false;		
	}
}
