package pranav.javaGUIProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyGUI implements ActionListener {
	
	int count;
	JFrame  frame;
	JPanel panel;
	JButton button;
	JLabel label;
	
	public MyGUI() {
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton("Click me!!");
		label = new JLabel("No of times Clicked: 0");
		
		button.addActionListener(this);
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Own GUI");
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new MyGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("No of times Clicked: " + count);
	}
}
