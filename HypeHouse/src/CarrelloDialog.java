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

public class CarrelloDialog extends JDialog {
	private JTable table;
	

	public CarrelloDialog(ControllerShop Controller) {
		setTitle("Carrello");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 880, 610);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(355, 13, 170, 94);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lbllogo.setIcon(new ImageIcon(imglogo));
		getContentPane().add(lbllogo);
		
		JLabel label = new JLabel("");
		label.setBounds(57, 127, 45, 45);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Controller.RitornaAllaHome();
				chiudicarrello();
				
			}
		});
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		label.setIcon(new ImageIcon(imghome));
		getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 185, 607, 284);
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
		

	
		
	
		 
		
	}
	private void chiudicarrello() {
		this.setVisible(false);
	}
}
