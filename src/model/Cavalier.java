package model;

public class Cavalier extends AbstractPiece{
	
	public Cavalier(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal){
		
		if(coord.x + 2 == xFinal && coord.y + 1 == yFinal 
				|| coord.y + 2 == yFinal && coord.x +1 == xFinal
				|| coord.x - 2 == xFinal && coord.y - 1 == yFinal 
				|| coord.y - 2 == yFinal && coord.x - 1 == xFinal
				|| coord.x + 2 == xFinal && coord.y - 1 == yFinal 
				|| coord.y + 2 == yFinal && coord.x - 1 == xFinal
				|| coord.x - 2 == xFinal && coord.y + 1 == yFinal 
				|| coord.y - 2 == yFinal && coord.x + 1 == xFinal)// A mettre mieux
			
			return true;
		else 
			return false;
	}

}
