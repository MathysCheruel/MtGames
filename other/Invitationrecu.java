package MTGames.other;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Invitationrecu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invitationrecu window = new Invitationrecu();
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
	public Invitationrecu() {
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
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(162dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(45dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Vous avez recu Une invitation");
		frame.getContentPane().add(lblNewLabel, "4, 2, 5, 1, center, default");
		
		JLabel lblNewLabel_1 = new JLabel("Vous avez recu une invitation de [Joueur]");
		frame.getContentPane().add(lblNewLabel_1, "6, 4, center, default");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\svo\\OneDrive - MTB\\Images\\Captures d’écran\\Capture d'écran 2024-04-12 103624.png"));
		frame.getContentPane().add(lblNewLabel_3, "6, 6, center, default");
		
		JLabel lblNewLabel_2 = new JLabel("Pour jouer a [Nom de jeux]");
		frame.getContentPane().add(lblNewLabel_2, "6, 8, center, default");
		
		JButton btnNewButton = new JButton("Refuser");
		frame.getContentPane().add(btnNewButton, "4, 10");
		
		JLabel lblNewLabel_4 = new JLabel("");
		frame.getContentPane().add(lblNewLabel_4, "6, 10");
		
		JButton btnNewButton_1 = new JButton("Accepter");
		frame.getContentPane().add(btnNewButton_1, "8, 10");
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\svo\\Downloads\\Capture d'écran 2024-04-12 09344.png"));
		frame.getContentPane().add(btnNewButton_2, "2, 12");
	}

}
