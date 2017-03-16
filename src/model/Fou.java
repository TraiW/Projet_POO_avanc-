package model;

/**
 * RÈsumÈ Creation fou avec couleur et coordonnÈes Valide le
 * dÈplacement de base du fou
 *
 */
public class Fou extends AbstractPiece {

	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Fou(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	/**
	 * R√©sum√© Valide les d√©placements en diagonales mais ne v√©rifie pas s'il
	 * y a une piece sur le chemin
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
		if (Math.abs(coord.x - xFinal) == Math.abs(coord.y - yFinal))
			bool = true;
		else
			bool = false;
		return bool;
	}

}
