package ilkebeliz.space;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ilkebeliz.space.gui.GameBoard;

public class Main {

	private static JFrame window;
	private static GameBoard board;
	static JButton jbQuit;
	static JButton jbStart;
	static JPanel startButtonPanel;
	static Font nFont= new Font("Algerian", Font.PLAIN , 18);
    static CloseWindow cw = new CloseWindow();
	public static void main(String[] args) {
		createFrame();
		createGameBoard();
	}
	
	private static void createFrame() {
		System.out.println("[Main]: Creating Frame");
		
		window = new JFrame("Save The World");
		window.setVisible(true);
		window.setBounds(100, 100, Reference.windowWidth, Reference.windowHeight);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void createGameBoard() {
		System.out.println("[Main]: Creating game board");

        jbQuit = new JButton("Quit");
        jbQuit.setFont(nFont);
        jbQuit.setBackground(Color.cyan);
        jbQuit.setBounds(442,506,127,32);
        jbQuit.addActionListener(cw);
       
        
		board = new GameBoard();
		window.add(board);

     	board.add(jbQuit);
		board.requestFocusInWindow();
	}
	static public class CloseWindow implements ActionListener{
		public void actionPerformed(ActionEvent event ) {
			JFrame fr = new JFrame("QUIT");
			if(JOptionPane.showConfirmDialog(fr, "Confirm if you want to quit","QUIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
	}
	}
	
}