package MTGames.app;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import MTGames.controler.UserControler;
import MTGames.controler.ManageUsersControler;
import MTGames.controler.LoginControler;
import MTGames.utilities.AppConstant;
import MTGames.utilities.AppSession;
import MTGames.view.screen.UserPanel;

public class DemoSwingAppV2 {

	private static JFrame frmMydemoswingapp;

	private static UserPanel userPanel;

	private AppSession appSession;

	public static void main(String[] args) {

		Runnable demoApp = new Runnable() {

			@Override
			public void run() {
				try {
					new DemoSwingAppV2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		SwingUtilities.invokeLater(demoApp);
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public DemoSwingAppV2() {
		setDataSource();
		frmMydemoswingapp = new JFrame();
		createAndShowGUI();
	}

	private void setDataSource() {
		AppConstant.dataSource.setUrl(AppConstant.APP_DATABASE_URL);
	}

	public static JFrame getFrmMydemoswingapp() {
		return frmMydemoswingapp;
	}

	public static UserPanel getUserPanel() {
		return userPanel;
	}

	private void createAndShowGUI() {
		
		appSession = AppSession.getInstance();
		appSession.setUserLogin(AppConstant.APP_DEFAULT_USER);

		frmMydemoswingapp.setTitle("MTGames");
		frmMydemoswingapp.setBounds(100, 100, 1040, 300);
		frmMydemoswingapp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmMydemoswingapp.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
        ImageIcon icon = new ImageIcon("MTGames/Images/LogoUser.png");

		// START - MENU
		JMenuBar menuBar = new JMenuBar();
		frmMydemoswingapp.setJMenuBar(menuBar);

		JMenu topMenu1 = new JMenu("Accueil");
		menuBar.add(topMenu1);
		
		JMenu topMenu2 = new JMenu("Partie");
		menuBar.add(topMenu2);

		JMenu topMenu3 = new JMenu("Scores");
		menuBar.add(topMenu3);
		
		topMenu3.addSeparator();
		JMenuItem topMenu1SubMenu1 = new JMenuItem("Dames");
		topMenu3.add(topMenu1SubMenu1);

		JMenuItem topMenu1SubMenu2 = new JMenuItem("Blocks");
		topMenu3.add(topMenu1SubMenu2);

		JMenuItem topMenu1SubMenu3 = new JMenuItem("Space I.");
		topMenu3.add(topMenu1SubMenu3);
		
		// END - MENU

		frmMydemoswingapp.setVisible(true);
	}
}
