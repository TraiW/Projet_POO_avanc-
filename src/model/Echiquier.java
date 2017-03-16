package model;

import java.util.LinkedList;
/**
 * Gère les paramètres de l'échiquier, le changement de joueur, le mouvement légal des pièces
 */
import java.util.List;

public class Echiquier implements BoardGames {

	Jeu jeuBlanc;
	Jeu jeuNoir;
	Jeu jeuCourant;
	Jeu jeuNonCourant;

	public Echiquier() {
		this.jeuBlanc = new Jeu(Couleur.BLANC);
		this.jeuNoir = new Jeu(Couleur.NOIR);
		this.jeuCourant = jeuBlanc;
		this.jeuNonCourant = jeuNoir;
	}

	/**
	 * Permet de changer le joueur courant.
	 */
	public void switchJoueur() {
		if (jeuCourant == jeuBlanc) {
			jeuCourant = jeuNoir;
			jeuNonCourant = jeuBlanc;
		} else {
			jeuCourant = jeuBlanc;
			jeuNonCourant = jeuNoir;
		}
	}

	/**
	 * @return une liste de PieceIHM qui pourra être exploitée par une IHM
	 */
	public java.util.List<PieceIHM> getPiecesIHM() {
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		list.addAll(this.jeuCourant.getPiecesIHM());
		list.addAll(this.jeuNonCourant.getPiecesIHM());
		System.out.println(list);
		return list;
	}

	/**
	 * Permet de vérifier si une pièce peut être déplacée. L'algo est le
	 * suivant : s'il n'existe pas de piece du jeu courant aux coordonnées
	 * initiales --> false, si les coordonnées finales ne sont pas valides ou
	 * égales aux initiales --> false, si position finale ne correspond pas à 
	 * algo de déplacement piece --> false, s'il existe une pièce
	 * intermédiaire sur la trajectoire --> false (sauf cavalier), s'il existe
	 * une pièce positionnées aux coordonnées finales : si elle est de la
	 * même couleur --> false ou tentative roque du roi, sinon : prendre la
	 * pièce intermédiaire (vigilance pour le cas du pion) et déplacer la
	 * pièce -->true, sinon déplacer la pièce -->true
	 *
	 *
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si le déplacement est effectué, false sinon
	 */
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		
		boolean bool =false;
		if (this.jeuCourant.isPieceHere(xInit, yInit) == false)
		{
			System.out.println("KO : la pièce séléctionnée ne vous appartient pas !");
			bool = false;
		} else if (this.jeuCourant.isPieceHere(xFinal, yFinal) == true)
		{
			System.out.println("KO : déplacement sur une pièce du même joueur");

			bool = false;
		}
		// si les coordonnées finales ne sont pas valides ou égales aux
		// initiales --> false,
		else if (xInit == xFinal && yInit == yFinal) {
			System.out.println("KO : Aucun déplacement n'a été appliqué"); 

			bool = false;
		} 
		else if (Coord.coordonnees_valides(xFinal, yFinal) == false){
			System.out.println("KO : les coordonnÃ©es finales ne sont pas valides");
			bool = false;
		}
		// si position finale ne correspond pas à algo de déplacement piece
		// --> false,
		else if (this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal) == false)// fait
		{
			System.out.println("KO : la position finale ne correspond pas au déplacement légal de la pièce");
			bool = false;
		}
		else if (this.jeuCourant.getPieceType(xInit, yInit).equals("Pion")) {
			System.out.println("Pion isMoveOk d'echiquier");
			// return false si :
			// avance droit + piÃ¨ce Ã  l'arrivÃ©e
			// avance en diag. et PAS de piÃ¨ce Ã  l'arrivÃ©e

			// renvoi true si:
			// on peut avancer tout droit sans prÃ©sence de piece
			// ou en diago si piece adverse prÃ©sente sauf si c'est roi

			if (this.jeuNonCourant.isPieceHere(xFinal, yFinal) == false) // PAS de pièce à l'arrivée
			{
				// et avance en diag
				if (this.jeuCourant.couleur == this.jeuBlanc.couleur) { // blancs=> Y descendant

					if ((xFinal == xInit - 1 || xFinal == xInit + 1) && (yFinal != yInit - 1)) {
						bool = false;
					}

				} else { // noirs => monte
					if ((xFinal == xInit - 1 || xFinal == xInit + 1) && (yFinal != yInit + 1)) {
						bool = false;
					}

				}
			} else // CAS OU IL Y A UNE PIECE du JEU ADVERSE EN DIAGO (TJR POUR LE PION)
			{

				if (this.jeuCourant.couleur == this.jeuBlanc.couleur)// blanc
				{
					if ((yFinal == yInit - 1) && this.jeuNonCourant.getPieceType(xFinal, yFinal) != "Roi")
					{
						System.out.println("Roi ou tentative de deplacement vers le bas (alors que tu as un jeu blanc)");
						bool = true;
					}
					bool = false;
				} 
				else {
					if ((yFinal == yInit + 1) && this.jeuNonCourant.getPieceType(xFinal, yFinal) != "Roi")
					{
						System.out.println("Roi ou tentative de deplacement vers le haut (alors que tu as un jeu noir)");
						bool = true;
					}
					bool = false;
				}
			}

			if (this.jeuCourant.couleur == this.jeuBlanc.couleur) // jeu blanc
			{
				System.out.println("check Couleur : Blanc _ isMoveOk d'echiquier");
				if (yFinal == yInit - 1 || yFinal == yInit - 2) 
				{
					bool = true;
				} 
				else {
					bool = false;
				}
			} 
			else{
				if (yFinal == yInit + 1 || yFinal == yInit + 2) {
					
					bool = true;
				} 
				else {
					bool = false;
				}
			}
		}
		if (this.jeuNonCourant.isPieceHere(xFinal, yFinal)) {

			System.out.println("Capture");
			bool = true;
		}
		// s'il existe une piÃ¨ce positionnÃ©es aux coordonnÃ©es finales :
		// si elle est de la mÃªme couleur --> false ou tentative roque du roi,

		// sinon dÃ©placer la piÃ¨ce -->true
		bool = true;

		return bool;
	}

	/**
	 * @param xInit,yInit, xFinal, yFinal
	 * @return true si le dÃ©placement est effectuÃ©, false sinon
	 */
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean bool = false;
		if (this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal) == true) {
			if (this.jeuCourant.move(xInit, yInit, xFinal, yFinal) == true) {
				switchJoueur();
				bool = true;
			}

		}
		bool = false;

		return bool;
	}

	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Echiquier\n [jeuCourant=" + jeuCourant + "\n jeuNonCourant=" + jeuNonCourant + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Echiquier echec = new Echiquier();
		System.out.println(echec);
		echec.switchJoueur();
		System.out.println(echec);
		System.out.println(echec.isMoveOk(0, 1, 0, 3));

	}

}
