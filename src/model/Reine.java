package model;

/**
 * RÈsumÈ Creation reine avec couleur et coordonnÈes Valide le
 * dÈplacement de base de la reine
 *
 */
public class Reine extends AbstractPiece {

	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Reine(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	/**
	 * R√©sum√© Valide les d√©placements en diagonales et en avant mais ne
	 * v√©rifie pas s'il y a une piece sur le chemin
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
		if (Math.abs(coord.x - xFinal) == Math.abs(coord.y - yFinal) || (coord.x == xFinal || coord.y == yFinal))

			bool = true;
		else

			bool = false;

		return bool;
	}
}
