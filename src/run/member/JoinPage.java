package run.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import run.MainFrame;

public class JoinPage extends JPanel{
	
	private MainFrame mf;
	private JPanel joinPage;
	private JButton btnLogin;
	private JButton btnJoin;
    private JButton btnSearchId;
    private JButton btnSearchPw;
    private JPasswordField pwText;
    private JTextField idText;
	
	public JoinPage() {}
	
	public JoinPage(MainFrame mf) {
		this.mf = mf;
		this.joinPage = this;
		joinPage.setPreferredSize(new Dimension(1200,600));
		this.setBackground(Color.WHITE);
		joinPage.setLayout(null);
		
		JLabel login = new JLabel("회원가입");
		login.setBounds(470, 120, 280, 25);
		login.setFont(login.getFont().deriveFont(20.0f));
		joinPage.add(login);

		JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(470, 160, 80, 25);
        joinPage.add(idLabel);
        
        JLabel pwLabel = new JLabel("PW");
        pwLabel.setBounds(470, 190, 80, 25);
        joinPage.add(pwLabel);
       
        idText = new JTextField(20);
        idText.setBounds(570, 160, 180, 25);
        joinPage.add(idText);
       
        pwText = new JPasswordField(20);
        pwText.setBounds(570, 190, 180, 25);
        joinPage.add(pwText);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(470, 220, 280, 25);
        joinPage.add(btnLogin);
        
        btnSearchId = new JButton("ID 찾기");
        btnSearchId.setBounds(470, 250, 90, 25);
        joinPage.add(btnSearchId);
        
        btnSearchId.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SerchID();
            }
            
        });

        btnSearchPw = new JButton("PW 찾기");
        btnSearchPw.setBounds(565, 250, 90, 25);
        joinPage.add(btnSearchPw);
        
        btnSearchPw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SerchPW();
            }
            
        });
        
        btnJoin = new JButton("회원가입");
        btnJoin.setBounds(660, 250, 90, 25);
        joinPage.add(btnJoin);
        
//        btnJoin.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new Join();
//            }
//            
//        });
		
		mf.add(joinPage,"Center");

	}

}
