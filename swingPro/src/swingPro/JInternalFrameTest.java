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
		setTitle("����");
		////
		add(btn, BorderLayout.NORTH);
		btn.addActionListener(this);
		///////////////////////////////////////
		add(desk, "Center");
		JInternalFrame if1 = new JInternalFrame("���� "); 
		 	Calculator2 cal = new Calculator2();//JPanel
		 	if1.add(cal);
		 	if1.setSize(new Dimension(400,300));
		 	if1.setVisible(true);
		 	desk.add(if1);
		 //										 ����	ũ������	�ݱ�  �ִ�ȭ	������ȭ
		JInternalFrame if2 = new JInternalFrame("�޸���",true, true,  true,  true);
			JTextArea ta =new JTextArea("ù��° �ؽ�Ʈ");
			JScrollPane sp = new JScrollPane(ta);
			if2.add(sp);
			if2.setBounds(new Rectangle(new Point(100,100),new Dimension(400,300))); //point : x,y��ǥ�� ������ Ŭ���� 
			if2.setVisible(true);
			desk.add(if2);
		//	if2.toFront();//���� �����̳ʸ� ������ ǥ���ϱ� 
		//////////////////////////////////////////////
			//�ð�
		JInternalFrame if3 = new JInternalFrame("�ð�");
			DigitalClock2 clock = new DigitalClock2();
			Thread t = new Thread(clock);
			t.start();//�ð�� �����带 ��������� �������� ��ü�� �����Ѵ� 
			if3.add(clock);
			if3.setBounds(200,200,400,400);
			if3.setVisible(true);
			desk.add(if3);
			//if3.toFront();
			
		JInternalFrame if4 = new JInternalFrame("�޸���");
			JTextArea ta2 = new JTextArea("�ι�° �ؽ�Ʈ �ڽ�����");
			if4.add(ta2);
			if4.setBounds(300,300,400,400);
			if4.setVisible(true);
			desk.add(if4);
			//////////////////////////////////////////
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//����ó���� Frame�� show�� ���Ŀ� ����Ͽ��� �Ѵ�. 
		
		try {
		if3.setSelected(true);
		}catch(PropertyVetoException e) {
			e.printStackTrace();
		}
		}
		//�������̵� 
	public void actionPerformed(ActionEvent ae) {
		//save���ý� 
		//DesktopPane���� Ȱ��ȭ�� InternalFrame��ü�� ������ 
		JInternalFrame f = desk.getSelectedFrame();//InternalFrame�� �����Ѵ�
		//InternalFrame���� TextArea��ü ������ 
		JTextArea owner = (JTextArea)f.getFocusOwner();
		System.out.println(owner.getText());
	}
	public static void main(String[] args) {
		new JInternalFrameTest();
	}

}
