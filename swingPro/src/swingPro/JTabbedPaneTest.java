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
		super("�ܸ޴�");
		/////////////////////
		//		���� 	������Ʈ
		//tp.add("����",cal);
		tp.add("�ð�",clock);
			Thread th = new Thread(clock);
		th.start();
		tp.add("�̹���",lbl);
		tp.add("ȸ�����",table);
		
		add(tp, "Center");
		/////////////////////////
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try{
		//	Thread.sleep(3000);
	}catch(Exception e ){
	}
	
				// ���߰� 		�� ������ ��ü ����
					//tp.addTab("��ư",ii2,btn,"��ư�� �����ϼ���...");
				//�߰��� ���߰��ϱ� 
			//	tp.insertTab("��ư",ii2, btn, "�߰��� �Ǹ޴�", 1);
	
		try{
			//Thread.sleep(3000);
	}catch(Exception e ){}
		//�ǻ��� index�� ������Ʈ�� ���� ��  ����� 
		//tp.remove(btn);//tp.remove(1);
		
		//���� Ȱ��ȭ ��Ȱ��ȭ 
		//true : Ȱ��ȭ false : ��Ȱ��ȭ 
	//	tp.setEnabled(false);
		//tp.setEnabledAt(1, false);//1���� index ��Ȱ��ȭ
		
		//�Ǹ޴��� ��ġ �̵� 
		//TOP, RIGHT, LEFT, BOTTOM
		//tp.setTabPlacement(JTabbedPane.LEFT);
	
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}
