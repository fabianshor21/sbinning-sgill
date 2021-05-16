package page;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
//
public class Lobby extends JFrame {
	public Lobby() {
		JLabel border = new JLabel();
		//
		this.setTitle("Sbinning Sgill");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,500);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#282a36"));
		this.setLayout(new BorderLayout());
		//
		border.setBorder(BorderFactory.createLineBorder(Color.decode("#8be9fd"),1));
		//
		this.add(border);
		this.setVisible(true);
	}
}
