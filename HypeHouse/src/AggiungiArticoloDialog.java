import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AggiungiArticoloDialog extends JDialog {
 
	private final JPanel contentPanel = new JPanel();

	private JTextField CodiceField;
	private JTextField GenereField;
	private JTextField CategoriaField;
	private JTextField NomeField;
	private JTextField ColoreField;
	private JTextField TagliaField;
	private JTextField PrezzoField;
	private JTextField QuantitaField;
	private ControllerShop ctrl;
	
	public AggiungiArticoloDialog(ControllerShop controller) {
		ctrl = controller;
		setBounds(100, 100, 439, 605);
		setTitle("Aggiungi Articolo");
		getContentPane().setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Aggiungi");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ControlloCorrettezzaInserimento();
				}
			});
			okButton.setBounds(93, 486, 101, 46);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Chiudi");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ctrl.SvuotaTabellaMgazzino();
					ctrl.AggiornaTabellaMagazzino();
					ctrl.AggiungiArticoloDialog(false);
				}
			});
			cancelButton.setBounds(267, 486, 101, 46);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblLogo = new JLabel("");
			lblLogo.setBounds(123, 13, 170, 64);
			Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
			getContentPane().setLayout(null);
			lblLogo.setIcon(new ImageIcon(imglogo));
			contentPanel.add(lblLogo);
		}
		{
			JLabel lblCodice = new JLabel("Codice");
			lblCodice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCodice.setBounds(22, 140, 49, 16);
			contentPanel.add(lblCodice);
		}
		{
			CodiceField = new JTextField();
			CodiceField.setBounds(93, 138, 179, 22);
			contentPanel.add(CodiceField);
			CodiceField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Genere");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(22, 174, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			GenereField = new JTextField();
			GenereField.setBounds(93, 172, 179, 22);
			contentPanel.add(GenereField);
			GenereField.setColumns(10);
		}
		{
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCategoria.setBounds(22, 203, 63, 25);
			contentPanel.add(lblCategoria);
		}
		{
			CategoriaField = new JTextField();
			CategoriaField.setBounds(93, 207, 179, 22);
			contentPanel.add(CategoriaField);
			CategoriaField.setColumns(10);
		}
		{
			JLabel lblNome = new JLabel("Nome");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNome.setBounds(22, 241, 56, 16);
			contentPanel.add(lblNome);
		}
		{
			NomeField = new JTextField();
			NomeField.setBounds(93, 239, 179, 22);
			contentPanel.add(NomeField);
			NomeField.setColumns(10);
		}
		{
			JLabel lblColore = new JLabel("Colore");
			lblColore.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblColore.setBounds(22, 274, 56, 16);
			contentPanel.add(lblColore);
		}
		{
			ColoreField = new JTextField();
			ColoreField.setBounds(93, 274, 179, 22);
			contentPanel.add(ColoreField);
			ColoreField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Taglia");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(22, 303, 56, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			TagliaField = new JTextField();
			TagliaField.setBounds(93, 305, 101, 22);
			contentPanel.add(TagliaField);
			TagliaField.setColumns(10);
		}
		{
			JLabel lblPrezzo = new JLabel("Prezzo");
			lblPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrezzo.setBounds(22, 341, 56, 16);
			contentPanel.add(lblPrezzo);
		}
		{
			PrezzoField = new JTextField();
			PrezzoField.setBounds(93, 338, 101, 22);
			contentPanel.add(PrezzoField);
			PrezzoField.setColumns(10);
		}
		{
			JLabel lblQuantit = new JLabel("Quantit\u00E0");
			lblQuantit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuantit.setBounds(22, 373, 56, 16);
			contentPanel.add(lblQuantit);
		}
		{
			QuantitaField = new JTextField();
			QuantitaField.setBounds(93, 371, 101, 22);
			contentPanel.add(QuantitaField);
			QuantitaField.setColumns(10);
		}
		{
			JLabel lblInserireArticoloDa = new JLabel("Inserire articolo da aggiungere al magazzino");
			lblInserireArticoloDa.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblInserireArticoloDa.setBounds(22, 90, 319, 25);
			contentPanel.add(lblInserireArticoloDa);
		}
		
//		JButton btnSeleFoto = new JButton("Carica foto");
//		btnSeleFoto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				instanziaFileChooser();
//			}
//		});
//		btnSeleFoto.setBounds(93, 410, 101, 25);
//		contentPanel.add(btnSeleFoto);
	}

	private void ControlloCorrettezzaInserimento() {
		if((CodiceField.getText().length()>0)&&(GenereField.getText().length()>0)&&(CategoriaField.getText().length()>0)&&(NomeField.getText().length()>0)&&(ColoreField.getText().length()>0)&&(TagliaField.getText().length()>0)&&(PrezzoField.getText().length()>0)&&(QuantitaField.getText().length()>0)){
//		    ctrl.AggiungiArticoloMagazzino(CodiceField.getText(), GenereField.getText(), CategoriaField.getText(), NomeField.getText(), ColoreField.getText(), TagliaField.getText(), PrezzoField.getText(), QuantitaField.getText());
		    ctrl.AggiungiArticoloDatabase(CodiceField.getText(), GenereField.getText(), CategoriaField.getText(), NomeField.getText(), ColoreField.getText(), TagliaField.getText(), PrezzoField.getText(), QuantitaField.getText());
			CodiceField.setText("");
			GenereField.setText("");
			CategoriaField.setText("");
			NomeField.setText("");
			ColoreField.setText("");
			TagliaField.setText("");
			PrezzoField.setText("");
			QuantitaField.setText("");

		}
		else
			ctrl.ErroreDialog("Inserire correttamente i valori.", "Errore Inserimento");
	}
//	public void instanziaFileChooser() {
//		JFileChooser fc = new JFileChooser();
//		fc.setMultiSelectionEnabled(true);
//		int returnVal = fc.showOpenDialog(null);
//		
//			if (returnVal == JFileChooser.APPROVE_OPTION) { 
//			  File[] file = fc.getSelectedFiles(); //This is where a real application would open the
//			  System.out.println(file[1].getAbsolutePath());
//			  	try {
//			  		Class.forName("com.mysql.cj.jdbc.Driver");
//			  		Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql1.gear.host:3306/hypehousedb","hypehousedb","!abc123!"); 
//			  			for(File cont : file) {
//			  				try { 
//			  					String updateSQL ="INSERT INTO fotoarticolo (IdFoto,CodiceBarre,Foto) VALUES " + "('1','1',?)";
//			  					PreparedStatement pstmt = con.prepareStatement(updateSQL); // read the file
//			  					FileInputStream input = new FileInputStream(cont); // set parameters
//			  					pstmt.setBinaryStream(1, input); pstmt.executeUpdate();
//			  					}
//			  				catch(Exception ex){ ex.printStackTrace();}
//		    
//			  								  }
//			         } 
//			  	catch (Exception e1) {}
//															}
//										}
		}

