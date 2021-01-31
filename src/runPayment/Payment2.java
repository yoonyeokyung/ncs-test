package runPayment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import dao.PaymentDAO;
import movieInformation.arraylist.Movies.MovieList;

public class Payment2 extends JFrame {
	Scanner sc = new Scanner(System.in);

	OutputStream out = null;
	ObjectOutputStream oout = null;

	/* 배열 */
	ArrayList productList = new ArrayList(); // 상품 이름만 받아오기
	ArrayList ProductListPrice = new ArrayList(); // 상품 가격만 받아오기
	ArrayList MovieList = new ArrayList();
	ArrayList areaList = new ArrayList();
	ArrayList dateList = new ArrayList();
	ArrayList timeList = new ArrayList();
	ArrayList seatList = new ArrayList();

	PaymentDAO dao = new PaymentDAO();
	String nickName = "송준원";
	int number; // 페이지 넘기는 숫자
	String movie = null; // 영화 이름 변수
	int movidPrice = 0; // 영화 가격 변수
	String movidArea = null; // 영화 장소 변수
	String date = null; // 영화 날짜 변수
	String time = null; // 영화 시간 변수
	String seat2[] = null; // 영화 좌석 변수
	String seat = ""; // 영화 좌석2 변수 DTO에 담아줄 변수
	int ticketPrice = 0; // 티켓 겟수를 알아내는 변수
	String product2 = ""; // 상품 이름 변수
	String product = ""; // 상품2 이름 변수 DTO에 담아줄 변수
	int productPrice = 0; // 상품 가격 변수
	String cardName = null; // 카드 이름 변수
	double cardDiscount = 0; // 카드 할인률 변수
	String toDay = null; // 시간 + 이름
	int pay = 0; // 총 금액
	int seatCount = 0; // 영화 좌석 선택 몇번 도는지 카운트 하는 변수
	BufferedImage img = null;
//    JTextField loginTextField;
//    JPasswordField passwordField;
	JButton bt;

	public static void main(String[] args) {
		new Payment2();
	}

	public Payment2() {
		setTitle("Payment");
		setSize(1200, 850);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1200, 850);

		try {
			img = ImageIO.read(new File("img/movie2.jpg"));
		} catch (IOException e) {
			System.out.println("movie2");
			System.exit(0);
		}

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1200, 850);
		layeredPane.setLayout(null);

	

		JLabel lb1 = new JLabel();
		MovieList = dao.MovieList();
		areaList = dao.MovieListArea((String) MovieList.get(0));
		int choiceMovie = 0;
		int hight = 350;
		
		JButton[] btn1 = new JButton[areaList.size()];
		
		for (int i = 0; i < areaList.size(); i++) {
//			System.out.println((i + 1) + ". " + MovieList.get(i));
			String List = (String) areaList.get(i);
			btn1[i]=new JButton(List);//버튼 초기화
			btn1[i].setBounds(240,hight, 150, 50); //버튼 크기,위치 지정
			hight += 50;
			layeredPane.add(btn1[i]);
			btn1[i].setBackground(Color.WHITE);
		}


//		movie = (String) MovieList.get(choiceMovie-1);
//		movidPrice = dao.moviePrice(choiceMovie-1);

//        loginTextField = new JTextField(15);
//        loginTextField.setBounds(770, 420, 280, 30);
//        layeredPane.add(loginTextField);
//        loginTextField.setOpaque(false);
//        loginTextField.setForeground(Color.white);
//        loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//     
//        passwordField = new JPasswordField(15);
//        passwordField.setBounds(771, 460, 280, 30);
//        passwordField.setOpaque(false);
//        passwordField.setForeground(Color.white);
//        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        layeredPane.add(passwordField);


		layeredPane.add(panel);
		getContentPane().add(layeredPane);
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

}