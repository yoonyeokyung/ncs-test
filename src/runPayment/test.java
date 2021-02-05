package runPayment;

import javax.swing.JFrame;

import run.member.Login;

public class test  extends JFrame{

	public test() {

		this.setBounds(200,100,1200,850);
		// setBounds(x좌표,y좌표,가로,세로)
		
//		new Payment(this);
		new Payment(this);

		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}
