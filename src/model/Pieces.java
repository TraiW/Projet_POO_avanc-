package model;

public interface Pieces {

	public boolean capture();
	public Couleur getCouleur();
	public int getX();
	public int getY();
	public boolean isMoveOk(int xFinal,int yFinal);
	boolean move(int xFinal, int yFinal);
//pull
}
