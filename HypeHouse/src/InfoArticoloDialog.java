import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
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
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;

public class InfoArticoloDialog extends JDialog {

	private JPanel contentPanel;
	private JScrollPane scrollPane;
	private JPanel panel;
	private ControllerShop ctrl;
	private FotoExstendsArticolo art;
	private GridBagConstraints constraint;
	private ArrayList<ImageIcon> foto;
	private JLabel lblImgPrincipale;
	private JLabel codbarre;
	private JLabel nome;
	private JLabel categoria;
	private JLabel colore;
	private JLabel taglia;
	private JLabel quantita;
	private JLabel prezzo;
	private JLabel genere;
	  
	public InfoArticoloDialog(ControllerShop controller, FotoExstendsArticolo articolo) {
		ctrl = controller;
		art = articolo;
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
				ctrl.VisibilitaHome(true);
				ctrl.VisibilitaArticoloDialog(false);
				ctrl.VisibilitaNegozioDialog(false);
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
		
		lblImgPrincipale = new JLabel("");
		lblImgPrincipale.setBounds(38, 186, 322, 227);
		contentPanel.add(lblImgPrincipale);
		
		JLabel lblcodbarre = new JLabel("CodiceBarre");
		lblcodbarre.setBounds(38, 474, 69, 14);
		contentPanel.add(lblcodbarre);
		
		JLabel lblgenere = new JLabel("Genere");
		lblgenere.setBounds(38, 574, 59, 14);
		contentPanel.add(lblgenere);
		
		JLabel lblcategoria = new JLabel("Categoria");
		lblcategoria.setBounds(38, 549, 69, 14);
		contentPanel.add(lblcategoria);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(38, 424, 46, 14);
		contentPanel.add(lblNome);
		
		codbarre = new JLabel("");
		codbarre.setBounds(133, 474, 77, 14);
		contentPanel.add(codbarre);
		
		genere = new JLabel("");
		genere.setBounds(133, 574, 89, 14);
		contentPanel.add(genere);
		
		nome = new JLabel("");
		nome.setBounds(133, 424, 126, 14);
		contentPanel.add(nome);
		
		categoria = new JLabel("");
		categoria.setBounds(133, 549, 77, 14);
		contentPanel.add(categoria);
		
		JLabel lblcolore = new JLabel("Colore");
		lblcolore.setBounds(38, 499, 46, 14);
		contentPanel.add(lblcolore);
		
		colore = new JLabel("");
		colore.setBounds(133, 499, 108, 14);
		contentPanel.add(colore);
		
		JLabel lblTaglia = new JLabel("Taglia");
		lblTaglia.setBounds(38, 524, 46, 14);
		contentPanel.add(lblTaglia);
		
		taglia = new JLabel("");
		taglia.setBounds(133, 524, 89, 14);
		contentPanel.add(taglia);
		
		JLabel lblprezzo = new JLabel("Prezzo");
		lblprezzo.setBounds(38, 449, 46, 14);
		contentPanel.add(lblprezzo);
		
		prezzo = new JLabel("");
		prezzo.setBounds(133, 449, 46, 14);
		contentPanel.add(prezzo);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E0");
		lblQuantit.setBounds(38, 599, 46, 14);
		contentPanel.add(lblQuantit);
		
		quantita = new JLabel("");
		quantita.setBounds(133, 599, 77, 14);
		contentPanel.add(quantita);
		
		JButton btnAggiungiAlCarrello = new JButton("Aggiungi al carrello");
		btnAggiungiAlCarrello.setBounds(569, 565, 139, 23);
		contentPanel.add(btnAggiungiAlCarrello);
		
		JLabel lblScegliQuantit = new JLabel("Scegli quantit\u00E0 :");
		lblScegliQuantit.setBounds(552, 509, 94, 14);
		contentPanel.add(lblScegliQuantit);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(656, 506, 69, 20);
		contentPanel.add(spinner);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 186, 470, 227);
		contentPanel.add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		//VINCOLI SUL LAYOUT GRIDBAG
	    constraint = new GridBagConstraints();
	    constraint.anchor = GridBagConstraints.CENTER;
	    constraint.fill = GridBagConstraints.NONE;
	    constraint.gridy = GridBagConstraints.RELATIVE;
	    constraint.gridx = GridBagConstraints.RELATIVE;
	    constraint.weightx = 1.0f;
	    constraint.weighty = 1.0f;
	   
	    //viene settato il layout della gridbag
	    setLayoutGrid();
	    
	    //vengono settate le label delle informazioni dell'articolo
	    setInfoLabel();
	    
	    scrollPane.setViewportView(panel);
	    
	    JLabel labelvert = new JLabel("");
	    Image imglinee = new ImageIcon(this.getClass().getResource("/linea.png")).getImage();
		labelvert.setIcon(new ImageIcon(imglinee));
	    labelvert.setBounds(344, 159, 46, 468);
	    contentPanel.add(labelvert);
	    
	    JLabel labeloriz = new JLabel("");
	    Image imglineeoriz = new ImageIcon(this.getClass().getResource("/lineaoriz.png")).getImage();
		labeloriz.setIcon(new ImageIcon(imglineeoriz));
	    labeloriz.setBounds(425, 434, 429, 29);
	    contentPanel.add(labeloriz);
	}
	
	private void setLayoutGrid() {
		foto = new ArrayList<ImageIcon>(art.getFotoArticolo());
		for(ImageIcon img : foto) {
			CreaLabelPerFoto(img);
		}
	}
	
	private void CreaLabelPerFoto(ImageIcon img) {
		JLabel lblfoto = new JLabel();
		lblfoto.setIcon(img);
		lblfoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblImgPrincipale.setIcon(img);
			}
		});
	    panel.add(lblfoto, constraint);
	}
	
	private void setInfoLabel() {
		nome.setText(art.getNome());
		codbarre.setText(art.getCodiceBarre());
		categoria.setText(art.getCategoria());
		colore.setText(art.getColore());
		taglia.setText(art.getTaglia());
		Integer qnt = new Integer(art.getQuantita());
		quantita.setText(qnt.toString());
		Double price = new Double(art.getPrezzo());
		prezzo.setText(price.toString());
		genere.setText(art.getGenere());
	}
}
