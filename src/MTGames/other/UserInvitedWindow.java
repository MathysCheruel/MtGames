package MTGames.other;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;

public class UserInvitedWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInvitedWindow window = new UserInvitedWindow();
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
	public UserInvitedWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JTextPane txtpnNousInvitons = new JTextPane();
		txtpnNousInvitons.setEditable(false);
		txtpnNousInvitons.setText("Nous invitons");
		panel.add(txtpnNousInvitons);
		
		JLabel ProfilPictureLabel = new JLabel("PhotoProfilDuJoueur");
		ProfilPictureLabel.setIcon(null);
		ProfilPictureLabel.setMinimumSize(new Dimension(15, 15));
		ProfilPictureLabel.setMaximumSize(new Dimension(25, 25));
		panel.add(ProfilPictureLabel);
		
		JTextPane txtpnPlayerX = new JTextPane();
		txtpnPlayerX.setEditable(false);
		txtpnPlayerX.setText("Player X");
		panel.add(txtpnPlayerX);
		
		JTextPane txtpnVousRejoindre = new JTextPane();
		txtpnVousRejoindre.setEditable(false);
		txtpnVousRejoindre.setText("à vous rejoindre...");
		panel.add(txtpnVousRejoindre);
		
		JTextPane txtpnVeuillezAttendreUne = new JTextPane();
		txtpnVeuillezAttendreUne.setEditable(false);
		txtpnVeuillezAttendreUne.setText("Veuillez attendre une réponse de sa part.");
		panel.add(txtpnVeuillezAttendreUne);
		
		JButton AnnulationButton = new JButton("Annuler");
		panel.add(AnnulationButton);
	}

}
