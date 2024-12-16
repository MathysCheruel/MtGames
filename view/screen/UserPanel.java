/**
 * 
 */
package MTGames.view.screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MTGames.controler.UserControler;
import MTGames.utilities.AppConstant;
import MTGames.utilities.AppSession;

/**
 * @author MCH
 *
 */
public class UserPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// START - BLOC USER INFO
	private JPanel userInfoPanel;
	private JTextField userInfoBlocFieldPseudo;
	private JLabel userInfoblocTitle;
	private JLabel userInfoblocLabNom;
	private JLabel userInfoblocLabPrenom;
	private JLabel userInfoblocLabProfil;
	private JCheckBox userInfoblocChckbxAdmin;
	private JCheckBox userInfoblocChckbxStandard;
	private JTextField userInfoBlocFieldLogin;
	private JPasswordField userInfoBlocFieldPassword;
	private JLabel userInfobloclabLogin;
	private JLabel userInfobloclabPassword;
	private JButton userInfoBlocOkButton;
	private JButton userInfoBlocCancelButton;
	// END - BLOC USER INFO
	private UserControler userControler;
	// MODE PAR DEFAUT
	private String mode = "";

	/**
	 * 
	 */
	public UserPanel(UserControler userControler) {
		super();
		this.userControler = userControler;
		this.mode = AppConstant.USER_PANEL_MODE_CONSULTATION;
		buildUserInfoPanel();
	}

	public JPanel getUserInfoPanel() {
		return userInfoPanel;
	}

//	public void refresh() {
//		buildUserInfoPanel();
//	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return this.mode;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void buildUserInfoPanel() {
		userInfoPanel = new JPanel();
		// BLOC masqué par défaut
		userInfoPanel.setVisible(false);
		// LAYOUT : Absolute
		userInfoPanel.setLayout(null);
		// START - Les composants du panel
		userInfoblocTitle = new JLabel();
		userInfoblocTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
		userInfoblocTitle.setBounds(6, 16, 189, 16);
		userInfoblocTitle.setText("Infos utilisateur");

		userInfoPanel.add(userInfoblocTitle);

		userInfoblocLabNom = new JLabel("Nom :");
		userInfoblocLabNom.setBounds(6, 44, 75, 16);
		userInfoPanel.add(userInfoblocLabNom);

		userInfoblocLabPrenom = new JLabel("Prénom :");
		userInfoblocLabPrenom.setBounds(6, 73, 75, 16);
		userInfoPanel.add(userInfoblocLabPrenom);

		userInfoblocLabProfil = new JLabel("Profil :");
		userInfoblocLabProfil.setBounds(6, 107, 75, 16);
		userInfoPanel.add(userInfoblocLabProfil);

		userInfoBlocFieldPseudo = new JTextField();
		userInfoBlocFieldPseudo.setBounds(106, 67, 122, 28);
		userInfoBlocFieldPseudo.setColumns(10);
		userInfoPanel.add(userInfoBlocFieldPseudo);

		userInfoblocChckbxStandard = new JCheckBox(AppConstant.APP_PROFIL_STANDARD);
		userInfoblocChckbxStandard.setBounds(106, 106, 104, 18);
		userInfoPanel.add(userInfoblocChckbxStandard);

		userInfoblocChckbxAdmin = new JCheckBox(AppConstant.APP_PROFIL_ADMIN);
		userInfoblocChckbxAdmin.setBounds(106, 124, 104, 18);
		userInfoPanel.add(userInfoblocChckbxAdmin);

		userInfobloclabLogin = new JLabel("LOGIN :");
		userInfobloclabLogin.setBounds(6, 155, 75, 16);
		userInfoPanel.add(userInfobloclabLogin);

		userInfoBlocFieldLogin = new JTextField();
		userInfoBlocFieldLogin.setColumns(10);
		userInfoBlocFieldLogin.setBounds(106, 149, 122, 28);
		userInfoPanel.add(userInfoBlocFieldLogin);

		userInfobloclabPassword = new JLabel("Password :");
		userInfobloclabPassword.setBounds(6, 183, 75, 16);
		userInfoPanel.add(userInfobloclabPassword);

		userInfoBlocFieldPassword = new JPasswordField();
		userInfoBlocFieldPassword.setColumns(10);
		userInfoBlocFieldPassword.setBounds(106, 177, 122, 28);
		userInfoPanel.add(userInfoBlocFieldPassword);

		userInfoBlocOkButton = new JButton("OK");
		userInfoBlocOkButton.setBounds(270, 149, 90, 28);
		userInfoBlocOkButton.setVisible(false);
		userInfoPanel.add(userInfoBlocOkButton);

		userInfoBlocCancelButton = new JButton("Annuler");
		userInfoBlocCancelButton.setBounds(270, 177, 90, 28);
		userInfoBlocCancelButton.setVisible(false);
		userInfoPanel.add(userInfoBlocCancelButton);

		// END - Les composants du panel
		// Gestion Evenements
		userInfoBlocOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "";
				// Contruction de la Map profils avec les valeurs des checkbox
				Map<String, Boolean> profils = new HashMap<String, Boolean>();
				profils.put(userInfoblocChckbxStandard.getText(),
						Boolean.valueOf(userInfoblocChckbxStandard.isSelected()));
				profils.put(userInfoblocChckbxAdmin.getText(), Boolean.valueOf(userInfoblocChckbxAdmin.isSelected()));
				boolean success = false;
				if (AppConstant.USER_PANEL_MODE_CONSULTATION.equals(mode)) {
					// Appel du controler pour créer le user
					//int id_utilisateur, String pseudo,String mail,String mdp,int id_image,int id_parametre ,int id_profil_utilisateur
					try {
						success = userControler.createUser(0,userInfoBlocFieldPseudo.getText() ,userInfoBlocFieldLogin.getText(),
								userInfoBlocFieldPassword.getText(), 0,0,0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					message = "L'utilisateur a été créé avec succès !";
				}
				if (AppConstant.USER_PANEL_MODE_MODIFICATION.equals(mode)) {
					// Appel du controler pour modifier le user
					try {
						success = userControler.updateUser(AppSession.getInstance().getUserToModify().getid_utilisateur(),
								userInfoBlocFieldPseudo.getText() ,userInfoBlocFieldLogin.getText(),
								userInfoBlocFieldPassword.getText(),0,0,0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					message = "L'utilisateur a été modifié avec succès !";
				}

				// Gérer le résultat
				JOptionPane resultDialog = new JOptionPane();

				if (success) {
					resultDialog.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				} else {
					message = "Oops un pb est survenu : " + AppSession.getInstance().getMessageToDisplay();
					resultDialog.setMessageType(JOptionPane.ERROR_MESSAGE);
					AppSession.getInstance().setMessageToDisplay("");
				}
				JOptionPane.showMessageDialog(userInfoPanel, message);
			}
		});

		// MODE CONSULTATION
//		if(AppConstant.USER_PANEL_MODE_CONSULTATION.equals(mode)) {
//			userInfoBlocOkButton.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// Contruction de la Map profils avec les valeurs des checkbox
//					Map<String, Boolean> profils = new HashMap<String, Boolean>();
//					profils.put(userInfoblocChckbxStandard.getText(),
//							Boolean.valueOf(userInfoblocChckbxStandard.isSelected()));
//					profils.put(userInfoblocChckbxAdmin.getText(), Boolean.valueOf(userInfoblocChckbxAdmin.isSelected()));
//					// Appel du controler pour créer le user
//					boolean success = userControler.createUser(userInfoBlocFieldNom.getText(), userInfoBlocFieldPseudo.getText(),
//							userInfoBlocFieldLogin.getText(), userInfoBlocFieldPassword.getText(), profils);
//					// Gérer le résultat
//					JOptionPane resultDialog = new JOptionPane();
//					
//					String message = "";
//					if(success) {
//						message = "L'utilisateur a été créé avec succès !";
//						resultDialog.setMessageType(JOptionPane.INFORMATION_MESSAGE);
//					} else {
//						message = "Oops un pb est survenu : "+AppSession.getInstance().getMessageToDisplay();
//						resultDialog.setMessageType(JOptionPane.ERROR_MESSAGE);
//						AppSession.getInstance().setMessageToDisplay("");
//					}
//					JOptionPane.showMessageDialog(userInfoPanel, message);
//				}
//			});
//		} else {
//			//MODE MODIFICATION
//			if(AppConstant.USER_PANEL_MODE_MODIFICATION.equals(mode)) {
//				userInfoBlocOkButton.setText("Modifier");
//				userInfoBlocOkButton.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// Contruction de la Map profils avec les valeurs des checkbox
//						Map<String, Boolean> profils = new HashMap<String, Boolean>();
//						profils.put(userInfoblocChckbxStandard.getText(),
//								Boolean.valueOf(userInfoblocChckbxStandard.isSelected()));
//						profils.put(userInfoblocChckbxAdmin.getText(), Boolean.valueOf(userInfoblocChckbxAdmin.isSelected()));
//						// Appel du controler pour créer le user
//						boolean success = userControler.updateUser(AppSession.getInstance().getUserToModify().getId(),userInfoBlocFieldNom.getText(), userInfoBlocFieldPseudo.getText(),
//								userInfoBlocFieldLogin.getText(), userInfoBlocFieldPassword.getText(), profils);
//						// Gérer le résultat
//						JOptionPane resultDialog = new JOptionPane();
//						
//						String message = "";
//						if(success) {
//							message = "L'utilisateur a été modifié avec succès !";
//							resultDialog.setMessageType(JOptionPane.INFORMATION_MESSAGE);
//						} else {
//							message = "Oops un pb est survenu : "+AppSession.getInstance().getMessageToDisplay();
//							resultDialog.setMessageType(JOptionPane.ERROR_MESSAGE);
//							AppSession.getInstance().setMessageToDisplay("");
//						}
//						JOptionPane.showMessageDialog(userInfoPanel, message);
//						// REPASSSER EN MODE PAR DEFAUT
////						mode = AppConstant.USER_PANEL_MODE_CONSULTATION;
//					}
//				});
//			}
//		}

		userInfoBlocCancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Effacer infos saisies
				resetUserPanelComponents();
				// Masquer le Panel userInfos
				userInfoPanel.setVisible(false);
			}
		});

	}

	public void disableUserPanelComponents() {
		userInfoBlocFieldPseudo.setEnabled(false);
		userInfoblocChckbxStandard.setEnabled(false);
		userInfoblocChckbxAdmin.setEnabled(false);
		userInfoBlocFieldLogin.setEnabled(false);
		userInfoBlocFieldPassword.setEnabled(false);
		userInfoBlocOkButton.setVisible(false);
		userInfoBlocCancelButton.setVisible(false);
	}

	public void enableUserPanelComponents(boolean showButtons) {
		userInfoBlocFieldPseudo.setEnabled(true);
		userInfoblocChckbxStandard.setEnabled(true);
		userInfoblocChckbxAdmin.setEnabled(true);
		userInfoBlocFieldLogin.setEnabled(true);
		userInfoBlocFieldPassword.setEnabled(true);
		userInfoBlocOkButton.setVisible(showButtons);
		userInfoBlocCancelButton.setVisible(showButtons);
	}

	public void fillWithConnectedUser() {
		if (AppSession.getInstance().getCurrentUser() != null) {
			userInfoBlocFieldPseudo.setText(AppSession.getInstance().getCurrentUser().getpseudo());
			if (AppSession.getInstance().getCurrentUser().getid_profil_utilisateur() != null) {
				if (AppSession.getInstance().getCurrentUser().getid_profil_utilisateur().toString().contains(AppConstant.APP_PROFIL_ADMIN)) {
					userInfoblocChckbxAdmin.setSelected(true);
				}
				if (AppSession.getInstance().getCurrentUser().getid_profil_utilisateur()
						.toString().contains(AppConstant.APP_PROFIL_STANDARD)) {
					userInfoblocChckbxStandard.setSelected(true);
				}
			}
			userInfoBlocFieldLogin.setText((String) AppSession.getInstance().getCurrentUser().getid_profil_utilisateur());
			userInfoBlocFieldPassword.setText(AppSession.getInstance().getCurrentUser().getmdp());
		}
	}

	public void fillUserInfoBlocForModify() {
		if (AppSession.getInstance().getUserToModify() != null) {
			userInfoBlocFieldPseudo.setText(AppSession.getInstance().getUserToModify().getpseudo());
			if (AppSession.getInstance().getUserToModify().getid_profil_utilisateur() != null) {
				if (AppSession.getInstance().getUserToModify().getid_profil_utilisateur().toString().contains(AppConstant.APP_PROFIL_ADMIN)) {
					userInfoblocChckbxAdmin.setSelected(true);
				}
				if (AppSession.getInstance().getUserToModify().getid_profil_utilisateur().toString().contains(AppConstant.APP_PROFIL_STANDARD)) {
					userInfoblocChckbxStandard.setSelected(true);
				}
			}
			userInfoBlocFieldLogin.setText((String) AppSession.getInstance().getUserToModify().getid_profil_utilisateur());
			userInfoBlocFieldPassword.setText(AppSession.getInstance().getUserToModify().getmdp());
		}
	}

	public void resetUserPanelComponents() {
		userInfoBlocFieldPseudo.setText("");
		userInfoblocChckbxStandard.setEnabled(false);
		userInfoblocChckbxAdmin.setEnabled(false);
		userInfoBlocFieldLogin.setText("");
		userInfoBlocFieldPassword.setText("");
	}



	public JTextField getUserInfoBlocFieldPrenom() {
		return userInfoBlocFieldPseudo;
	}

	public void setUserInfoBlocFieldPrenom(JTextField userInfoBlocFieldPseudo) {
		this.userInfoBlocFieldPseudo = userInfoBlocFieldPseudo;
	}

	public JLabel getUserInfoblocTitle() {
		return userInfoblocTitle;
	}

	public void setUserInfoblocTitle(JLabel userInfoblocTitle) {
		this.userInfoblocTitle = userInfoblocTitle;
	}

	public JLabel getUserInfoblocLabNom() {
		return userInfoblocLabNom;
	}

	public void setUserInfoblocLabNom(JLabel userInfoblocLabNom) {
		this.userInfoblocLabNom = userInfoblocLabNom;
	}

	public JLabel getUserInfoblocLabPrenom() {
		return userInfoblocLabPrenom;
	}

	public void setUserInfoblocLabPrenom(JLabel userInfoblocLabPrenom) {
		this.userInfoblocLabPrenom = userInfoblocLabPrenom;
	}

	public JLabel getUserInfoblocLabProfil() {
		return userInfoblocLabProfil;
	}

	public void setUserInfoblocLabProfil(JLabel userInfoblocLabProfil) {
		this.userInfoblocLabProfil = userInfoblocLabProfil;
	}

	public JCheckBox getUserInfoblocChckbxAdmin() {
		return userInfoblocChckbxAdmin;
	}

	public void setUserInfoblocChckbxAdmin(JCheckBox userInfoblocChckbxAdmin) {
		this.userInfoblocChckbxAdmin = userInfoblocChckbxAdmin;
	}

	public JCheckBox getUserInfoblocChckbxStandard() {
		return userInfoblocChckbxStandard;
	}

	public void setUserInfoblocChckbxStandard(JCheckBox userInfoblocChckbxStandard) {
		this.userInfoblocChckbxStandard = userInfoblocChckbxStandard;
	}

	public JTextField getUserInfoBlocFieldLogin() {
		return userInfoBlocFieldLogin;
	}

	public void setUserInfoBlocFieldLogin(JTextField userInfoBlocFieldLogin) {
		this.userInfoBlocFieldLogin = userInfoBlocFieldLogin;
	}

	public JPasswordField getUserInfoBlocFieldPassword() {
		return userInfoBlocFieldPassword;
	}

	public void setUserInfoBlocFieldPassword(JPasswordField userInfoBlocFieldPassword) {
		this.userInfoBlocFieldPassword = userInfoBlocFieldPassword;
	}

	public JLabel getUserInfobloclabLogin() {
		return userInfobloclabLogin;
	}

	public void setUserInfobloclabLogin(JLabel userInfobloclabLogin) {
		this.userInfobloclabLogin = userInfobloclabLogin;
	}

	public JLabel getUserInfobloclabPassword() {
		return userInfobloclabPassword;
	}

	public void setUserInfobloclabPassword(JLabel userInfobloclabPassword) {
		this.userInfobloclabPassword = userInfobloclabPassword;
	}

	public JButton getUserInfoBlocOkButton() {
		return userInfoBlocOkButton;
	}

	public void setUserInfoBlocOkButton(JButton userInfoBlocOkButton) {
		this.userInfoBlocOkButton = userInfoBlocOkButton;
	}

	public JButton getUserInfoBlocCancelButton() {
		return userInfoBlocCancelButton;
	}

	public void setUserInfoBlocCancelButton(JButton userInfoBlocCancelButton) {
		this.userInfoBlocCancelButton = userInfoBlocCancelButton;
	}

}
