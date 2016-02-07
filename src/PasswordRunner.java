import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PasswordRunner extends JFrame{
	
	private String version = "v1.0.0";

	private JTextArea output =  new JTextArea(); //output text area
	private JTextField len = new JTextField(); //input text box for generated password length
	private JTextField times = new JTextField(); //input text box for the amount of passwords generated
	private JButton go = new JButton(); //the start button
	private JLabel len_label = new JLabel(), times_label = new JLabel(); //labels for len & times
	private JLabel vlabel = new JLabel(); //version label
	
	
	public PasswordRunner(){
		setSize(640,480);
		setTitle("Password Generation Tool");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		len_label.setText("Length: ");
		add(len_label);
		
		len.setPreferredSize(new Dimension(96,28));
		len.setText("14");
		len.setToolTipText("Length of passwords");
		add(len);
		
		times_label.setText("Times: ");
		add(times_label);
		
		times.setPreferredSize(new Dimension(96,28));
		times.setText("10");
		times.setToolTipText("For redundancy: the amount of passwords to be generated");
		add(times);
		
		go.setText("Start");
		go.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int l = 0,t = 0;
				try{
					l = Integer.parseInt(len.getText());
					t = Integer.parseInt(times.getText());
				}catch(Exception e){
					output.setText("Invalid input!");
				}
				if(l>65||l<=0){
					output.setText("Invalid password length!");
				}
				else if(t>12||t<=0){
					output.setText("Invalid times value!");
				}
				else{
					output.setText(PasswordGenerator.generatePasswords(l, t));
				}
			}
			
		});
		add(go);
		
		vlabel.setText(version);
		add(vlabel);
		
		output.setEditable(false);
		output.setPreferredSize(new Dimension(480,380));
		add(output);

		
		setVisible(true);
	}
	
	public static void main(String args[]){
		new PasswordRunner();
	}
	
}
