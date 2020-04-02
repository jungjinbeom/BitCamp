package swingPro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest01  extends JFrame{

	//
	JPanel           jPanel;
	JTable 			  table;
	DefaultTableModel model;
	JLabel              lbl = new JLabel("선택한 데이터가 뜨는 곳이래여");
	JScrollPane         sp;
	
	String[]  title = {"번호", "이름", "전화번호", "메일"};
	Object[][] data = {
						  {100, "이길동", "-1- 203= 3342", "위메일"},
						  {200, "김길동", "미공개지렁", "이 뭐야 먹는거"},
						  {300, "사길동", "나도 모르지렁", "야?"},
						  {400, "오길동", "너는 아니?", "모야모야 무슨 재"},
						  {500, "삼길동", "폰없찐인걸", "미있는게 새로나왔나"},
						  {600, "일길동", "님폰없?", "그런것보다 졸려."},
					   };
	
	
	public JTableTest01() {
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp    = new JScrollPane(table);
		
		add(sp);
		
		add(lbl, "South");
		
		
		
	
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//setTableEdit();
		
		table.addMouseListener(new MouseAdapter() {
			//released : 클릭 후
			public void mouseReleased(MouseEvent me) {
				//마우스 버튼 종류 알아내기.
				int clickButton = me.getButton();// 1은 왼쪽 버튼, 2는 마우스 휠, 3은 마우스 오른쪽 버튼이다.'
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
		//행추가.
			//~데이터를 일차원 배로 만들어야 한다.
		waitTime(2000);
		
		Object[] addData = {900, "쉐종", "있겠냐?", "알겠냐?"};
		model.addRow(addData);
		
		Object[] insertData = {900, "세에종2", "있겠냐고", "있을리가 없ㅈ너"};
		model.insertRow( 2, insertData);
		
		waitTime(2000);
		
		model.moveRow(2, 5, 0);
		
		waitTime(2000);
		// 칼럼추가
		model.addColumn("비고");
	
		table.removeColumn(table.getColumn("전화 번호"));
	}
	
	public void waitTime(int i) {
		try {
			Thread.sleep(i);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		new JTableTest01();
	}

}
