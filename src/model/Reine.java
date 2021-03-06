package model;

/**
 * R�sum� Creation reine avec couleur et coordonn�es Valide le
 * d�placement de base de la reine
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
	 * Résumé Valide les déplacements en diagonales et en avant mais ne
	 * vérifie pas s'il y a une piece sur le chemin
	 * 
	 * @param xFinal
	 *            colonne
	 * @param yFinal
	 *            ligne
	 * @return true si le mouvement est validé
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
