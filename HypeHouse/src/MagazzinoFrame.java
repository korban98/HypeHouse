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
	private JTable table;
	private JLabel lblNomeAdmin;
	
	public MagazzinoFrame(ControllerShop ctrl) {
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
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table);
			
		JButton btnNewButton_1 = new JButton("Aggiungi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.AggiungiArticoloDialog();
			}
		});
		btnNewButton_1.setBounds(127, 397, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifica");
		btnNewButton_2.setBounds(274, 397, 108, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnSvuota = new JButton("Svuota");
		btnSvuota.setBounds(615, 397, 108, 23);
		contentPane.add(btnSvuota);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(336, 13, 170, 79);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lblLogo.setIcon(new ImageIcon(imglogo));
		contentPane.add(lblLogo);
	}
	
	public void SetLabelNomeAdmin(String nomeadmin) {
		lblNomeAdmin.setText(nomeadmin);
	}
}
