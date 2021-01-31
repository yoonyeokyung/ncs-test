package movieInformation.arraylist.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	/* 비교를 위해 comparable를 구현, 입출력의 직렬화를 위해 Serializable를 구현*/
	public class MovieDTO implements Comparable, Serializable{
		
	/* 영화 정보를 관리하기 위한 용도의 DTO 클래스 */
		private String movie;		// 영화제목
		private String story;		// 줄거리
		private String director;	// 감독
		private String actor;		// 배우
		private String review;		// 관람평
		private int visitors;		// 누적 관람객 수	

	/* 클래스 버전 관리와 다른 클래스 구분하기 위한 '버전 아이디(난수)' */
	private static final long serialVersionUID = 1786173601363444283L;
	
	/* 생성자 */
	public MovieDTO() {}
		
		
	public List<String> movarr = new ArrayList<String>();
	public List<String> schmovarr = new ArrayList<String>();
	public List<Integer> visitarr = new ArrayList<Integer>();

	
	public MovieDTO(String movie, String story, String director, String actor, String review,
			int visitors) {
		this.movie = movie;
		this.story = story;
		this.director = director;
		this.actor = actor;
		this.review = review;
		this.visitors = visitors;
	}
	
	public MovieDTO(String movie2, String story2, String director2, String actor2) {
		this.movie = movie2;
		this.story = story2;
		this.director = director2;
		this.actor = actor2;
	}
	public MovieDTO(int visitors) {
		this.visitors = visitors;
	}
		

	public MovieDTO(java.lang.String string, int i) {
	}


	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getVisitors() {
		return visitors;
	}

	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}

	@Override
	public String toString() {
		return "\n영화제목 : " + movie + "\n줄거리 : " + story + "\n감독 : " + director + "출현배우 : " + actor
				+ "감상평 : " + review + "누적 관람 수 : " + visitors;
	}

	/* 내림차순을 사용하기 위해 작성한 오버이라딩 AsendingInput */
	@Override
	public int compareTo(Object o) {
		/* 내림 차순 */
		return this.getVisitors() - ((MovieDTO)o).getVisitors();			// this. - 매개변수 다운캐스팅 = 오름차순
	}
	
	
}
