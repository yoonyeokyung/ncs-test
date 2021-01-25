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
		
		bList.add("1. 원더 우먼 1984");
		bList.add("2. 소울");
		bList.add("3. #아이엠 히어");
		bList.add("4. 조제");
		bList.add("5. 화양연화");
		
		cList.add("1. 이 안에 외계인이 있다");
		cList.add("2. 톰과 제리");
		cList.add("3. 호라이즌 제로");
		
		
		MovieDTO ml = new MovieDTO();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1. 차트, 2. 현재상영작 3. 상영예정작 : ");
		int click = sc.nextInt();
		switch(click) {
			case 1 :
				System.out.println(aList);
				break;
			case 2 :
				System.out.println(bList);
				ml.movielist();
				break;
			case 3 :
				System.out.println(cList);
				ml.movieschlist();
				break;
			default :
				System.out.println("다시 입력해 주세요");
		
		
		
			}
	}
	
}
