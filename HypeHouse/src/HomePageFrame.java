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
import java.util.ArrayList;

public class HomePageFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnAccedi;
	private JButton btnLogout;
	private ControllerShop ctrl;
	private ArrayList<FotoExstendsArticolo> listaarticoli;

	//COSTRUTTORE
	public HomePageFrame(ControllerShop controller) {
		ctrl=controller;
		listaarticoli = new ArrayList<FotoExstendsArticolo>();
		listaarticoli = ctrl.getArrayArticoli();
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
				ctrl.negoziodialog = new NegozioDialog(ctrl,"Donna", listaarticoli);
				ctrl.VisibilitaNegozioDialog(true, "Donna");
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
				ctrl.negoziodialog = new NegozioDialog(ctrl, "Uomo", listaarticoli);
				ctrl.VisibilitaNegozioDialog(true, "Uomo");
				ctrl.VisibilitaHome(false);
			}
		});
		btnUomo.setBounds(75, 165, 249, 391);
		contentPane.add(btnUomo);
		
		JButton btnBambini = new JButton("");
		Image imgbambini = new ImageIcon(this.getClass().getResource("/JBambinimax.png")).getImage();
		btnBambini.setIcon(new ImageIcon(imgbambini));
		btnBambini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.negoziodialog = new NegozioDialog(ctrl, "Bambini", listaarticoli);
				ctrl.VisibilitaNegozioDialog(true, "Bambini");
				ctrl.VisibilitaHome(false);
			}
		});
		btnBambini.setBounds(555, 165, 235, 391);
		contentPane.add(btnBambini);
		
		JButton btnCarrello = new JButton("");
		Image imgcarrello = new ImageIcon(this.getClass().getResource("/carrellobtn.png")).getImage();
		btnCarrello.setIcon(new ImageIcon(imgcarrello));
		btnCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.AggiornaTabellaCarrello();
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
				ctrl.carrellodialog = new CarrelloDialog(ctrl, null);
			}
		});
		btnLogout.setBounds(653, 108, 89, 29);
		contentPane.add(btnLogout);
		btnLogout.setVisible(false);
	}
	
	//il metodo setta visibile il bottone logout
	public void setbottonelogout() {
		btnLogout.setVisible(true);
		btnAccedi.setVisible(false);
	}
		
	//il metodo setta visibile il bottone login
	public void setbottoneaccedi() {
		btnLogout.setVisible(false);
		btnAccedi.setVisible(true);
	}
}
