package dto;

import java.io.Serializable;

public class ExMovieInfoDTO implements Serializable{
	
	private String title;
	private String story;
	private String director;
	private String actor;
	private String img;
	
	public ExMovieInfoDTO() {
		
	}

	public ExMovieInfoDTO(String title, String story, String director, String actor, String img) {
		this.title = title;
		this.story = story;
		this.director = director;
		this.actor = actor;
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ExMovieInfoDTO [title=" + title + ", story=" + story + ", director=" + director + ", actor=" + actor
				+ ", img=" + img + "]";
	}
	
}
