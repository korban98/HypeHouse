import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrdineCompletatoDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private ControllerShop ctrl;

	//COSTRUTTORE
	public OrdineCompletatoDialog(ControllerShop Controller) {
		ctrl = Controller;
		setBounds(100, 100, 494, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		lblLogo.setIcon(new ImageIcon(imglogo));
		lblLogo.setBounds(151, 13, 170, 82);
		contentPanel.add(lblLogo);
		 
		JLabel lblCongratulazioneIlTuo = new JLabel("Congratulazioni, il tuo ordine \u00E8 stato effettuato con successo");
		lblCongratulazioneIlTuo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCongratulazioneIlTuo.setBounds(45, 149, 419, 16);
		contentPanel.add(lblCongratulazioneIlTuo);
		
		JLabel label = new JLabel("");
		Image imgyes = new ImageIcon(this.getClass().getResource("/yes1.png")).getImage();
		label.setIcon(new ImageIcon(imgyes));
		label.setBounds(218, 176, 32, 38);
		contentPanel.add(label);
		
		JButton btnTornaAllaHome = new JButton("Torna alla Home");
		btnTornaAllaHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.homeframe = new HomePageFrame(ctrl);
				ctrl.VisibilitaHome(true);
				ctrl.homeframe.setbottonelogout();
				ctrl.completaordine.setVisible(false);
				ctrl.ordinecompletatodialog.setVisible(false);
				ctrl.SvuotaTabellaCarrello();
				ctrl.AggiornaTabellaCarrello();
			}
		});
		btnTornaAllaHome.setBounds(172, 227, 127, 25);
		contentPanel.add(btnTornaAllaHome);
	}
}
