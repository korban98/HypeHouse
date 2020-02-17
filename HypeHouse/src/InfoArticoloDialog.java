import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfoArticoloDialog extends JDialog {

	private JPanel contentPanel;
	private ControllerShop ctrl;
	
	  
	public InfoArticoloDialog(ControllerShop controller) {
		ctrl=controller;
		setTitle("Descrizione articolo");
		setBounds(100, 100, 886, 667);
		contentPanel = new JPanel();
		getContentPane().setBackground(Color.WHITE);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		this.setResizable(false);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(370, 13, 170, 93);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lblLogo.setIcon(new ImageIcon(imglogo));
		contentPanel.add(lblLogo);
		
		JLabel lblhome = new JLabel("");
		lblhome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrl.RitornaAllaHome();
			}
		});
		lblhome.setBounds(38, 118, 46, 45);
		contentPanel.add(lblhome);
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		lblhome.setIcon(new ImageIcon(imghome));
		
		JLabel lbltornaindietro = new JLabel("");
		lbltornaindietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.VisibilitaArticoloDialog(false);
			}
		});
		lbltornaindietro.setBounds(106, 118, 46, 45);
		contentPanel.add(lbltornaindietro);
		Image imgarrow = new ImageIcon(this.getClass().getResource("/arrowimg.png")).getImage();
		lbltornaindietro.setIcon(new ImageIcon(imgarrow));
		
		JLabel lblcarrello = new JLabel("");
		lblcarrello.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ctrl.VisibilitaArticoloDialog(false);
				ctrl.VisualizzaCarrelloDialog(true);
			}
		});
		lblcarrello.setBounds(830, 118, 36, 45);
		contentPanel.add(lblcarrello);
		Image imgcarrello = new ImageIcon(this.getClass().getResource("/carrellobtn.png")).getImage();
		lblcarrello.setIcon(new ImageIcon(imgcarrello));
		

	}
}
