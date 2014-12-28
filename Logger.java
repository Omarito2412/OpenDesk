import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Logger implements ActionListener{

	public Logger() {
		JFrame mainView = new JFrame();
		mainView.setSize(new Dimension(800,800));
		mainView.setVisible(true);
		mainView.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = 40;
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0;
		c.gridy = 0;
		JLabel Label1 = new JLabel("Server");
		mainView.add(Label1, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		JTextField Text1 = new JTextField(256);
		mainView.add(Text1, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		JLabel Label2 = new JLabel("Project");
		mainView.add(Label2, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		JTextField Text2 = new JTextField(64);
		mainView.add(Text2, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		JLabel Label3 = new JLabel("Username");
		mainView.add(Label3, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		JTextField Text3 = new JTextField(64);
		mainView.add(Text3, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		JLabel Label4 = new JLabel("Password");
		mainView.add(Label4, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		JPasswordField Text4 = new JPasswordField(256);
		mainView.add(Text4, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(this);
		mainView.add(Submit,c);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("WOHOO");
	}
	public static void main(String args[]){
		Logger g = new Logger();
	}
}
