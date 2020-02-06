import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableMagazzino;
	private JLabel lblNomeAdmin;
	private ControllerShop ctrl;
	
	public MagazzinoFrame(ControllerShop controller) {
		ctrl=controller;
		setTitle("Magazzino");
		setBounds(100, 100, 858, 616);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Esci");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.VisibilitaHome(true);
				ctrl.ChiudiMagazzino();
			}
		});
		btnNewButton.setBounds(743, 90, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNomeAdmin = new JLabel("");
		lblNomeAdmin.setBounds(655, 94, 78, 14);
		contentPane.add(lblNomeAdmin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 126, 822, 333);
		contentPane.add(scrollPane);
		
		tableMagazzino = new JTable();
		tableMagazzino.setColumnSelectionAllowed(true);
		tableMagazzino.setModel(new DefaultTableModel(
			new Object[][] {
				,
			},
			new String[] {
				"", "Barcode", "Genere", "Categoria", "Nome", "Colore", "Taglia", "Prezzo", "Quantit\u00E0"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableMagazzino);
			
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.AggiungiArticoloDialog(true);
			}
		});
		btnAggiungi.setBounds(118, 500, 108, 23);
		contentPane.add(btnAggiungi);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBounds(275, 500, 108, 23);
		contentPane.add(btnModifica);
		
		JButton btnSvuota = new JButton("Svuota");
		btnSvuota.setBounds(617, 500, 108, 23);
		contentPane.add(btnSvuota);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(336, 13, 170, 79);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lblLogo.setIcon(new ImageIcon(imglogo));
		contentPane.add(lblLogo);
	}
	
	public void AggiungiArticoloaTableMagazzino(Articolo a) {
		DefaultTableModel dtm = (DefaultTableModel) this.tableMagazzino.getModel();
		dtm.addRow(new Object[] {a.getCodiceBarre(), a.getGenere(), a.getCategoria(), a.getNome(), a.getColore(), a.getTaglia(), a.getPrezzo(), a.getQuantita()});
	}
	
	public void SetLabelNomeAdmin(String nomeadmin) {
		lblNomeAdmin.setText(nomeadmin);
	}
}
