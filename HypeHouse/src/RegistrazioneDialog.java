import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

public class RegistrazioneDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textEmail;
	private ControllerShop ctrl;
	private JTextField textCodiceAdmin;

	//COSTRUTTORE
	public RegistrazioneDialog(ControllerShop controller) {
		ctrl = controller;
		setBounds(100, 100, 464, 586);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		this.setResizable(false);
		contentPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(135, 13, 170, 82);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lblLogo.setIcon(new ImageIcon(imglogo));
		contentPanel.add(lblLogo);
		
		JLabel lblU = new JLabel("Username");
		lblU.setBounds(30, 186, 78, 16);
		contentPanel.add(lblU);
		
		textUsername = new JTextField();
		textUsername.setBounds(30, 201, 145, 22);
		contentPanel.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 236, 78, 16);
		contentPanel.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(30, 253, 145, 22);
		contentPanel.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 321, 56, 16);
		contentPanel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(30, 338, 145, 22);
		contentPanel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(30, 362, 56, 16);
		contentPanel.add(lblCognome);
		
		textCognome = new JTextField();
		textCognome.setBounds(30, 379, 145, 22);
		contentPanel.add(textCognome);
		textCognome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(30, 412, 56, 16);
		contentPanel.add(lblNewLabel);
		
		textEmail = new JTextField();
		textEmail.setBounds(30, 426, 145, 22);
		contentPanel.add(textEmail);
		textEmail.setColumns(10);
		{
			JButton okButton = new JButton("Conferma");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControlloCorrettezzaInserimento();
				}
			});
			okButton.setBounds(280, 379, 127, 37);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Annulla");
			cancelButton.setBounds(280, 453, 127, 37);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ctrl.VisibilitaRegistrazioneDialog(false);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel lblRegistrazione = new JLabel("Registrazione");
		lblRegistrazione.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRegistrazione.setBounds(59, 140, 127, 26);
		contentPanel.add(lblRegistrazione); 
		
		JLabel lblLogoRegistrazione = new JLabel("");
		Image imglist = new ImageIcon(this.getClass().getResource("/jlist.png")).getImage();
		lblLogoRegistrazione.setIcon(new ImageIcon(imglist));
		lblLogoRegistrazione.setBounds(30, 126, 36, 37);
		contentPanel.add(lblLogoRegistrazione);
		
		textCodiceAdmin = new JTextField();
		textCodiceAdmin.setColumns(10);
		textCodiceAdmin.setBounds(30, 478, 145, 22);
		contentPanel.add(textCodiceAdmin);
		
		JLabel lblCodiceAdminopzionale = new JLabel("Codice Admin (opzionale)");
		lblCodiceAdminopzionale.setBounds(30, 463, 145, 16);
		contentPanel.add(lblCodiceAdminopzionale);
		
	}
	
	//il metodo controlla che siano state compilate tutte le field, controlla se � stato inserito il codice Admin
	//che viene fornito dal titolare per poter consentire la registrazione agli amministratori
	//quindi registra il nuovo utente Admin o Guest
	private void ControlloCorrettezzaInserimento() {
		if((textUsername.getText().length()>0)&&(textPassword.getText().length()>0)&&(textNome.getText().length()>0)&&
				(textCognome.getText().length()>0)&&(textEmail.getText().length()>0)){
			if((textCodiceAdmin.getText().equals("!abc123!"))) {
				ctrl.AggiungiUtenteDatabase(textUsername.getText(), textPassword.getText(), "Admin", textNome.getText(), textCognome.getText(),
						 textEmail.getText());
				SvuotaField();
			}	
			else if(textCodiceAdmin.getText().length()==0) {
				ctrl.AggiungiUtenteDatabase(textUsername.getText(), textPassword.getText(), "Guest", textNome.getText(), textCognome.getText(),
						 textEmail.getText());
				SvuotaField();
			}
			else
				ctrl.ErroreDialog("Codice Admin non corretto.", "Errore Inserimento");
		}
		else
			ctrl.ErroreDialog("Riempire correttamente tutti i campi.", "Errore Inserimento");
	}
	
	//il metodo svuota le field
	private void SvuotaField() {
		textUsername.setText("");
		textPassword.setText("");
		textNome.setText("");
		textCognome.setText("");
		textEmail.setText("");
		textCodiceAdmin.setText("");
	}
}
