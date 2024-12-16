package MTGames.other;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;



public class Accessibilité {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accessibilité window = new Accessibilité();
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
	public Accessibilité() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 429);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
						frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
								ColumnSpec.decode("186px"),
								FormSpecs.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("max(244dlu;default)"),
								FormSpecs.RELATED_GAP_COLSPEC,
								FormSpecs.DEFAULT_COLSPEC,
								ColumnSpec.decode("21px"),
								FormSpecs.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("max(82dlu;default)"),
								FormSpecs.RELATED_GAP_COLSPEC,
								FormSpecs.DEFAULT_COLSPEC,},
							new RowSpec[] {
								RowSpec.decode("37px"),
								FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC,
								RowSpec.decode("322px"),
								FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC,
								RowSpec.decode("33px"),}));
				
						
						JLabel lblNewLabel = new JLabel("Accessibilité");
						lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						frame.getContentPane().add(lblNewLabel, "3, 2, fill, top");
				
				JLabel btnNewButton_1 = new JLabel("Activer le mode accessibilité visuel :");
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				frame.getContentPane().add(btnNewButton_1, "3, 4, fill, fill");
				
				JCheckBox chckbxNewCheckBox = new JCheckBox("");
				frame.getContentPane().add(chckbxNewCheckBox, "5, 4, left, fill");
				
				JButton btnNewButton_2_1 = new JButton("Retour");
				btnNewButton_2_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				frame.getContentPane().add(btnNewButton_2_1, "6, 5, 3, 1, fill, top");
	}

}
