package swingPro;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class FrameTest {
	Frame f = new Frame("창의 제목");
	public FrameTest() {
			//창의 제목
			f.setTitle("제목바꿈");
		
			//제목에 iconImage 표시 
			//	setIconimage(Image image);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image img = kit.getImage("img/img.jpg");
			f.setIconImage(img);
			//창의 크기 설정
			//f.setSize(300,400);//px단위 
			Dimension dim = new Dimension(500,500);//width , height값의 두정수를 보관하는 객체 
			f.setSize(dim);
			
			Rectangle rect =new Rectangle(200,200,400,400);
			//f.setBounds(100,100,300,300);
			f.setBounds(rect);
			//창의 표시 
			f.setVisible(true);//true: 보임 ,false= 숨김 
			
		
		}
	

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		new FrameTest();
	}

}
