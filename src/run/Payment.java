package run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import dao.PaymentDAO;
import member.MemberManager;

public class Payment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		OutputStream out = null;
		ObjectOutputStream oout = null;
		
		PaymentDAO dao = new PaymentDAO();

		int number;					// 페이지 넘기는 숫자
		String movie = null;		// 영화 이름 변수
		int movidPrice = 0;			// 영화 가격 변수
		String date = null;			// 영화 날짜 변수
		int time = 0; 				// 영화 시간 변수
		String[] seat = null;		// 영화 좌석 변수
		String seat2 = null; 		// 영화 좌석2 변수 DTO에 담아줄 변수
		int ticketNumber = 0; 		// 티켓 겟수를 알아내는 변수
		String[] product = null;	// 상품 이름 변수
		String product2 = null; 	// 상품2 이름 변수 DTO에 담아줄 변수
		int productPrice = 0; 		// 상품 가격 변수
		String cardName = null; 	// 카드 이름 변수
		Double cardDiscount = 0.0; 	// 카드 할인률 변수
		int aLumpSum = 0; 			// 총 금액

		System.out.println("텔레코딩 영화관에 오신걸 환영합니다 ㅎ");
		System.out.println("1. 메인페이지에서 예매하기 클리시");
		System.out.println("2. 영화 정보 보다가 예매하기 클릭시");
		System.out.println("9. 나가기");

		System.out.print("입력 : ");
		number = sc.nextInt();			

		if (number == 1 || number == 2) {
			while (true) {
				switch (number) {
				
				case 1:
					System.out.println();
					/* 영화선택 */
					movie = dao.movieTitle();
					movidPrice = dao.moviePrice();

					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println();
					
					number = 2;
					break;
					
				case 2:
					System.out.println();
					/* 영화시간 선택 */
					date = dao.movieDate();
					time = dao.movieTime();

					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println(date + " " + time + "시");
					
					number = 3;
					break;
					
				case 3:
					/* 영화 좌석 선택 */
					System.out.println();
					seat = dao.movieSeat();

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
					dao.print2("송준원",seat[0], seat[1], seat[2], seat[3], seat[4]);
					
					number = 4;
					break;
					
				case 4:
					/* 상품 선택 */
					product = dao.productTitle();
					productPrice = dao.productPrice();
					
					

					
					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println(date + " " + time + "시");
					System.out.print("좌석번호 : ");
					for (int i = 0; i < seat.length; i++) {
						if (seat[i].charAt(0) != '0') {
							System.out.print(seat[i] + "번호  ");
						}
					}
					System.out.println();
					for (int i = 0; i < product.length; i++) {
						if (product[i].charAt(0) != '0') {
							System.out.print("상품 : " + product[i]);
						}
					}
					/* 총액 구하기 위한 식 */
					aLumpSum = movidPrice * ticketNumber + productPrice;
					System.out.println("상품 총 금액 : " + productPrice);
					System.out.println("현재 총 금액 : " + aLumpSum + "원");
					System.out.println();
					dao.print3("송준원",product[0], product[1]);
					number = 5;
					break;
					
				case 5:
					/* 카드결재 */
					cardName = dao.cardName();
					cardDiscount = dao.cardDiscount();

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
					System.out.println("현재 총 금액 : " + (int) (aLumpSum - (aLumpSum * (cardDiscount/100))) + "원");
					System.out.println();
					
					/* 입출력 하기 */
					dao.print("송준원", movie, time + "시", cardName, (int)(aLumpSum - (aLumpSum * (cardDiscount/100))));
					
					
					number = 6;
					break;
					
				default:
					System.out.println("로그인을 해주세요");
				} // switch문
				
				if (number == 6) {
					break;
				} // if문
			} // while문
		} else { // if문
			
			System.out.println("잘못입력했습니다 다시 ㄱㄱ");
		} // else문

	} // void main 마지막
}