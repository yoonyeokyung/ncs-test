package run.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dto.MemberDTO;
import member.MemberManager;
import run.ChangePanel;
import run.MainFrame;

public class LoginPage extends JPanel{
	
	private MainFrame mf;
	private JPanel loginPage;
	private MemberManager memberManager = new MemberManager();
	
	public LoginPage() {}
	
	public LoginPage(MainFrame mf) {
		this.mf = mf;
		this.loginPage = this;
		loginPage.setPreferredSize(new Dimension(1200,600));
		loginPage.setBackground(Color.WHITE);
		loginPage.setLayout(null);
		
		JLabel login = new JLabel("LOGIN");
		login.setBounds(470, 120, 280, 25);
		login.setFont(login.getFont().deriveFont(20.0f));
        loginPage.add(login);

        // Label
        
		JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(470, 160, 80, 25);
        loginPage.add(idLabel);
        
        JLabel pwLabel = new JLabel("PW");
        pwLabel.setBounds(470, 190, 80, 25);
        loginPage.add(pwLabel);
        
        // TextField
        
        JTextField idText = new JTextField(20);
        idText.setBounds(570, 160, 180, 25);
        loginPage.add(idText);
       
        JPasswordField pwText = new JPasswordField(20);
        pwText.setBounds(570, 190, 180, 25);
        loginPage.add(pwText);
        
        // Button
        JButton btnSearchId = new JButton("ID 찾기");
        btnSearchId.setBounds(470, 250, 90, 25);
        loginPage.add(btnSearchId);
        
        JButton btnSearchPw = new JButton("PW 찾기");
        btnSearchPw.setBounds(565, 250, 90, 25);
        loginPage.add(btnSearchPw);
        
        JButton btnJoin = new JButton("회원가입");
        btnJoin.setBounds(660, 250, 90, 25);
        loginPage.add(btnJoin);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(470, 220, 280, 25);
        loginPage.add(btnLogin);
        
        // Anonymous Class
        btnSearchId.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SerchID();
            }
            
        });
        
        btnSearchPw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SerchPW();
            }
            
        });
        
        btnJoin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	ChangePanel.changePanel(mf, loginPage, new JoinPage(mf));
            }
            
        });
        
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	MemberDTO memberInfo = memberManager.login(idText.getText(), pwText.getText());
            	if(memberInfo != null) {
            		JOptionPane.showMessageDialog(null, "로그인 성공");
            	} else {
            		JOptionPane.showMessageDialog(null, "ID 혹은 PW가 다릅니다.");
            	}
//            	ChangePanel.changePanel(mf, loginPage, new mainPage(mf));
            }
            
        });
		
		mf.add(loginPage,"Center");

	}

}
