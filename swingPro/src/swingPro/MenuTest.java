package swingPro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


	public class MenuTest extends JFrame implements ActionListener{
		
		//메뉴
		
	//객체 생성 
		JMenuBar mb = new JMenuBar();
			JMenu fileMenu = new JMenu("파일");
				JMenuItem openMenu = new JMenuItem("열기");
				JMenuItem saveMenu = new JMenuItem("저장하기");
				JMenuItem closeMenu = new JMenuItem("종료"); 
			JMenu editMenu = new JMenu("편집");
				JMenuItem fontMenu = new JMenuItem("글꼴");
			JMenu helpMenu = new JMenu("도움말");
				JMenu runMenu = new JMenu("실행");
				JMenuItem memo = new JMenuItem("메모장");
				JMenuItem chrome = new JMenuItem("크롬");
				JMenuItem editPlus = new JMenuItem("에디트플러스");
			JMenuItem help = new JMenuItem("도움말");
				
			
			
		//Center
			JTextArea ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		//JTextArea ta = new JTextArea();
	
		
		
		JList<String>fontList;
		DefaultListModel<String> listModel;
		
		JPanel fontStyle = new JPanel();
		JButton bold = new JButton("진하게");
		JButton italic = new JButton("기울림");
		JButton plain = new JButton("보통");
		
		JComboBox<Integer> fontSize;
		Vector<Integer> vec;
		
		JPanel fontButPane = new JPanel();
		JButton fontSet = new JButton("적용");
		JButton fontcancel = new JButton("취소");
	public MenuTest() {
		mb.add(fileMenu);
			fileMenu.add(openMenu);
			fileMenu.add(saveMenu);
				fileMenu.addSeparator();//경계선
			fileMenu.add(closeMenu);
		mb.add(editMenu);
			editMenu.add(fontMenu);
		
		mb.add(helpMenu);
			helpMenu.add(runMenu);
				runMenu.add(memo);
				runMenu.add(chrome);
				runMenu.add(editPlus);
			helpMenu.add(help);
			
			setJMenuBar(mb);
			
			add(sp, BorderLayout.CENTER);
			setSize(800,800);
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			//이벤트 등록 
			openMenu.addActionListener(this);
			saveMenu.addActionListener(this);
			closeMenu.addActionListener(this);
			fontMenu.addActionListener(this);
			memo.addActionListener(this);
			chrome.addActionListener(this);
			editPlus.addActionListener(this);
			help.addActionListener(this);
				
	}
//오버라이딩
		int b, i;
		JDialog dialog;
	public void actionPerformed(ActionEvent ae) {
//		String lbl = ae.getActionCommand();
		Object obj = ae.getSource();
		if(obj instanceof JMenuItem) {////////////////////
		JMenuItem menu = (JMenuItem)obj;
//		if(lbl.equals("열기")) {	//열기 
			if(menu.equals(openMenu)) {//객체로 비교하기 , 열기 
				fileOpen();
			}else if(menu.equals(saveMenu)) {
				fileSave();
			}else if (menu.equals(closeMenu)){
				dispose();
				System.exit(0);
			}else if (menu.equals(fontMenu)) {
				showDialog();
			}else if(menu.equals(memo)) {
				startProcess("notePad.exe");
			}else if(menu.equals(chrome)) {
				startProcess("C://Program Files (x86)/Google/Chrome/Application/chrome.exe http://www.naver.com");
			}else if(menu.equals(editPlus)) {
				startProcess("C://Program Files/EditPlus/editplus.exe");
			}
			
		}else if(obj instanceof JButton) {///----------
			
			JButton eventBut = (JButton)obj;	
			if(eventBut.equals(bold)) {
				b=1;
			}else if(eventBut.equals(italic)) {
				i=2;
			}else if(eventBut.equals(plain)) {
				b=0; i=0;
			}else if(eventBut.equals(fontSet)) {//적용
				//글꼴 (fontList), 글자크기 (fontSize)
				
				String f =fontList.getSelectedValue();
				int size= (Integer)fontSize.getSelectedItem();
				Font font = new Font(f, b+i, size);
				ta.setFont(font);
				dialog.setVisible(false);
				
			}else if(eventBut.equals(fontcancel)) {
				dialog.setVisible(false);
			}
		}
	}
	//메모장,크롬
	public void startProcess(String filename) {
		try {
		Runtime run = Runtime.getRuntime();
	
			run.exec(filename);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	//글꼴
	
	public void showDialog() {		
		 dialog = new JDialog(this , "글꼴",false);//true:부모창 사용 불가능 ,false:부모창 사용 가능
		//글꼴만들기 
		//Font : 글꼴, 글자유형 () 위치 크기  
		
		listModel = new DefaultListModel<String>();
		//글꼴 데이터 추가 
		Toolkit kit = Toolkit.getDefaultToolkit();
		String f[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(String fnt: f) {
			listModel.addElement(fnt);
			
		}
		fontList = new JList(listModel);
		JScrollPane sp2  =new JScrollPane(fontList); 
		dialog.add(sp2,"West");
		
		
		//글자유형 
		fontStyle.add(bold); fontStyle.add(italic); fontStyle.add(plain);
		dialog.add(fontStyle, "Center");
		
		//글자크기
		vec = new Vector<Integer>();
		
		for(int i = 7; i<=100; i++) {
			if(i>20) {
				i+=2;
			}
			vec.add(i);
		}
		fontSize = new JComboBox<Integer>(vec);
		JPanel p = new JPanel();
		p.add(fontSize);
		dialog.add(p,"East");
		
		//
		fontButPane = new JPanel();
		fontButPane.add(fontSet);
		fontButPane.add(fontcancel);
		dialog.add(fontButPane, "South");
		dialog.setSize(400,300);
		dialog.setVisible(true);
		
		
		//dialog 이벤트 등록
		bold.addActionListener(this);
		italic.addActionListener(this);
		plain.addActionListener(this);
		fontSet.addActionListener(this);
		fontcancel.addActionListener(this);
//		JColorChooser color = new JColorChooser();
//	Color selColor = color.showDialog(this, "색상표", Color.BLUE);
//		//글자색 : setForeground
//		//배경색 : setBackground
//	ta.setForeground(selColor);
	}
	//저장
	public void fileSave() {
		JFileChooser fc = new JFileChooser();
		int sel=fc.showSaveDialog(this);//0:저장 1:취소
		if(sel == 0) {//저장선택시
				try {
				//경로 + 파일
						File file = fc.getSelectedFile();
				
						FileWriter fw = new FileWriter(file);
						fw.write(ta.getText());
						fw.flush();
						fw.close();
						
						//파일명 셋팅 
						setTitle(file.getAbsolutePath());
						
				}catch(IOException e ) {
					e.printStackTrace();
					
				}
				
			}
		}
		
		
	//열기
			public void fileOpen() {
				File file = new File("C://javaEx/Array03.java");
				JFileChooser fc = new JFileChooser();
				fc.setSelectedFile(file);
				fc.setMultiSelectionEnabled(true);
				
				//////////////Filter 만들기 ////////////////////////////////
				FileFilter ff = new FileNameExtensionFilter("java파일(*.java)","java","Java","JAVA");
				fc.addChoosableFileFilter(ff);
				
				FileFilter ff2 = new FileNameExtensionFilter("이미지파일","gif","jpg","png","jpeg");
				fc.addChoosableFileFilter(ff2);	
				//////////////////////////////////////////////////////////
				//열기:0/취소:1
			int chooser	=	fc.showOpenDialog(this);//열기창을 보여준다
			if(chooser ==0) {
				ta.setText("");;
				try {
					//선택한 경로와 파일명 얻어오기
				File selFile = fc.getSelectedFile();
				
				//선택된 파일명 
				String fileName=selFile.getPath();
				setTitle(fileName);
				
				FileReader fr = new FileReader(selFile);
				BufferedReader br = new BufferedReader(fr);
				//System.out.println("......1");	
				
				while(true) {
				//System.out.println("......");	
					String inStr =br.readLine();
					if(inStr==null) break;
					ta.append(inStr+"\n");
				}
				
				}catch(Exception e){
					e.printStackTrace();
				}
		}
	}
	public static void main(String[] args) {
				new MenuTest();
	}
	
	

}
