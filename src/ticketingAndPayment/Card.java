package ticketingAndPayment;

import java.util.Scanner;

public class Card {
	Scanner sc = new Scanner(System.in);
	int choice;

	public String cardName() {
		String[] cardList = { "카카오뱅크", "우리은행", "기업은행", "삼성페이" };
		int a = 0;
		while (true) {
			System.out.println("1. 카카오뱅크 ");
			System.out.println("2. 우리은행");
			System.out.println("3. 기업은행");
			System.out.println("4. 삼성페이");
			System.out.print("카드를 선택해 주세요 : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				return cardList[choice-1];
			case 2:
				return cardList[choice-1];
			case 3:
				return cardList[choice-1];
			case 4:
				return cardList[choice-1];
			default:
				System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
			}
		}
	} 

	public Double cardDiscount() {
		Double[] cardListDiscount = { 0.03, 0.05, 0.01, 0.02 };

		return cardListDiscount[choice-1];
	}

}
