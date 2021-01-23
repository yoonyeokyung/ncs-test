package ticketingAndPayment;

import java.util.Scanner;

public class MovieTime {

	Scanner sc = new Scanner(System.in);
	int choice;

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
		choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7) {
			break;
		} 
		System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
	}

		return moviedate[choice];
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
			choice = sc.nextInt();
			sc.nextLine();
			if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7) {
				break;
			}
			System.out.println("잘못 선택하셨습니다 다시 선택해 주세요");
		}

		return moviedate[choice];
	}

}
