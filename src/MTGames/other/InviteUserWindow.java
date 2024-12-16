package MTGames.other;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JTextPane;

public class InviteUserWindow {

	private JFrame frame;
	private JButton AccueilButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InviteUserWindow window = new InviteUserWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InviteUserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/* Barre du haut + Logo et Titre de fenêtre */
		frame = new JFrame();
		
		frame.setTitle("MTGames");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		AccueilButton = new JButton("Accueil");
		AccueilButton.setBackground(new Color(128, 128, 128));
		toolBar.add(AccueilButton);
		
		JButton PartieButton = new JButton("Partie");
		PartieButton.setBackground(new Color(128, 128, 128));
		toolBar.add(PartieButton);
		
		JButton ScoreButton = new JButton("Scores");
		ScoreButton.setBackground(new Color(128, 128, 128));
		toolBar.add(ScoreButton);
		
		JButton UserButton = new JButton("");
		UserButton.setIgnoreRepaint(true);
		UserButton.setForeground(new Color(255, 255, 255));
		UserButton.setPreferredSize(new Dimension(20, 20));
		UserButton.setMinimumSize(new Dimension(15, 15));
		UserButton.setMaximumSize(new Dimension(25, 25));
		toolBar.add(UserButton);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JTextPane txtpnJoueursEnLigne = new JTextPane();
		txtpnJoueursEnLigne.setEditable(false);
		txtpnJoueursEnLigne.setText("Joueur(s) en ligne à inviter");
		panel.add(txtpnJoueursEnLigne);
		
		JButton InvitePlayer1Button = new JButton("Player 1");
		panel.add(InvitePlayer1Button);
		
		JButton InvitePlayer2Button = new JButton("Player 2");
		panel.add(InvitePlayer2Button);
	}

}
