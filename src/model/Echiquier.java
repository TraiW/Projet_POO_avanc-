package model;

public class Echiquier implements BoardGames {


	Jeu jeuBlanc = new Jeu(Couleur.BLANC);
	Jeu jeuNoir = new Jeu(Couleur.NOIR);
	Jeu jeuCourant;
	Jeu jeuNonCourant;
	
		public Echiquier ()
		{
			this.jeuBlanc= new Jeu(Couleur.BLANC);
			this.jeuNoir= new Jeu(Couleur.NOIR);
			this.jeuCourant = jeuBlanc;
			this.jeuNonCourant = jeuNoir;
		}
	
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
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal)
	{
		
		//	s'il n'existe pas de piece du jeu courant aux coordonnées initiales --> false,
		if(this.jeuCourant.isPieceHere(xInit, yInit)==false)
		{
			System.out.println("KO : la pièce séléctionnée ne vous appartient pas !");
			return false;
			}
		else if(this.jeuCourant.isPieceHere(xFinal, yFinal)==true)
		{
			System.out.println("KO : déplacement sur une pièce du même joueur");

			return false;
		}
		//		si les coordonnées finales ne sont pas valides ou égales aux initiales --> false,
		else if(xInit==xFinal && yInit==yFinal)
		{
			System.out.println("KO : Aucun déplacement n'a été appliqué");

			return false;
			}
		else if(Coord.coordonnees_valides(xFinal, yFinal)==false) //renvoi false si les coord ne sont pas valides
		{
			System.out.println("KO : les coordonnées finales ne sont pas valides");
			return false;
			}
		//		si position finale ne correspond pas à  algo de déplacement piece --> false,
		else if(this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal)==false)
		{
			System.out.println("KO : la position finale ne correspond pas a l'algo de déplacement légal de la pièce");
			return false;
			}
		
		
		else if(this.jeuCourant.getPieceType(xInit, yInit).equals("Pion"))
		{
			// return false si :
			// avance droit + pièce à l'arrivée
			// avance en diag. et PAS de pièce à l'arrivée
			
			//renvoi true si:
			//on peut avancer tout droit sans présence de piece
			// ou en diago si piece adverse présente sauf si c'est roi

			
			if(this.jeuCourant.couleur==this.jeuBlanc.couleur) //jeu blanc
			{
				if(yFinal!=yInit+1 || xFinal !=xInit) //verifie qu'on avance bien droit et dans la bonne direction
				{
					return false;
				}
			}
			else//jeux noir
			{
				if(yFinal!=yInit-1 || xFinal !=xInit)
				{
					return false;
				}
			}
			//pas de piece adverse à l'azrrivé donc de l'autre couleur osus entendu
			if(this.jeuNonCourant.isPieceHere(xFinal, yFinal)==false) // PAS de pièce à l'arrivée
			{
				// et avance en diag
				if(this.jeuCourant.couleur==this.jeuBlanc.couleur){ // blancs => Y descendant
					if((xFinal==xInit-1|| xFinal==xInit+1) && (yFinal!=yInit+1))
					{
						return false;
					}					
				} 
				else { //noirs => monte
					if((xFinal==xInit-1|| xFinal==xInit+1) && (yFinal!=yInit-1))	
						return false;
				}
			}
			else
			{
				if(this.jeuCourant.couleur==this.jeuBlanc.couleur)
				{ 
					if((xFinal==xInit-1|| xFinal==xInit+1) && (yFinal!=yInit+1))
					{
						//capture
						return false;
					}					
				} 
				else 
				{ 
					if((xFinal==xInit-1|| xFinal==xInit+1) && (yFinal!=yInit-1))	
					{
						//capture
						return false;

					}
				}
			
			}
			return true;

		}
		
		
		 if(this. jeuNonCourant.isPieceHere(xFinal, yFinal)){
			
			// prendre la pièce intermédiaire (vigilance pour le cas du pion) et déplacer la pièce -->true,
				this. jeuNonCourant.setPossibleCapture();
				
				System.out.println("Capture");
				return true;
		}
	

		//		s'il existe une pièce positionnées aux coordonnées finales :
		//si elle est de la même couleur --> false ou tentative roque du roi,
		 
		 //sinon déplacer la pièce -->true
		//TODO
		System.out.println("OK : déplacement simple");
		return true;		
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
		return "Echiquier\n [jeuCourant=" + jeuCourant + "\n jeuNonCourant="
				+ jeuNonCourant + "]";
	}

	public static void main(String[] args) {
		Echiquier echec = new Echiquier();
		echec.switchJoueur();
		System.out.println(echec);
	}

}
