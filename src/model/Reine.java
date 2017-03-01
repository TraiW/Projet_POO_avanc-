package model;

public class Reine extends AbstractPiece{
	


	public Reine(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal){
		if(Math.abs(coord.x - xFinal) == Math.abs(coord.y - yFinal)
				|| (coord.x == xFinal  || coord.y == yFinal) )
			
			return true;
		else
			
			return false;
	}
}
