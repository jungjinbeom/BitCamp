package swingPro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AdapterTest extends JFrame {
	///
	
	String txt = "������ �׽�Ʈ��";
	public AdapterTest() {
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

//		addWindowListener(new WindowHandler());
		//�͸��� ���� Ŭ���� 
		addWindowListener(new WindowAdapter() {
			//�������̵�
			public void windowClosing(WindowEvent we) {
				System.out.println("The End........");
				dispose();
				System.exit(0);
			}
		});
	}

//	//����Ŭ���� 
//	class WindowHandler extends WindowAdapter{
//		//�ʿ��� �޼ҵ常 ��������̵��Ѵ�.
//		//we�� �������� ���� 
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
