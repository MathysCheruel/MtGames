package MTGames.other;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
 
public class InvitationRefuser {
 
	private JFrame frame;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvitationRefuser window = new InvitationRefuser();
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
	public InvitationRefuser() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(225dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(78dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(29dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Invitation Refusée");
		frame.getContentPane().add(lblNewLabel, "4, 2, center, default");
		
		JLabel lblNewLabel_5 = new JLabel("malheureusement");
		frame.getContentPane().add(lblNewLabel_5, "4, 4, center, default");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\svo\\OneDrive - MTB\\Images\\Captures d’écran\\Capture d'écran 2024-04-12 103624.png"));
		frame.getContentPane().add(lblNewLabel_1, "4, 6, center, default");
		
		JLabel lblNewLabel_2 = new JLabel("[Joueur]");
		frame.getContentPane().add(lblNewLabel_2, "4, 8, center, default");
		
		JLabel lblNewLabel_3 = new JLabel("a refusée de vous rejoindre");
		frame.getContentPane().add(lblNewLabel_3, "4, 10, center, default");
		
		JLabel lblNewLabel_4 = new JLabel("Veuillez reourner a l'ecran d'accueil");
		frame.getContentPane().add(lblNewLabel_4, "4, 12, center, default");
		
		JButton btnNewButton = new JButton("Retour");
		frame.getContentPane().add(btnNewButton, "6, 14");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow ();
				main.frame.setVisible(true);
				main.frame.setSize(frame.getSize());
				main.frame.setLocation(frame.getLocation());
				frame.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\svo\\Downloads\\Capture d'écran 2024-04-12 09344.png"));
		frame.getContentPane().add(btnNewButton_1, "2, 16");
	}
 
}
