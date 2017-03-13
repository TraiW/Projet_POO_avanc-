package model;

/**
 * Résumé
 * Creation cavalier avec couleur et coordonnées
 * Valide le déplacement de base du cavalier
 *
 */
public class Cavalier extends AbstractPiece{
	
	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Cavalier(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	
	/** Résumé
	 * Valide les déplacements en L mais ne vérifie pas s'il y a une piece sur le chemin
	 * @param xFinal colonne
	 * @param yFinal ligne
	 * @return true si le mouvement est validé 
	 * 
	 */
	public boolean isMoveOk(int xFinal, int yFinal){
		boolean bool = false;
		if(coord.x + 2 == xFinal && coord.y + 1 == yFinal 
				|| coord.y + 2 == yFinal && coord.x +1 == xFinal
				|| coord.x - 2 == xFinal && coord.y - 1 == yFinal 
				|| coord.y - 2 == yFinal && coord.x - 1 == xFinal
				|| coord.x + 2 == xFinal && coord.y - 1 == yFinal 
				|| coord.y + 2 == yFinal && coord.x - 1 == xFinal
				|| coord.x - 2 == xFinal && coord.y + 1 == yFinal 
				|| coord.y - 2 == yFinal && coord.x + 1 == xFinal)// A mettre mieux
			
			bool = true;
		else 
			bool = false;
		return bool;
	}

}