package swingPro;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class FrameTest {
	Frame f = new Frame("â�� ����");
	public FrameTest() {
			//â�� ����
			f.setTitle("����ٲ�");
		
			//���� iconImage ǥ�� 
			//	setIconimage(Image image);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image img = kit.getImage("img/img.jpg");
			f.setIconImage(img);
			//â�� ũ�� ����
			//f.setSize(300,400);//px���� 
			Dimension dim = new Dimension(500,500);//width , height���� �������� �����ϴ� ��ü 
			f.setSize(dim);
			
			Rectangle rect =new Rectangle(200,200,400,400);
			//f.setBounds(100,100,300,300);
			f.setBounds(rect);
			//â�� ǥ�� 
			f.setVisible(true);//true: ���� ,false= ���� 
			
		
		}
	

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		new FrameTest();
	}

}
