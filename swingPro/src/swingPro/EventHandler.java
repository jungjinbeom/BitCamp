package swingPro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventHandler implements ActionListener{
	JTextArea ta;
	//�̺�Ʈó�� Ŭ���� 
	public EventHandler() {	
	}
	public EventHandler(JTextArea ta) {
		this.ta = ta;
	}
	public void actionPerformed(ActionEvent ae){
		JTextField tf =(JTextField) ae.getSource();
		
		//setText() : ���μ��� , append() : �߰�;
		ta.append(tf.getText()+"\n");
		tf.setText("");
		
	}	
}
