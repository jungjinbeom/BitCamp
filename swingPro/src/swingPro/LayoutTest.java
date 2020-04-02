package swingPro;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutTest extends JFrame {

	public LayoutTest() {
		//레이아웃 변경
		//setLayout (new FlowLayout());
		setLayout (new GridLayout(4,0,5,5));
		
		for(int i = 1 ; i <=9 ; i++) {
			JButton but = new JButton(String.valueOf(i));
			add(but);
			
		}
		
		setSize(300,300);
		setVisible(true);
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	

	public static void main(String[] args) {
		new LayoutTest();
	}

}
