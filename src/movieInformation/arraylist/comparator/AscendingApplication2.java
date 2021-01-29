package movieInformation.arraylist.comparator;

import java.util.ArrayList;
import java.util.List;

import movieInformation.arraylist.dto.MovieDTO;

public class AscendingApplication2 {

	public static void main(String[] args) {
		/* 내림차순을 볼 수 있는 클래스이다. */
		/* 어레이리스트 인스턴스 생성. 다형성으로 List로 형변환. MovieDTO로 제한하여 담을 수 있다. */
		List<MovieDTO> movieList = new ArrayList<>();
		
		movieList.add(new MovieDTO("원더우먼", "이러저러했다", "존아저씨", "데카프리오", "dhdh", "좋았다", 1100));
		movieList.add(new MovieDTO("원더우먼", "이러저러했다", "존아저씨", "데카프리오", "dhdh", "좋았다", 1100));
		movieList.add(new MovieDTO("외계인뭐시기", "이러저러했다", "존아저씨", "데카프리오", "dhdh", "좋았다", 11000));
		movieList.add(new MovieDTO("아이엠히어", "이러저러했다", "존아저씨", "데카프리오", "dldl", "좋았다", 2000));
		movieList.add(new MovieDTO("조제", "이러저러했다", "존아저씨", "데카프리오", "gkgk", "dkdk", 5000));
		movieList.add(new MovieDTO("화양연화", "이러저러했다", "존아저씨", "데카프리오", "dldl", "좋았다", 40000));
		
		
		
		/* 영화 목록 다보기 */
		movieList.sort(new AscendingVisiters());		
		int i = 0;
		for(MovieDTO b : movieList) {
			i += 1;
			System.out.println(i + "위 : "+ b.getMovie() + ", 조회수 : " + b.getVisitors());
		}
		
		System.out.println();

		
		
		
//		/* for문을 통한 순위 출력(단점: 모든 목록 다나옴) */
//		for(int i = 0 ; i < movieList.size(); i++) {
//			System.out.println((i+1) + "위" + movieList.get(i));
//		}
		
	}

}
