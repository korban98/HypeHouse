import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField UsernameField;
	private JPasswordField passwordField;
	private ControllerShop ctrl;
	
	//COSTRUTTORE
	public LoginDialog(ControllerShop Controller) {
		ctrl=Controller;
		setTitle("Log-in");
		setBounds(100, 100, 426, 328);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		this.setResizable(false);
		contentPanel.setLayout(null);
		{
			JButton btnAccedi = new JButton("Accedi");
			btnAccedi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControlloCredenziali();
					ctrl.VisibilitaLoginDialog(false);
				}
			});
			btnAccedi.setBounds(66, 229, 102, 23);
			contentPanel.add(btnAccedi);
		
		}
		{
			JButton btnRegistrati = new JButton("Registrati");
			btnRegistrati.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Controller.VisibilitaRegistrazioneDialog(true);
				}
			});
			btnRegistrati.setBounds(228, 229, 102, 23);
			contentPanel.add(btnRegistrati);
		}
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(137, 13, 170, 84);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lblLogo.setIcon(new ImageIcon(imglogo));
		contentPanel.add(lblLogo);
		
		JLabel lblLogoPass = new JLabel("");
		Image imglogopass = new ImageIcon(this.getClass().getResource("/jpassword.png")).getImage();
		lblLogoPass.setIcon(new ImageIcon(imglogopass));
		lblLogoPass.setBounds(82, 161, 30, 30);
		contentPanel.add(lblLogoPass);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(122, 110, 76, 14);
		contentPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(122, 158, 109, 14);
		contentPanel.add(lblPassword);
	
		UsernameField = new JTextField();
		UsernameField.setBounds(122, 122, 192, 20);
		contentPanel.add(UsernameField);
		UsernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 171, 192, 20);
		contentPanel.add(passwordField);
		
		JLabel lblLogoUser = new JLabel("");
		Image imglogouser = new ImageIcon(this.getClass().getResource("/jusername.png")).getImage();
		lblLogoUser.setIcon(new ImageIcon(imglogouser));
		lblLogoUser.setBounds(82, 110, 30, 37);
		contentPanel.add(lblLogoUser);
	}
	
	//il metodo sviota le field username e password
	private void SvuotaTextField() {
		UsernameField.setText("");
		passwordField.setText("");
	}
	
	//il metodo controlla se l'utente è Admin o Guest
	private void EffettuaAccesso(String tipoutente, Utente user) {
		if(tipoutente.equals("Admin")) {
			AccessoAdmin(user);
		}
		else if(tipoutente.equals("Guest")) {
			AccessoGuest(user);
		}
	}
	
	//il metodo rende visibile i frame per l'accesso Admin
	private void AccessoAdmin(Utente user) {
		if(ctrl.carrellodialog.isVisible() == true) {
			ctrl.VisibilitaArticoloDialog(false);
			ctrl.carrellodialog.setVisible(false);
			ctrl.negoziodialog.setVisible(false);
		}
		ctrl.AggiornaTabellaMagazzino();
		ctrl.VisibilitaMagazzinoAdmin(user.getUsername());
		ctrl.VisibilitaHome(false);
	}
	
	//il metodo rende visibile i frame per l'accesso Guest
	private void AccessoGuest(Utente user) {
		if(ctrl.carrellodialog.isVisible() == true) {
			ctrl.carrellodialog.setVisible(false);
			ctrl.carrellodialog = new CarrelloDialog(ctrl, user);
			ctrl.AggiornaTabellaCarrello();
			ctrl.carrellodialog.setVisible(true);
		}
		else {
			ctrl.VisibilitaNegozioGuest();
			ctrl.carrellodialog = new CarrelloDialog(ctrl, user);
			ctrl.carrellodialog.revalidate();
			ctrl.carrellodialog.repaint();
		}
	}
	
	//il metodo controlla che le credenziali inserite siano presenti nel database, quindi effettua l'accesso
	@SuppressWarnings("deprecation")
	private void ControlloCredenziali() {
		Utente user = new Utente(null, null, null, null, null, null);
		if((UsernameField.getText().length()>0)&&(passwordField.getText().length()>0)) {
			user = ctrl.ControlloUtenteRegistrato(UsernameField.getText(), passwordField.getText());
			if(user.getTipoUtente()!=null) {
				EffettuaAccesso(user.getTipoUtente(), user);	
			}
			else {
				ctrl.ErroreDialog("Utente non registrato.", "Errore");
			}
			SvuotaTextField();
		}
		else {
			SvuotaTextField();
			ctrl.ErroreDialog("Inserire Username e Password.", "Errore Inserimento");
		}
	}
	
}