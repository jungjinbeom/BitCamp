package swingPro;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventMain extends JFrame implements WindowListener{
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();
	public EventMain() {
		add(ta);	add(tf,"South");
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ ���
		tf.addActionListener(new  EventHandler(ta));//��ü ����� 
		addWindowListener(this);
		
	}
	//�������̵�
	

	
// �������̵� �޼ҵ���� adapter�� ����Ͽ� ��� ����ϱ�	
	//Keyadapter Windowadapter

	@Override
	public void windowOpened(WindowEvent e) {
		//System.out.println("Opened");
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
	//System.out.println("Closing");
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		//System.out.println("Closed");
	}


	@Override
	public void windowIconified(WindowEvent e) {
		//System.out.println("Iconified");
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		//System.out.println("Deiconfied");
		
	}
	public void windowActivated(WindowEvent e) {
		//System.out.println("Activated");
		
	}
	public void windowDeactivated(WindowEvent e) {
		
		//System.out.println("Deactivated");
	}
	
	public static void main(String[] args) {
		new EventMain();

	}

}
