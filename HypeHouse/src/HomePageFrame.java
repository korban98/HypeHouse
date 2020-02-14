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
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class HomePageFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnAccedi;
	private JButton btnLogout;
	private ControllerShop ctrl;

	public HomePageFrame(ControllerShop controller) {
		ctrl=controller;
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 886, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		Image imgdonna = new ImageIcon(this.getClass().getResource("/JDonnabtnmax.png")).getImage();
		
		JButton btnDonna = new JButton("");
		btnDonna.setIcon(new ImageIcon(imgdonna));
		btnDonna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.NegozioDialog(true);
				ctrl.VisibilitaHome(false);
			}
		});
		btnDonna.setBounds(322, 165, 235, 391);
		contentPane.add(btnDonna);
		
		JButton btnUomo = new JButton("");
		Image imguomo = new ImageIcon(this.getClass().getResource("/JUomobtnmax.png")).getImage();
		btnUomo.setIcon(new ImageIcon(imguomo));
		btnUomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.NegozioDialog(true);
				ctrl.VisibilitaHome(false);
			}
		});
		btnUomo.setBounds(75, 165, 249, 391);
		contentPane.add(btnUomo);
		
		JButton btnBambini = new JButton("");
		btnBambini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.NegozioDialog(true);
				ctrl.VisibilitaHome(false);
			}
		});
		Image imgbambini = new ImageIcon(this.getClass().getResource("/JBambinimax.png")).getImage();
		btnBambini.setIcon(new ImageIcon(imgbambini));
		btnBambini.setBounds(555, 165, 235, 391);
		contentPane.add(btnBambini);
		
		JButton btnCarrello = new JButton("");
		btnCarrello.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.VisualizzaCarrelloDialog(true); 
				
			}
		});
		Image imgcarrello = new ImageIcon(this.getClass().getResource("/carrellobtn.png")).getImage();
		btnCarrello.setIcon(new ImageIcon(imgcarrello));
		btnCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.VisualizzaCarrelloDialog(true);
			}
		});
		btnCarrello.setBounds(760, 108, 30, 29);
		contentPane.add(btnCarrello);
		
		JLabel lblLogo = new JLabel("");
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinalsmax.jpeg")).getImage();
		lblLogo.setIcon(new ImageIcon(imglogo));
		lblLogo.setBounds(336, 13, 199, 95);
		contentPane.add(lblLogo);
		
		btnAccedi = new JButton("Accedi");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.VisibilitaLoginDialog(true);
			}
		});
		btnAccedi.setBounds(653, 108, 89, 29);
		contentPane.add(btnAccedi);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setbottoneaccedi();
			}
		});
		btnLogout.setBounds(653, 108, 89, 29);
		contentPane.add(btnLogout);
		btnLogout.setVisible(false);
	}
	
	public void setbottonelogout() {
		btnLogout.setVisible(true);
		btnAccedi.setVisible(false);
	}
		 
	public void setbottoneaccedi() {
		btnLogout.setVisible(false);
		btnAccedi.setVisible(true);
	}
}
