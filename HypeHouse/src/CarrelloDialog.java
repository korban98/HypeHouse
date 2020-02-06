import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarrelloDialog extends JDialog {
	private JTable table;
	private final JPanel contentPanel = new JPanel();
	private ControllerShop ctrl;

	public CarrelloDialog(ControllerShop controller) {
		ctrl=controller;
		setTitle("Carrello");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 880, 657);
		setContentPane(contentPanel);
		this.setResizable(false);
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(325, 13, 210, 108);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinalsmax.jpeg")).getImage();
		getContentPane().setLayout(null);
		lbllogo.setIcon(new ImageIcon(imglogo));
		getContentPane().add(lbllogo);
		
		JLabel lblhome = new JLabel("");
		lblhome.setBounds(62, 124, 45, 45);
		lblhome.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ctrl.VisualizzaCarrelloDialog(false);
				ctrl.VisibilitaHome(true);
				
				
			}
		});
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		lblhome.setIcon(new ImageIcon(imghome));
		getContentPane().add(lblhome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 176, 607, 284);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Nome", "Colore", "Taglia", "Prezzo", "Quantità"
			}
		) {
			Class[] columnTypes = new Class[] {
					Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
				});
		scrollPane.setViewportView(table);
		
		JLabel lblTotale = new JLabel("Totale:");
		lblTotale.setBounds(661, 479, 45, 16);
		contentPanel.add(lblTotale);
		
		JLabel labelotalepagamento = new JLabel("");
		labelotalepagamento.setBounds(701, 479, 56, 16);
		contentPanel.add(labelotalepagamento);
		
		JButton btnSvuotaCarrello = new JButton("Svuota carrello");
		btnSvuotaCarrello.setBounds(140, 510, 127, 52);
		contentPanel.add(btnSvuotaCarrello);
		
		JButton btnEliminaArticoloSelezionato = new JButton("Elimina articolo \r\n");
		btnEliminaArticoloSelezionato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminaArticoloSelezionato.setBounds(325, 510, 127, 52);
		contentPanel.add(btnEliminaArticoloSelezionato);
		
		JButton btnNewButton = new JButton("Completa ordine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(514, 511, 127, 50);
		contentPanel.add(btnNewButton);
	}
}
