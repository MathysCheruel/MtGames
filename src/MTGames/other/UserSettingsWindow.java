package MTGames.other;
 
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
 
public class UserSettingsWindow extends JDialog {
 
	private static final long serialVersionUID = 1L;
	final JPanel contentPanel = new JPanel();
 
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
			UserSettingsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModifProfil modifProfil = new ModifProfil();
					modifProfil.frame.setVisible(true);
					dispose();
				}
			});
		}
		{
			JButton ConfidentialiteButton = new JButton("Confidentialite");
			contentPanel.add(ConfidentialiteButton);
			ConfidentialiteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RGPD rgpd = new RGPD();
					rgpd.frame.setVisible(true);
					dispose();
				}
			});
		}
		{
			JButton DeconnexionButton = new JButton("Deconnexion");
			contentPanel.add(DeconnexionButton);
			DeconnexionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConnexionMenu connexionMenu = new ConnexionMenu();
					connexionMenu.setVisible(true);
					dispose();
				}
			});
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainWindow mainWindow = new MainWindow();
						mainWindow.frame.setVisible(true);
						dispose();
					}
				});
			}
		}
	}
 
}
