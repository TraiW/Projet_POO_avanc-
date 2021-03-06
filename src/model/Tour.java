package model;

/**
 * R�sum� Creation tour avec couleur et coordonn�es Valide le
 * d�placement de base de la tour
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
	 * Résumé Valide les déplacements en avant, arrière de n'importe combien
	 * de cases mais ne vérifie pas s'il y a une piece sur le chemin
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
		if (coord.x == xFinal || coord.y == yFinal)
			bool = true;
		else
			bool = false;

		return bool;
	}
}
