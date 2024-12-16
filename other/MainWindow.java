package MTGames.other;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextPane;

public class MainWindow {

	private JFrame frmMtgames;
	private JButton AccueilButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMtgames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/* Barre du haut + Logo et Titre de fenêtre */
		frmMtgames = new JFrame();
		frmMtgames.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MAC\\Desktop\\Nouveau dossier\\aa8f87130553681.6182b7d098180.jpg"));
		frmMtgames.setTitle("MTGames");
		frmMtgames.getContentPane().setBackground(new Color(255, 255, 255));
		frmMtgames.setBounds(100, 100, 450, 300);
		frmMtgames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(192, 192, 192));
		frmMtgames.getContentPane().add(toolBar, BorderLayout.NORTH);
		
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
		frmMtgames.getContentPane().add(panel, BorderLayout.CENTER);
		
		JTextPane txtpnListeDesJeux = new JTextPane();
		txtpnListeDesJeux.setEditable(false);
		txtpnListeDesJeux.setText("LISTE DES JEUX");
		panel.add(txtpnListeDesJeux);
		
		JButton DamesButton = new JButton("Dames");
        DamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Charger la classe dynamiquement
                    Class<?> cls = Class.forName("C:\\BTS\\Workspace\\MTGames\\JeuDame\\Lanceur.java");
                    
                    // Obtenir la méthode main
                    Method method = cls.getMethod("main", String[].class);
                    
                    // Appeler la méthode main
                    String[] params = null; // ou passer des arguments si nécessaire
                    method.invoke(null, (Object) params);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		panel.add(DamesButton);
		
		JButton BlocksButton = new JButton("Blocks");
		panel.add(BlocksButton);
		
		JButton SpaceI_Button = new JButton("Space I.");
		panel.add(SpaceI_Button);
		
		JButton SettingsButton = new JButton("Parametres");
		panel.add(SettingsButton);
	}

}
