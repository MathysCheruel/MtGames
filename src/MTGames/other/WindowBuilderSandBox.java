package MTGames.other;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WindowBuilderSandBox extends JFrame {

	/**
	 * A utiliser comme bac à sable pour dessiner les écrans visuellement avec le
	 * pluggin Eclipse "WindowBuilder", ou faire d'autres tests, etc...
	 * Pour installer WindowBuilder => Help >> Eclipse Marketplace.... >> Rechercher WindowBuilder et installer la version courante  
	 * Un tuto publié par Exlipse (10min) : https://www.eclipse.org/windowbuilder/
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderSandBox frame = new WindowBuilderSandBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderSandBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 4, 4));

		JLabel lblNewLabel = new JLabel("Login");
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel_1 = new JLabel("Password");
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
