package model;

/**
 * R�sum� Creation cavalier avec couleur et coordonn�es Valide le
 * d�placement de base du cavalier
 *
 */
public class Cavalier extends AbstractPiece {

	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Cavalier(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	/**
	 * R�sum� Valide les d�placements en L mais ne v�rifie pas s'il y a une
	 * piece sur le chemin
	 * 
	 * @param xFinal
	 *            colonne
	 * @param yFinal
	 *            ligne
	 * @return true si le mouvement est valid�
	 * 
	 */
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean bool = false;
		if (coord.x + 2 == xFinal && coord.y + 1 == yFinal || coord.y + 2 == yFinal && coord.x + 1 == xFinal
				|| coord.x - 2 == xFinal && coord.y - 1 == yFinal || coord.y - 2 == yFinal && coord.x - 1 == xFinal
				|| coord.x + 2 == xFinal && coord.y - 1 == yFinal || coord.y + 2 == yFinal && coord.x - 1 == xFinal
				|| coord.x - 2 == xFinal && coord.y + 1 == yFinal || coord.y - 2 == yFinal && coord.x + 1 == xFinal)

			bool = true;
		else
			bool = false;

		return bool;
	}

}