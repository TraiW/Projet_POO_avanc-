package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

/**
 * G�re les param�tres du jeu, l'affichage, la pr�sence de pi�ce sur le damier, la validation du d�placement des pi�ces et la promotion
 */
public class Jeu {

	public List<Pieces> pieces = null;
	public boolean CapturePossible = false;
	Couleur couleur;

	/**
	 * @param couleur
	 */
	public Jeu(Couleur couleur) {
		this.couleur = couleur;
		pieces = ChessPiecesFactory.newPieces(couleur);

	}

	@Override
	public String toString() {
		return "Jeu :\n [pieces=\n" + pieces + "]";
	}

	/**
	 * @param x
	 * @param y
	 * @return true si une pièce se trouve aux coordonnées indiquées
	 */
	private Pieces findPiece(int x, int y) {
		Pieces fausse = null;

		for (Pieces p : pieces) {
			if (p.getX() == x && p.getY() == y) {
				return p;

			}

		}
		System.out.println("Pas de pièce, impossible de la retourner (findPiece dans Jeu.java");
		return fausse;// sert a rien on l'appelle qu'apres isPieceHere mais au
						// cas ou
	}

	/**
	 * @param x
	 * @param y
	 * @return true si une pièce se trouve aux coordonnées indiquées
	 */
	public boolean isPieceHere(int x, int y) {

		for (Pieces p : pieces) {
			if (p.getX() == x && p.getY() == y) {
				return true;

			}

		}
		return false;

	}

	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si piece du jeu peut être déplacée aux coordonnées
	 *         finales, false sinon
	 */
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean bool = false;
		Pieces p = null;
		if (isPieceHere(xInit, yInit) == true) {
			p = findPiece(xInit, yInit);
			if (p.isMoveOk(xFinal, yFinal) == true) {

				bool = true;
			} else {

				bool = false;
			}
		} else {

			bool = false;
		}

		return bool;
	}

	/**
	 * @param x
	 * @param y
	 * @return couleur de la pièce aux coordonnées x, y
	 */
	public Couleur getPieceColor(int x, int y) {
		Pieces p;
		Couleur retour = null;
		if (isPieceHere(x, y) == true) {
			p = findPiece(x, y);
			retour = p.getCouleur();
			return retour;
		} 
		else {
		}
		return retour;
	}

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true si on est bien dans le cas d'une promotion du pion
	 */
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		boolean bool = false;
		if (this.getPieceColor(xFinal, yFinal) == Couleur.BLANC) {
			bool = true;// TODO
		}
		bool = true;
		
		return bool;
	}

	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si déplacement pièce effectué
	 */
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean bool = false;
		Pieces p = null;
		if (isPieceHere(xInit, yInit) == true) {
			p = findPiece(xInit, yInit);

			if (isMoveOk(xInit, yInit, xFinal, yFinal) == true) {
				p.move(xFinal, yFinal);
				bool = true;
			} else {
				bool = false;
			}
		} else {
			bool = false;
		}

		return bool;
	}

	/**
	 * @param x
	 * @param y
	 * @return type de la pièce aux coordonnées x,y c'est à dire le nom de la
	 *         classe : maPiece.getClass().getSimpleName();
	 */
	public String getPieceType(int x, int y) {
		Pieces p = null;
		String nomPiece = null;
		if (isPieceHere(x, y) == true) {
			p = findPiece(x, y);
			nomPiece = p.getClass().getSimpleName();
			System.out.println(" nom de la piece : " + nomPiece);
		}
		return nomPiece;
	}

	/**
	 * @return true si promotion OK
	 */
	public Coord getKingCoord() {
		Coord retour = new Coord(-1, -1);

		for (Pieces p : pieces) {
			if (p.getClass().getSimpleName().equals("Roi") == true) {
				retour.x = p.getX();
				retour.y = p.getY();
				return retour;
			}
		}
		return retour;
	}

	public boolean capture(int xCatch, int yCatch) {
		return true;
	}

	/**
	 * @return une vue de la liste des pièces en cours ne donnant que des
	 *         accès en lecture sur des PieceIHM (type piece + couleur + liste
	 *         de coordonnées)
	 */
	public List<PieceIHM> getPiecesIHM() {
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();

		for (Pieces piece : pieces) {
			boolean existe = false;
			// si le type de piece existe déjà dans la liste de PieceIHM
			// ajout des coordonnées de la pièce dans la liste de Coord de ce
			// type
			// si elle est toujours en jeu (x et y != -1)
			for (PieceIHM pieceIHM : list) {
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())) {
					existe = true;
					if (piece.getX() != -1) {
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			// sinon, création d'une nouvelle PieceIHM si la pièce est
			// toujours en jeu
			if (!existe) {
				if (piece.getX() != -1) {
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(), piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Jeu J1 = new Jeu(Couleur.BLANC);
		Jeu J2 = new Jeu(Couleur.NOIR);
		// System.out.println(J1);
		// System.out.println(J2);
		// Test de la fonction findPiece
		// Pieces P= null;
		// P=J1.findPiece(0,7);
		// System.out.println(P);

		// Test fonction getKingCoord()
		// System.out.println(J1.getKingCoord());
		// System.out.println(J2.getKingCoord());

		// Test fonction get PieceColor
		// System.out.println(J1.getPieceColor(0, 7));
		// System.out.println(J2.getPieceColor(0, 0));

		// Test de la fonction getPiecesIHM()
		// System.out.println(J1.getPiecesIHM());

		// Test de la fonction getPieceType(int x, int y)
		// System.out.println(J1.getPieceType(6,7));

		// Test de la fonction isMoveOk ()
		/*
		 * System.out.println(J1.isMoveOk(0, 7, 1, 8));
		 * System.out.println(J1.isMoveOk(0, 7, 8, 7));
		 */

		// Test fonction isPieceHere (x,y)
		/*
		 * System.out.println(J1.isPieceHere(0, 7));
		 * System.out.println(J1.isPieceHere(0, 0));
		 */

		// Test fonction move
		// System.out.println(J1);
		//
		// boolean t=J1.move(0,7,5,7);
		// System.out.println(J1);

	}

}
