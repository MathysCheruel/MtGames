package MTGames.view.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import MTGames.app.DemoSwingAppV2;
import MTGames.controler.ManageUsersControler;
import MTGames.controler.view.ManageUsersView;
import MTGames.model.pojo.utilisateur;
import MTGames.utilities.AppConstant;
import MTGames.utilities.AppSession;

public class ManageUsersScreen extends ManageUsersView {
	private JFrame frame;
	private JList<String> list;
	private JButton modifierButton;
	private JButton supprimerButton;
	private Collection<utilisateur> usersList;
	private Map<Integer, utilisateur> mappingJListIndexUser;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ManageUsersScreen(ManageUsersControler manageUsersControler) throws SQLException {
		super(manageUsersControler);
		build();
	}

	private void build() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 409);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("Gérer les utilisateurs");

		usersList = getManageUsersControler().getUsers();

		// Alimentation Jlist via DefaultListModel
		DefaultListModel<String> listModel = new DefaultListModel<>();
		Iterator<utilisateur> iterator = usersList.iterator();
		utilisateur user = null;
		mappingJListIndexUser = new HashMap<>();
		Integer index = 0;
		// Pour chaque utilisateur trouvé
		while (iterator.hasNext()) {
			user = iterator.next();
			// On ajouter un élément au DefaultListModel à l'index souhaité
			listModel.add(index, user.getpseudo()+ AppConstant.LIST_SEPARATOR + user.getid_utilisateur());
			// On alimente notre mapping entre l'index (as KEY) dans la JList (enfin... son
			// DefaultListModel) et l'objet User (as VALUE)
			mappingJListIndexUser.put(index, user);
			// Incrémenter index
			index++;
		}
		list = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Liste des utilisateurs", TitledBorder.CENTER, TitledBorder.TOP));
//		frame.getContentPane().add(scrollPane);

		modifierButton = new JButton("Modifier");
		modifierButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ITEM A MODIFIER : " + list.getSelectedValue());
				// Récupérer l'objet à partir de l'index sélectionné
				utilisateur selectedUser = mappingJListIndexUser.get(list.getSelectedIndex());
				// On stocke le User sélectionné dans AppSession
				AppSession.getInstance().setUserToModify(selectedUser);
				// Alimentation UserPanel avec le user à modifier (à partir de celui dans
				// AppSession)
				DemoSwingAppV2.getUserPanel().fillUserInfoBlocForModify();
				DemoSwingAppV2.getUserPanel().enableUserPanelComponents(true);
				DemoSwingAppV2.getUserPanel().getUserInfoPanel().setVisible(true);
				DemoSwingAppV2.getUserPanel().setMode(AppConstant.USER_PANEL_MODE_MODIFICATION);
				close();
			}
		});
		supprimerButton = new JButton("Supprimer");

		supprimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ITEM A SUPPRIMER : " + list.getSelectedValue());
				// Récupérer l'objet à partir de l'index sélectionné
				utilisateur selectedUser = mappingJListIndexUser.get(list.getSelectedIndex());
				Boolean success = null;
				try {
					success = getManageUsersControler().deleteUser(selectedUser);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// Gérer le résultat
				JOptionPane resultDialog = new JOptionPane();

				String message = "";
				if (success) {
					message = "L'utilisateur a été supprimé avec succès !";
					resultDialog.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				} else {
					message = "Oops un pb est survenu : " + AppSession.getInstance().getMessageToDisplay();
					resultDialog.setMessageType(JOptionPane.ERROR_MESSAGE);
					AppSession.getInstance().setMessageToDisplay("");
				}
				JOptionPane.showMessageDialog(frame, message);
				close();
			}
		});
		// com.jgoodies.forms.layout.FormLayout.FormLayout => à référencer dans le class
		// path (voir répertoire Librairies du projet)
		frame.getContentPane().add(scrollPane, "2, 2, 1, 3, fill, fill");
		frame.getContentPane().add(modifierButton, "4, 2, fill, top");
		frame.getContentPane().add(supprimerButton, "4, 4, left, top");
	}

	@Override
	public void display() {
		if (!frame.isVisible()) {
			frame.setVisible(true);
		}

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		frame.dispose();
	}
}
