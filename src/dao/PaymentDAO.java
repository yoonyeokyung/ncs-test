package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import dto.PaymentDTO;


public class PaymentDAO {
	
	Scanner sc = new Scanner(System.in);	
	
	/* 입출력 */
	OutputStream out = null;				
	ObjectOutputStream oout = null;
	InputStream in = null;
	ObjectInputStream oin = null;
	
	/* 상품 부분 */
	int choiceProduct;
	int choiceProduct2;
	String[] productchoice = {"0" , "0", "0", "0", "0"};
	/* 영화 부분 */
	int choiceMovie;
	/* 시간 부분 */
	int choicetimne;
	/* 카드 부분 */
	int choiceCard;

	private Object m;

	
	/* product */
	public String[] productTitle() {
		String[] productList = { "팝콘", "콜라" };
		int choiceNumber = 0; // 사용자가 선택한 번호를 담기 위한 변수
		int loop = 0;
		while (loop == 0) {

			System.out.println("1. 팝콘 ");
			System.out.println("2. 콜라");
			System.out.print("상품을 선택해 주세요 : ");
			choiceProduct = sc.nextInt();
			sc.nextLine();

			productchoice[choiceNumber] = productList[choiceProduct - 1];
			choiceNumber++;

			System.out.println("1. 상품 더 선택하기");
			System.out.println("2. 그만선택하기");
			System.out.print("번호을 선택해 주세요 : ");
			choiceProduct2 = sc.nextInt();
			sc.nextLine();

			if (choiceProduct2 == 2) { // 반복문 나가기
				loop++;
			} // if문

		} // while문
		return productchoice;
	}

	public int productPrice() {
		int price = 0;
		String[] productListPrice = { "5000", "2000" };
		for (int i = 0; i < productchoice.length; i++) {
			if (productchoice[i].charAt(0) != '0') {
				if (productchoice[i].charAt(0) == '팝') {
					price += 5000; // 팝콘
				} else {
					price += 2000; // 콜라
				}
			}
		}
		return price;
	}

	/* movie */
	public String movieTitle() {

		String[] movielist = { "신세계", "해리포터" };
		while (true) {
			System.out.println("1. 신세계 ");
			System.out.println("2. 해리포터");
			System.out.print("영화를 선택해 주세요 : ");
			choiceMovie = sc.nextInt();
			sc.nextLine();
			if (choiceMovie == 1 || choiceMovie == 2) {
				break;
			}
			System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
		}
		return movielist[choiceMovie-1];
	}

	public int moviePrice() {
		int price;

		if (choiceMovie == 1) {
			price = 7000; // 신세계 가격
		} else {
			price = 5000; // 해리포터 가격
		}

		return price;
	}

	/* seat */
	public String[] movieSeat() {
		int a = 0;
		int[] choice = new int[4];
		int choice2;
		String[] movieSeat = { "a1", "a2", "a3", "a4", "a5" }; // 영화관 이미지 부분 선택 되면 예매 바뀌는 기능
		String[] movieSeatchoice = { "0", "0", "0", "0", "0" }; // 좌석의 기본 값을 가지고 있다가 나중에 return 할떄 예매 부분 남아있는 값 넣어주기
		int movieSeatchoice2 = 1; // 좌석의 기본 값을 가지고 있다가 나중에 return 할떄 예매 부분 남아있는 값 넣어주기

		while (a == 0) {
			int choiceNumber = 0; // 사용자가 선택한 번호를 담기 위한 변수

			System.out.println("1. " + movieSeat[0]);
			System.out.println("2. " + movieSeat[1]);
			System.out.println("3. " + movieSeat[2]);
			System.out.println("4. " + movieSeat[3]);
			System.out.println("5. " + movieSeat[4]);
			System.out.print("좌석을 선택해 주세요 : ");
			choice[choiceNumber] = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < movieSeatchoice2; i++) {
				if (movieSeatchoice[i].charAt(0) == '0')
					movieSeatchoice[i] = movieSeat[choice[choiceNumber] - 1]; // 사용자가 선택한 좌석 번호를 movieSeatchoice 넣어주기
			}
			movieSeatchoice2 += 1;

			movieSeat[choice[choiceNumber] - 1] = "예매"; // 사용자가 선택했으니 보여주는 화면에서는 예매라고 보여주기

			System.out.println("1. 좌석 더 선택하기");
			System.out.println("2. 그만선택하기");
			System.out.print("번호을 선택해 주세요 : ");
			choice2 = sc.nextInt();
			sc.nextLine();

			if (choice2 == 2) { // 반복문 나가기
				a++;
			} // if문

		} // while문

		return movieSeatchoice;

	}

	/* time */
	public String movieDate() {

		String[] moviedate = { "25일/월", "26일/화", "27일/수", "28일/목", "29일/금", "30일/토", "31일/일" };
		while (true) {
			System.out.println("1. " + moviedate[0]);
			System.out.println("2. " + moviedate[1]);
			System.out.println("3. " + moviedate[2]);
			System.out.println("4. " + moviedate[3]);
			System.out.println("5. " + moviedate[4]);
			System.out.println("6. " + moviedate[5]);
			System.out.println("7. " + moviedate[6]);
			System.out.print("요일을 선택해 주세요 : ");
			choicetimne = sc.nextInt();
			sc.nextLine();
			if (choicetimne == 1 || choicetimne == 2 || choicetimne == 3 || choicetimne == 4 || choicetimne == 5 || choicetimne == 6 || choicetimne == 7) {
				break;
			}
			System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
		}

		return moviedate[choicetimne];
	}

	public int movieTime() {

		int[] moviedate = { 12, 13, 14, 15, 16, 17, 18 };
		while (true) {
			System.out.println("1. " + moviedate[0]);
			System.out.println("2. " + moviedate[1]);
			System.out.println("3. " + moviedate[2]);
			System.out.println("4. " + moviedate[3]);
			System.out.println("5. " + moviedate[4]);
			System.out.println("6. " + moviedate[5]);
			System.out.println("7. " + moviedate[6]);
			System.out.print("시간을 선택해 주세요 : ");
			choicetimne = sc.nextInt();
			sc.nextLine();
			if (choicetimne == 1 || choicetimne == 2 || choicetimne == 3 || choicetimne == 4 || choicetimne == 5 || choicetimne == 6 || choicetimne == 7) {
				break;
			}
			System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
		}

		return moviedate[choicetimne];
	}

	/* card */
	public String cardName() {
		String[] cardList = { "카카오뱅크", "우리은행", "기업은행", "삼성페이" };
		int a = 0;
		while (true) {
			System.out.println("1. 카카오뱅크 ");
			System.out.println("2. 우리은행");
			System.out.println("3. 기업은행");
			System.out.println("4. 삼성페이");
			System.out.print("카드를 선택해 주세요 : ");
			choiceCard = sc.nextInt();
			sc.nextLine();
			switch (choiceCard) {
			case 1:
				return cardList[choiceCard - 1];
			case 2:
				return cardList[choiceCard - 1];
			case 3:
				return cardList[choiceCard - 1];
			case 4:
				return cardList[choiceCard - 1];
			default:
				System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
			}
		}
	}

	public Double cardDiscount() {
		Double[] cardListDiscount = { 0.03, 0.05, 0.01, 0.02 };

		return cardListDiscount[choiceCard - 1];
	}
	
	/* 영와정보 압출력 */
	public String print(String inckName, String movie, String time, String cardName, int pay) {
		String print = "예매완료";	
		FileReader fr = null;
		try {
			out = new FileOutputStream("test.txt");
			oout = new ObjectOutputStream(out);

			PaymentDTO paDto1 = new PaymentDTO(inckName, movie, time + "시", cardName, pay);
//			PaymentDTO m = (PaymentDTO) oin.readObject();
//			oout.writeObject(m); // Member의 객체를 Object화 하여 3개의 객체를 저장
			oout.writeObject(paDto1); // Member의 객체를 Object화 하여 3개의 객체를 저장

			System.out.println("파일 저장 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		try {
//			out = new FileOutputStream("test.txt");
//			oout = new ObjectOutputStream(out);			
//
//			
//		
//			PaymentDTO paDto = new PaymentDTO(inckName, movie, time + "시", cardName, pay);
//
//			oout.writeObject(paDto); //저장
//			
//			System.out.println("파일 저장 성공!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				oout.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		return print;
	}
	
	/* 현재 상황 */
	public void thePresent1(String movie, int movidPrice) {
		/* 현재 선택 현황 */
		System.out.println(movie + " " + movidPrice + "원");
		System.out.println();
	}
	public void thePresent2(String movie, int movidPrice, String date, int time) {
		/* 현재 선택 현황 */
		System.out.println(movie + " " + movidPrice + "원");
		System.out.println(date + " " + time + "시");
	}
	public void thePresent3(String movie, int movidPrice, String date, int time,String[] seat,String seat2) {
		int ticketNumber=0;
		/* 현재 선택 현황 */
		System.out.println(movie + " " + movidPrice + "원");
		System.out.println(date + " " + time + "시");
		System.out.print("좌석번호 : ");
		for (int i = 0; i < seat.length; i++) {
			if (seat[i].charAt(0) != '0') {
				System.out.print(seat[i] + "번호  ");
				ticketNumber++;
			}
		}
		System.out.println();
		System.out.println("현재 총 금액 : " + movidPrice * ticketNumber + "원");
		System.out.println();
	}
	public void thePresent4(String movie, int movidPrice, String date, int time,String[] seat,String seat2,String[] product,String product2,int productPrice,int aLumpSum) {
		int ticketNumber=0;
		/* 현재 선택 현황 */
		System.out.println(movie + " " + movidPrice + "원");
		System.out.println(date + " " + time + "시");
		System.out.print("좌석번호 : ");
		for (int i = 0; i < seat.length; i++) {
			if (seat[i].charAt(0) != '0') {
				System.out.print(seat[i] + "번호  ");
				ticketNumber++;
			}
		}
		System.out.println();
		for (int i = 0; i < product.length; i++) {
			if (product[i].charAt(0) != '0') {
				System.out.print("상품 : " + product[i]);
				ticketNumber++;
			}
		}
		System.out.println("상품 총 금액 : " + productPrice);
		System.out.println("현재 총 금액 : " + aLumpSum + "원");
		System.out.println();
	}
	
	public void thePresent5(String movie, int movidPrice, String date, int time,String[] seat,String seat2,String[] product,String product2,int productPrice,String cardName,Double cardDiscount,int aLumpSum) {
		int ticketNumber=0;
		/* 현재 선택 현황 */
		System.out.println(movie + " " + movidPrice + "원");
		System.out.println(date + " " + time + "시");
		System.out.print("좌석번호 : ");
		for (int i = 0; i < seat.length; i++) {
			if (seat[i].charAt(0) != '0') {
				System.out.print(seat[i] + "번호  ");
				seat2 += seat[i] + " ";
				ticketNumber++;
			}
		}
		System.out.println();
		for (int i = 0; i < product.length; i++) {
			if (product[i].charAt(0) != '0') {
				System.out.print("상품 : " + product[i]);
				product2 += product[i] + " ";
				ticketNumber++;
			}
		}
		System.out.println("상품 총 금액 : " + productPrice);
		System.out.println("카드선택 : " + cardName + "카드 할인률 : " + (int) (cardDiscount * 100) + "%");
		System.out.println("현재 총 금액 : " + (int) (aLumpSum - (aLumpSum * cardDiscount)) + "원");
		System.out.println();
	}
}
