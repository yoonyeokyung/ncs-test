package run;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		
		this.setBounds(300,300,1200,200); // 화면 크기 회의
		// setBounds(x좌표,y좌표,가로,세로)
//		new MainPage(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}