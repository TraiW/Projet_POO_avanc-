package model;

import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {


	/**
	 * 
	 */
	Jeu jeuBlanc;
	Jeu jeuNoir;
	Jeu jeuCourant;
	Jeu jeuNonCourant;
	
		

		public Echiquier ()
		{
			this.jeuBlanc= new Jeu(Couleur.BLANC);
			this.jeuNoir= new Jeu(Couleur.NOIR);
			this.jeuCourant = jeuBlanc;
			this.jeuNonCourant = jeuNoir;
		}
		
/**
 * Permet de changer le joueur courant. 
 */
	public void switchJoueur() {
		//System.out.println("Avant le switchJoueur : J-C "+jeuCourant+ "J-nC"+jeuNonCourant);
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
		//System.out.println("après le switchJoueur : J-C "+jeuCourant+ "J-nC"+jeuNonCourant);

	}

	/**
	 *
	 * @return     une liste de PieceIHM qui pourra être exploitée par une IHM
	 */
	public java.util.List<PieceIHM> getPiecesIHM(){
        List<PieceIHM> list = new LinkedList<PieceIHM>();
        list.addAll(this.jeuCourant.getPiecesIHM());
        list.addAll(this.jeuNonCourant.getPiecesIHM());     
        System.out.println(list);
        return list;
    }
	
	/**
	 *Permet de vérifier si une piéce peut être déplacée.
	 *L'algo est le suivant :
	 *s'il n'existe pas de piece du jeu courant aux coordonnées initiales --> false,
	 *si les coordonnées finales ne sont pas valides ou égales aux initiales --> false,
	 *si position finale ne correspond pas à algo de déplacement piece --> false,
	 *s'il existe une piéce intermédiaire sur la trajectoire --> false (sauf cavalier),
	 *s'il existe une piéce positionnées aux coordonnées finales :
	 *si elle est de la méme couleur --> false ou tentative roque du roi,
	 *sinon : prendre la piéce intermédiaire (vigilance pour le cas du pion) et déplacer la piéce -->true,
	 *sinon déplacer la piéce -->true
	 *
	 *
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si le déplacement est effectué, false sinon
	 */
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal)
	{
		//jeu Courant bien blanc
		//	s'il n'existe pas de piece du jeu courant aux coordonnées initiales --> false,
//		if(this.jeuCourant.isPieceHere(xInit, yInit)==false) //fait
//		{
//			System.out.println("KO : la pièce séléctionnée ne vous appartient pas !");
//			return false;
//			}
//		System.out.println("x0 :"+xInit+" - y0 :"+yInit);
//		System.out.println("xf :"+xFinal+" - yf :"+yFinal);


		if(this.jeuCourant.isPieceHere(xInit, yInit)==false) //fait
		{
			System.out.println("KO : la pièce séléctionnée ne vous appartient pas !");
			return false;
			}
		else if(this.jeuCourant.isPieceHere(xFinal, yFinal)==true)//fait
		{
			System.out.println("KO : déplacement sur une pièce du même joueur");

			return false;
		}
		//		si les coordonnées finales ne sont pas valides ou égales aux initiales --> false,
		else if(xInit==xFinal && yInit==yFinal)
		{
			System.out.println("KO : Aucun déplacement n'a été appliqué"); //fait

			return false;
			}
		else if(Coord.coordonnees_valides(xFinal, yFinal)==false) //renvoi false si les coord ne sont pas valides
		{
			System.out.println("KO : les coordonnées finales ne sont pas valides");//fait
			 return false;
			}
		//		si position finale ne correspond pas à  algo de déplacement piece --> false,
		else if(this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal)==false)//fait
		{
			System.out.println("KO : la position finale ne correspond pas a l'algo de déplacement légal de la pièce");
			return false;
			}
		
		
		else if(this.jeuCourant.getPieceType(xInit, yInit).equals("Pion"))
		{
				System.out.println("Pion isMoveOk d'echiquier");
				// return false si :
				// avance droit + pièce à l'arrivée
				// avance en diag. et PAS de pièce à l'arrivée
				
				//renvoi true si:
				//on peut avancer tout droit sans présence de piece
				// ou en diago si piece adverse présente sauf si c'est roi
	
				if(this.jeuNonCourant.isPieceHere(xFinal, yFinal)==false) // PAS de pièce à l'arrivée
				{
	
					// et avance en diag
						if(this.jeuCourant.couleur==this.jeuBlanc.couleur)
						{ // blancs => Y descendant
		
							if((xFinal==xInit-1|| xFinal==xInit+1) && (yFinal!=yInit-1))
							{
								System.out.println("isMoveOk_0");
		
								return false;
							}	
		
						} 
						else 
						{ //noirs => monte
							if((xFinal==xInit-1|| xFinal==xInit+1) && (yFinal!=yInit+1))	
							{
								System.out.println("isMoveOk_1");
		
								return false;
							}
								
						}
				}
			else //CAS OU IL Y A UNE PIECE du JEU ADVERSE EN DIAGO(TJR POUR LE PION)
				{
		
						if(this.jeuCourant.couleur==this.jeuBlanc.couleur)//blanc
						{ 
							if((yFinal==yInit-1) && this.jeuNonCourant.getPieceType(xFinal, yFinal)!="Roi" )//pièce noir à l'arrivé //ATTENTION, VERIFIER QUE CE N'EST PAS LE ROI
							{
								System.out.println("Roi ou tentative de deplacement vers le bas (alors que tu as un jeu blanc)");
								return true;
							}
							return false;
						} 
						else //pour les noirs
						{ 
							if((yFinal==yInit+1) && this.jeuNonCourant.getPieceType(xFinal, yFinal)!="Roi" )//pièce noir à l'arrivé //ATTENTION, VERIFIER QUE CE N'EST PAS LE ROI
							{
								System.out.println("Roi ou tentative de deplacement vers le haut (alors que tu as un jeu noir)");
								return true;
							}
							return false;
						}
					
				}

			if(this.jeuCourant.couleur==this.jeuBlanc.couleur) //jeu blanc
			{
				System.out.println("check Couleur : Blanc _ isMoveOk d'echiquier");
				if(yFinal==yInit-1 || yFinal==yInit-2) //verifie qu'on avance bien droit et dans la bonne direction
				{
					//System.out.println("Le pion blanc va en haut donc OK");

					return true;
				}
				else
				{
					//System.out.println("Le pion blanc va en bas donc KO");
					return false;
				}
			}
			else//jeux noir
			{
				if(yFinal==yInit+1 || yFinal==yInit+2) //verifie qu'on avance bien droit et dans la bonne direction
				{
					//System.out.println("Le pion noir va en haut donc OK");

					return true;
				}
				else
				{
					//System.out.println("Le pion noir va en bas donc KO");
					return false;
				}
			}
		}
			//pas de piece adverse à l'azrrivé donc de l'autre couleur osus entendu
			
			//System.out.println("OK : déplacement simple_0");
			//capture de pion
		

		
		//FIN PION
		
			
			 if(this. jeuNonCourant.isPieceHere(xFinal, yFinal))
			 {
				
				// prendre la pièce intermédiaire (vigilance pour le cas du pion) et déplacer la pièce -->true,
					//this. jeuNonCourant.setPossibleCapture();
					
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
	
	
 /**
  * @param xInit, yInit, xFinal, yFinal
  * @return true si le déplacement est effectué, false sinon
  */
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean bool = false;
		//System.out.println("x :"+xInit+" - y :"+yInit);
		if(this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal) == true)
		{
			if(this.jeuCourant.move(xInit, yInit, xFinal, yFinal) == true)
			{
				//getPiecesIHM();
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
		return "Echiquier\n [jeuCourant=" + jeuCourant + "\n jeuNonCourant="
				+ jeuNonCourant + "]";
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
