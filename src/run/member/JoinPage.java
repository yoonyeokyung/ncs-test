package run.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import member.MemberManager;
import run.ChangePanel;
import run.MainFrame;

public class JoinPage extends JPanel{
	
	private MainFrame mf;
	private JPanel joinPage;
	private int idC = 0;
	private int pwC = 0;
	private char gender = '남';
	private MemberManager memberManager = new MemberManager();
	
	public JoinPage(MainFrame mf) {
		this.mf = mf;
		this.joinPage = this;
		joinPage.setPreferredSize(new Dimension(1200,600));
		joinPage.setBackground(Color.WHITE);
		joinPage.setLayout(null);
		
		JLabel join = new JLabel("회원가입");
		join.setBounds(470, 120, 280, 25);
		join.setFont(join.getFont().deriveFont(20.0f));
		joinPage.add(join);

		// Label
		JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(470, 160, 80, 25);
        joinPage.add(idLabel);
        
        JLabel idCheckValue = new JLabel();
        idCheckValue.setBounds(470, 190, 280, 25);
        joinPage.add(idCheckValue);
        
        JLabel pwLabel = new JLabel("PW");
        pwLabel.setBounds(470, 220, 80, 25);
        joinPage.add(pwLabel);
        
        JLabel pwCheckLabel = new JLabel("PW Check");
        pwCheckLabel.setBounds(470, 250, 80, 25);
        joinPage.add(pwCheckLabel);
        
        JLabel pwCheckValue = new JLabel();
        pwCheckValue.setBounds(470, 280, 280, 25);
        joinPage.add(pwCheckValue);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(470, 310, 80, 25);
        joinPage.add(nameLabel);
        
        JLabel birthLabel = new JLabel("Birth");
        birthLabel.setBounds(470, 340, 80, 25);
        joinPage.add(birthLabel);
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(470, 370, 80, 25);
        joinPage.add(genderLabel);
        
        JLabel addrLabel = new JLabel("Address");
        addrLabel.setBounds(470, 400, 80, 25);
        joinPage.add(addrLabel);
       
        // TextField
        JTextField idText = new JTextField(20);
        idText.setBounds(570, 160, 180, 25);
        joinPage.add(idText);
       
        JPasswordField pwText = new JPasswordField(20);
        pwText.setBounds(570, 220, 180, 25);
        joinPage.add(pwText);
        
        JPasswordField pwCheckText = new JPasswordField(20);
        pwCheckText.setBounds(570, 250, 180, 25);
        joinPage.add(pwCheckText);
       
        JTextField nameText = new JTextField(20);
        nameText.setBounds(570, 310, 180, 25);
        joinPage.add(nameText);
        
        JTextField birthText = new JTextField("ex)20210101",20);
        birthText.setBounds(570, 340, 180, 25);
        joinPage.add(birthText);
       
//        JTextField genderText = new JTextField(20);
//        genderText.setBounds(570, 370, 180, 25);
//        joinPage.add(genderText);
        
        JTextField addrText = new JTextField(20);
        addrText.setBounds(570, 400, 180, 25);
        joinPage.add(addrText);
        
        // RadioButton
        JRadioButton btnM = new JRadioButton("남자");
        btnM.setBackground(Color.WHITE);
        btnM.setBounds(570, 370, 90, 25);
        JRadioButton btnW = new JRadioButton("여자");
        btnW.setBackground(Color.WHITE);
        btnW.setBounds(660, 370, 90, 25);
        ButtonGroup gdButton = new ButtonGroup();
        gdButton.add(btnM);
        gdButton.add(btnW);
        joinPage.add(btnM);
        joinPage.add(btnW);
        btnM.setSelected(true);
        
        // Button
        JButton btnIdCheack = new JButton("ID Check");
        btnIdCheack.setBounds(760, 160, 90, 25);
        joinPage.add(btnIdCheack);
        
        JButton btnPwCheack = new JButton("PW Check");
        btnPwCheack.setBounds(760, 250, 90, 25);
        joinPage.add(btnPwCheack);
        
        JButton btnJoin = new JButton("회원가입");
        btnJoin.setBounds(470, 430, 280, 25);
        joinPage.add(btnJoin);
        
        // Anonymous Class
        btnM.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	gender = '남';
            }
            
        });
        
        btnW.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	gender = '여';
            }
            
        });
        
        btnIdCheack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(idText.getText().equals("")) {
            		JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
				}else if(memberManager.doubleCheck(idText.getText())) {
            		idCheckValue.setText("이미 사용중인 ID입니다.");
            		idC = 0;
            	}else {
					idCheckValue.setText("사용 가능한 ID입니다.");
            		idC++;
            	}
            }
            
        });
        
        btnPwCheack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(pwText.getText().equals("") || pwCheckText.getText().equals("")) {
            		JOptionPane.showMessageDialog(null, "PW를 입력해주세요.");
				}else if(pwText.getText().equals(pwCheckText.getText())){
					pwCheckValue.setText("비밀번호가 일치합니다.");
					pwC++;
				}else {
					pwCheckValue.setText("비밀번호가 일치하지 않습니다.");
					pwC = 0;
				}	
            }
            
        });
        
        btnJoin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(idC == 0) {
            		JOptionPane.showMessageDialog(null, "ID 중복확인을 해주세요.");
				}else if(pwC == 0) {
            		JOptionPane.showMessageDialog(null, "비밀번호가 일치하는지 확인해주세요.");
				}else if(nameText.getText().equals("") || birthText.getText().equals("") || birthText.getText().equals("ex)20210101") || addrText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸없이 입력해주세요.");
				}else if(birthText.getText().length() != 8) {
					JOptionPane.showMessageDialog(null, "양식에 맞춰 입력해주세요");
				}else if(memberManager.join(idText.getText(), pwText.getText(), nameText.getText(), birthText.getText(), gender, addrText.getText())) {
					JOptionPane.showMessageDialog(null, "회원가입 성공!");
					ChangePanel.changePanel(mf, joinPage, new LoginPage(mf));
				}else {
					JOptionPane.showMessageDialog(null, "회원가입 실패!");
				}
            }
            
        });

	}

}
