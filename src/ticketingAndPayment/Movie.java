package ticketingAndPayment;

import java.util.Scanner;

public class Movie {
	Scanner sc = new Scanner(System.in);
	int choice;
	
	public String movieTitle() {
		
		String[] movielist = {"신세계" , "해리포터"};
		while (true) {
		System.out.println("1. 신세계 ");
		System.out.println("2. 해리포터");
		System.out.print("영화를 선택해 주세요 : ");
		choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1 || choice == 2) {
			break;
		}
		System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
		}
		return movielist[choice];
	}
	 
	public int moviePrice() {
		int price;
		
		if(choice == 1) {	
		price = 7000;		// 신세계 가격
		}else {
		price = 5000;		// 해리포터 가격
		}

		return price;
	}
	
	
}
