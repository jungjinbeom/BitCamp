package swingPro;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFrameTest extends JFrame {
	JButton but1 = new JButton("���������ÿ�"); 
	JButton but2 = new JButton("���"); 
	JButton but3 = new JButton("����"); 
	JButton but4 = new JButton("�ɹ�"); 
	
	//�������� �ؽ�Ʈ �Է� ���۳�Ʈ 
	JTextArea ta = new JTextArea();
	public JFrameTest() {
		super("JFrame ������");//â�� ������ ���� ���� Ŭ������ ������ȣ�� 
		//setTitle("Test");
		//BorderLayout ��������
		//FlowLayout  ���۳�Ʈ ������� 
		//GridLayout 5ĭ��
		add(but1,"North");//�����̳ʿ� ���۳�Ʈ �߰�
		add(but2, BorderLayout.SOUTH);
		add(but3,"West");
		add(but4,"East");
		
		JScrollPane sp = new JScrollPane(ta);
		add(sp,"Center");
		
		setSize(300,400);
		setVisible(true);
		
		//���α׷� ����� ���μ��� �ڿ�����
		//DISPOSE_ON_CLOSE ������ư�� ������ �����±�� 
		//DO_NOTHING_ON_CLOSE ������ư�� ������ �������ʴ� ���
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameTest();
	}

}
