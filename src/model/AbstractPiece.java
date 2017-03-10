package model;

/**
 * Résumé
 * Gère le comportement commun à toutes les pièces
 * Chaque pièce qui dérive sera capable de dire si le déplacement est OK
 *
 */
public abstract class AbstractPiece implements Pieces{
	

	public Coord coord=null;
	public Couleur couleur=null;
	
	/**
	 * @param couleur
	 * @param coord
	 */
	public AbstractPiece(Couleur couleur, Coord coord){
		this.couleur=couleur;
		this.coord=coord;
		
	}
	
/**
 * @return true si la piece est capturée
 * Position x et y à -1
 */
	public boolean capture(){
		this.coord.x=-1;
		this.coord.y=-1;
		return true;
		
	}
/**
 * @return la couleur de la pièce
 */
	public Couleur getCouleur(){
		return this.couleur;
	}
	
	public int getX(){
		return this.coord.x;
	}
	
	public int getY(){
		return this.coord.y;
	}
	
	
/**
 * @return true si déplacement légal en fonction 
 * des algo de déplacement spécifique de chaque pièce
 */
	public abstract boolean isMoveOk(int xFinal,int yFinal);

	
/**
 * @return true si le deplacement est effectué
 */
	public boolean move(int xFinal, int yFinal){
		
		if(isMoveOk(xFinal,yFinal)==true)
		{
			this.coord.x=xFinal;
			this.coord.y=yFinal;
			System.out.println("déplacement effectué");
			return true;
		}
		System.out.println("deplacement refusé");
		return false;
		
	}
	
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[coord=" + coord + ", couleur=" + couleur + "] \n";
	}
//	public static void main(String[] args) 
//	{
////		Pieces testTour= new Fou(Couleur.NOIR,new Coord(5,6));
////		System.out.println("création tour");
////		System.out.println("La tour bouge en 0,5");
////		testTour.move(4,5);
////		System.out.println("La tour a bien bougé");
//		 
//	}

}
