package model;

/**
 * Résumé Gère le comportement commun à toutes les pièces Chaque pièce qui
 * dérive sera capable de dire si le déplacement est OK
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
	 * @return true si la piece est captur�e Position x et y �-1 pour la supprimer du plateau
	 */
	public boolean capture() {
		this.coord.x = -1;
		this.coord.y = -1;
		return true;

	}

	/**
	 * @return la couleur de la pi�ce
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * @return cooronn�e x de la pi�ce
	 * */
	public int getX() {
		return this.coord.x;
	}

	/**
	 * @return cooronn�e y de la pi�ce
	 * */
	public int getY() {
		return this.coord.y;
	}

	/**
	 * @param xFinal et yFinal coordonn�es finales de la pi�ce
	 * @return true si d�placement l�gal en fonction des algo de d�placement
	 *         sp�cifique de chaque pi�ce
	 */
	public abstract boolean isMoveOk(int xFinal, int yFinal);

	/**
	 * @param xFinal et yFinal coordonn�es finales de la pi�ce
	 * @return true si le deplacement est effectu� et modifie les coordonn�es de la pi�ce aux coordonn�es finales
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
