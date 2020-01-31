import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarrelloDialog extends JDialog {

	public CarrelloDialog(ControllerShop Controller) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 832, 589);
		getContentPane().setLayout(null);
		
		JLabel lbllogo = new JLabel("");
		Image imglogo = new ImageIcon(this.getClass().getResource("/logofinals.jpeg")).getImage();
		lbllogo.setIcon(new ImageIcon(imglogo));
		lbllogo.setBounds(320, 24, 170, 101);
		getContentPane().add(lbllogo);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Controller.RitornaAllaHome();
				chiudicarrello();
				
			}
		});
		label.setBounds(78, 141, 45, 45);
		Image imghome = new ImageIcon(this.getClass().getResource("/homeLabel.png")).getImage();
		label.setIcon(new ImageIcon(imghome));
		getContentPane().add(label);
		
		 
		
	}
	private void chiudicarrello() {
		this.setVisible(false);
	}
}
