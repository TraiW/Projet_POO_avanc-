package model;

/**
 * R�sum� Creation fou avec couleur et coordonn�es Valide le
 * d�placement de base du fou
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
	 * Résumé Valide les déplacements en diagonales mais ne vérifie pas s'il
	 * y a une piece sur le chemin
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
		if (Math.abs(coord.x - xFinal) == Math.abs(coord.y - yFinal))
			bool = true;
		else
			bool = false;
		return bool;
	}

}
