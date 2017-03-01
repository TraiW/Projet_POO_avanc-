package model;

public abstract class AbstractPiece implements Pieces{
	
	public Coord coord;
	public Couleur couleur;
	
	public AbstractPiece(Couleur couleur, Coord coord){
		this.couleur=couleur;
		this.coord=coord;
		
	}
	public boolean capture(){
		this.coord.x=-1;
		this.coord.y=-1;
		return true;
		
	}
	public Couleur getCouleur(){
		return this.couleur;
		 
	}
	public int getX(){
		return this.coord.x;
	}
	public int getY(){
		return this.coord.y;
	}
	public abstract boolean isMoveOk(int xFinal,int yFinal);
		
	public boolean move(int xFinal, int yFinal){
		
		if(isMoveOk(xFinal,yFinal)==true)
		{
			this.coord.x=xFinal;
			this.coord.y=yFinal;
			return true;
		}
		return false;
		
	}
	@Override
	public String toString() {
		return "AbstractPièce [coord=" + coord + ", couleur=" + couleur + "]";
	}
	

}
