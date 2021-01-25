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
	public void moviemenu1() {
		ArrayList aList = new ArrayList();	
		
		aList.add("1위 ");
		aList.add("2위 ");
		aList.add("3위 ");
		aList.add("4위 ");
		
		System.out.println(aList);
		
	}
	public void moviemenu2() {
		
		ArrayList bList = new ArrayList();	

		bList.add("1. 원더 우먼 1984");
		bList.add("2. 소울");
		bList.add("3. #아이엠 히어");
		bList.add("4. 조제");
		bList.add("5. 화양연화");
		
		System.out.println(bList);

	}
	public void moviemenu3() {
		
		ArrayList cList = new ArrayList();	
		
		cList.add("1. 이 안에 외계인이 있다");
		cList.add("2. 톰과 제리");
		cList.add("3. 호라이즌 제로");
		
		System.out.println(cList);

	}
	
	
	public void movielist() {
		
		ArrayList<String> list1 = new ArrayList<String>();	
		
		list1.add("원더우먼 1984");
		list1.add("story");
		list1.add("director");
		list1.add("actor");
		list1.add("work");
		list1.add("riview");
		list1.add("visitors");
		
		ArrayList<String> list2 = new ArrayList<String>();	
		list2.add("소울");
		list2.add("story");
		list2.add("director");
		list2.add("actor");
		list2.add("work");
		list2.add("riview");
		list2.add("visitors");

		ArrayList<String> list3 = new ArrayList<String>();	
		list3.add("#아이엠 히어");
		list3.add("story");
		list3.add("director");
		list3.add("actor");
		list3.add("work");
		list3.add("riview");
		list3.add("visitors");
		
		ArrayList<String> list4 = new ArrayList<String>();	
		list4.add("조제");
		list4.add("story");
		list4.add("director");
		list4.add("actor");
		list4.add("work");
		list4.add("riview");
		list4.add("visitors");
		
		ArrayList<String> list5 = new ArrayList<String>();	
		list5.add("화양연화");
		list5.add("story");
		list5.add("director");
		list5.add("actor");
		list5.add("work");
		list5.add("riview");
		list5.add("visitors");

		Scanner sc = new Scanner(System.in);

		System.out.print("원하는 영화의 숫자를 입력해 주세요 : ");
		int click2 = sc.nextInt();
		switch(click2) {
		case 1 :
			System.out.println(list1);
			break;
		case 2 :
			System.out.println(list2);
			break;
		case 3 :
			System.out.println(list3);
			break;
		case 4 :
			System.out.println(list4);
			break;
		case 5 :
			System.out.println(list5);
			break;
		default :
			System.out.println("다시 입력해 주세요");
		}
	}	
	public void movieschlist() {
		
		ArrayList<String> schList1 = new ArrayList<String>();	
		schList1.add("이 안에 외계인이 있다");
		schList1.add("story");
		schList1.add("director");
		schList1.add("actor");
		schList1.add("work");
		schList1.add("riview");
		schList1.add("visitors");
		
		ArrayList<String> schList2 = new ArrayList<String>();	
		schList2.add("톰과 제리");
		schList2.add("story");
		schList2.add("director");
		schList2.add("actor");
		schList2.add("work");
		schList2.add("riview");
		schList2.add("visitors");
		
		ArrayList<String> schList3 = new ArrayList<String>();	
		schList3.add("호라이즌 제로");
		schList3.add("story");
		schList3.add("director");
		schList3.add("actor");
		schList3.add("work");
		schList3.add("riview");
		schList3.add("visitors");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 영화의 숫자를 입력해 주세요 : ");
		int click2 = sc.nextInt();
		switch(click2) {
		case 1 :
			System.out.println(schList1);
			break;
		case 2 :
			System.out.println(schList2);
			break;
		case 3 :
			System.out.println(schList3);
			break;
		default :
			System.out.println("다시 입력해 주세요");

		}
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
