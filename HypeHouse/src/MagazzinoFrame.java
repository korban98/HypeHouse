import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	public JTable tableMagazzino;
	private JLabel lblNomeAdmin;
	private JLabel lblErroreSelezione;
	private ControllerShop ctrl;
	
	public MagazzinoFrame(ControllerShop controller) {
		ctrl=controller;
		setTitle("Magazzino");
		setBounds(100, 100, 858, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		scrollPane.setBounds(10, 121, 822, 251);
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
		btnAggiungi.setBounds(127, 397, 108, 23);
		contentPane.add(btnAggiungi);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int checkselezionata = ControllaCheckSelezionate();
				if(checkselezionata==1) {
					lblErroreSelezione.setText("");
					//modifica quantita.
					ctrl.ModificaArticoloMagazzino(ArticoloDaModificare());
				}
				else if(checkselezionata>1) {
					ctrl.SvuotaTabellaMgazzino();
					ctrl.AggiornaTabellaMagazzino();
					lblErroreSelezione.setText("Selezionare un solo articolo.");
				}
				else
					lblErroreSelezione.setText("Nessun articolo selezionato.");
			}
		});
		btnModifica.setBounds(274, 397, 108, 23);
		contentPane.add(btnModifica);
		
		JButton btnSvuota = new JButton("Svuota");
		btnSvuota.setBounds(615, 397, 108, 23);
		contentPane.add(btnSvuota);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(336, 13, 170, 79);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lblLogo.setIcon(new ImageIcon(imglogo));
		contentPane.add(lblLogo);
		
		lblErroreSelezione = new JLabel("");
		lblErroreSelezione.setForeground(Color.red);
		lblErroreSelezione.setBounds(392, 401, 196, 14);
		contentPane.add(lblErroreSelezione);
	}
	
	private String ArticoloDaModificare() {
		DefaultTableModel dtm = (DefaultTableModel) this.tableMagazzino.getModel();
		String nome=null;
		for(int i=0; i<dtm.getRowCount(); i++) {
			if((Boolean)dtm.getValueAt(i, 0)==true)
				nome = (String)dtm.getValueAt(i, 1);
		}
		return nome;
	}
	
	private int ControllaCheckSelezionate() {
		int selezionati = 0;
		DefaultTableModel dtm = (DefaultTableModel) this.tableMagazzino.getModel();
		for(int i=0; i<dtm.getRowCount(); i++) {
			if((Boolean)dtm.getValueAt(i, 0)==true)
				selezionati++;
		}
		return selezionati;
	}
	
	public void AggiungiArticoloaTableMagazzino(Articolo a) {
		DefaultTableModel dtm = (DefaultTableModel) this.tableMagazzino.getModel();
		dtm.addRow(new Object[] {false, a.getCodiceBarre(), a.getGenere(), a.getCategoria(), a.getNome(), a.getColore(), a.getTaglia(), a.getPrezzo(), a.getQuantita()});
	}
	
	public void SetLabelNomeAdmin(String nomeadmin) {
		lblNomeAdmin.setText(nomeadmin);
	}
}
