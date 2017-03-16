package launcher.localLauncher;

import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JFrame;

import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import model.observable.ChessGame;
import vue.ChessGameGUI;

/**
 * Lance l'exécution d'un jeu d'échec en mode
 *         graphique. La vue (ChessGameGUI) observe le modèle (ChessGame) les
 *         échanges passent par le contrôleur (ChessGameControlers)
 * 
 */
public class LauncherGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ChessGame chessGame;
		ChessGameControlers chessGameControler;
		JFrame frame;
		Dimension dim;
		Dimension dim1;

		dim = new Dimension(800, 800); // dimension divisible par 8 please
										// (8cases)
		dim1 = new Dimension(810, 830);
		chessGame = new ChessGame();
		chessGameControler = new ChessGameControler(chessGame);

		frame = new ChessGameGUI("Jeu d'�chec", chessGameControler, dim);
		chessGame.addObserver((Observer) frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 10);
		frame.setPreferredSize(dim1);
		frame.pack();
		frame.setVisible(true);
	}
}
