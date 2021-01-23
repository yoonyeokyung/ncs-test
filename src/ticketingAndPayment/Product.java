package ticketingAndPayment;

import java.util.Scanner;

public class Product {
	Scanner sc = new Scanner(System.in);
	int choice;
	int choice2;
	String[] productchoice = {"0" , "0", "0", "0", "0"};
	
	public String[] productTitle() {
		String[] productList = {"팝콘" , "콜라"};
	
		int loop = 0; 
		while (loop == 0) {
			int choiceNumber = 0;		// 사용자가 선택한 번호를 담기 위한 변수

			System.out.println("1. 팝콘 ");
			System.out.println("2. 콜라");
			System.out.print("상품을 선택해 주세요 : ");
			choice = sc.nextInt();
			sc.nextLine();
		
			productchoice[choiceNumber] = productList[choice-1];
			choiceNumber++;
			
			System.out.println("1. 상품 더 선택하기");
			System.out.println("2. 그만선택하기");
			System.out.print("번호을 선택해 주세요 : ");
			choice2 = sc.nextInt();
			sc.nextLine();

			if (choice2 == 2) {		// 반복문 나가기
				loop++;
			} // if문

		} // while문
		
		return productchoice;
	}

	public int productPrice() {
		int price = 0;
		String[] productListPrice = {"5000" , "2000"};
		for(int i = 0; i < productchoice.length; i++) {
			if(productchoice[i].charAt(0) != '0') {
				if(productchoice[i].charAt(0) == '5') {
					price += 5000;	// 팝콘
				}else {
					price += 2000;	// 콜라
				}
			}
		}
		return price;
	}

}
