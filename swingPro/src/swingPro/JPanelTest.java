package swingPro;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class JPanelTest {
	JFrame frm = new JFrame("JPanelTest");
	
	
	JButton btn1 = new JButton("Click"); 
	
	//ImageIcon ii =new ImageIcon("img/ico_001_ds5vvf.png");
	public JPanelTest() {
		
		frm.add(btn1, BorderLayout.NORTH);
		
		
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(4,4,5,5));
		for(int i=1; i<=16;i++) {
			pane.add(new JButton(String.valueOf(i)));
		}
		frm.add(pane,"Center");
		
		//������ ���ڿ� �Է��ϴ� ���۳�Ʈ 
		JTextField tf = new JTextField();
		frm.add(tf,"South");
		
		
		
		JLabel lbl = new JLabel("�޼���");
		frm.add(lbl, "West");
		
//		JLabel lbl2= new JLabel(ii);
//		frm.add(lbl2,"East");
		
		frm.setSize(400,400);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new JPanelTest();
		
	}
	
}
