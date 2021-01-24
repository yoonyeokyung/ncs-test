package movieInformation.arraylist.run;

import java.util.ArrayList;
import java.util.Scanner;

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
				
		
//		System.out.println("원더우먼 : " + );
//		System.out.println("소울 : " + list2);
//		System.out.println("#아이엠 히어 : " + list3);
//		System.out.println("조제 : " + list4);
//		System.out.println("화양연화 : " + list5);

//		System.out.println("이 안에 외계인이 있다: " + schList1);
//		System.out.println("톰과 제리 : " + schList2);
//		System.out.println("호라이즌 제로 : " + schList3);
		
		
		}
		
	}
}
