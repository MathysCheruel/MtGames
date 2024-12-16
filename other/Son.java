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
import javax.swing.JSlider;



public class Son {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Son window = new Son();
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
	public Son() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 429);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
						frame.getContentPane().setLayout(new MigLayout("", "[177px][131px][78.00][][][][][][][][][][]", "[37px][33px][33px][33px][][][][][][][][][][]"));
				
						
						JLabel lblNewLabel = new JLabel("Son");
						lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						frame.getContentPane().add(lblNewLabel, "cell 2 0,grow");
				
				JButton btnNewButton_2_1 = new JButton("Retour");
				btnNewButton_2_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				
				JLabel btnNewButton_2 = new JLabel("Son");
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				frame.getContentPane().add(btnNewButton_2, "cell 1 3,grow");
				
				JSlider slider = new JSlider();
				frame.getContentPane().add(slider, "cell 2 3 7 1");
				
				JLabel btnNewButton_1 = new JLabel("Musique");
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				frame.getContentPane().add(btnNewButton_1, "cell 1 4,grow");
				
				JSlider slider_1 = new JSlider();
				frame.getContentPane().add(slider_1, "cell 2 4 5 1");
				btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				frame.getContentPane().add(btnNewButton_2_1, "cell 12 13,growx,aligny top");
	}

}
