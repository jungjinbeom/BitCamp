package swingPro;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame {
	JTabbedPane tp = new JTabbedPane();
	Calculator2 cal = new Calculator2();
	DigitalClock2 clock = new DigitalClock2();
	
	ImageIcon ii = new ImageIcon("img/ico_001_ds5vvf.png");
	JLabel lbl = new JLabel(ii);
	
	JTableTest02 table =new JTableTest02();
	
	ImageIcon ii2 = new ImageIcon("img/img.jpg");
	JButton btn = new JButton();
	public JTabbedPaneTest() {
		super("텝메뉴");
		/////////////////////
		//		제목 	컴포넌트
		//tp.add("계산기",cal);
		tp.add("시계",clock);
			Thread th = new Thread(clock);
		th.start();
		tp.add("이미지",lbl);
		tp.add("회원목록",table);
		
		add(tp, "Center");
		/////////////////////////
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try{
		//	Thread.sleep(3000);
	}catch(Exception e ){
	}
	
				// 탭추가 		라벨 아이콘 객체 툴팁
					//tp.addTab("버튼",ii2,btn,"버튼을 선택하세요...");
				//중간에 탭추가하기 
			//	tp.insertTab("버튼",ii2, btn, "추가된 탭메뉴", 1);
	
		try{
			//Thread.sleep(3000);
	}catch(Exception e ){}
		//탭삭제 index나 컴포넌트를 지정 후  지운다 
		//tp.remove(btn);//tp.remove(1);
		
		//탭의 활성화 비활성화 
		//true : 활성화 false : 비활성화 
	//	tp.setEnabled(false);
		//tp.setEnabledAt(1, false);//1번의 index 비활성화
		
		//탭메뉴의 위치 이동 
		//TOP, RIGHT, LEFT, BOTTOM
		//tp.setTabPlacement(JTabbedPane.LEFT);
	
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}
