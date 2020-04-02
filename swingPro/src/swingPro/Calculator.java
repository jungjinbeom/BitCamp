package swingPro;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
		
	
//	JTextField txtField = new JTextField(); 
//	String func;
//	String inputStr="";
//	double num;
	Font fnt = new Font("Arial",Font.BOLD,30);
	//BorderLayout����
	JLabel resultLbl = new JLabel("0.0",JLabel.RIGHT);
	JPanel frmCenter = new JPanel(new BorderLayout());
		JPanel north = new JPanel(new GridLayout(1,3));
		JPanel center = new JPanel(new GridLayout(4,4));
		
		//JButton
		//��ư�� �迭�� ����� ��� 
		//�׼� �̺�Ʈ�� Ű �̺�Ʈ
		String butLbl[] = {"Backspace","Clear","End"
							,"7","8","9","+"
						   	,"4","5","6","-"
						   	,"1","2","3","*"
						   	,"0",".","=","/"};
		
		//������ �����ϴ� ���� 
		double result;//0.0
		String operator="";
	
	public Calculator() {
		super("����");//����
		 resultLbl.setFont(fnt);
		add( resultLbl,"North");
		
		add(frmCenter);//frame center
			frmCenter.add(north,"North");
			frmCenter.add(center);
			
			//button �߰� 
			for(int idx=0; idx<butLbl.length;idx++) {//idx=0,1,2,3,4,5,6,7,8,9
				JButton but = new JButton(butLbl[idx]);
				but.setFont(fnt);
				if(idx<=2) {
					north.add(but);
				}else {
					center.add(but);//���� , ��Ģ���� 
				}
				but.addActionListener(this);//�̺�Ʈ ��� 
			}
		
			setSize(400,250);
			
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
		}

		//�������̵�
		public void actionPerformed(ActionEvent ae) {
			String eBtn = ae.getActionCommand();//�̺�Ʈ�� �߻��� ��ư�� label
			//byte, short, int, char, String
			switch(eBtn){
				case "+" : case "-" : case "/" : case "*" : setOperator(eBtn);break;
				case "=" : getArithemetic();break;
				case "Backspace" : setLastCut();break;
				case "Clear" : setBtnClear();break;
				case "End" : dispose(); System.exit(0); break;
				case "." : setPoint();break;
				case "0" : case "1" : case "2" :
				case "3" : case "4" : case "5" : 
				case "6" : case "7" : case "8" : case "9" :
					setNumber(eBtn);
					break;
			}
		}
		
		//�Ҽ������ý� 
		public void setPoint() {
			String txt = resultLbl.getText();
			if(txt.indexOf(".")==-1) {//�Ҽ����� ������ 
				resultLbl.setText(txt+".");
				
			}
		}
		//Backspace��ư ���ý� 
		public void setLastCut() {
			String txt = resultLbl.getText();
			if(txt.length()<0) {
				resultLbl.setText(txt.substring(0,txt.length()-1));
			}else { 
				resultLbl.setText("0");	
			}
		}
		//���� ��ư ���ý� 
		public void setNumber(String num) {
			String txt = resultLbl.getText();
			if(resultLbl.getText().equals("0.0")) {//�ʱⰪ 0.0�� ������
				resultLbl.setText(num);
			}else{//
				resultLbl.setText(txt+num);
			}
		}
		//������(+.-.*./)
		
	public void setOperator(String operator) {
		//�󺧰� ����
		result = Double.parseDouble(resultLbl.getText().trim());
		//������ ����
		this.operator = operator;
		//���ʱ�ȭ 
		resultLbl.setText(" ");
		
	}
	//����ϱ� : = Ŭ���� 
	public void getArithemetic() {
		double num2 = Double.parseDouble(resultLbl.getText());
		switch(operator) {
		case "+" : result = result += num2;break;
		case "-" : result = result -= num2;break;
		case "*" : result = result *= num2;break;
		case "/" : result = result /= num2; 
		}
		resultLbl.setText(String .valueOf(result));
	}
	public void setBtnClear() {
		result = 0;
		operator = "";
		resultLbl.setText("0.0");
	}
	
//
//	public void actionPerformed(ActionEvent e) {
////JButton but = (JButton)e.getSource();
////		try {
//	String txtButton = e.getActionCommand();
////resultLbl.setText(resultLbl.getText() + e.getActionCommand());
//			if(txtButton.equals("0") ||txtButton.equals("1")||
//					txtButton.equals("2")||txtButton.equals("3")
//					||txtButton.equals("4")||txtButton.equals("5")
//					||txtButton.equals("6")||txtButton.equals("7")
//					||txtButton.equals("8")||txtButton.equals("9")) {
//				
//				
//					inputStr+=txtButton;
//					resultLbl.setText(inputStr);
//				}
//			if(txtButton.contentEquals("End")) {
//				dispose();
//				System.exit(0);
//			}else if (txtButton.equals("Clear")) {
//				inputStr = "0";
//				resultLbl.setText(inputStr);
//				
//			}else if (txtButton.equals("Backspace")) {
//				if(resultLbl.getText().length()>1) {//�迭�� ���̰� 1���� Ŭ��� 
//				String result = inputStr.substring(0,resultLbl.getText().length()-1);
//				resultLbl.setText(inputStr=result);
//				}else	if(resultLbl.getText().length()<=1) {
//						resultLbl.setText(inputStr="0");
//					
//				}	
//				
//			}else if(txtButton.equals("+")) {
//				String curr = resultLbl.getText();
//					num = Double.parseDouble(curr);
//					resultLbl.setText(inputStr= " ");
//					 func = "PLUS";
//			}else if(txtButton.equals("-")) {
//				String curr = resultLbl.getText();
//					num = Double.parseDouble(curr);
//					resultLbl.setText(inputStr= " ");
//					 func = "MIN";
//			}else if(txtButton.equals("*")) {
//				String curr = resultLbl.getText();
//					num = Double.parseDouble(curr);
//					resultLbl.setText(inputStr= " ");
//					 func = "MUL";
//			}else if(txtButton.equals("/")) {
//				String curr = resultLbl.getText();
//					num = Double.parseDouble(curr);
//					resultLbl.setText(inputStr= " ");
//					 func = "DIV";
//			}else if (txtButton.equals(".")) {
//				inputStr += txtButton;
//				resultLbl.setText(inputStr);
//			}else if(txtButton.equals("=")) {
//				switch(func) {
//					case "PLUS" : {
//						double currVal = Double.parseDouble(resultLbl.getText());
//						resultLbl.setText((num+currVal)+"");
//						break;
//					}case "MIN" : {
//						double currVal = Double.parseDouble(resultLbl.getText());
//						resultLbl.setText((num-currVal)+"");
//						break;
//					}case "MUL" : {
//						double currVal =Double.parseDouble(resultLbl.getText());
//						resultLbl.setText((num*currVal)+"");
//						break;
//					}case "DIV" : { 
//						double currVal = Double.parseDouble(resultLbl.getText());
//						resultLbl.setText((num/currVal)+"");
//						break;
//					}
//				}
//			}
//			
//		}
//	
	
	public static void main(String[] args) {
		new Calculator();

	}



	
}


