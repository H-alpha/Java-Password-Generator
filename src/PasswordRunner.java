import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PasswordRunner extends JFrame{
	
	private String version = "v1.1.9";

	private JTextArea output =  new JTextArea(); //output text area
	private JTextField len = new JTextField(); //input text box for generated password length
	private JTextField times = new JTextField(); //input text box for the amount of passwords generated
	private JButton go = new JButton(); //the start button
	private JLabel len_label = new JLabel(), times_label = new JLabel(); //labels for len & times
	private JLabel vlabel = new JLabel(); //version label
	private JScrollPane scroll_out = new JScrollPane (output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //scroll pane for the output box
	private JCheckBox upper = new JCheckBox("Uppercase"), lower = new JCheckBox("Lowercase"), nums = new JCheckBox("Numbers"), sym = new JCheckBox("Symbols"), spaces = new JCheckBox("Spaces"); //check boxes for more customization
	
	public PasswordRunner(){
		setSize(640,480);
		setTitle("Password Generation Tool");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout()); //styling
		getContentPane().setBackground(Color.BLACK); //black background 4 el1te haXXx0rZ
		
		len_label.setText("Length: "); //length label
		len_label.setForeground(Color.WHITE);
		add(len_label);
		
		len.setPreferredSize(new Dimension(96,28)); //length text box
		len.setText("14");
		len.setToolTipText("Length of passwords");
		len.setBackground(new Color(10,10,10));
		len.setForeground(Color.WHITE);
		add(len);
		
		times_label.setText("Times: "); //times label
		times_label.setForeground(Color.WHITE);
		add(times_label);
		
		times.setPreferredSize(new Dimension(96,28)); //times text box
		times.setText("10");
		times.setToolTipText("For redundancy: the amount of passwords to be generated");
		times.setBackground(new Color(10,10,10));
		times.setForeground(Color.WHITE);
		add(times);
		
		go.setText("Start"); //start button
		go.setBackground(Color.BLACK);
		go.setForeground(Color.WHITE);
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
				if(l>80||l<=0){
					output.setText("Invalid password length!");
				}
				else if(t>100||t<=0){
					output.setText("Invalid times value!");
				}
				else{
					String u = ""; //holder for the generated passwords below
					for(int x=0; x<t; x++){
						u+=(PasswordGenerator.generatePasswords(l, upper.isSelected(), lower.isSelected(), nums.isSelected(), sym.isSelected(), spaces.isSelected()));
						u+="\n\n";
					}
					output.setText(u);
				}
			}
			
		});
		add(go);
		
		vlabel.setText(version); //version label
		vlabel.setForeground(Color.WHITE);
		add(vlabel);
		
		output.setEditable(false); //output text box inside scoll container
		output.setBackground(new Color(10,10,10));
		output.setForeground(Color.WHITE); //styling 4 el1t3 h@xxx0rzz
		scroll_out.setPreferredSize(new Dimension(580,380)); //output text area and scrollable container size
		scroll_out.setBackground(Color.BLACK);
		add(scroll_out);
		
		//sets default selection for check boxes
		upper.setSelected(true);
		lower.setSelected(true);
		nums.setSelected(true);
		sym.setSelected(true);
		spaces.setSelected(false);
		
		//setting check box backgrounds to black
		upper.setBackground(Color.BLACK);
		lower.setBackground(Color.BLACK);
		nums.setBackground(Color.BLACK);
		sym.setBackground(Color.BLACK);
		spaces.setBackground(Color.BLACK);
		
		//setting check box text color
		upper.setForeground(Color.WHITE);
		lower.setForeground(Color.WHITE);
		nums.setForeground(Color.WHITE);
		sym.setForeground(Color.WHITE);
		spaces.setForeground(Color.WHITE);
		
		//adding the check boxes
		add(upper);
		add(lower);
		add(nums);
		add(sym);
		add(spaces);

		setVisible(true);
	}
	
	public static void main(String args[]){
		new PasswordRunner();
	}
	
}
