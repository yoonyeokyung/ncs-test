package run;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JPanel{
	
	private MainFrame mf;
	private JPanel loginPage;
	private JButton btnLogin;
	private JButton btnJoin;
    private JButton btnSearchId;
    private JButton btnSearchPw;
    private JPasswordField pwText;
    private JTextField idText;
	
	public LoginPage() {}
	
	public LoginPage(MainFrame mf) {
		this.mf = mf;
		this.loginPage = this;
		loginPage.setPreferredSize(new Dimension(1200,600));
		this.setBackground(Color.WHITE);
		loginPage.setLayout(null);

		JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(470, 110, 80, 25);
        loginPage.add(idLabel);
        
        JLabel pwLabel = new JLabel("PW");
        pwLabel.setBounds(470, 140, 80, 25);
        loginPage.add(pwLabel);
       
        idText = new JTextField(20);
        idText.setBounds(570, 110, 180, 25);
        loginPage.add(idText);
       
        pwText = new JPasswordField(20);
        pwText.setBounds(570, 140, 180, 25);
        loginPage.add(pwText);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(470, 180, 280, 25);
        loginPage.add(btnLogin);
        
        btnSearchId = new JButton("ID 찾기");
        btnSearchId.setBounds(470, 220, 90, 25);
        loginPage.add(btnSearchId);
        
        btnSearchPw = new JButton("PW 찾기");
        btnSearchPw.setBounds(565, 220, 90, 25);
        loginPage.add(btnSearchPw);
        
        btnJoin = new JButton("회원가입");
        btnJoin.setBounds(660, 220, 90, 25);
        loginPage.add(btnJoin);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(630, 180, 300, 25);
        loginPage.add(btnLogin);
        
        
        
        
        
        
		// Header
		JLabel headerTop = new JLabel();
		headerTop.setOpaque(true); 
		headerTop.setBackground(new Color(95, 0, 128));
		headerTop.setPreferredSize(new Dimension(1200, 10));
		JLabel header = new JLabel();
		header.setOpaque(true); 
		header.setBackground(Color.BLUE);
		header.setPreferredSize(new Dimension(1200, 140));
		
		mf.add(loginPage,"Center");

	}

}
