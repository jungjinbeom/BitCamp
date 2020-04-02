package swingPro;


import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class DigitalClock2 extends JPanel implements Runnable{
		Font fnt = new Font("Arial", Font.BOLD+Font.ITALIC,90);
		JLabel time = new JLabel("",JLabel.CENTER);
		
	
		
	public DigitalClock2() {
		this(0,0);
	}
	public DigitalClock2(int x , int y) {
		//super(DigitalClock);
		setLayout(new BorderLayout());//flowLayout--> borderLayout으로 변경 
		time.setFont(fnt);
		add(time);
		//setBounds(x, y, 500,200);
		setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void run() {
		while(true) {
			setTime();
			try {
				Thread.sleep(1000);
				
			}catch(Exception e){
			
			}
		}
	}
		public void setTime() {
			Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 	
		String sdfTxt = sdf.format(now.getTime());
		time.setText(sdfTxt);
	}
}
