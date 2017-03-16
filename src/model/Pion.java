package model;

/**
 * RÈsumÈ Creation pion avec couleur et coordonnÈes Valide le
 * dÈplacement de base du pion
 *
 */
public class Pion extends AbstractPiece implements Pions {

	/**
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Pion(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	/**
	 * R√©sum√© Valide les d√©placements en avant d'une case et deux cases mais
	 * ne v√©rifie pas s'il y a une piece sur le chemin
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
		if (coord.y == 1 || coord.y == 6) {

			if (coord.y == 1) {
				if (yFinal == coord.y + 2) {
					bool = true;
				}

			} else if (coord.y == 6) {
				if (yFinal == coord.y - 2) {
					bool = true;
				}
			}
		}

		if (yFinal == coord.y + 1 || yFinal == coord.y - 1) 
		{
			bool = true;
		}
		if ((xFinal == coord.x + 1 || xFinal == coord.x - 1) && (yFinal == coord.y + 1 || yFinal == coord.y - 1)) {
			if (isMoveDiagOk(xFinal, yFinal) == true) {
				bool = true;
			} else {
				System.out.println("2");
				bool = false;
			}
		}

		return bool;
	}

	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		boolean bool = false;
		int deltax = xFinal - this.getX();
		int deltay = yFinal - this.getY();
		if (deltax * deltay == 1) {
			bool = true;
		} 
		else {
			bool = false;
		}
		return bool;
	}
}
