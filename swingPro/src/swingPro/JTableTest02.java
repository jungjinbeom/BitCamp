package swingPro;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest02  extends JPanel{

	//
	JPanel           jPanel;
	JTable 			  table;
	DefaultTableModel model;
	JLabel              lbl = new JLabel("������ �����Ͱ� �ߴ� ���̷���");
	JScrollPane         sp;
	
	String[]  title = {"��ȣ", "�̸�", "��ȭ��ȣ", "����"};
	Object[][] data = {
						  {100, "�̱浿", "-1- 203= 3342", "������"},
						  {200, "��浿", "�̰�������", "�� ���� �Դ°�"},
						  {300, "��浿", "���� ������", "��?"},
						  {400, "���浿", "�ʴ� �ƴ�?", "��߸�� ���� ��"},
						  {500, "��浿", "�������ΰ�", "���ִ°� ���γ��Գ�"},
						  {600, "�ϱ浿", "������?", "�׷��ͺ��� ����."},
					   };
	
	
	public JTableTest02() {
		
		setLayout(new BorderLayout());
		
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp    = new JScrollPane(table);
		
		add(sp);
		
		add(lbl, "South");
		
		
		
	
		//setSize(500, 500);
		//setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//setTableEdit();
		
		table.addMouseListener(new MouseAdapter() {
			//released : Ŭ�� ��
			public void mouseReleased(MouseEvent me) {
				//���콺 ��ư ���� �˾Ƴ���.
				int clickButton = me.getButton();// 1�� ���� ��ư, 2�� ���콺 ��, 3�� ���콺 ������ ��ư�̴�.'
				if(clickButton == 1) {
				int rowIdx  = table.getSelectedRow();
				int colCnt  = table.getColumnCount();
				String txt = "";
				for(int i = 0; i < colCnt; i++) {
					//Object object = table.getValue(rowIdx, i);
					//txt += object + "";
				}
				lbl.setText(txt);
				}
			}
		});
	}
	
	public void setTableEdit(){
		//���߰�.
			//~�����͸� ������ ��� ������ �Ѵ�.
		waitTime(2000);
		
		Object[] addData = {900, "����", "�ְڳ�?", "�˰ڳ�?"};
		model.addRow(addData);
		
		Object[] insertData = {900, "������2", "�ְڳİ�", "�������� ������"};
		model.insertRow( 2, insertData);
		
		waitTime(2000);
		
		model.moveRow(2, 5, 0);
		
		waitTime(2000);
		// Į���߰�
		model.addColumn("���");
	
		table.removeColumn(table.getColumn("��ȭ ��ȣ"));
	}
	
	public void waitTime(int i) {
		try {
			Thread.sleep(i);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
