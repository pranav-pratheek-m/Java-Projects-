package pranav.logingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI implements ActionListener{
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel usernameLabel;
	private static JTextField usernameField;
	private static JLabel passwordLabel;
	private static JPasswordField passwordField;
	private static JButton loginButton,resetButton;
	private static JLabel successLabel;
	
	
	
	public static void main(String[] args) {
		
		frame = new JFrame();
		panel = new JPanel();
		
		frame.setSize(600,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10,20,80,25);
		panel.add(usernameLabel);
		
		usernameField = new JTextField(20);
		usernameField.setBounds(100,20,165,25);
		panel.add(usernameField);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
		passwordField = new JPasswordField(20);
		passwordField.setBounds(100,50,165,25);
		panel.add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(10,80,80,25);
		loginButton.addActionListener(new LoginGUI());
		panel.add(loginButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(120,80,80,25);
		resetButton.addActionListener(new LoginGUI());
		panel.add(resetButton);
		
		successLabel = new JLabel("");
		successLabel.setBounds(10,110,300,25);
		panel.add(successLabel);
		
		
		frame.add(panel);
		frame.setVisible(true);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loginButton) {
			   String username = usernameField.getText();
		       String password = passwordField.getText();
		       
		       if(username.equals("PranavMalleboyina") && password.equals("Gre@testPr0grammer")) {
		    	   successLabel.setText("LOGIN IS SUCCESSFUL!!");
		       }else {
		    	   successLabel.setText("INVALID USERNAME OR PASSWORD!!");
		       }
		}else if(e.getSource() == resetButton) {
			   usernameField.setText("");
			   passwordField.setText("");
			   successLabel.setText("");
		}else {
			
		}		
	}
}
