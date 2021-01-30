package run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import dao.PaymentDAO;
import member.MemberManager;

public class Payment {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		OutputStream out = null;
		ObjectOutputStream oout = null;

		/* 배열 */
		ArrayList productList = new ArrayList();		// 상품 이름만 받아오기
		ArrayList ProductListPrice = new ArrayList();		// 상품 가격만 받아오기
		
		PaymentDAO dao = new PaymentDAO();
		String nickName = "송준원";
		int number; // 페이지 넘기는 숫자
		String movie = null; // 영화 이름 변수
		int movidPrice = 0; // 영화 가격 변수
		String date = null; // 영화 날짜 변수
		int time = 0; // 영화 시간 변수
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
		int seatCount = 0; 										// 영화 좌석 선택 몇번 도는지 카운트 하는 변수

		System.out.println("텔레코딩 영화관에 오신걸 환영합니다 ㅎ");
		System.out.println("1. 메인페이지에서 예매하기 클리시");
		System.out.println("2. 영화 정보 보다가 예매하기 클릭시");
		System.out.println("9. 나가기");

		System.out.print("입력 : ");
		number = sc.nextInt();

		if (number == 1 || number == 2) {
			while (true) {
				switch (number) {

				case 1: /* 영화선택 */
					int choiceMovie = 0;
					System.out.println();
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

					movie = dao.movieTitle(choiceMovie);
					movidPrice = dao.moviePrice(choiceMovie);

					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println();

					number = 2;
					break;

				case 2: /* 영화시간 선택 */
					int choicetimne = 0;
					int moviedate = 0;
					System.out.println();

					String[] moviedate1 = { "25일/월", "26일/화", "27일/수", "28일/목", "29일/금", "30일/토", "31일/일" };
					while (true) {
						for (int i = 0; i < moviedate1.length; i++) {
							System.out.println((i + 1) + ". " + moviedate1[i]);
						}
						System.out.print("요일을 선택해 주세요 : ");
						choicetimne = sc.nextInt();
						sc.nextLine();
						if (choicetimne >= 1 && choicetimne <= moviedate1.length) {
							break;
						}
						System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
					}
					date = dao.movieDate(choicetimne);
					int[] moviedate11 = { 12, 13, 14, 15, 16, 17, 18 };
					while (true) {
						for (int i = 0; i < moviedate11.length; i++) {
							System.out.println((i + 1) + ". " + moviedate11[i]);
						}

						System.out.print("시간을 선택해 주세요 : ");
						choicetimne = sc.nextInt();
						sc.nextLine();
						if (choicetimne >= 1 && choicetimne <= moviedate11.length) {
							break;
						}
						System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
					}
					time = dao.movieTime(choicetimne);

					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println(date + " " + time + "시");

					number = 3;
					break;

				case 3: /* 좌석 선택 */
					String[] movieSeat = { "a1", "a2", "a3", "a4", "a5" }; 	// 영화관 이미지 부분 선택 되면 예매 바뀌는 기능
					int choice2 = 0; 										// 사용자가 선택한 번호를 담기 위한 변수
					int choiceNumber = 0; 									// 사용자가 선택한 번호를 담기 위한 변수
															
					String movieSeatChoice = null;
					/* 영화 좌석 선택 */
					System.out.println();
					while (true) {
						seatCount++;
						choiceNumber = 0;
						for (int i = 0; i < movieSeat.length; i++) {
							System.out.println((i + 1) + ". " + movieSeat[i]);
						}
						System.out.print("좌석을 선택해 주세요 : ");
						choiceNumber = sc.nextInt();
						sc.nextLine();
						seat += movieSeat[choiceNumber] + " ";
						movieSeat[choiceNumber] = "O";
						
						if (choiceNumber >= 1 && choiceNumber <= movieSeat.length) {
							System.out.println("1. 좌석 더 선택하기");
							System.out.println("2. 그만선택하기");
							System.out.print("번호을 선택해 주세요 : ");
							choice2 = sc.nextInt();
							sc.nextLine();
							if (choice2 == 2) { // 반복문 나가기
								break;
							} else {
								System.out.println("다시 입력해 주세요");
							}
						}
					}
					ticketPrice = dao.movieSeat(movidPrice,seatCount);

					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println(date + " " + time + "시");
					System.out.print("좌석번호 : " + seat);
					System.out.println();
					System.out.println("현재 총 금액 : " + ticketPrice + "원");
					System.out.println();

					number = 4;
					break;

				case 4: /* 상품 선택 */
					productList = dao.ProductListName();
					int choiceProduct = 0;
					int choiceConut = 0;
					int choiceProduct2 = 0;

					while (true) {
						for(int i = 0; i < productList.size(); i++) {
							System.out.println((i+1)+". "+productList.get(i));
						}
						System.out.print("상품을 선택해 주세요 : ");
						choiceProduct = sc.nextInt();
						sc.nextLine();

						if (choiceProduct >= 1 && choiceProduct <= productList.size()) {
							System.out.println(productList.get(choiceProduct - 1) + "갯수를 골라주세요");
							System.out.print("갯수는 : ");
							choiceConut = sc.nextInt();
							sc.nextLine();
							product2 = (String) productList.get(choiceConut-1);
							product = dao.productTitle(product2,choiceProduct, choiceConut);

							System.out.println("1. 상품 더 선택하기");
							System.out.println("2. 그만선택하기");
							System.out.print("번호을 선택해 주세요 : ");
							choiceProduct2 = sc.nextInt();
							sc.nextLine();

							if (choiceProduct2 == 2) { // 반복문 나가기
								break;

							} // if문
						}
					}
					productPrice = dao.productPrice();

					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println(date + " " + time + "시");
					System.out.print("좌석번호 : " + seat);
					System.out.println();
					System.out.print("상품 : " + product);
					/* 총액 구하기 위한 식 */
					pay = ticketPrice + productPrice;
					System.out.println("상품 총 금액 : " + productPrice);
					System.out.println("현재 총 금액 : " + pay + "원");
					System.out.println();

					number = 5;
					break;

				case 5: /* Card 선택 */

					int choiceCard = 0;
					String[] cardList = { "카카오뱅크", "우리은행", "기업은행", "삼성페이" };
					while (true) {
						for (int i = 0; i < cardList.length; i++) {
							System.out.println((i + 1) + ". " + cardList[i]);
						}
						System.out.print("카드를 선택해 주세요 : ");
						choiceCard = sc.nextInt();
						sc.nextLine();
						if (choiceCard >= 1 && choiceCard <= cardList.length) {
							break;
						} else {
							System.out.println("다시 선택 해주세요");
						}
					}
					switch (choiceCard) {
					case 1:
						cardName = cardList[choiceCard - 1];
						break;
					case 2:
						cardName = cardList[choiceCard - 1];
						break;
					case 3:
						cardName = cardList[choiceCard - 1];
						break;
					case 4:
						cardName = cardList[choiceCard - 1];
						break;
					default:
						System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
					}

					/* 카드결재 */
					cardDiscount = dao.cardDiscount(choiceCard);
					toDay = dao.toDay();

					/* 현재 선택 현황 */
					System.out.println(movie + " " + movidPrice + "원");
					System.out.println(date + " " + time + "시");
					System.out.print("좌석번호 : " + seat);
					System.out.println();
					System.out.print("상품 : " + product);
					System.out.println("상품 총 금액 : " + productPrice);
					System.out.println("카드선택 : " + cardName + "카드 할인률 : " + (int) (cardDiscount * 100) + "%");
					System.out.println("현재 총 금액 : " + (int) (pay - (pay * (cardDiscount / 100))) + "원");
					System.out.println();
					
					pay = (int)(pay - (pay * (cardDiscount / 100)));
					
					/* 입출력 하기 */
					String cardDiscountDAO = cardDiscount+"";
					String timeDAO = time+"시";
					String productPriceDAO = productPrice+"원";
					String viewer = seatCount + "명"; // 영화 보는사람 카운트 몇명 보는지
					dao.print(nickName, movie, timeDAO, seat, viewer, ticketPrice, product, productPriceDAO, cardName, cardDiscountDAO, pay, toDay);
//					
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

	private static String productList(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}