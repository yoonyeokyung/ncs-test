package run;

import javax.swing.JFrame;
import run.member.LoginPage;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		
		this.setBounds(200,100,1200,850);
		// setBounds(x좌표,y좌표,가로,세로)
		
		new Header(this);
		new LoginPage(this);
		new Footer(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}