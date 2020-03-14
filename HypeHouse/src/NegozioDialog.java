import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class NegozioDialog extends JFrame {
	
	private JPanel contentPanel;
	private ControllerShop ctrl;
	private GridBagConstraints constraint;
	private JScrollPane scrollPane;
	private JPanel panel;
	public ArrayList<FotoExtendsArticolo> listaarticoli;
	private ArrayList<FotoExtendsArticolo> articolipergenere;
	private JLabel lblSezione;
	
	//COSTRUTTORE
	public NegozioDialog(ControllerShop controller, String genere, ArrayList<FotoExtendsArticolo> lista) {
		ctrl=controller;
		listaarticoli = lista;
		articolipergenere = new ArrayList<FotoExtendsArticolo>();
		
		setTitle("Negozio");
		setBounds(100, 10, 886, 650);
		contentPanel = new JPanel();
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		this.setResizable(false);
		
		JLabel lbllogo = new JLabel("");
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinalsmax.jpeg")).getImage();
		lbllogo.setIcon(new ImageIcon(imglogo));
		lbllogo.setBounds(367, 13, 220, 110);
		contentPanel.add(lbllogo);
		
		JLabel LabelHome = new JLabel("");
		LabelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrl.VisibilitaHome(true);
				ctrl.negoziodialog.setVisible(false);
			}
		});
		LabelHome.setBounds(51, 129, 45, 50);
		contentPanel.add(LabelHome);
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		LabelHome.setIcon(new ImageIcon(imghome));
		
		JLabel label = new JLabel("");
		Image imglinee = new ImageIcon(this.getClass().getResource("/linea.png")).getImage();
		label.setIcon(new ImageIcon(imglinee));
		label.setBounds(10, 187, 38, 405);
		contentPanel.add(label);
		
		JLabel labelcarrello = new JLabel("");
		labelcarrello.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.AggiornaTabellaCarrello();
				ctrl.VisualizzaCarrelloDialog(true);
			}
		});
		Image imgcarrello = new ImageIcon(this.getClass().getResource("/carrellobtn.png")).getImage();
		labelcarrello.setIcon(new ImageIcon(imgcarrello));
		labelcarrello.setBounds(807, 137, 45, 42);
		contentPanel.add(labelcarrello);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 187, 801, 405);
		contentPanel.add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		scrollPane.setViewportView(panel);
		
		lblSezione = new JLabel("");
		lblSezione.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSezione.setBounds(436, 137, 126, 42);
		contentPanel.add(lblSezione);
    
		//VINCOLI SUL LAYOUT GRIDBAG
	    constraint = new GridBagConstraints();
	    constraint.anchor = GridBagConstraints.CENTER;
	    constraint.fill = GridBagConstraints.NONE;
	    constraint.gridy = GridBagConstraints.RELATIVE;
	    constraint.weightx = 1.0f;
	    constraint.weighty = 1.0f;
	    setLayoutGrid(genere);
	}
	
	//il metodo crea una label per ogni articolo per inserirvi la prima immagine di ognuno
	private void CreaLabelPerArticolo(int j, int i) {
		JLabel lblfoto = new JLabel();
		lblfoto.setIcon(articolipergenere.get(i).getPrimaFotoArticolo());
		lblfoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrl.setInfoArtDialog(articolipergenere.get(i));
			}
		});
		JLabel lblnome = new JLabel(articolipergenere.get(i).getNome());
		JLabel lblprezzo = new JLabel("€ "+articolipergenere.get(i).getPrezzo().toString());
	    constraint.gridx = j;
	    panel.add(lblfoto, constraint);
	    constraint.gridx = j;
	    panel.add(lblnome, constraint);
	    constraint.gridx = j;
	    panel.add(lblprezzo, constraint);
	}
	
	//Il metodo setta il numero di label da applicare sul panel per ogni articolo presente nel Database
	private void setLayoutGrid(String genere) {
		 String numerolabel = ctrl.ContaArticoliInDatabase(genere);
		 articolipergenere = getArrayArticoliPerGenere(genere);
		 if(numerolabel!=null) {
		    	Integer nlabel = new Integer(numerolabel);
		    	for(int i = 0; i < nlabel; i++) {
		    		for(int j=0; (j<3) && (i < nlabel); j++) {
		    			CreaLabelPerArticolo(j, i);
		    			i++;
		    		}
		    		i--;
		    	}
		}
		else {
				ctrl.ErroreDialog("Sold Out", "Errore");
		}
	}
	
	//il metodo popola un ArrayList di articoli dello stesso genere
	private ArrayList<FotoExtendsArticolo> getArrayArticoliPerGenere(String genere) {
		for(FotoExtendsArticolo art : listaarticoli) {
			if(art.getGenere().equals(genere))
				articolipergenere.add(art);
		}
		return articolipergenere;
	}
	
	//il metodo setta la label della sezione genere
	public void SetLabelSezione(String genere) {
		lblSezione.setText(genere);
	}
}
