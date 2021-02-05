package runPayment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.PaymentDAO;

public class Payment extends JPanel {

	private test test;
	private JPanel Payment;
	/* 배열 */
	ArrayList MovieList = new ArrayList();

	PaymentDAO dao = new PaymentDAO();
	String nickName = "송준원";
	int number; // 페이지 넘기는 숫자
	String movie = null; // 영화 이름 변수
	int movidPrice = 0; // 영화 가격 변수
	String toDay = null; // 시간 + 이름
	int pay = 0; // 총 금액
	BufferedImage img = null;
	JButton bt;
	
	public Payment(test test) {
		this.test = test;
		this.Payment = this;
		
		test.setSize(1200, 850);
		test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			img = ImageIO.read(new File("img/movie1.jpg"));
		} catch (IOException e) {
			System.out.println("movie1");
			System.exit(0);
		}
		
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1200, 850);
		Payment.setLayout(null);

	

		JLabel lb1 = new JLabel();
		MovieList = dao.MovieList();
		int choiceMovie = 0;
		int hight = 350;
		
		JButton[] btn1 = new JButton[MovieList.size()];
		
		for (int i = 0; i < MovieList.size(); i++) {

			String List = (String) MovieList.get(i);
			btn1[i]=new JButton(List);//버튼 초기화
			btn1[i].setBounds(240,hight, 150, 50); //버튼 크기,위치 지정
			hight += 50;
			Payment.add(btn1[i]);
			btn1[i].setBackground(Color.WHITE);
		}


//		movie = (String) MovieList.get(choiceMovie-1);
//		movidPrice = dao.moviePrice(choiceMovie-1);
		

		Payment.add(panel);
		
	
		setVisible(true);
		
		
		for(int i = 0; i < MovieList.size();i++) {
			btn1[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("안녕");
					ChangePanel.changePanel(test, Payment, new Payment1(test));
				}
			});
			}
		test.add(Payment);
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
		
	
}
