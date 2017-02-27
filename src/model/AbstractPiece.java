package src.model;

public class AbstractPiece implements Pieces{
	
	public Coord coord;
	public Couleur couleur;
	
	public AbstractPiece(Couleur couleur, Coord coord){
		this.couleur=couleur;
		this.coord=coord;
		
	}
	public boolean capture(){
		
	}
	public Couleur getCouleur(){
		
	}
	public int getX(){
		
	}
	public int getY(){
		
	}
	public boolean isMoveOk(int xFinal,int yFinal){
		
	}
	public boolean move(int xFinal, int yFinal){
		
	}

}
