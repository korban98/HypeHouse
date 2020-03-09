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
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CarrelloDialog extends JDialog {
	private JTable table;
	private final JPanel contentPanel = new JPanel();
	private ControllerShop ctrl;
	private JLabel labeltotalepagamento;

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
		lblhome.setBounds(51, 118, 45, 45);
		lblhome.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ctrl.VisualizzaCarrelloDialog(false);
				ctrl.VisibilitaArticoloDialog(false);
				ctrl.negoziodialog.setVisible(false);
				ctrl.VisibilitaHome(true);
			}
		});
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		lblhome.setIcon(new ImageIcon(imghome));
		getContentPane().add(lblhome);
		
		JLabel lbltornaindietro = new JLabel("");
		lbltornaindietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.VisualizzaCarrelloDialog(false);
			}
		});
		lbltornaindietro.setBounds(106, 118, 46, 45);
		contentPanel.add(lbltornaindietro);
		Image imgarrow = new ImageIcon(this.getClass().getResource("/arrowimg.png")).getImage();
		lbltornaindietro.setIcon(new ImageIcon(imgarrow));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 180, 801, 284);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Nome", "Colore", "Genere", "Taglia", "Prezzo", "Quantità"
			}
		) {
			Class[] columnTypes = new Class[] {
					Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class
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
		
		labeltotalepagamento = new JLabel("");
		labeltotalepagamento.setBounds(701, 479, 56, 16);
		contentPanel.add(labeltotalepagamento);
		
		JButton btnSvuotaCarrello = new JButton("Svuota e\r\n torna alla Home");
		btnSvuotaCarrello.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSvuotaCarrello.setHorizontalAlignment(SwingConstants.LEFT);
		btnSvuotaCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input = JOptionPane.showConfirmDialog(null,"Sicuro di voler svuotare il tuo carrello?", "Attenzione", JOptionPane.YES_NO_OPTION);
				if(input==0) {
					SvuotaTabellaCarrello();
					ctrl.homeframe = new HomePageFrame(ctrl);
					ctrl.VisibilitaHome(true);
					ctrl.VisualizzaCarrelloDialog(false);
					ctrl.VisibilitaArticoloDialog(false);
				}
			}
		});
		btnSvuotaCarrello.setBounds(190, 542, 153, 52);
		contentPanel.add(btnSvuotaCarrello);
		
		JButton btnEliminaArticoloSelezionato = new JButton("Elimina articolo \r\n");
		btnEliminaArticoloSelezionato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminaArticoloSelezionato.setBounds(393, 542, 127, 52);
		contentPanel.add(btnEliminaArticoloSelezionato);
		
		JButton btnNewButton = new JButton("Completa ordine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(567, 543, 127, 50);
		contentPanel.add(btnNewButton);
	}
	
	public void AggiungiArticoloaTableCarrello(Articolo art) {
		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
		dtm.addRow(new Object[] {false, art.getNome(), art.getColore(), art.getGenere(), art.getTaglia(), art.getPrezzo(), art.getQuantita()});
	}
	
	public void SvuotaTabellaCarrello() {
		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
		dtm.setRowCount(0);
	}
	
	public void setTotaleCarrello () {
		
	}
}
