package model;

public class Roi extends AbstractPiece{
	
	public Roi(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal)
	{
		if(coord.x + 1 == xFinal || coord.y + 1 == yFinal  )
			return true;
		else 
			return false;
	}

}
