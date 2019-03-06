
// Juan Pablo Velazco Velaquez
// Mayra Patricia Guajardo Palomera
//Comentario: Luis Gerardo nos asesoro con la explicacion del problema

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class controlHanoi extends JPanel {
	private JButton start;
	private JTextField text;

	public controlHanoi(panelHanoi p) {
		super();
		this.setPreferredSize(new Dimension(900, 60));
		this.text = new JTextField(5);
		this.start = new JButton("Inicio");
		this.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.disk(Integer.parseInt(text.getText()));
			}
		});

		this.add(this.text);
		this.add(this.start);
	}
}