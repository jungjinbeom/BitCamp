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
		
		//�޴�
		
	//��ü ���� 
		JMenuBar mb = new JMenuBar();
			JMenu fileMenu = new JMenu("����");
				JMenuItem openMenu = new JMenuItem("����");
				JMenuItem saveMenu = new JMenuItem("�����ϱ�");
				JMenuItem closeMenu = new JMenuItem("����"); 
			JMenu editMenu = new JMenu("����");
				JMenuItem fontMenu = new JMenuItem("�۲�");
			JMenu helpMenu = new JMenu("����");
				JMenu runMenu = new JMenu("����");
				JMenuItem memo = new JMenuItem("�޸���");
				JMenuItem chrome = new JMenuItem("ũ��");
				JMenuItem editPlus = new JMenuItem("����Ʈ�÷���");
			JMenuItem help = new JMenuItem("����");
				
			
			
		//Center
			JTextArea ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		//JTextArea ta = new JTextArea();
	
		
		
		JList<String>fontList;
		DefaultListModel<String> listModel;
		
		JPanel fontStyle = new JPanel();
		JButton bold = new JButton("���ϰ�");
		JButton italic = new JButton("��︲");
		JButton plain = new JButton("����");
		
		JComboBox<Integer> fontSize;
		Vector<Integer> vec;
		
		JPanel fontButPane = new JPanel();
		JButton fontSet = new JButton("����");
		JButton fontcancel = new JButton("���");
	public MenuTest() {
		mb.add(fileMenu);
			fileMenu.add(openMenu);
			fileMenu.add(saveMenu);
				fileMenu.addSeparator();//��輱
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
			
			//�̺�Ʈ ��� 
			openMenu.addActionListener(this);
			saveMenu.addActionListener(this);
			closeMenu.addActionListener(this);
			fontMenu.addActionListener(this);
			memo.addActionListener(this);
			chrome.addActionListener(this);
			editPlus.addActionListener(this);
			help.addActionListener(this);
				
	}
//�������̵�
		int b, i;
		JDialog dialog;
	public void actionPerformed(ActionEvent ae) {
//		String lbl = ae.getActionCommand();
		Object obj = ae.getSource();
		if(obj instanceof JMenuItem) {////////////////////
		JMenuItem menu = (JMenuItem)obj;
//		if(lbl.equals("����")) {	//���� 
			if(menu.equals(openMenu)) {//��ü�� ���ϱ� , ���� 
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
			}else if(eventBut.equals(fontSet)) {//����
				//�۲� (fontList), ����ũ�� (fontSize)
				
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
	//�޸���,ũ��
	public void startProcess(String filename) {
		try {
		Runtime run = Runtime.getRuntime();
	
			run.exec(filename);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	//�۲�
	
	public void showDialog() {		
		 dialog = new JDialog(this , "�۲�",false);//true:�θ�â ��� �Ұ��� ,false:�θ�â ��� ����
		//�۲ø���� 
		//Font : �۲�, �������� () ��ġ ũ��  
		
		listModel = new DefaultListModel<String>();
		//�۲� ������ �߰� 
		Toolkit kit = Toolkit.getDefaultToolkit();
		String f[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(String fnt: f) {
			listModel.addElement(fnt);
			
		}
		fontList = new JList(listModel);
		JScrollPane sp2  =new JScrollPane(fontList); 
		dialog.add(sp2,"West");
		
		
		//�������� 
		fontStyle.add(bold); fontStyle.add(italic); fontStyle.add(plain);
		dialog.add(fontStyle, "Center");
		
		//����ũ��
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
		
		
		//dialog �̺�Ʈ ���
		bold.addActionListener(this);
		italic.addActionListener(this);
		plain.addActionListener(this);
		fontSet.addActionListener(this);
		fontcancel.addActionListener(this);
//		JColorChooser color = new JColorChooser();
//	Color selColor = color.showDialog(this, "����ǥ", Color.BLUE);
//		//���ڻ� : setForeground
//		//���� : setBackground
//	ta.setForeground(selColor);
	}
	//����
	public void fileSave() {
		JFileChooser fc = new JFileChooser();
		int sel=fc.showSaveDialog(this);//0:���� 1:���
		if(sel == 0) {//���弱�ý�
				try {
				//��� + ����
						File file = fc.getSelectedFile();
				
						FileWriter fw = new FileWriter(file);
						fw.write(ta.getText());
						fw.flush();
						fw.close();
						
						//���ϸ� ���� 
						setTitle(file.getAbsolutePath());
						
				}catch(IOException e ) {
					e.printStackTrace();
					
				}
				
			}
		}
		
		
	//����
			public void fileOpen() {
				File file = new File("C://javaEx/Array03.java");
				JFileChooser fc = new JFileChooser();
				fc.setSelectedFile(file);
				fc.setMultiSelectionEnabled(true);
				
				//////////////Filter ����� ////////////////////////////////
				FileFilter ff = new FileNameExtensionFilter("java����(*.java)","java","Java","JAVA");
				fc.addChoosableFileFilter(ff);
				
				FileFilter ff2 = new FileNameExtensionFilter("�̹�������","gif","jpg","png","jpeg");
				fc.addChoosableFileFilter(ff2);	
				//////////////////////////////////////////////////////////
				//����:0/���:1
			int chooser	=	fc.showOpenDialog(this);//����â�� �����ش�
			if(chooser ==0) {
				ta.setText("");;
				try {
					//������ ��ο� ���ϸ� ������
				File selFile = fc.getSelectedFile();
				
				//���õ� ���ϸ� 
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
