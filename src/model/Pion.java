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
		
		if(coord.y ==1 || coord.y == 6)
		{
			if(coord.y + 2 ==yFinal  || coord.y -2 == yFinal)
				{
				return true;
				}
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
	
//	public boolean move(int x,int y){
//		return true;
//	}

}
