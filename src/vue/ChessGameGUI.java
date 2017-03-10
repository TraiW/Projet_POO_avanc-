package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Coord;
import model.Couleur;
import tools.ChessImageProvider;
import controler.ChessGameControlers;
import model.PieceIHM;

public class ChessGameGUI extends javax.swing.JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer {

JLayeredPane layeredPane;
JPanel chessBoard;
JLabel chessPiece;
int xAdjustment;
int yAdjustment;
Dimension boardSize;
ChessGameControlers chessGameControler;
Coord cInit=new Coord(xAdjustment, xAdjustment);

/**
 * @param string
 * @param chessGameControler
 * @param dim
 */
public ChessGameGUI(String string, ChessGameControlers chessGameControler, Dimension dim) {
	boardSize = dim;
	
	this.chessGameControler=chessGameControler;
	
	layeredPane = new JLayeredPane();
	 	
	 	//getContentPane().removeAll();
	getContentPane().add(layeredPane);
	
	layeredPane.setPreferredSize(boardSize);
	layeredPane.addMouseListener(this);
	layeredPane.addMouseMotionListener(this); 
	
	chessBoard = new JPanel();
	layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
	chessBoard.setLayout( new GridLayout(8, 8) );
	chessBoard.setPreferredSize( boardSize );
	chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
	for (int i = 0; i < 64; i++) {
		 JPanel square = new JPanel( new BorderLayout() );
		 chessBoard.add( square );
		 int row = (i / 8) % 2;
		 if (row == 0)
		 {
			 square.setBackground( i % 2 == 0 ? Color.black : Color.white );
		 }
		 else
		 {
			 square.setBackground( i % 2 == 0 ? Color.white : Color.black );
		 }
  }

	 
}
//fin constructor
	
	
	
	@Override
public void update(Observable arg0, Object arg1) {
		
	List<PieceIHM> pieceIHM = (List<PieceIHM>)arg1;
	JLabel piece=null;
	JPanel panel=null;

	for(PieceIHM p : pieceIHM)
	{
	  for(Coord c : p.getList())
	  {
		  piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(p.getTypePiece(), p.getCouleur())));
		  panel = (JPanel) chessBoard.getComponent(c.x + c.y *8);
		  panel.removeAll();
		  panel.add(piece);
		  
	  
		 // System.out.println(c.x * 8 + c.y + " => " + panel.getBackground());
		 }
	  }
	
	  chessBoard.revalidate();
	  chessBoard.repaint();
}
	
	
public void mousePressed(MouseEvent e){
	
	  chessPiece = null;
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
	 
	  if (c instanceof JPanel) 
		  return;
	 
	  Point parentLocation = c.getParent().getLocation();
	  xAdjustment = parentLocation.x - e.getX();
	  yAdjustment = parentLocation.y - e.getY();
	  chessPiece = (JLabel)c;
	  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
	  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
	  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
//	  System.out.println("coord init2 dep : x= "+c.getX()/100+"y= "+c.getY()/100); // pour recup les coord de départ
	  cInit.x = c.getX()/100;
  cInit.y=c.getY()/100;
	  
}
		 
		  //Move the chess piece around
		  
public void mouseDragged(MouseEvent me) {
	
	  if (chessPiece == null) return;
	  	chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	 }
	 
	  //Drop the chess piece back onto the chess board



	 
public void mouseReleased(MouseEvent e) {
	
	  Coord cfinal=new Coord(xAdjustment, xAdjustment);

	  if(chessPiece == null) 
		  return;
	 
	  chessPiece.setVisible(false);
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY()); 
	  

	//	 System.out.println("test released :"+c.getX()/100+" /"+c.getY()/100);// pour recup les coord d'arrivée
	  cfinal.x=c.getX()/100;
	  cfinal.y=c.getY()/100;
	  
	  if(chessGameControler.move(cInit, cfinal)==false)
	  {
		  return;
	  }
	  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
	  }
	  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
	  }
	 
	  chessPiece.setVisible(true);
}
	 

public void mouseClicked(MouseEvent e) {
	  
}

public void mouseMoved(MouseEvent e) {
}

public void mouseEntered(MouseEvent e){
	  
}

public void mouseExited(MouseEvent e) {
	  
}
}