package MTGames.other;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

public class UserSettingsWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserSettingsWindow dialog = new UserSettingsWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserSettingsWindow() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JTextPane txtpnProfil = new JTextPane();
			txtpnProfil.setEditable(false);
			txtpnProfil.setText("Profil");
			contentPanel.add(txtpnProfil);
		}
		{
			JButton UserSettingsButton = new JButton("Parametres de profil");
			contentPanel.add(UserSettingsButton);
		}
		{
			JButton ConfidentialiteButton = new JButton("Confidentialite");
			contentPanel.add(ConfidentialiteButton);
		}
		{
			JButton DeconnexionButton = new JButton("Deconnexion");
			contentPanel.add(DeconnexionButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
