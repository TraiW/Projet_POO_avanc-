package model;

/**
 * RÃ©sumÃ© GÃ¨re le comportement commun Ã  toutes les piÃ¨ces Chaque piÃ¨ce qui
 * dÃ©rive sera capable de dire si le dÃ©placement est OK
 *
 */
public abstract class AbstractPiece implements Pieces {

	public Coord coord = null;
	public Couleur couleur = null;

	/**
	 * @param couleur
	 * @param coord
	 */
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;

	}

	/**
	 * @return true si la piece est capturée Position x et y à -1 pour la supprimer du plateau
	 */
	public boolean capture() {
		this.coord.x = -1;
		this.coord.y = -1;
		return true;

	}

	/**
	 * @return la couleur de la pièce
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * @return cooronnée x de la pièce
	 * */
	public int getX() {
		return this.coord.x;
	}

	/**
	 * @return cooronnée y de la pièce
	 * */
	public int getY() {
		return this.coord.y;
	}

	/**
	 * @param xFinal et yFinal coordonnées finales de la pièce
	 * @return true si déplacement légal en fonction des algo de déplacement
	 *         spécifique de chaque pièce
	 */
	public abstract boolean isMoveOk(int xFinal, int yFinal);

	/**
	 * @param xFinal et yFinal coordonnées finales de la pièce
	 * @return true si le deplacement est effectué et modifie les coordonnées de la pièce aux coordonnées finales
	 */
	public boolean move(int xFinal, int yFinal) {
		boolean bool = false;
		if (xFinal == -1 && yFinal == 1) {
			bool = true;
		}

		if (isMoveOk(xFinal, yFinal) == true) {
			this.coord.x = xFinal;
			this.coord.y = yFinal;
			bool = true;
		}
		bool = false;

		return bool;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[coord=" + coord + ", couleur=" + couleur + "] \n";
	}

}
