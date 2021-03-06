package runPayment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.PaymentDAO;
import member.MemberManager;
import run.ChangePanel;
import run.MainFrame;
import runPayment.Payment1.MyPanel;

public class Payment1 extends JPanel{

	private test test; 
	private JPanel Payment2;

	ArrayList MovieList = new ArrayList();
	ArrayList areaList = new ArrayList();
	
	PaymentDAO dao = new PaymentDAO();
	String nickName = "송준원";
	int number; // 페이지 넘기는 숫자
	String movie = null; // 영화 이름 변수
	int movidPrice = 0; // 영화 가격 변수
	String movidArea = null; // 영화 장소 변수
	int pay = 0; // 총 금액
	int seatCount = 0; // 영화 좌석 선택 몇번 도는지 카운트 하는 변수
	BufferedImage img = null;
	
	public Payment1(test test) {
			
		this.test = test;
		this.Payment2 = this;
		
		
		test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			img = ImageIO.read(new File("img/movie2.jpg"));
		} catch (IOException e) {
			System.out.println("movie2");
			System.exit(0);
		}
		
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1200, 850);
		Payment2.setLayout(null);

	

		JLabel lb1 = new JLabel();
		MovieList = dao.MovieList();
		areaList = dao.MovieListArea((String) MovieList.get(0));
		int choiceMovie = 0;
		int hight = 350;
		
		JButton[] btn1 = new JButton[areaList.size()];
		
		for (int i = 0; i < areaList.size(); i++) {
			String List = (String) areaList.get(i);
			btn1[i]=new JButton(List);//버튼 초기화
			btn1[i].setBounds(240,hight, 150, 50); //버튼 크기,위치 지정
			hight += 50;
			btn1[i].setBackground(Color.WHITE);
			Payment2.add(btn1[i]);
		}

	
//		movie = (String) MovieList.get(choiceMovie-1);
//		movidPrice = dao.moviePrice(choiceMovie-1);

	
		Payment2.add(panel);
				
		setVisible(true);
		test.add(Payment2);
	
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
}