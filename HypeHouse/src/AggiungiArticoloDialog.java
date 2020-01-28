import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggiungiArticoloDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_codice;
	private JTextField textField_genere;
	private JTextField textField_categoria;
	private JTextField textField_nome;
	private JTextField textField_colore;
	private JTextField textField_taglia;
	private JTextField textField_prezzo;
	private JTextField textField_quantita;
	private ControllerShop controller;
	
	public AggiungiArticoloDialog(ControllerShop controller) {
		setBounds(100, 100, 438, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Aggiungi");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ControlloCorrettezzaInserimento();
				}
			});
			okButton.setBounds(73, 443, 101, 46);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Chiudi");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChiudiAddArtDialog();
				}
			});
			cancelButton.setBounds(241, 443, 101, 46);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblLogo = new JLabel("logo");
			lblLogo.setBounds(175, 42, 71, 25);
			contentPanel.add(lblLogo);
		}
		{
			JLabel lblCodice = new JLabel("Codice");
			lblCodice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCodice.setBounds(22, 140, 49, 16);
			contentPanel.add(lblCodice);
		}
		{
			textField_codice = new JTextField();
			textField_codice.setBounds(93, 138, 179, 22);
			contentPanel.add(textField_codice);
			textField_codice.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Genere");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(22, 174, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			textField_genere = new JTextField();
			textField_genere.setBounds(93, 172, 179, 22);
			contentPanel.add(textField_genere);
			textField_genere.setColumns(10);
		}
		{
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCategoria.setBounds(22, 203, 63, 25);
			contentPanel.add(lblCategoria);
		}
		{
			textField_categoria = new JTextField();
			textField_categoria.setBounds(93, 207, 179, 22);
			contentPanel.add(textField_categoria);
			textField_categoria.setColumns(10);
		}
		{
			JLabel lblNome = new JLabel("Nome");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNome.setBounds(22, 241, 56, 16);
			contentPanel.add(lblNome);
		}
		{
			textField_nome = new JTextField();
			textField_nome.setBounds(93, 239, 179, 22);
			contentPanel.add(textField_nome);
			textField_nome.setColumns(10);
		}
		{
			JLabel lblColore = new JLabel("Colore");
			lblColore.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblColore.setBounds(22, 274, 56, 16);
			contentPanel.add(lblColore);
		}
		{
			textField_colore = new JTextField();
			textField_colore.setBounds(93, 274, 179, 22);
			contentPanel.add(textField_colore);
			textField_colore.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Taglia");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(22, 303, 56, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_taglia = new JTextField();
			textField_taglia.setBounds(93, 305, 101, 22);
			contentPanel.add(textField_taglia);
			textField_taglia.setColumns(10);
		}
		{
			JLabel lblPrezzo = new JLabel("Prezzo");
			lblPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrezzo.setBounds(22, 341, 56, 16);
			contentPanel.add(lblPrezzo);
		}
		{
			textField_prezzo = new JTextField();
			textField_prezzo.setBounds(93, 338, 101, 22);
			contentPanel.add(textField_prezzo);
			textField_prezzo.setColumns(10);
		}
		{
			JLabel lblQuantit = new JLabel("Quantit\u00E0");
			lblQuantit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuantit.setBounds(22, 373, 56, 16);
			contentPanel.add(lblQuantit);
		}
		{
			textField_quantita = new JTextField();
			textField_quantita.setBounds(93, 371, 101, 22);
			contentPanel.add(textField_quantita);
			textField_quantita.setColumns(10);
		}
		{
			JLabel lblInserireArticoloDa = new JLabel("Inserire articolo da aggiungere al magazzino");
			lblInserireArticoloDa.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblInserireArticoloDa.setBounds(22, 90, 319, 25);
			contentPanel.add(lblInserireArticoloDa);
		}
	}

	private void ChiudiAddArtDialog() {
		
		setVisible(false);
	}
	
	private void ControlloCorrettezzaInserimento() {
		if((textField_codice.getText().length()>0)&&(textField_genere.getText().length()>0)&&(textField_categoria.getText().length()>0)&&(textField_nome.getText().length()>0)&&(textField_colore.getText().length()>0)&&(textField_taglia.getText().length()>0)&&(textField_prezzo.getText().length()>0)&&(textField_quantita.getText().length()>0)){
			controller.AggiungiArticolo(textField_codice.getText(), textField_genere.getText(), textField_categoria.getText(),textField_nome.getText(),textField_colore.getText(),textField_taglia.getText(),textField_prezzo.getText(),textField_quantita.getText());
			textField_codice.setText("");
			textField_genere.setText("");
			textField_categoria.setText("");
			textField_nome.setText("");
			textField_colore.setText("");
			textField_taglia.setText("");
			textField_prezzo.setText("");
			textField_quantita.setText("");
		}
		else
			JOptionPane.showMessageDialog(new JPanel(), "Inserire Valori", "Errore Inserimento",
			        JOptionPane.ERROR_MESSAGE);
	}
}

