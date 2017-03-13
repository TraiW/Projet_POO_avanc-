package model;

public class Roi extends AbstractPiece{
	
	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Roi(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}

/** Résumé
 * Valide les déplacements tout autour de lui et d'une case mais ne vérifie pas s'il y a une piece sur le chemin
 * @param xFinal colonne
 * @param yFinal ligne
 * @return true si le mouvement est validé 
 * 
 */
	public boolean isMoveOk(int xFinal, int yFinal)
	{
		boolean bool = false;
		if(coord.x + 1 == xFinal || coord.y + 1 == yFinal 
				|| coord.x +1 == coord.y +1 || coord.x -1 == coord.y -1 
				|| coord.x -1 == coord.y +1 || coord.x +1 == coord.y -1)
			
			bool = true;
		else
			
			bool = false;
	
	return bool;	
	}

}
