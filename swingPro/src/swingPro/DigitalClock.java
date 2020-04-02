package swingPro;

import java.awt.Font;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class DigitalClock extends JFrame {
		Font fnt = new Font("Arial", Font.BOLD+Font.ITALIC,90);
		JLabel time = new JLabel("",JLabel.CENTER);
	public DigitalClock() {
		setTitle("Clock");
		//string 변경해야한다 
		time.setFont(fnt);
		add(time);
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		start();
	}
	public void start() {
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

	public static void main(String[] args) {
		new DigitalClock();

	}

}
