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
	JButton but2 = new JButton("�ι�°��ư");
	//enter : �ڽ��� �ۻ���  -  ActionEvent
	//key�� ������� ����Է��� Ű�� �ֿܼ� ��� - KeyEvent,KeyListener
	JTextField tf = new JTextField(20);
	
	public ActionEventTest() {
		setLayout(new FlowLayout());
		
		
		add(but);
		add(but2);
		add(tf);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ ��Ϲ�� 
		//1.�������̽� ��� : ActionListener 
		//2.�߻�޼ҵ� �������̵� 
		//3.�̺�Ʈ��� addActionListener();
		but.addActionListener(this);
		but2.addActionListener(this);
		tf.addActionListener(this);
		tf.addKeyListener(this);
	
	}
	
	//ActionListener�� �߻�޼ҵ� �������̵�     //JButton, JTextField
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻��� ��ư ���� ������ 
		//String event= ae.getActionCommand();		
		//System.out.println(event+" Ŭ���ϴ�.....");

		//�̺�Ʈ�� �߻��Ѱ�ü�� ������ 
//		Object obj= ae.getSource();
//		JButton eventBut = (JButton)obj;
//		
//		if(eventBut.equals(but)) {
//			System.out.println("click");
//		}else if (eventBut.equals(but2)) {
//			System.out.println("�ι�°��ư");
//		}
		
		//��ư��  �ؽ�Ʈ�ڽ����� �̺�Ʈ �˾Ƴ���(�������)
		//��üinstanceof(��) Ŭ����
		Object obj  = ae.getSource();
		if(obj instanceof JButton){//��ư��  �ؽ�Ʈ�ڽ����� �̺�Ʈ �˾Ƴ���(�������)
			JButton b = (JButton)obj;
			System.out.println(b.getText());//b.setText();
			b.setText("11111");
		}else if(obj instanceof JTextField) {//��ư��  �ؽ�Ʈ�ڽ����� �̺�Ʈ �˾Ƴ���(�������)
			JTextField tf2 = (JTextField)obj;
			tf2.setText("");
			
		}
	}
	//KeyListener�� �������̵�
	public void keyPressed(KeyEvent ke) {//Ű�� ��������
		//System.out.println("Press");
		}
	public void keyReleased(KeyEvent ke ) {//������ ���� ������
		System.out.println(ke.getKeyCode()+"="+ke.getKeyChar());
		//��� �Է��� Ű�� ESCŰ���� �˾Ƴ��� ���α׷��� �����Ѵ� 
		if(ke.getKeyCode()==KeyEvent.VK_ESCAPE) {
			dispose();//�ڿ�����
			System.exit(0);//
			
		}
	}
	public void keyTyped(KeyEvent ke) {//Ű�� ������ ������
		//System.out.println("type");
	}
	
	public static void main(String arg[]) {
		new ActionEventTest();
}
}
