import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaArticoloMagazFrame extends JDialog {
	public JTextField quantitaField;
	private ControllerShop ctrl;

	public ModificaArticoloMagazFrame(ControllerShop controller, String CodiceBarre) {
		ctrl = controller;
		setBounds(100, 100, 468, 203);
		getContentPane().setLayout(null);
		
		JLabel lblRimuoviArticoloDal = new JLabel("Rimuovi articolo dal Magazzino");
		lblRimuoviArticoloDal.setForeground(Color.RED);
		lblRimuoviArticoloDal.setBounds(59, 100, 200, 22);
		getContentPane().add(lblRimuoviArticoloDal);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean eliminato = ctrl.RimuoviArticoloMagazzino(CodiceBarre);
				if(eliminato==true) {
					ctrl.SvuotaTabellaMgazzino();
					ctrl.AggiornaTabellaMagazzino();
					ctrl.modificamagaz.setVisible(false);
					
				}
				else {
					ctrl.ErroreDialog("Articolo non rimosso correttamente.", "Errore");
				}
			}
		});
		btnRimuovi.setBounds(269, 100, 104, 23);
		getContentPane().add(btnRimuovi);
		
		quantitaField = new JTextField();
		quantitaField.setBounds(323, 36, 50, 20);
		getContentPane().add(quantitaField);
		quantitaField.setColumns(10);
		
		JLabel lblAggiungidiminuisciQuantitIn = new JLabel("Aggiungi/Diminuisci quantit\u00E0 in Magazzino");
		lblAggiungidiminuisciQuantitIn.setBounds(24, 31, 238, 31);
		getContentPane().add(lblAggiungidiminuisciQuantitIn);
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.setBounds(269, 35, 41, 23);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("+");
		button.setBounds(383, 35, 41, 23);
		getContentPane().add(button);
	}
}
