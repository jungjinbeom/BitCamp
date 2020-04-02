package swingPro;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalLayout extends JFrame implements ActionListener{
	Font fnt = new Font("±Ã¼­Ã¼",Font.BOLD+Font.ITALIC,20);
	public CalLayout() {
		JLabel lbl = new JLabel("0.0",JLabel.RIGHT);
	lbl.setFont(fnt);
		add(lbl, "North");
	
		

		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(1,3));
	
		JButton btn1 =new JButton("Backspace");
		JButton btn2 =new JButton("Clear");
		JButton btn3 =new JButton("End");
	
		pane2.add(btn1);
		pane2.add(btn2);
		pane2.add(btn3);
		
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(4,4));
		JButton but7 = new JButton("7");
		JButton but8 = new JButton("8");
		JButton but9 = new JButton("9");
		JButton but4 = new JButton("4");
		JButton but5 = new JButton("5");
		JButton but6 = new JButton("6");
		JButton but1 = new JButton("1");
		JButton but2 = new JButton("2");
		JButton but3 = new JButton("3");
		JButton butp = new JButton("+");
		JButton butm = new JButton("-");
		JButton butmt = new JButton("*");
		JButton but0 = new JButton("0");
		JButton butz = new JButton(".");
		JButton bute = new JButton("=");
		JButton butdi = new JButton("/");
		
		pane.add(but7);
		pane.add(but8);
		pane.add(but9);
		pane.add(butp);
		pane.add(but4);
		pane.add(but5);
		pane.add(but6);
		pane.add(butm);
		pane.add(but1);
		pane.add(but2);
		pane.add(but3);
		pane.add(butmt);
		pane.add(but0);
		pane.add(butz);
		pane.add(bute);
		pane.add(butdi);
		
	
		
		
		add(pane,"South");
		add(pane2,"Center");
		
		
		
		
		pane2.add(btn1);
		pane2.add(btn2);
		pane2.add(btn3);
	
		
			setSize(300,200);
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				
		
		
		
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		
	}

	public static void main(String[] args) {
			new  CalLayout();
	}

}
