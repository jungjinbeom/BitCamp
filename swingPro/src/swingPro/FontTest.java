package swingPro;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FontTest extends JFrame {
	Font fnt = new Font("����ü", Font.BOLD+Font.ITALIC,40);
	public FontTest() {
			//Font : �۲� , ����ũ��, ����(����PLAIN, ���ϰ�BOLD, �����ITALIC)�� ������ �� �ִ�
			JLabel lbl = new JLabel("Font Ŭ���� �׽�Ʈ ");
			lbl.setFont(fnt);
			add(lbl);
			
			setSize(400,200);
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FontTest();

	}

}
