package movieInformation.arraylist.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDTO implements Comparable, Serializable{
	private String movie;		// 영화제목
	private String story;		// 줄거리
	private String director;	// 감독
	private String actor;		// 배우
	private String work;		// 출현작
	private String review;		// 관람평
	private int visitors;		// 누적 관람객 수	

	private static final long serialVersionUID = 1786173601363444283L;
	public MovieDTO() {
	}

	public MovieDTO(String movie, String story, String director, String actor, String work, String review,
			int visitors) {
		this.movie = movie;
		this.story = story;
		this.director = director;
		this.actor = actor;
		this.work = work;
		this.review = review;
		this.visitors = visitors;
	}
	
	public MovieDTO(String movie2, String story2, String director2, String actor2, String work2) {
		this.movie = movie2;
		this.story = story2;
		this.director = director2;
		this.actor = actor2;
		this.work = work2;
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

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
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
		return "MovieDTO [movie=" + movie + ", story=" + story + ", director=" + director + ", actor=" + actor
				+ ", work=" + work + ", review=" + review + ", visitors=" + visitors + "]";
	}

	@Override
	public int compareTo(Object o) {
		/* 오름 차순 */
		return this.getVisitors() - ((MovieDTO)o).getVisitors();			// this. - 매개변수 다운캐스팅 = 오름차순
	}

}
