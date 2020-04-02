package swingPro;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFrameTest extends JFrame {
	JButton but1 = new JButton("누르지마시오"); 
	JButton but2 = new JButton("경고"); 
	JButton but3 = new JButton("종료"); 
	JButton but4 = new JButton("훔바"); 
	
	//여러줄의 텍스트 입력 컴퍼넌트 
	JTextArea ta = new JTextArea();
	public JFrameTest() {
		super("JFrame 연습중");//창의 제목을 가진 상위 클래스의 생성자호출 
		//setTitle("Test");
		//BorderLayout 동서남북
		//FlowLayout  컴퍼넌트 순서대로 
		//GridLayout 5칸씩
		add(but1,"North");//컨테이너에 컴퍼넌트 추가
		add(but2, BorderLayout.SOUTH);
		add(but3,"West");
		add(but4,"East");
		
		JScrollPane sp = new JScrollPane(ta);
		add(sp,"Center");
		
		setSize(300,400);
		setVisible(true);
		
		//프로그램 종료시 프로세스 자원해제
		//DISPOSE_ON_CLOSE 엑스버튼을 누르면 꺼지는기능 
		//DO_NOTHING_ON_CLOSE 엑스버튼을 눌러도 꺼지지않는 기능
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameTest();
	}

}
