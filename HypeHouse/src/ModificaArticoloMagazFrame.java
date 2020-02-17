import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JSeparator;

public class ModificaArticoloMagazFrame extends JDialog {
	private ControllerShop ctrl;
	private JSpinner spinner;
	private String codBarre;

	public ModificaArticoloMagazFrame(ControllerShop controller, String CodiceBarre) {
		ctrl = controller;
		codBarre = CodiceBarre;
		setTitle("Modifica magazzino");
		setBounds(100, 100, 468, 241);
		getContentPane().setLayout(null);
		
		JLabel lblRimuoviArticoloDal = new JLabel("Rimuovi articolo dal Magazzino");
		lblRimuoviArticoloDal.setForeground(Color.RED);
		lblRimuoviArticoloDal.setBounds(77, 133, 200, 22);
		getContentPane().add(lblRimuoviArticoloDal);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean eliminato = ctrl.RimuoviArticoloMagazzino(CodiceBarre);
				if(eliminato==true) {
					ctrl.SvuotaTabellaMgazzino();
					ctrl.AggiornaTabellaMagazzino();
					setVisible(false);
				}
				else {
					ctrl.ErroreDialog("Articolo non rimosso correttamente.", "Errore");
				}
			}
		});
		btnRimuovi.setBounds(275, 133, 104, 23);
		getContentPane().add(btnRimuovi);
		
		JLabel lblAggiungidiminuisciQuantitIn = new JLabel("Aggiungi/Diminuisci quantit\u00E0 in Magazzino");
		lblAggiungidiminuisciQuantitIn.setBounds(30, 34, 247, 31);
		getContentPane().add(lblAggiungidiminuisciQuantitIn);
		 
		int qntiniziale= ctrl.getQuantitaArticoloDatabase(codBarre); 
		SpinnerNumberModel modelSpinner = new SpinnerNumberModel(qntiniziale, 1, 99999, 1);
		spinner = new JSpinner(modelSpinner);
		spinner.setBounds(273, 36, 54, 26);
		getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean modificaok = ctrl.ModificaQuantitaArticoloDatabase(spinner.getValue().toString(), codBarre);
				if(modificaok==true) {
					ctrl.SvuotaTabellaMgazzino();
					ctrl.AggiornaTabellaMagazzino();
					setVisible(false);
				}
				else {
					ctrl.ErroreDialog("Modifica non effettuata correttamente.", "Errore");
				}
			}
		});
		btnNewButton.setBounds(337, 38, 91, 23);
		getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 110, 420, 8);
		getContentPane().add(separator);
	}
}
