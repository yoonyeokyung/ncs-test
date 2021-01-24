package movieInformation.arraylist.run;

import java.util.ArrayList;
import java.util.Scanner;

import movieInformation.arraylist.dto.MovieDTO;

public class Application {

	public static void main(String[] args) {
		ArrayList aList = new ArrayList();	
		ArrayList bList = new ArrayList();	
		ArrayList cList = new ArrayList();	
		
		aList.add("1위 ");
		aList.add("2위 ");
		aList.add("3위 ");
		aList.add("4위 ");
		
		bList.add("원더 우먼 1984");
		bList.add("소울");
		bList.add("#아이엠 히어");
		bList.add("조제");
		bList.add("화양연화");
		
		cList.add("이 안에 외계인이 있다");
		cList.add("톰과 제리");
		cList.add("호라이즌 제로");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1. 차트, 2. 현재상영작 3. 상영예정작 : ");
		int click = sc.nextInt();
		
		switch(click) {
			case 1 :
				System.out.println(aList);
				break;
			case 2 :
				System.out.println(bList);
				break;
			case 3 :
				System.out.println(cList);
				break;
			default :
				System.out.println("다시 입력해 주세요");
				
				
				
				
		MovieDTO mov1 = new MovieDTO("원더우먼 1984", "", "감독 : 패티 젠킨스(Patty Jenkins)", "배우 : 겔 가돗 Gal Gadot 주연 | 다이애나/원더우먼 역", "", "",
				100);
		MovieDTO mov2 = new MovieDTO();
		MovieDTO mov3 = new MovieDTO();
		MovieDTO mov4 = new MovieDTO();
		MovieDTO mov5 = new MovieDTO();

		MovieDTO schmov1 = new MovieDTO();
		MovieDTO schmov2 = new MovieDTO();
		MovieDTO schmov3 = new MovieDTO();
		
		
		System.out.println("원더우먼 : " + mov1);
		System.out.println("소울 : " + mov2);
		System.out.println("#아이엠 히어 : " + mov3);
		System.out.println("조제 : " + mov4);
		System.out.println("화양연화 : " + mov5);

		System.out.println("이 안에 외계인이 있다: " + schmov1);
		System.out.println("톰과 제리 : " + schmov2);
		System.out.println("호라이즌 제로 : " + schmov3);
		
		
		}
		
	}
}
