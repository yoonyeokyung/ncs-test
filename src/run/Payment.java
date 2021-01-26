package run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import account.Member;
import dao.PaymentDAO;

public class Payment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		OutputStream out = null;
		ObjectOutputStream oout = null;
		
		PaymentDAO dao = new PaymentDAO();

		int number;					// 페이지 넘기는 숫자
		String movid = null;		// 영화 이름 변수
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
					movid = dao.movieTitle();
					movidPrice = dao.moviePrice();

					/* 현제 선택 정보 */
					dao.thePresent1(movid, movidPrice);
					
					number = 2;
					break;
					
				case 2:
					System.out.println();
					/* 영화시간 선택 */
					date = dao.movieDate();
					time = dao.movieTime();

					/* 현제 선택 정보 */
					dao.thePresent2(movid, movidPrice, date, time);
					
					number = 3;
					break;
					
				case 3:
					/* 영화 좌석 선택 */
					System.out.println();
					seat = dao.movieSeat();

					/* 현제 선택 정보 */
					dao.thePresent3(movid, movidPrice, date, time, seat, seat2);
					
					number = 4;
					break;
					
				case 4:
					/* 상품 선택 */
					product = dao.productTitle();
					productPrice = dao.productPrice();
					
					/* 총액 구하기 위한 식 */
					aLumpSum = movidPrice * ticketNumber + productPrice;

					/* 현제 선택 정보 */
					dao.thePresent4(movid, movidPrice, date, time, seat, seat2, product, product2, productPrice, aLumpSum);
					
					number = 5;
					break;
					
				case 5:
					/* 카드결재 */
					cardName = dao.cardName();
					cardDiscount = dao.cardDiscount();

					/* 현제 선택 정보 */
					dao.thePresent5(movid, movidPrice, date, time, seat, seat2, product, product2, productPrice, cardName, cardDiscount, aLumpSum);	// 입 출력
					
					/* 입출력 하기 */
					dao.print("송준원", movid, time + "시", cardName, (int)(aLumpSum / 100 * (100-cardDiscount)));	
					
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