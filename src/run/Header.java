package run;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Header extends JPanel{
	
	private MainFrame mf;
	private JPanel header;
	
	public Header() {}
	
	public Header(MainFrame mf) {
		this.mf = mf;
		this.header = this;
		header.setPreferredSize(new Dimension(1200,150));
		this.setBackground(Color.BLUE);
		
		mf.add(header, "North");
	}

}
