package ticketingAndPayment;

import java.util.Scanner;

public class MovieSeat {
	int a = 0;

	Scanner sc = new Scanner(System.in);
	int[] choice = new int[4];
	int choice2;

	public String[] movieSeat() {

		String[] movieSeat = { "a1", "a2", "a3", "a4", "a5" };			// 영화관 이미지 부분 선택 되면 예매 바뀌는 기능
		String[] movieSeatchoice = { "0", "0", "0", "0", "0" };	// 좌석의 기본 값을 가지고 있다가 나중에 return 할떄 예매 부분 남아있는 값 넣어주기
		int movieSeatchoice2 = 1;	// 좌석의 기본 값을 가지고 있다가 나중에 return 할떄 예매 부분 남아있는 값 넣어주기

		while (a == 0) {
			int choiceNumber = 0;		// 사용자가 선택한 번호를 담기 위한 변수

			System.out.println("1. " + movieSeat[0]);
			System.out.println("2. " + movieSeat[1]);
			System.out.println("3. " + movieSeat[2]);
			System.out.println("4. " + movieSeat[3]);
			System.out.println("5. " + movieSeat[4]);
			System.out.print("좌석을 선택해 주세요 : ");
			choice[choiceNumber] = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < movieSeatchoice2; i++){
				if(movieSeatchoice[i].charAt(0) == '0')
				movieSeatchoice[i] = movieSeat[choice[choiceNumber]-1];	// 사용자가 선택한 좌석 번호를 movieSeatchoice 넣어주기
			}
			movieSeatchoice2 += 1;

			movieSeat[choice[choiceNumber]-1] = "예매";	// 사용자가 선택했으니 보여주는 화면에서는 예매라고 보여주기


			System.out.println("1. 좌석 더 선택하기");
			System.out.println("2. 그만선택하기");
			System.out.print("번호을 선택해 주세요 : ");
			choice2 = sc.nextInt();
			sc.nextLine();

			if (choice2 == 2) {		// 반복문 나가기
				a++;
			} // if문

		} // while문

		return movieSeatchoice;
		
	}

}
