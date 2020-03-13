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
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompletaOrdineDialog extends JDialog {

	private JPanel contentPanel;
	private ControllerShop ctrl;
	private JLabel lblIndirizzo;
	private JTextField textFieldIndirizzo;
	private JLabel lblCAP;
	private JTextField textFieldCAP;
	private JLabel lblIntestatarioCarta;
	private JTextField textFieldIntestatario;
	private JLabel lblScadenza;
	private JTextField textFieldScadenza;
	private JLabel lblNumeroCarta;
	private JTextField textFieldNumCarta;
	private JLabel lblCVC;
	private JTextField textFieldCVC;
	private JLabel lblCitta;
	private JTextField textFieldCitta;
	private JButton btnConferma;
	private JButton btnConfermapagamento;
	private Utente utente;
	private double tot;
	
	//COSTRUTTORE
	public CompletaOrdineDialog(ControllerShop controller, Utente user, double totale) {
		ctrl=controller;
		utente = user;
		tot = totale;
		setTitle("Magazzino");
		setBounds(100, 100, 858, 616);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		 
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(348, 13, 170, 90);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lbllogo.setIcon(new ImageIcon(imglogo));
		contentPanel.add(lbllogo);
		
		JLabel labelhome = new JLabel("");
		labelhome.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ctrl.completaordine.setVisible(false);
				ctrl.VisibilitaHome(true);
			}
		});
		labelhome.setBounds(38, 121, 45, 45);
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		labelhome.setIcon(new ImageIcon(imghome));
		contentPanel.add(labelhome);
		
		JLabel labelvert = new JLabel("");
	    Image imglinee = new ImageIcon(this.getClass().getResource("/linea.png")).getImage();
		labelvert.setIcon(new ImageIcon(imglinee));
	    labelvert.setBounds(523, 192, 46, 370);
	    contentPanel.add(labelvert);
	    
	    btnConferma = new JButton("Conferma ordine");
	    btnConferma.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ControlloInserimentoPerPagaAllaConsegna();
	    		ctrl.ordinecompletatodialog.setVisible(true);
	    	}
	    });
	    btnConferma.setBounds(603, 429, 187, 45);
	    contentPanel.add(btnConferma);
	    btnConferma.setVisible(false);
	    
	    btnConfermapagamento = new JButton("Conferma pagamento");
	    btnConfermapagamento.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ControlloInserimentoPerPagaOnline();
	    		ctrl.ordinecompletatodialog.setVisible(true);
	    	}
	    });
	    btnConfermapagamento.setBounds(603, 429, 187, 45);
	    contentPanel.add(btnConfermapagamento);
	    btnConfermapagamento.setVisible(false);
	    
	    JButton btnAnnulla = new JButton("Annulla e torna alla Home");
	    btnAnnulla.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ctrl.homeframe = new HomePageFrame(ctrl);
				ctrl.VisibilitaHome(true);
				ctrl.homeframe.setbottonelogout();
				ctrl.completaordine.setVisible(false);
	    	}
	    });
	    btnAnnulla.setBounds(603, 485, 187, 45);
	    contentPanel.add(btnAnnulla);
	    
	    JLabel lblCostoSpedizione = new JLabel("Costi di spedizione: \u20AC 5,00");
	    lblCostoSpedizione.setBounds(603, 269, 151, 14);
	    contentPanel.add(lblCostoSpedizione);
	    
	    JLabel lbltot = new JLabel("Totale:");
	    lbltot.setBounds(603, 310, 46, 14);
	    contentPanel.add(lbltot);
	    
	    JLabel lblTotale = new JLabel("€ "+(tot+5));
	    lblTotale.setBounds(650, 310, 46, 14);
	    contentPanel.add(lblTotale);
	    
	    lblIndirizzo = new JLabel("Indirizzo");
	    lblIndirizzo.setBounds(134, 293, 86, 14);
	    contentPanel.add(lblIndirizzo);
	    lblIndirizzo.setVisible(false);
	    
	    textFieldIndirizzo = new JTextField();
	    textFieldIndirizzo.setBounds(134, 307, 238, 20);
	    contentPanel.add(textFieldIndirizzo);
	    textFieldIndirizzo.setColumns(10);
	    textFieldIndirizzo.setVisible(false);
	    
	    lblCAP = new JLabel("C.A.P.");
	    lblCAP.setBounds(134, 386, 46, 14);
	    contentPanel.add(lblCAP);
	    lblCAP.setVisible(false);
	    
	    textFieldCAP = new JTextField();
	    textFieldCAP.setBounds(134, 399, 86, 20);
	    contentPanel.add(textFieldCAP);
	    textFieldCAP.setColumns(10);
	    textFieldCAP.setVisible(false);
	    
	    JButton btnPagamentoConsegna = new JButton("Pagamento alla consegna");
	    btnPagamentoConsegna.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		VisibilitaFieldConsegna();
	    		btnConfermapagamento.setVisible(false);
	    		btnConferma.setVisible(true);
	    	}
	    });
	    btnPagamentoConsegna.setBounds(100, 220, 190, 45);
	    contentPanel.add(btnPagamentoConsegna);
	    
	    JButton btnPagamentoCarta = new JButton("Pagamento con carta");
	    btnPagamentoCarta.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		VisibilitaFieldConsegna();
	    		VisibilitaFieldPagaConCarta();
	    		btnConferma.setVisible(false);
	    		btnConfermapagamento.setVisible(true);
	    	}
	    });
	    btnPagamentoCarta.setBounds(300, 220, 190, 45);
	    contentPanel.add(btnPagamentoCarta);
	    
	    lblIntestatarioCarta = new JLabel("Nome intestatario");
	    lblIntestatarioCarta.setBounds(134, 455, 120, 14);
	    contentPanel.add(lblIntestatarioCarta);
	    lblIntestatarioCarta.setVisible(false);
	    
	    textFieldIntestatario = new JTextField();
	    textFieldIntestatario.setBounds(134, 469, 170, 20);
	    contentPanel.add(textFieldIntestatario);
	    textFieldIntestatario.setColumns(10);
	    textFieldIntestatario.setVisible(false);
	    
	    lblScadenza = new JLabel("Scadenza");
	    lblScadenza.setBounds(348, 455, 86, 14);
	    contentPanel.add(lblScadenza);
	    lblScadenza.setVisible(false);
	    
	    textFieldScadenza = new JTextField();
	    textFieldScadenza.setBounds(348, 469, 86, 20);
	    contentPanel.add(textFieldScadenza);
	    textFieldScadenza.setColumns(10);
	    textFieldScadenza.setVisible(false);
	    
	    lblNumeroCarta = new JLabel("Numero carta");
	    lblNumeroCarta.setBounds(134, 500, 120, 14);
	    contentPanel.add(lblNumeroCarta);
	    lblNumeroCarta.setVisible(false);
	    
	    textFieldNumCarta = new JTextField();
	    textFieldNumCarta.setBounds(134, 514, 170, 20);
	    contentPanel.add(textFieldNumCarta);
	    textFieldNumCarta.setColumns(10);
	    textFieldNumCarta.setVisible(false);
	    
	    lblCVC = new JLabel("CVC/CVV");
	    lblCVC.setBounds(348, 500, 70, 14);
	    contentPanel.add(lblCVC);
	    lblCVC.setVisible(false);
	    
	    textFieldCVC = new JTextField();
	    textFieldCVC.setBounds(348, 514, 86, 20);
	    contentPanel.add(textFieldCVC);
	    textFieldCVC.setColumns(10);
	    textFieldCVC.setVisible(false);
	    
	    lblCitta = new JLabel("Citt\u00E0");
	    lblCitta.setBounds(134, 342, 46, 14);
	    contentPanel.add(lblCitta);
	    lblCitta.setVisible(false);
	    
	    textFieldCitta = new JTextField();
	    textFieldCitta.setBounds(134, 355, 86, 20);
	    contentPanel.add(textFieldCitta);
	    textFieldCitta.setColumns(10);
	    textFieldCitta.setVisible(false);
	    
	    JLabel lblSelezionaIlTuo = new JLabel("Seleziona il tuo metodo di pagamento:");
	    lblSelezionaIlTuo.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblSelezionaIlTuo.setBounds(163, 192, 255, 28);
	    contentPanel.add(lblSelezionaIlTuo);
	}
	
	//il metodo rende visibile le field per il pagamento alla consegna
	private void VisibilitaFieldConsegna() {
		lblIndirizzo.setVisible(true);
		textFieldIndirizzo.setVisible(true);
		lblCAP.setVisible(true);
		textFieldCAP.setVisible(true);
		lblCitta.setVisible(true);
		textFieldCitta.setVisible(true);
		lblIntestatarioCarta.setVisible(false);
		textFieldIntestatario.setVisible(false);
		lblScadenza.setVisible(false);
		textFieldScadenza.setVisible(false);
		lblNumeroCarta.setVisible(false);
		textFieldNumCarta.setVisible(false);
		lblCVC.setVisible(false);
		textFieldCVC.setVisible(false);
	}
	
	//il metodo rende visibile le field per il pagamento con carta
	private void VisibilitaFieldPagaConCarta() {
		lblIntestatarioCarta.setVisible(true);
		textFieldIntestatario.setVisible(true);
		lblScadenza.setVisible(true);
		textFieldScadenza.setVisible(true);
		lblNumeroCarta.setVisible(true);
		textFieldNumCarta.setVisible(true);
		lblCVC.setVisible(true);
		textFieldCVC.setVisible(true);
	}
	
	//il metodo controlla se sono stati inseriti valori all'interno delle field per pagamento online
	//quindi salva l'ordine nel database e lo conferma
	private void ControlloInserimentoPerPagaOnline() {
		if((textFieldIndirizzo.getText().length()>0) && (textFieldCitta.getText().length()>0) && (textFieldCAP.getText().length()>0)
				&& (textFieldIntestatario.getText().length()>0) && (textFieldNumCarta.getText().length()>0) && 
				(textFieldScadenza.getText().length()>0) && (textFieldCVC.getText().length()>0)) {
			boolean confermato = ctrl.SalvaOrdine(tot, utente.getUsername(), textFieldIndirizzo.getText(), textFieldCAP.getText(), textFieldCitta.getText());
			if(confermato == true)
				ctrl.ConfermaOrdine();
			SvuotaField();
		}
		else {
			SvuotaField();
			ctrl.ErroreDialog("Inserisci tutti i campi", "Errore");
		}
	}
	
	//il metodo controlla se sono stati inseriti valori all'interno delle field per pagamento alla consegna
	//quindi salva l'ordine nel database e lo conferma
	private void ControlloInserimentoPerPagaAllaConsegna() {
		if((textFieldIndirizzo.getText().length()>0) && (textFieldCitta.getText().length()>0) && (textFieldCAP.getText().length()>0)) {
			boolean confermato = ctrl.SalvaOrdine(tot, utente.getUsername(), textFieldIndirizzo.getText(), textFieldCAP.getText(), textFieldCitta.getText());
			if(confermato == true)
				ctrl.ConfermaOrdine();
			SvuotaField();
		}
		else {
			SvuotaField();
			ctrl.ErroreDialog("Inserisci tutti i campi", "Errore");
		}
	}
	
	//il metodo svuota le field
	private void SvuotaField() {
		textFieldIndirizzo.setText("");
		textFieldCitta.setText("");
		textFieldCAP.setText("");
		textFieldIntestatario.setText("");
		textFieldNumCarta.setText("");
		textFieldScadenza.setText("");
		textFieldCVC.setText("");
	}
}
