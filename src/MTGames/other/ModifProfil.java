package MTGames.other;
 
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
 
public class ModifProfil {
 
	JFrame frame;
	private JTextField PseudoField;
	private JTextField EmailField;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifProfil window = new ModifProfil ();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ModifProfil() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 268);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(152dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(107dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(94dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(28dlu;default)"),
				RowSpec.decode("18dlu:grow"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(77dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(72dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),}));
		
		JLabel lblNewLabel = new JLabel("Paramètres Utilisateur");
		frame.getContentPane().add(lblNewLabel, "4, 2, 5, 1, center, default");
		
		JLabel lblNewLabel_1 = new JLabel("Pseudo");
		frame.getContentPane().add(lblNewLabel_1, "4, 4, center, default");
		
		PseudoField = new JTextField();
		frame.getContentPane().add(PseudoField, "6, 4, 3, 1, fill, default");
		PseudoField.setColumns(10);
		
		JLabel NewLabel = new JLabel("Adresse e-mail");
		frame.getContentPane().add(NewLabel, "4, 6, center, default");
		
		EmailField = new JTextField();
		frame.getContentPane().add(EmailField, "6, 6, 3, 1, fill, default");
		EmailField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Image de profil");
		frame.getContentPane().add(lblNewLabel_4, "4, 10, center, default");
		
		JButton btnNewButton_2 = new JButton("Importer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ImageLabel.setIcon(new ImageIcon("C:\\Users\\svo\\OneDrive - MTB\\Images\\Captures d’écran\\Capture d'écran 2024-04-12 092844.png"));
		frame.getContentPane().add(ImageLabel, "6, 10, 1, 3, center, default");
		frame.getContentPane().add(btnNewButton_2, "8, 10");
		
		JButton btnNewButton = new JButton("Retour");
		frame.getContentPane().add(btnNewButton, "4, 12");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSettingsWindow userSettingsWindow = new UserSettingsWindow();
				userSettingsWindow.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Accepter");
		frame.getContentPane().add(btnNewButton_1, "8, 12");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSettingsWindow userSettingsWindow = new UserSettingsWindow();
				userSettingsWindow.setVisible(true);
				frame.dispose();
			}
		});
	}
 
}
