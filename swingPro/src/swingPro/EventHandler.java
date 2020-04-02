package swingPro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventHandler implements ActionListener{
	JTextArea ta;
	//이벤트처리 클래스 
	public EventHandler() {	
	}
	public EventHandler(JTextArea ta) {
		this.ta = ta;
	}
	public void actionPerformed(ActionEvent ae){
		JTextField tf =(JTextField) ae.getSource();
		
		//setText() : 세로셋팅 , append() : 추가;
		ta.append(tf.getText()+"\n");
		tf.setText("");
		
	}	
}
