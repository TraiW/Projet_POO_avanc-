package model;

public class AbstractPiece implements Pieces{
	
	public Coord coord;
	public Couleur couleur;
	
	public AbstractPiece(Couleur couleur, Coord coord){
		this.couleur=couleur;
		this.coord=coord;
		
	}
	public boolean capture(){
		return false;
		
	}
	public Couleur getCouleur(){
		return couleur;
		
	}
	public int getX(){
		return 0;
		
	}
	public int getY(){
		return 0;
		
	}
	public boolean isMoveOk(int xFinal,int yFinal){
		return false;
		
	}
	public boolean move(int xFinal, int yFinal){
		return false;
		
	}

}
