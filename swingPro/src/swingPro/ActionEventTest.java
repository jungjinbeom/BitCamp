package swingPro;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ActionEventTest  extends JFrame implements ActionListener, KeyListener{
	JButton but = new JButton("Click");
	JButton but2 = new JButton("두번째버튼");
	//enter : 박스의 글삭제  -  ActionEvent
	//key를 누른경우 방금입력한 키를 콘솔에 출력 - KeyEvent,KeyListener
	JTextField tf = new JTextField(20);
	
	public ActionEventTest() {
		setLayout(new FlowLayout());
		
		
		add(but);
		add(but2);
		add(tf);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록방법 
		//1.인터페이스 상속 : ActionListener 
		//2.추상메소드 오버라이딩 
		//3.이벤트등록 addActionListener();
		but.addActionListener(this);
		but2.addActionListener(this);
		tf.addActionListener(this);
		tf.addKeyListener(this);
	
	}
	
	//ActionListener의 추상메소드 오버라이딩     //JButton, JTextField
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생한 버튼 라벨을 얻어오기 
		//String event= ae.getActionCommand();		
		//System.out.println(event+" 클릭하누.....");

		//이벤트가 발생한객체를 얻어오기 
//		Object obj= ae.getSource();
//		JButton eventBut = (JButton)obj;
//		
//		if(eventBut.equals(but)) {
//			System.out.println("click");
//		}else if (eventBut.equals(but2)) {
//			System.out.println("두번째버튼");
//		}
		
		//버튼과  텍스트박스에서 이벤트 알아내기(구별방법)
		//객체instanceof(비교) 클래스
		Object obj  = ae.getSource();
		if(obj instanceof JButton){//버튼과  텍스트박스에서 이벤트 알아내기(구별방법)
			JButton b = (JButton)obj;
			System.out.println(b.getText());//b.setText();
			b.setText("11111");
		}else if(obj instanceof JTextField) {//버튼과  텍스트박스에서 이벤트 알아내기(구별방법)
			JTextField tf2 = (JTextField)obj;
			tf2.setText("");
			
		}
	}
	//KeyListener의 오버라이딩
	public void keyPressed(KeyEvent ke) {//키를 누른상태
		//System.out.println("Press");
		}
	public void keyReleased(KeyEvent ke ) {//눌렀다 손을 놓으면
		System.out.println(ke.getKeyCode()+"="+ke.getKeyChar());
		//방금 입력한 키가 ESC키인지 알아내어 프로그램을 종료한다 
		if(ke.getKeyCode()==KeyEvent.VK_ESCAPE) {
			dispose();//자원해제
			System.exit(0);//
			
		}
	}
	public void keyTyped(KeyEvent ke) {//키를 누른후 놓으면
		//System.out.println("type");
	}
	
	public static void main(String arg[]) {
		new ActionEventTest();
}
}
