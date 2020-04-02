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

public class Calculator2 extends JPanel implements ActionListener {
		
	
//	JTextField txtField = new JTextField(); 
//	String func;
//	String inputStr="";
//	double num;
	Font fnt = new Font("Arial",Font.BOLD,30);
	//BorderLayout고정
	JLabel resultLbl = new JLabel("0.0",JLabel.RIGHT);
	JPanel frmCenter = new JPanel(new BorderLayout());
		JPanel north = new JPanel(new GridLayout(1,3));
		JPanel center = new JPanel(new GridLayout(4,4));
		
		//JButton
		//버튼을 배열로 만드는 방식 
		//액션 이벤트와 키 이벤트
		String butLbl[] = {"Backspace","Clear","End"
							,"7","8","9","+"
						   	,"4","5","6","-"
						   	,"1","2","3","*"
						   	,"0",".","=","/"};
		
		//연산결과 보관하는 변수 
		double result;//0.0
		String operator="";
	
	public Calculator2() {
//		super("계산기");//제목
		setLayout(new BorderLayout());//-----
		 resultLbl.setFont(fnt);
		add( resultLbl,"North");
		
		add(frmCenter);//frame center
			frmCenter.add(north,"North");
			frmCenter.add(center);
			
			//button 추가 
			for(int idx=0; idx<butLbl.length;idx++) {//idx=0,1,2,3,4,5,6,7,8,9
				JButton but = new JButton(butLbl[idx]);
				but.setFont(fnt);
				if(idx<=2) {
					north.add(but);
				}else {
					center.add(but);//숫자 , 사칙연산 
				}
				but.addActionListener(this);//이벤트 등록 
			}
		
			setSize(400,250);
			
			setVisible(true);
		//	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
		}

		//오버라이딩
		public void actionPerformed(ActionEvent ae) {
			String eBtn = ae.getActionCommand();//이벤트가 발생한 버튼의 label
			//byte, short, int, char, String
			switch(eBtn){
				case "+" : case "-" : case "/" : case "*" : setOperator(eBtn);break;
				case "=" : getArithemetic();break;
				case "Backspace" : setLastCut();break;
				case "Clear" : setBtnClear();break;
				case "End" : System.exit(0); break; //dispose;
				case "." : setPoint();break;
				case "0" : case "1" : case "2" :
				case "3" : case "4" : case "5" : 
				case "6" : case "7" : case "8" : case "9" :
					setNumber(eBtn);
					break;
			}
		}
		
		//소수점선택시 
		public void setPoint() {
			String txt = resultLbl.getText();
			if(txt.indexOf(".")==-1) {//소수점이 없을때 
				resultLbl.setText(txt+".");
				
			}
		}
		//Backspace버튼 선택시 
		public void setLastCut() {
			String txt = resultLbl.getText();
			if(txt.length()<0) {
				resultLbl.setText(txt.substring(0,txt.length()-1));
			}else { 
				resultLbl.setText("0");	
			}
		}
		//숫자 버튼 선택시 
		public void setNumber(String num) {
			String txt = resultLbl.getText();
			if(resultLbl.getText().equals("0.0")) {//초기값 0.0이 있을때
				resultLbl.setText(num);
			}else{//
				resultLbl.setText(txt+num);
			}
		}
		//연산자(+.-.*./)
		
	public void setOperator(String operator) {
		//라벨값 보관
		result = Double.parseDouble(resultLbl.getText().trim());
		//연산자 보관
		this.operator = operator;
		//라벨초기화 
		resultLbl.setText(" ");
		
	}
	//계산하기 : = 클릭시 
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
//				if(resultLbl.getText().length()>1) {//배열의 길이가 1보다 클경우 
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
	
//	public static void main(String[] args) {
//		new Calculator();
//
//	}	
}


