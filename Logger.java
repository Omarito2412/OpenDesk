import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;


public class Logger implements ActionListener{
	private JTextField Texts[];
	public Logger() {
		JFrame mainView = new JFrame();
		mainView.setSize(new Dimension(800,800));
		mainView.setVisible(true);
		mainView.setLayout(new GridBagLayout());
		Texts = new JTextField[4];
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
		Texts[0] = Text1;
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
		Texts[1] = Text2;
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
		Texts[2] = Text3;
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
		Texts[3] = Text4; 
		mainView.add(Text4, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(this);
		mainView.add(Submit,c);
	}
	public void actionPerformed(ActionEvent e){
		try {this.Verify();} catch(Exception E){};
		
	}
	private void Verify() throws Exception{
		URL server = new URL(Texts[0].getText());
		HttpURLConnection handle = (HttpURLConnection) server.openConnection();
		handle.setRequestMethod("POST");
		String params = "project="+Texts[1].getText()+"&username="+Texts[2].getText()+"&password="+Texts[3].getText();
		handle.setDoOutput(true);
		handle.setRequestProperty("Accept-Charset", "UTF-8");
		handle.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + "UTF-8");
		OutputStream output = handle.getOutputStream();
		output.write(params.getBytes("UTF-8"));
		InputStream Response = handle.getInputStream();
	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(Response, "UTF-8"))) {
	        for (String line; (line = reader.readLine()) != null;) {
	        	System.out.println(line);
	        }
	    }
	}
	public static void main(String args[]){
		Logger g = new Logger();
	}
}
