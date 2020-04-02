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
		
		//이벤트 등록
		tf.addActionListener(new  EventHandler(ta));//객체 존재시 
		addWindowListener(this);
		
	}
	//오버라이딩
	

	
// 오버라이딩 메소드들을 adapter를 사용하여 골라서 사용하기	
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
