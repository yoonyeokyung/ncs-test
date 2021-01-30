package run;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Footer extends JPanel{

	private MainFrame mf;
	private JPanel footer;
	
	public Footer() {}
	
	public Footer(MainFrame mf) {
		this.mf = mf;
		this.footer = this;	
		footer.setPreferredSize(new Dimension(1200,100));
		this.setBackground(Color.RED);
		
		mf.add(footer, "South");
	}
	
}
