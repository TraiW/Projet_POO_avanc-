package model;

/**
 * RÈsumÈ Creation tour avec couleur et coordonnÈes Valide le
 * dÈplacement de base de la tour
 *
 */
public class Tour extends AbstractPiece {

	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Tour(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	/**
	 * R√©sum√© Valide les d√©placements en avant, arri√®re de n'importe combien
	 * de cases mais ne v√©rifie pas s'il y a une piece sur le chemin
	 * 
	 * @param xFinal
	 *            colonne
	 * @param yFinal
	 *            ligne
	 * @return true si le mouvement est valid√©
	 * 
	 */

	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean bool = false;
		if (coord.x == xFinal || coord.y == yFinal)
			bool = true;
		else
			bool = false;

		return bool;
	}
}
