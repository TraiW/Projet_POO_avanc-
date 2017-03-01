package model;

public class Echiquier implements BoardGames {


	Jeu jeuBlanc = new Jeu(Couleur.BLANC);
	Jeu jeuNoir = new Jeu(Couleur.NOIR);
	Jeu jeuCourant = jeuBlanc;
	Jeu jeuNonCourant = jeuNoir;
	
	public void switchJoueur() {
		if(jeuCourant == jeuBlanc)
		{
			jeuCourant = jeuNoir;
			jeuNonCourant = jeuBlanc;
		}
		else
		{
			jeuCourant = jeuBlanc;
			jeuNonCourant = jeuNoir;
		}
	}

	public Object getPiecesIHM() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
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
		return "Echiquier []";
	}

}
