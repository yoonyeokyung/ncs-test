package movieInformation.arraylist.dto;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieDTO {
	private String movie;		// 영화제목
	private String story;		// 줄거리
	private String director;	// 감독
	private String actor;		// 배우
	private String work;		// 출현작
	private String review;		// 관람평
	private int visitors;		// 누적 관람객 수	

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

}
