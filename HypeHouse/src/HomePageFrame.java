import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HomePageFrame extends JFrame {

	private JPanel contentPane;

	public HomePageFrame(ControllerShop ctrl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDonna = new JButton("");
		Image imgdonna = new ImageIcon(this.getClass().getResource("/JDonnabtn.png")).getImage();
		btnDonna.setIcon(new ImageIcon(imgdonna));
		btnDonna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnDonna.setBounds(51, 102, 175, 254);
		contentPane.add(btnDonna);
		
		JButton btnUomo = new JButton("");
		Image imguomo = new ImageIcon(this.getClass().getResource("/JUomobtn.png")).getImage();
		btnUomo.setIcon(new ImageIcon(imguomo));
		btnUomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUomo.setBounds(231, 102, 175, 254);
		contentPane.add(btnUomo);
		
		JButton btnBambini = new JButton("");
		Image imgbambini = new ImageIcon(this.getClass().getResource("/JBambinibtn.png")).getImage();
		btnBambini.setIcon(new ImageIcon(imgbambini));
		btnBambini.setBounds(410, 102, 175, 254);
		contentPane.add(btnBambini);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.setBounds(460, 62, 90, 29);
		contentPane.add(btnAccedi);
		
		JButton btnCarrello = new JButton("");
		Image imgcarrello = new ImageIcon(this.getClass().getResource("/carrellobtn.png")).getImage();
		btnCarrello.setIcon(new ImageIcon(imgcarrello));
		btnCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCarrello.setBounds(555, 62, 30, 29);
		contentPane.add(btnCarrello);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(258, 11, 79, 54);
		contentPane.add(lblLogo);
	}
}