package movieInformation.arraylist.run;

import java.util.Scanner;

import movieInformation.arraylist.dao.MovieDAO;

public class Application {

	public static void main(String[] args) {
		MovieDAO ml = new MovieDAO();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1. 차트, 2. 현재상영작 3. 상영예정작 : ");
		int click = sc.nextInt();
		switch(click) {
			case 1 :
				ml.moviemenu1();
				break;
			case 2 :
				ml.moviemenu2();
				ml.movielist();
				break;
			case 3 :
				ml.moviemenu3();
				ml.movieschlist();
				break;
			default :
				System.out.println("다시 입력해 주세요");
			
		/* 	1. ml.get어쭈구 geter를 활용 해보는 방법 고민(MovieDTO에 geter에 값 넣기) 
		 *  -> 해당하는 모든정보를 넣고 상황에 따른 값 swith를 써야 될 것으로 추정 (유지보수가 좋을 것으로 보임)
		 * 
		 *  2. toString을 활용해보거나	
		 *  -> 영화 하나에 대한 정보를 한번에 다 출력
		 *  
		 *  3. MovieDTO에 toString을 getInfomation으로 바꿔서 진행해보거나... (참고: 챕터6 섹션4. UserDTO 81번 줄
		 *  -> 2번과 마찬가지 아닐까 싶음
		 *  
		 *  셋 중 고민해서 작업해보기 
		 *  2,3번 중 원하는 값만 출력 가능하다면?
		 *  <MovieDTO> 활용해보기? 
		 *  
		 *  셋다 해보니 에러등... 더 고민해보자
		 */
				
			
		}
	}
	
}
