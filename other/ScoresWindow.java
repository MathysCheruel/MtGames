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
import javax.swing.JTextArea;
import javax.swing.JList;

public class ScoresWindow {

	private JFrame frame;
	private JButton AccueilButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoresWindow window = new ScoresWindow();
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
	public ScoresWindow() {
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
		UserButton.setIcon(new ImageIcon(MainWindow.class.getResource("/MTGames/Images/LogoUser.png")));
		toolBar.add(UserButton);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JTextPane txtpnTableauDesScores = new JTextPane();
		txtpnTableauDesScores.setEditable(false);
		txtpnTableauDesScores.setText("Tableau des scores");
		panel.add(txtpnTableauDesScores);
		
		JTextPane txtpnJeu = new JTextPane();
		txtpnJeu.setEditable(false);
		txtpnJeu.setText("Jeu :");
		panel.add(txtpnJeu);
		
		JTextPane txtpner_1 = new JTextPane();
		txtpner_1.setEditable(false);
		txtpner_1.setText("1er :");
		panel.add(txtpner_1);
		
		JTextPane txtpner_2 = new JTextPane();
		txtpner_2.setEditable(false);
		txtpner_2.setText("2eme :");
		panel.add(txtpner_2);
		
		JTextPane txtpner_3 = new JTextPane();
		txtpner_3.setEditable(false);
		txtpner_3.setText("3eme :");
		panel.add(txtpner_3);
		
		JTextPane txtpner_4 = new JTextPane();
		txtpner_4.setEditable(false);
		txtpner_4.setText("4eme :");
		panel.add(txtpner_4);
		
		JTextPane txtpner_5 = new JTextPane();
		txtpner_5.setEditable(false);
		txtpner_5.setText("5eme :");
		panel.add(txtpner_5);
		
		JButton SettingsButton = new JButton("Parametres");
		panel.add(SettingsButton);
	}

}
