package ticketingAndPayment;

import java.util.Scanner;

import account.Member;

public class Payment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Movie mv = new Movie(); // 영화목록 선택 화면
		MovieTime mt = new MovieTime(); // 영화 시간 선택 화면
		MovieSeat ms = new MovieSeat(); // 영화 좌선 선택 화면
		Product pd = new Product(); // 상품 선택 화면
		Card cd = new Card();				// 카드 또는 쿠폰 선택 화면

		int number;
		String movid = null; 		// 영화 이름 변수
		int movidPrice = 0; 		// 영화 가격 변수
		String date = null; 		// 영화 날짜 변수
		int time = 0; 				// 영화 시간 변수
		String[] seat = null; 		// 영화 좌석 변수
		int ticketNumber = 0; 		// 티켓 겟수를 알아내는 변수
		String[] product = null; 	// 상품 이름 변수
		int productPrice = 0; 		// 상품 가격 변수
		String cardName = null;		// 카드 이름 변수
		Double cardDiscount = 0.0;		// 카드 할인률 변수
		int aLumpSum = 0;			// 총 금액
		
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
					movid = mv.movieTitle();
					movidPrice = mv.moviePrice();

					/* 현재 선택 현황 */
					System.out.println(movid + " " + movidPrice);
					number = 2;
					break;
				case 2:
					System.out.println();
					/* 영화시간 선택 */
					date = mt.movieDate();
					time = mt.movieTime();

					/* 현재 선택 현황 */
					System.out.println(movid + " " + movidPrice + "원");
					System.out.println(date + " " + time + "시");
					number = 3;
					break;
				case 3:
					/* 영화 좌석 선택 */
					System.out.println();
					seat = ms.movieSeat();

					/* 현재 선택 현황 */
					System.out.println(movid + " " + movidPrice + "원");
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
					number = 4;
					break;
				case 4:
					/* 상품 선택 */
					product = pd.productTitle();
					productPrice = pd.productPrice();
					aLumpSum = movidPrice * ticketNumber + productPrice;

					/* 현재 선택 현황 */
					System.out.println(movid + " " + movidPrice + "원");
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
					number = 5;
					break;
				case 5:
					/* 카드결재 */
					cardName = cd.cardName();
					cardDiscount = cd.cardDiscount();
					
					/* 현재 선택 현황 */
					System.out.println(movid + " " + movidPrice + "원");
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
					System.out.println("카드선택 : " + cardName + "카드 할인률 : " + (int)(cardDiscount*100) + "%");
					System.out.println("현재 총 금액 : " + (int)(aLumpSum - (aLumpSum * cardDiscount)) + "원");
					number = 6;
					break;
				default:
					System.out.println("로그인을 해주세요");
				} 	// switch문
				if (number == 6) {
					break;
				}	// if문
			} 		// while문
		} else { 	// if문
			System.out.println("잘못입력했습니다 다시 ㄱㄱ");
		} 			// else문

	} 				// void main 마지막
}