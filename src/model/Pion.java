package model;

public class Pion extends AbstractPiece implements Pions{
	
	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Pion(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}

/** Résumé
 * Valide les déplacements en avant d'une case et deux cases
 * mais ne vérifie pas s'il y a une piece sur le chemin
 * @param xFinal colonne
 * @param yFinal ligne
 * @return true si le mouvement est validé 
 * 
 */
	public boolean isMoveOk(int xFinal,int yFinal){
		boolean bool = false;
		if(coord.y ==1 || coord.y == 6)
		{
//			System.out.println("1");

			if(coord.y==1)
			{
				if(yFinal==coord.y + 2)
				{
					//System.out.println("true pion.java");
					bool = true;
				}
			
			}
			else if(coord.y==6) //coord.y==6
			{
				if(yFinal==coord.y - 2)
				{
					//System.out.println("isMoveOk 2 du pion.java OK");
					bool = true;
				}
			}	
		}
		
		if(yFinal==coord.y + 1   || yFinal == coord.y -1 ) //Gérer le premier deplacement
		{
			//System.out.println("isMoveOk du pion.java OK");
			bool = true;
		}
		/*else 
		{
			System.out.println("isMoveOk du pion.java KO");

			bool = false;
		} car si avance de 2 cases -> vrai mais le else met faux */
		return bool;
	}
	
	public boolean isMoveDiagOk(int xFinal,int yFinal){
//		if(Math.abs(coord.x - xFinal) == Math.abs(coord.y - yFinal))
//			return true; //Gérer qu'il y a bien un pion adverse
//		else 
//			return false;
		boolean bool=false;
		int deltax = xFinal-this.getX();
		int deltay = yFinal-this.getY();
		//On verifiera les couleurs dans echiquier ;):
		if( deltax*deltay==1)
			{
				bool=true;
			}
		else
			{
				bool=false;
			}
		return bool;
	}
	
//	public boolean move(int x,int y){
//		return true;
//	}

}
