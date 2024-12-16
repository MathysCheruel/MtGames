package MTGames.view.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import MTGames.app.DemoSwingAppV2;
import MTGames.controler.LoginControler;
import MTGames.controler.view.LoginView;
import MTGames.utilities.AppConstant;
import MTGames.utilities.AppSession;

/**
 * Ecran Login / hérite de LoginView
 * 
 * @author MCH
 *
 */
public class LoginScreen extends LoginView {
	private JFrame frame = null;
	private JPanel panel = null;
	private JButton okButton = null;
	private JButton cancelButton = null;
	private JLabel loginLab = null;
	private JLabel passwordLab = null;
	private JTextField loginField;
	private JPasswordField passwordField;

	/**
	 * Constructeur.
	 * 
	 */
	public LoginScreen(LoginControler loginControler) {
		super(loginControler);
		build();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void build() {
		frame = new JFrame();
		frame.setTitle("Ecran de connexion vraiment pas beau :-)");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 494, 184);

		panel = new JPanel();
		frame.setContentPane(panel);
		panel.setLayout(new java.awt.GridLayout(0, 2, 0, 0));

		loginLab = new JLabel("LOGIN");
		loginLab.setHorizontalAlignment(SwingConstants.CENTER);
		loginLab.setBounds(10, 11, 216, 41);
		frame.getContentPane().add(loginLab);

		loginField = new JTextField();
		loginField.setBounds(323, 11, 288, 41);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);

		passwordLab = new JLabel("PASSWORD");
		passwordLab.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLab.setToolTipText("Renseignez votre login");
		passwordLab.setBounds(10, 63, 216, 41);
		frame.getContentPane().add(passwordLab);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(323, 63, 288, 41);
		frame.getContentPane().add(passwordField);

		okButton = new JButton("OK");
		okButton.setBounds(10, 115, 288, 61);
		frame.getContentPane().add(okButton);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane optionPane = new JOptionPane();

				if (geLoginControler().doLogin(loginField.getText(), passwordField.getText())) {
					optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
					optionPane.setOptionType(JOptionPane.OK_OPTION);
					JOptionPane.showMessageDialog(frame, "Bienvenue " + loginField.getText() + "!");
					AppSession appSession = AppSession.getInstance();
					appSession.setUserLogin(loginField.getText());
					DemoSwingAppV2.getFrmMydemoswingapp().setTitle(AppConstant.APP_TITLE + loginField.getText());
					close();
				} else {
					optionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
					optionPane.setOptionType(JOptionPane.OK_OPTION);
					JOptionPane.showMessageDialog(frame, "L'utilisateur " + loginField.getText()
							+ " n'a pas été trouvé ou le mot de passe renseigné est erroné ! Merci de retenter...");
					loginField.setText("");
					passwordField.setText("");
				}

			}
		});

		cancelButton = new JButton("ANNULER");
		cancelButton.setBounds(323, 115, 288, 61);
		frame.getContentPane().add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});

	}

	@Override
	public void display() {
		if (!frame.isVisible()) {
			frame.setVisible(true);
		}
	}

	@Override
	public void close() {
		frame.dispose();
	}
}
