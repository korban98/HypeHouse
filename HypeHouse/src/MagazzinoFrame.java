import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public MagazzinoFrame(ControllerShop ctrl) {
		setBounds(100, 100, 858, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Esci");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(743, 90, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome_Admin");
		lblNewLabel.setBounds(655, 94, 78, 14);
		contentPane.add(lblNewLabel);
		
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
	
//		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
//		scrollPane.setRowHeaderView(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("Aggiungi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(320, 11, 233, 79);
		contentPane.add(lblLogo);
	}
}
