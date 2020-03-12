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
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CarrelloDialog extends JDialog {
	public JTable table;
	private final JPanel contentPanel = new JPanel();
	private ControllerShop ctrl;
	private JLabel labeltotalepagamento;
	private JLabel lblMessaggio;
	private Utente utente;

	public CarrelloDialog(ControllerShop controller, Utente user) {
		ctrl=controller;
		utente = user;
		setTitle("Carrello");
		contentPanel.setForeground(new Color(255, 0, 0));
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
				//controlla se info articolo è aperta quindi chiudi stesso con negozio
				if(ctrl.articolodialog != null) {
					ctrl.VisibilitaArticoloDialog(false);
				}
				else if (ctrl.negoziodialog.isVisible() == true) {
					ctrl.negoziodialog.setVisible(false);
				}
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
				"", "CodiceBare", "Nome", "Colore", "Genere", "Taglia", "Prezzo", "Quantità"
			}
		) {
			Class[] columnTypes = new Class[] {
					Boolean.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class
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
		
		JButton btnSvuotaCarrello = new JButton("Svuota e torna alla Home");
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
		
		JButton btnEliminaArticoloSelezionato = new JButton("Rimuovi articoli \r\n");
		btnEliminaArticoloSelezionato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selezione = ControllaCheckSelezionate();
				if(selezione != 0) {
					lblMessaggio.setVisible(false);
					RimuoviArticoliSelezionatiCarrello();
					ctrl.AggiornaTabellaCarrello();
				}
				else
					lblMessaggio.setVisible(true);
			}
		});
		btnEliminaArticoloSelezionato.setBounds(393, 542, 127, 52);
		contentPanel.add(btnEliminaArticoloSelezionato);
		
		JButton btnComplOrdine = new JButton("Completa ordine");
		btnComplOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//crea ordine e rimuovi le quantità scelte dal database per ogni articolo
				if (user != null) {
					ControlloProseguiOrdine();
//					if(ctrl.articolodialog != null) {
//						ctrl.VisibilitaArticoloDialog(false);
//					}
//					else if (ctrl.negoziodialog != null) {
//						ctrl.negoziodialog.setVisible(false);
//					}
//					if (ctrl.homeframe.isVisible() == true) {
//						ctrl.VisibilitaHome(false);
//					}
					
//					ctrl.carrellodialog.setVisible(false);
//					ctrl.completaordine.setVisible(true);
				}
				else
					ctrl.VisibilitaLoginDialog(true);
			}
		});
		btnComplOrdine.setBounds(567, 543, 127, 50);
		contentPanel.add(btnComplOrdine);
		
		lblMessaggio = new JLabel("nessuna check selezionata");
		lblMessaggio.setForeground(new Color(255, 0, 0));
		lblMessaggio.setBounds(393, 603, 127, 14);
		contentPanel.add(lblMessaggio);
		lblMessaggio.setVisible(false);
	}
	
	public void AggiungiArticoloaTableCarrello(Articolo art) {
		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
		dtm.addRow(new Object[] {false, art.getCodiceBarre(), art.getNome(), art.getColore(), art.getGenere(), art.getTaglia(), art.getPrezzo(), art.getQuantita()});
	}
	
	public void SvuotaTabellaCarrello() {
		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
		dtm.setRowCount(0);
	}
	
	private void RimuoviArticoliSelezionatiCarrello() {
		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
		int j = 0;
		for(int i=0; i<dtm.getRowCount(); i++) {
			if((Boolean)dtm.getValueAt(i, 0)==true) {
				ctrl.ReimpostaQuantita((String)dtm.getValueAt(i, 1), (Integer)dtm.getValueAt(i, 7));
				ctrl.RimuoviArticoloCarrello(j);
				j--;
			}
			j++;
		}
	}
	
	private void ControlloProseguiOrdine() {
		Double tot = new Double(labeltotalepagamento.getText());
		boolean presente = ctrl.ControlloPresenzaArticoliCarrello(utente, tot);
		if (presente == true) {
			if(ctrl.articolodialog != null) {
				ctrl.VisibilitaArticoloDialog(false);
			}
			else if (ctrl.negoziodialog != null) {
				ctrl.negoziodialog.setVisible(false);
			}
			if (ctrl.homeframe.isVisible() == true) {
				ctrl.VisibilitaHome(false);
			}
		}
		else
			ctrl.ErroreDialog("Non ci sono articoli nel tuo carrello.", "Errore");
	}
	
	private int ControllaCheckSelezionate() {
		int selezionati = 0;
		DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
		for(int i=0; i<dtm.getRowCount(); i++) {
			if((Boolean)dtm.getValueAt(i, 0)==true)
				selezionati++;
		}
		return selezionati;
	}
	
	public void setTotaleCarrello () {
		Double tmp = ctrl.SommaTotaleCarrello();
		labeltotalepagamento.setText(tmp.toString());
	}
}
