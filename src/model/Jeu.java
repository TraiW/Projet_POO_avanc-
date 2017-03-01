package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	public List<Pieces> pieces = null;
	public boolean CapturePossible=false;
	
	
	public Jeu(Couleur couleur)
	{
		pieces= ChessPiecesFactory.newPieces(couleur);

	}


	@Override
	public String toString() {
		return "Jeu :\n [pieces=\n" + pieces + "]";
	}
	
	private Pieces findPiece(int x, int y)
	{
		Pieces fausse=null;
	
		for(Pieces p : pieces)
		{
			if(p.getX()==x && p.getY()==y)
			{
				return p;
	
			}
			System.out.println("Pas de pièce, impossible de la retourner (findPiece dans Jeu.java");
			return fausse;//sert a rien on l'appelle qu'apres isPieceHere mais au cas ou
		}
		return fausse;
	}
	
	public boolean isPieceHere(int x,int y)
	{
		Pieces p=null;
		p=findPiece(x,y);
		if(p==null)
		{
			return false;
		}	
		
		return true;
	}
	
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal)
	{
		Pieces p=null;
		if(isPieceHere(xInit,yInit)==true)
		{
			p=findPiece(xInit,yInit);
			if(p.isMoveOk(xFinal, yFinal)==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
		
		
	}
	public boolean move(int xInit,int yInit,int xFinal,int yFinal)
	{
		Pieces p=null;
		if(isPieceHere(xInit,yInit)==true)
		{
			p=findPiece(xInit,yInit);

			if(isMoveOk(xInit,yInit, yFinal, yFinal)==true)
			{
				p.move(xFinal,yFinal);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	public void setPossibleCapture()
	{
		
		CapturePossible=true;
		CapturePossible=false;

	}
	
	public String getPieceType(int x,int y)
	{
		Pieces p=null;
		String nomPiece=null;
		if(isPieceHere(x,y)==true)
		{
			p=findPiece(x,y);
			nomPiece=p.getClass().getSimpleName();
		}
		return nomPiece;
	}
	
	public Couleur getCouleur(){
		Pieces p=null;
		return p.getCouleur();
	}

	public boolean capture(int xCatch,int yCatch)
	{
		return true;
	}

	public static void main(String[] args) {
	
		Jeu blanc= new Jeu(Couleur.BLANC);
		Jeu noir = new Jeu(Couleur.NOIR);
		System.out.println(blanc);
		System.out.println(noir);



		
	}
	
	

}
