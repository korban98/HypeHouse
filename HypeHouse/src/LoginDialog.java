import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
	private JTextField textField;
	private JPasswordField passwordField;

	
	public LoginDialog(ControllerShop Controller) {
		setTitle("Log-in");
		setBounds(100, 100, 426, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnAccedi = new JButton("Accedi");
			btnAccedi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(gettext()==true){
						Controller.VisibilitaMagazzinoAdmin();
					}
					else {
						Controller.TipoUtenteLoggato();
					}
					//controllo se nelle textfield ci sono valori corrispondenti al db

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
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(185, 52, 46, 14);
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
		
		textField = new JTextField();
		textField.setBounds(122, 122, 192, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 171, 192, 20);
		contentPanel.add(passwordField);
		
		JLabel lblLogoUser = new JLabel("");
		Image imglogouser = new ImageIcon(this.getClass().getResource("/jusername.png")).getImage();
		lblLogoUser.setIcon(new ImageIcon(imglogouser));
		lblLogoUser.setBounds(82, 110, 30, 37);
		contentPanel.add(lblLogoUser);
	}
	
	private boolean gettext() {
		boolean flag=false;
		if(textField.getText().equals("Admin")) {
			flag=true;
			return flag;
		}
		else {
			return flag;
		}
	}
}
