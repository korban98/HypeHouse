import java.awt.GridBagConstraints;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InfoArticoloDialog extends JDialog {

	private JPanel contentPanel;
	private JScrollPane scrollPane;
	private JPanel panel;
	private ControllerShop ctrl;
	public FotoExtendsArticolo art;
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
	private SpinnerNumberModel modelSpinner;
	private JSpinner spinner;
	private JLabel lblSelezionareUnaQuantit;
	  
	//COSTRUTTORE
	public InfoArticoloDialog(ControllerShop controller, FotoExtendsArticolo articolo) {
		ctrl = controller;
		art = articolo;
		setTitle("Descrizione articolo");
		setBounds(100, 100, 886, 667);
		contentPanel = new JPanel();
		getContentPane().setBackground(Color.WHITE);
		contentPanel.setBackground(new Color(255, 255, 255));
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
				ctrl.negoziodialog.setVisible(false);
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
				ctrl.negoziodialog.setVisible(true);
			}
		});
		lbltornaindietro.setBounds(106, 118, 46, 45);
		contentPanel.add(lbltornaindietro);
		Image imgarrow = new ImageIcon(this.getClass().getResource("/arrowimg.png")).getImage();
		lbltornaindietro.setIcon(new ImageIcon(imgarrow));
		
		JLabel lblcarrello = new JLabel("");
		lblcarrello.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ctrl.AggiornaTabellaCarrello();
				ctrl.VisualizzaCarrelloDialog(true);
			}
		});
		lblcarrello.setBounds(830, 118, 36, 45);
		contentPanel.add(lblcarrello);
		Image imgcarrello = new ImageIcon(this.getClass().getResource("/carrellobtn.png")).getImage();
		lblcarrello.setIcon(new ImageIcon(imgcarrello));
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		lblImgPrincipale = new JLabel("");
		lblImgPrincipale.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgPrincipale.setBackground(Color.WHITE);
		lblImgPrincipale.setBounds(38, 186, 322, 227);
		lblImgPrincipale.setBorder(blackline);
		contentPanel.add(lblImgPrincipale);
		
		JLabel lblcodbarre = new JLabel("CodiceBarre");
		lblcodbarre.setBounds(38, 474, 94, 14);
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
		codbarre.setBounds(133, 474, 126, 14);
		contentPanel.add(codbarre);
		
		genere = new JLabel("");
		genere.setBounds(133, 574, 89, 14);
		contentPanel.add(genere);
		
		nome = new JLabel("");
		nome.setBounds(133, 424, 178, 14);
		contentPanel.add(nome);
		
		categoria = new JLabel("");
		categoria.setBounds(133, 549, 126, 14);
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
		taglia.setBounds(133, 524, 108, 14);
		contentPanel.add(taglia);
		
		JLabel lblprezzo = new JLabel("Prezzo");
		lblprezzo.setBounds(38, 449, 46, 14);
		contentPanel.add(lblprezzo);
		
		prezzo = new JLabel("");
		prezzo.setBounds(133, 449, 89, 14);
		contentPanel.add(prezzo);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E0");
		lblQuantit.setBounds(38, 599, 69, 14);
		contentPanel.add(lblQuantit);
		
		quantita = new JLabel("");
		quantita.setBounds(133, 599, 77, 14);
		contentPanel.add(quantita);
		
		JLabel lblScegliQuantit = new JLabel("Scegli quantit\u00E0 :");
		lblScegliQuantit.setBounds(552, 509, 94, 14);
		contentPanel.add(lblScegliQuantit);
		
		modelSpinner = new SpinnerNumberModel(0, 0, art.getQuantita(), 1);
		spinner = new JSpinner(modelSpinner);
		spinner.setBounds(656, 506, 69, 20);
		contentPanel.add(spinner);
		
		JButton btnAggiungiAlCarrello = new JButton("Aggiungi al carrello");
		btnAggiungiAlCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer quantita = new Integer(spinner.getValue().toString());
				boolean PresenzaArticoloCart = ctrl.ControlloArticoloPresenteCarrello(art);
				if (PresenzaArticoloCart == false) {
					if(quantita != 0) {
						lblSelezionareUnaQuantit.setVisible(false);
						ctrl.AggiungiArticoloCarrello(articolo, spinner.getValue().toString());
						SpinnerNumberModel modelSpinner1 = new SpinnerNumberModel(0, 0, articolo.getQuantita(), 1);
						spinner.setModel(modelSpinner1);
					}
					else 
						lblSelezionareUnaQuantit.setVisible(true);
				}
				else {
					if(quantita != 0) {
					ctrl.AggiungiQuantitaArticoloCarrello(articolo, spinner.getValue().toString());
					SpinnerNumberModel modelSpinner1 = new SpinnerNumberModel(0, 0, articolo.getQuantita(), 1);
					spinner.setModel(modelSpinner1);
					}
					else 
						lblSelezionareUnaQuantit.setVisible(true);
				}
			}
		});
		btnAggiungiAlCarrello.setBounds(569, 565, 139, 23);
		contentPanel.add(btnAggiungiAlCarrello);
		
		
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
	    
	    lblSelezionareUnaQuantit = new JLabel("Selezionare una quantit\u00E0 maggiore di zero.");
	    lblSelezionareUnaQuantit.setForeground(new Color(255, 0, 0));
	    lblSelezionareUnaQuantit.setBounds(534, 534, 263, 14);
	    contentPanel.add(lblSelezionareUnaQuantit);
	    lblSelezionareUnaQuantit.setVisible(false);
	}
	
	//il metodo scorre tutte le immagini dell'array e ne crea una label per ciascuna di esse
	private void setLayoutGrid() {
		foto = new ArrayList<ImageIcon>(art.getFotoArticolo());
		for(ImageIcon img : foto) {
			CreaLabelPerFoto(img);
		}
	}
	
	//il metodo istanzia una label per l'immagine attuale
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
	
	//il metodo modifica la quantità massima selezionabile nello spinner dopo aver inserito un articolo nel carrello
	public void ModificaQuantitaSpinner(int quantita) {
		SpinnerNumberModel modelSpinner2 = new SpinnerNumberModel(0, 0, quantita, 1);
		spinner.setModel(modelSpinner2);
	}
	
	//il metodo setta nelle label di informazione i dettagli dell'articolo
	private void setInfoLabel() {
		nome.setText(art.getNome());
		codbarre.setText(art.getCodiceBarre());
		categoria.setText(art.getCategoria());
		colore.setText(art.getColore());
		taglia.setText(art.getTaglia());
		Integer qnt = new Integer(art.getQuantita());
		quantita.setText(qnt.toString());
		Double price = new Double(art.getPrezzo());
		prezzo.setText("€ "+price.toString());
		genere.setText(art.getGenere());
	}
}
