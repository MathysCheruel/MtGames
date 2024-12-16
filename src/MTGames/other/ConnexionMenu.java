package MTGames.other;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ConnexionMenu extends JFrame {

	/**
	 * A utiliser comme bac à sable pour dessiner les écrans visuellement avec le
	 * pluggin Eclipse "WindowBuilder", ou faire d'autres tests, etc...
	 * Pour installer WindowBuilder => Help >> Eclipse Marketplace.... >> Rechercher WindowBuilder et installer la version courante  
	 * Un tuto publié par Exlipse (10min) : https://www.eclipse.org/windowbuilder/
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JPasswordField PasswordField;
	private Label LabelConnexion;
	private Button ButtonCompte;
	private Button ButtonConnexion;
	private JTextField LoginField;
	private JButton btnNewButton;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionMenu window = new ConnexionMenu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConnexionMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(new FormLayout(new ColumnSpec[] {
						FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(0dlu;default)"),
						FormSpecs.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("255px"),
						ColumnSpec.decode("22dlu:grow"),
						ColumnSpec.decode("274px:grow"),
						FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC,},
					new RowSpec[] {
						FormSpecs.PARAGRAPH_GAP_ROWSPEC,
						RowSpec.decode("60px"),
						RowSpec.decode("68px"),
						RowSpec.decode("60px"),
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("60px"),
						RowSpec.decode("max(36dlu;default)"),
						RowSpec.decode("max(31dlu;default)"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(11dlu;default)"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,}));
								
								LabelConnexion = new Label("Connexion");
								contentPane.add(LabelConnexion, "4, 2, 3, 1, center, default");
						
								JLabel lblNewLabel = new JLabel("Login");
								contentPane.add(lblNewLabel, "4, 4, center, fill");
								
								LoginField = new JTextField();
								contentPane.add(LoginField, "6, 4, fill, default");
								LoginField.setColumns(10);
						
								lblNewLabel_1 = new JLabel("Password");
								contentPane.add(lblNewLabel_1, "4, 6, center, fill");
						
						PasswordField = new JPasswordField();
						contentPane.add(PasswordField, "6, 6, fill, default");
						
						ButtonCompte = new Button("Creer un compte");
						ButtonCompte.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								CreationCompte Creationcompte = new CreationCompte();
								Creationcompte.frame.setVisible(true);
								Creationcompte.frame.setSize(getSize());
								Creationcompte.frame.setLocation(getLocation());
								dispose();
							}
						});
						contentPane.add(ButtonCompte, "4, 8, fill, default");
						
						ButtonConnexion = new Button("Connexion");
						ButtonConnexion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								MainWindow Mainwindow = new MainWindow();
								Mainwindow.frame.setVisible(true);
								Mainwindow.frame.setSize(getSize());
								Mainwindow.frame.setLocation(getLocation());
								dispose();
								
							}
						});
						
						contentPane.add(ButtonConnexion, "6, 8, fill, default");
						
						btnNewButton = new JButton("");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Parametres parametres = new Parametres();
								parametres.frame.setVisible(true);
								parametres.frame.setSize(getSize());
								parametres.frame.setLocation(getLocation());
								dispose();
							}
						});
						btnNewButton.setIcon(new ImageIcon("C:\\Users\\svo\\Downloads\\Capture d'écran 2024-04-12 09344.png"));
						contentPane.add(btnNewButton, "2, 12");
	}

}
