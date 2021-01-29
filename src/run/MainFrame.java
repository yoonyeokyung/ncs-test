package run;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		
		this.setBounds(500,500,300,200); // 화면 크기 회의
		
//		new MainPage(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}