package swingPro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class JInternalFrameTest extends JFrame implements ActionListener{
	JDesktopPane desk = new JDesktopPane();
	JButton btn = new JButton("Save");
	public JInternalFrameTest() {
		super("JInternalFrame");
		setTitle("제목");
		////
		add(btn, BorderLayout.NORTH);
		btn.addActionListener(this);
		///////////////////////////////////////
		add(desk, "Center");
		JInternalFrame if1 = new JInternalFrame("계산기 "); 
		 	Calculator2 cal = new Calculator2();//JPanel
		 	if1.add(cal);
		 	if1.setSize(new Dimension(400,300));
		 	if1.setVisible(true);
		 	desk.add(if1);
		 //										 제목	크기조절	닫기  최대화	아이콘화
		JInternalFrame if2 = new JInternalFrame("메모장",true, true,  true,  true);
			JTextArea ta =new JTextArea("첫번째 텍스트");
			JScrollPane sp = new JScrollPane(ta);
			if2.add(sp);
			if2.setBounds(new Rectangle(new Point(100,100),new Dimension(400,300))); //point : x,y좌표를 가지는 클래스 
			if2.setVisible(true);
			desk.add(if2);
		//	if2.toFront();//현재 컨테이너를 앞으로 표시하기 
		//////////////////////////////////////////////
			//시계
		JInternalFrame if3 = new JInternalFrame("시계");
			DigitalClock2 clock = new DigitalClock2();
			Thread t = new Thread(clock);
			t.start();//시계는 스레드를 사용함으로 스레드의 객체를 생성한다 
			if3.add(clock);
			if3.setBounds(200,200,400,400);
			if3.setVisible(true);
			desk.add(if3);
			//if3.toFront();
			
		JInternalFrame if4 = new JInternalFrame("메모장");
			JTextArea ta2 = new JTextArea("두번째 텍스트 박스내용");
			if4.add(ta2);
			if4.setBounds(300,300,400,400);
			if4.setVisible(true);
			desk.add(if4);
			//////////////////////////////////////////
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//예외처리와 Frame이 show가 된후에 기술하여야 한다. 
		
		try {
		if3.setSelected(true);
		}catch(PropertyVetoException e) {
			e.printStackTrace();
		}
		}
		//오버라이딩 
	public void actionPerformed(ActionEvent ae) {
		//save선택시 
		//DesktopPane에서 활성화된 InternalFrame객체를 얻어오기 
		JInternalFrame f = desk.getSelectedFrame();//InternalFrame을 리턴한다
		//InternalFrame에서 TextArea객체 얻어오기 
		JTextArea owner = (JTextArea)f.getFocusOwner();
		System.out.println(owner.getText());
	}
	public static void main(String[] args) {
		new JInternalFrameTest();
	}

}
