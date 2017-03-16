package model;

import java.util.LinkedList;
/**
 * G�re les param�tres de l'�chiquier, le changement de joueur, le mouvement l�gal des pi�ces
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
	 * @return une liste de PieceIHM qui pourra �tre exploit�e par une IHM
	 */
	public java.util.List<PieceIHM> getPiecesIHM() {
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		list.addAll(this.jeuCourant.getPiecesIHM());
		list.addAll(this.jeuNonCourant.getPiecesIHM());
		System.out.println(list);
		return list;
	}

	/**
	 * Permet de v�rifier si une pi�ce peut �tre d�plac�e. L'algo est le
	 * suivant : s'il n'existe pas de piece du jeu courant aux coordonn�es
	 * initiales --> false, si les coordonn�es finales ne sont pas valides ou
	 * �gales aux initiales --> false, si position finale ne correspond pas �
	 * algo de d�placement piece --> false, s'il existe une pi�ce
	 * interm�diaire sur la trajectoire --> false (sauf cavalier), s'il existe
	 * une pi�ce positionn�es aux coordonn�es finales : si elle est de la
	 * m�me couleur --> false ou tentative roque du roi, sinon : prendre la
	 * pi�ce interm�diaire (vigilance pour le cas du pion) et d�placer la
	 * pi�ce -->true, sinon d�placer la pi�ce -->true
	 *
	 *
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si le d�placement est effectu�, false sinon
	 */
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		
		boolean bool =false;
		if (this.jeuCourant.isPieceHere(xInit, yInit) == false)
		{
			System.out.println("KO : la pi�ce s�l�ctionn�e ne vous appartient pas !");
			bool = false;
		} else if (this.jeuCourant.isPieceHere(xFinal, yFinal) == true)
		{
			System.out.println("KO : d�placement sur une pi�ce du m�me joueur");

			bool = false;
		}
		// si les coordonn�es finales ne sont pas valides ou �gales aux
		// initiales --> false,
		else if (xInit == xFinal && yInit == yFinal) {
			System.out.println("KO : Aucun d�placement n'a �t� appliqu�"); 

			bool = false;
		} 
		else if (Coord.coordonnees_valides(xFinal, yFinal) == false){
			System.out.println("KO : les coordonnées finales ne sont pas valides");
			bool = false;
		}
		// si position finale ne correspond pas � algo de d�placement piece
		// --> false,
		else if (this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal) == false)// fait
		{
			System.out.println("KO : la position finale ne correspond pas au d�placement l�gal de la pi�ce");
			bool = false;
		}
		else if (this.jeuCourant.getPieceType(xInit, yInit).equals("Pion")) {
			System.out.println("Pion isMoveOk d'echiquier");
			// return false si :
			// avance droit + pièce à l'arrivée
			// avance en diag. et PAS de pièce à l'arrivée

			// renvoi true si:
			// on peut avancer tout droit sans présence de piece
			// ou en diago si piece adverse présente sauf si c'est roi

			if (this.jeuNonCourant.isPieceHere(xFinal, yFinal) == false) // PAS de pi�ce � l'arriv�e
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
		// s'il existe une pièce positionnées aux coordonnées finales :
		// si elle est de la même couleur --> false ou tentative roque du roi,

		// sinon déplacer la pièce -->true
		bool = true;

		return bool;
	}

	/**
	 * @param xInit,yInit, xFinal, yFinal
	 * @return true si le déplacement est effectué, false sinon
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
