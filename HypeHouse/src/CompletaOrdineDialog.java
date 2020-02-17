import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class CompletaOrdineDialog extends JDialog {

	private JPanel contentPanel;
	private ControllerShop ctrl;

	public CompletaOrdineDialog(ControllerShop controller) {
		ctrl=controller;
		setTitle("Magazzino");
		setBounds(100, 100, 858, 616);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(348, 13, 170, 90);
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		getContentPane().setLayout(null);
		lbllogo.setIcon(new ImageIcon(imglogo));
		contentPanel.add(lbllogo);
	}
}
