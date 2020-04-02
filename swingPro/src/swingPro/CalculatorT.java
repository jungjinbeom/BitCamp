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

public class CalculatorT extends JFrame implements ActionListener{
	Font fnt = new Font("Arial", Font.BOLD, 30);
	String inputStr = "";
	double firstNum;
	String func = "ADD";
	
	
	
	
    JLabel tf = new JLabel("0.0", JLabel.RIGHT);
    JPanel frmCenter = new JPanel(new BorderLayout());
        JPanel north = new JPanel(new GridLayout(1,3));
        JPanel center = new JPanel(new GridLayout(4,4));
        
        //JBotton
        String butLbl[] = {"Backspace","Clear","End",
        		              "7","8","9","+",
        		              "4","5","6","-", 
        		              "1","2","3","*",
        		              "0",".","=","/",};
	public CalculatorT() {
		super("계산기");
		tf.setFont(fnt);
		add(tf, "North");
		
		add(frmCenter);//frame Center
		    frmCenter.add(north,"North");
		    frmCenter.add(center);
		    
		//button 추가
		for(int idx=0; idx<butLbl.length; idx++) {
			JButton but = new JButton(butLbl[idx]);
			but.setFont(fnt);
			if(idx<=2) {
				north.add(but);
			}else {
				center.add(but);
			}
			but.addActionListener(this);
		} 
		
		setSize(400,250);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		 String butLbl = ae.getActionCommand();
		 if(butLbl.equals("0") || butLbl.equals("1") || butLbl.equals("2") || butLbl.equals("3") ||
			 butLbl.equals("4") || butLbl.equals("5") || butLbl.equals("6") || butLbl.equals("7") ||
			 butLbl.equals("8") || butLbl.equals("9") ) 
		 {
			 inputStr+=butLbl;
			 tf.setText(inputStr);
		 }
		 if(butLbl.equals("Backspace")) {
			 if(tf.getText().length()>1) {
				 String result = inputStr.substring(0, tf.getText().length()-1);
				 tf.setText(inputStr=result);
			 }else if(tf.getText().length()<=1) {
				 tf.setText(inputStr=" ");
			 }
		 }else if(butLbl.equals("Clear")) {
			 inputStr = " ";
			 tf.setText(inputStr);
		 }else if(butLbl.equals("End")){
			 dispose();
		     System.exit(0);
		 }else if(butLbl.equals("+")) {
			 String curr = tf.getText();
			   firstNum = Double.parseDouble(curr);
			   tf.setText(inputStr = " ");
			   func = "ADD";
		 }else if(butLbl.equals("-")) {
			 String curr = tf.getText();
				firstNum = Double.parseDouble(curr);
				tf.setText(inputStr = " ");
				func = "MIN";
		 }else if(butLbl.equals("*")) {
			 String curr = tf.getText();
				firstNum = Double.parseDouble(curr);
				tf.setText(inputStr = " ");
				func = "MUL";
		 }else if(butLbl.equals("/")) {
			 String curr = tf.getText();
				firstNum = Double.parseDouble(curr);
				tf.setText(inputStr = " ");
				func = "DIV";
		 }else if(butLbl.equals(".")) {
				inputStr += butLbl;
				tf.setText(inputStr);
		 }else if(butLbl.equals("=")) {
			 switch(func) {
			       case "ADD":{
			    	   double currVal = Double.parseDouble(tf.getText());
			    	   tf.setText((firstNum+currVal)+"");
			    	   break;
			       }case "MIN":{
			    	   double currVal = Double.parseDouble(tf.getText());
			    	   tf.setText((firstNum-currVal)+"");
			    	   break;
			       }case "MUL":{
			    	   double currVal = Double.parseDouble(tf.getText());
			    	   tf.setText((firstNum*currVal)+"");
			    	   break;
			       }case "DIV":{
			    	   double currVal = Double.parseDouble(tf.getText());
			    	   tf.setText((firstNum/currVal)+"");
			    	   break;
			       }
			 }
		 }
	
	}

	public static void main(String[] args) {
		new CalculatorT();

	}

}
