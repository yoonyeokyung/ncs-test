package dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import dto.PaymentDTO;
import ticketingAndPayment.MyOutputStream;

public class PaymentDAO {

	Scanner sc = new Scanner(System.in);

	/* 상품 부분 */
	String[] productchoice = { "0", "0", "0", "0", "0" };
	int priceProduct;

	/* 카드 부분 */


	private Object m;

	

	/* movie */
	public String movieTitle(int choiceMovie) {

		String[] movielist = { "신세계", "해리포터" };
		return movielist[choiceMovie - 1];
	}

	public int moviePrice(int choiceMovie) {
		int price;

		if (choiceMovie == 1) {
			price = 7000; // 신세계 가격
		} else {
			price = 5000; // 해리포터 가격
		}

		return price;
	}

	

	/* time */
	public String movieDate(int choicetimne) {

		String[] moviedate = { "25일/월", "26일/화", "27일/수", "28일/목", "29일/금", "30일/토", "31일/일" };
		return moviedate[choicetimne];
	}

	public int movieTime(int choicetimne) {

		int[] moviedate = { 12, 13, 14, 15, 16, 17, 18 };
		return moviedate[choicetimne];
	}
	
	/* seat */
	public String[] movieSeat(int choiceNumber,int choice2) {
	
		
		
		String[] movieSeat = { "a1", "a2", "a3", "a4", "a5" }; // 영화관 이미지 부분 선택 되면 예매 바뀌는 기능
		String[] movieSeatchoice = { "0", "0", "0", "0", "0" }; // 좌석의 기본 값을 가지고 있다가 나중에 return 할떄 예매 부분 남아있는 값 넣어주기
		int movieSeatchoice2 = 1; // 좌석의 기본 값을 가지고 있다가 나중에 return 할떄 예매 부분 남아있는 값 넣어주기
			
			for (int i = 0; i < movieSeatchoice2; i++) {
				if (movieSeatchoice[i].charAt(0) == '0')
					movieSeatchoice[i] = movieSeat[choiceNumber - 1]; // 사용자가 선택한 좌석 번호를 movieSeatchoice 넣어주기
			}
			movieSeatchoice2 += 1;

			movieSeat[choiceNumber - 1] = "예매"; // 사용자가 선택했으니 보여주는 화면에서는 예매라고 보여주기

		return movieSeatchoice;

	}
	
	/* product */
	public String[] productTitle(int choiceProduct , int choiceConut) {
		String[] productList = { "팝콘", "콜라" };
		String[] productListPrice = { "5000", "2000" };
		int choiceNumber = 0; // 사용자가 선택한 번호를 담기 위한 변수
		int price = 0;
			productchoice[choiceNumber] = productList[choiceProduct - 1] + choiceConut;
			for (int i = 0; i < productchoice.length; i++) {
				if (productchoice[i].charAt(0) != '0') {
					if (productchoice[i].charAt(0) == '팝') {
						price += 5000 * choiceConut; // 팝콘
					} else {
						price += 2000 * choiceConut; // 콜라
					}
				}
			}

			choiceNumber++;

		priceProduct = priceProduct + price;
		return productchoice;
	}

	public int productPrice() {
		return priceProduct;
	}
	
	/* card */
	public Double cardDiscount(int choiceCard) {
		Double[] cardListDiscount = { 0.03, 0.05, 0.01, 0.02 };

		return cardListDiscount[choiceCard - 1];
	}

	/* 영와정보 압출력 */
	public String print(String inckName, String movie, String time, String cardName, int pay) {

		ObjectOutputStream objOut = null;
		String print = "예매완료";
		try {

			if (new File("DB/test.txt").exists()) {
				System.out.println("있을 때");
				/* 기존에 파일이 있을 경우 */
				objOut = new MyOutputStream(new BufferedOutputStream(new FileOutputStream("DB/payment.txt", true)));
			} else {
				System.out.println("없을 때");
				/* 기존에 파일이 없을 경우 */
				objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/payment.txt")));
			}

			PaymentDTO paDto = new PaymentDTO(inckName, movie, time, cardName, pay);
			objOut.writeObject(paDto);
			System.out.println("파일 저장 성공!");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
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

	/* 영와정보 압출력 */
	public void print2(String inckName, String seat1, String seat2, String seat3, String seat4, String seat5) {
		ObjectOutputStream objOut = null;
		try {

			if (new File("DB/seat.txt").exists()) {
				System.out.println("있을 때");
				/* 기존에 파일이 있을 경우 */
				objOut = new MyOutputStream(new BufferedOutputStream(new FileOutputStream("DB/seat.txt", true)));
			} else {
				System.out.println("없을 때");
				/* 기존에 파일이 없을 경우 */
				objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/seat.txt")));
			}

			PaymentDTO paDto = new PaymentDTO(inckName, seat1, seat2, seat3, seat4, seat5);
			objOut.writeObject(paDto);
			System.out.println("파일 저장 성공!");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public void print3(String inckName, String product, String product2) {
		ObjectOutputStream objOut = null;
		try {

			if (new File("DB/product.txt").exists()) {
				System.out.println("있을 때");
				/* 기존에 파일이 있을 경우 */
				objOut = new MyOutputStream(new BufferedOutputStream(new FileOutputStream("DB/product.txt", true)));
			} else {
				System.out.println("없을 때");
				/* 기존에 파일이 없을 경우 */
				objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/product.txt")));
			}

			PaymentDTO paDto = new PaymentDTO(inckName, product, product2);
			objOut.writeObject(paDto);
			System.out.println("파일 저장 성공!");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}

}
