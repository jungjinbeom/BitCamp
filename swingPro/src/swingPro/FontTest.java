package swingPro;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FontTest extends JFrame {
	Font fnt = new Font("돋움체", Font.BOLD+Font.ITALIC,40);
	public FontTest() {
			//Font : 글꼴 , 글자크기, 유형(보통PLAIN, 진하게BOLD, 기울임ITALIC)을 설정할 수 있다
			JLabel lbl = new JLabel("Font 클래스 테스트 ");
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
