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
		System.out.println("deplacement refusé");
		return false;
		
	}
	@Override
	public String toString() {
		return "AbstractPièce [coord=" + coord + ", couleur=" + couleur + "]";
	}
	public static void main(String[] args) 
	{
		Pieces testTour= new Fou(Couleur.NOIR,new Coord(5,6));
		System.out.println("création tour");
		System.out.println("La tour bouge en 0,5");
		testTour.move(4,5);
		System.out.println("La tour a bien bougé");
		 
	}

}
