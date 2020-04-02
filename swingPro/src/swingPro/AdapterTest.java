package swingPro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AdapterTest extends JFrame {
	///
	
	String txt = "윈도우 테스트중";
	public AdapterTest() {
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

//		addWindowListener(new WindowHandler());
		//익명의 내부 클래스 
		addWindowListener(new WindowAdapter() {
			//오버라이딩
			public void windowClosing(WindowEvent we) {
				System.out.println("The End........");
				dispose();
				System.exit(0);
			}
		});
	}

//	//내부클래스 
//	class WindowHandler extends WindowAdapter{
//		//필요한 메소드만 재오버라이딩한다.
//		//we에 프레임이 담긴다 
//		public void windowClosing(WindowEvent we) {
//			System.out.println(txt);
//			dispose();
//			System.exit(0);
//		}
//	}
	public static void main(String[] args) {
		new AdapterTest();
	}

}
