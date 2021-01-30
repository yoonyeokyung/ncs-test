package administrator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Condition {	// 삭제 예정
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== 관람 조건 선택 =====");
		System.out.println("원하시는 지역의 영화관을 선택하세요.");
		System.out.println("1. 강남");
		System.out.println("2. 강동");
		System.out.println("3. 광주");
		System.out.println("4. 부천");
		System.out.println("5. 제주");
		System.out.print("번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 :
			System.out.println("강남을 선택하셨습니다. 원하시는 관람 날짜와 시간을 선택해주세요");
			break;
		case 2 :
			System.out.println("강동을 선택하셨습니다. 원하시는 관람 날짜와 시간을 선택해주세요");
			break;
		case 3 :
			System.out.println("광주를 선택하셨습니다. 원하시는 관람 날짜와 시간을 선택해주세요");
			break;
		case 4 :
			System.out.println("부천을 선택하셨습니다. 원하시는 관람 날짜와 시간을 선택해주세요");
			break;
		case 5 :
			System.out.println("제주를 선택하셨습니다. 원하시는 관람 날짜와 시간을 선택해주세요");
			break;
		}
		
		// 시간 처리 
		// (월이 넘어가도 날짜 넘어가게 수정 - 21/01/26)
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        SimpleDateFormat df = new SimpleDateFormat("MM월 dd일");
//      System.out.println("현재 : " + df.format(cal.getTime()));
		
		for(int i = 0 ; i < 5 ; i++) {
			cal.add(Calendar.DATE, 1);
			System.out.println(df.format(cal.getTime()));
			System.out.println("9시 \t 11시 \t 14시 \t 17시 \t 20시");
			System.out.println("");
		}
		
		
	}
}
