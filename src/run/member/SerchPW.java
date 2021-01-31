package run.member;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SerchPW extends JFrame {
    // 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
	SerchPW() {
        setTitle("PW 찾기");

        
        JPanel searchP = new JPanel();
        searchP.setLayout(null);
        setContentPane(searchP);
        
        JLabel searchL = new JLabel("회원님의 이름과 ID를 입력해주세요.");
        searchL.setBounds(10, 10, 200, 25);
        searchP.add(searchL);
        
        JLabel nmLabel = new JLabel("NAME : ");
        nmLabel.setBounds(10, 50, 80, 25);
        searchP.add(nmLabel);
        
        JTextField nmText = new JTextField(20);
        nmText.setBounds(110, 50, 100, 25);
        searchP.add(nmText);
        
        JLabel idLabel = new JLabel("ID : ");
        idLabel.setBounds(10, 90, 80, 25);
        searchP.add(idLabel);
        
        JTextField idText = new JTextField(20);
        idText.setBounds(110, 90, 100, 25);
        searchP.add(idText);
        
        JButton btnSearch = new JButton("PW 찾기");
        btnSearch.setBounds(10, 130, 200, 25);
        searchP.add(btnSearch);
        
        JLabel value = new JLabel();
        value.setBounds(10, 170, 200, 25);
        searchP.add(value);
        
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//               JLabel 안에 변수명 입력해야함
            	value.setText("사용자의 비밀번호값");
            }
            
        });
        
        setBounds(200, 200, 240, 260);
        setResizable(false);
        setVisible(true);
	}
}
