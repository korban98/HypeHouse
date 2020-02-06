import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.Box;

public class NegozioDialog extends JFrame {
	
	private final JPanel contentPanel = new JPanel();
	private ControllerShop ctrl;
	
	public NegozioDialog(ControllerShop controller) {
		ctrl=controller;
		setTitle("Negozio");
		setBounds(100, 100, 948, 725);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbllogo = new JLabel("");
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinalsmax.jpeg")).getImage();
		lbllogo.setIcon(new ImageIcon(imglogo));
		lbllogo.setBounds(334, 13, 220, 110);
		contentPanel.add(lbllogo);
		
		JLabel LabelHome = new JLabel("");
		LabelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrl.RitornaAllaHome();
				ctrl.NegozioDialog(false);
			}
		});
		LabelHome.setBounds(51, 129, 45, 50);
		contentPanel.add(LabelHome);
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		LabelHome.setIcon(new ImageIcon(imghome));
		
		JLabel lblNewLabel = new JLabel("Maglie");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(51, 238, 45, 17);
		contentPanel.add(lblNewLabel);
		
		JLabel lblFelpe = new JLabel("Felpe");
		lblFelpe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFelpe.setBounds(51, 270, 45, 16);
		contentPanel.add(lblFelpe);
		
		JLabel lblGiubbinicappotti = new JLabel("Giubbini&Cappotti");
		lblGiubbinicappotti.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiubbinicappotti.setBounds(51, 301, 126, 16);
		contentPanel.add(lblGiubbinicappotti);
		
		JLabel lblCinture = new JLabel("Cinture");
		lblCinture.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCinture.setBounds(51, 330, 56, 16);
		contentPanel.add(lblCinture);
		
		JLabel lblPantaloni = new JLabel("Pantaloni");
		lblPantaloni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPantaloni.setBounds(51, 362, 66, 16);
		contentPanel.add(lblPantaloni);
		
		JLabel lblCalzini = new JLabel("Calzini");
		lblCalzini.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCalzini.setBounds(51, 399, 45, 16);
		contentPanel.add(lblCalzini);
		
		JLabel lblNewLabel_1 = new JLabel("Scarpe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 435, 56, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		Image imglinee = new ImageIcon(this.getClass().getResource("/linea.png")).getImage();
		label.setIcon(new ImageIcon(imglinee));
		label.setBounds(169, 220, 56, 280);
		contentPanel.add(label);
		
		JLabel labelcarrello = new JLabel("");
		labelcarrello.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.NegozioDialog(false);
				 ctrl.VisualizzaCarrelloDialog(true);
			}
		});
		Image imgcarrello = new ImageIcon(this.getClass().getResource("/carrellobtn.png")).getImage();
		labelcarrello.setIcon(new ImageIcon(imgcarrello));
		labelcarrello.setBounds(824, 129, 30, 39);
		contentPanel.add(labelcarrello);
		
	}

}
