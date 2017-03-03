package model;

public class Pion extends AbstractPiece implements Pions{
	
	public Pion(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	
	public boolean isMoveOk(int xFinal,int yFinal){
		
		if(coord.x ==1 || coord.x == 6)
		{
			if(coord.y ==2 || coord.y == -2)
				return true;
			else
				return false;
		}
		
		if(coord.y + 1 == yFinal || coord.y -1 == yFinal) //Gérer le premier deplacement
			return true;
		else 
			return false;	
	}
	
	public boolean isMoveDiagOk(int xFinal,int yFinal){
		if(Math.abs(coord.x - xFinal) == Math.abs(coord.y - yFinal))
			return true; //Gérer qu'il y a bien un pion adverse
		else 
			return false;
	}
	
	public boolean move(int x,int y){
		return true;
	}

}
