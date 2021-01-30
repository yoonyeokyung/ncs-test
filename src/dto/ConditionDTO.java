package dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConditionDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5573095974969011316L;
	private String movieTitle;
	private String area;
	private String date;
	private String showTime;
	private String seat;
	public List<String> movieArr = new ArrayList<String>();
	public List<String> areaArr = new ArrayList<String>();
	public List<String> dateArr = new ArrayList<String>();
	public List<String> timeArr = new ArrayList<String>();
	public List<String> seatArr = new ArrayList<String>();
	
	public ConditionDTO() {
	}


	public ConditionDTO(String movieTitle, String area, String date, String showTime, String seat) {
		super();
		this.movieTitle = movieTitle;
		this.area = area;
		this.date = date;
		this.showTime = showTime;
		this.seat = seat;
	}

	


	public String getMovieTitle() {
		return movieTitle;
	}


	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getShowTime() {
		return showTime;
	}


	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}


	public String getSeat() {
		return seat;
	}


	public void setSeat(String seat) {
		this.seat = seat;
	}

	
	
	@Override
	public String toString() {
		return "ConditionDTO [movieTitle=" + movieTitle + ", area=" + area + ", date=" + date + ", showTime=" + showTime
				+ ", seat=" + seat + "]";
	}


	public void movieSelect() {
		movieArr.add("원더우먼1984");
		movieArr.add("소울");
		movieArr.add("#아이엠히어");
		movieArr.add("조제");
		movieArr.add("화양연화");
	}
	
	public void areaSelect() {
		areaArr.add("강남");
		areaArr.add("강동");
		areaArr.add("광주");
		areaArr.add("부천");
		areaArr.add("제주");
	}
	
	public void timeSelect() {
		timeArr.add("9시");
		timeArr.add("11시");
		timeArr.add("14시");
		timeArr.add("17시");
		timeArr.add("20시");
	}
	
	public void seatSelect() {
		seatArr.add("A1");
		seatArr.add("A2");
		seatArr.add("A3");
		seatArr.add("A4");
		seatArr.add("A5");
	}
	
	public void dateSelect() {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        SimpleDateFormat df = new SimpleDateFormat("MM월 dd일");
        
        for(int i = 0 ; i < 5 ; i++) {
			cal.add(Calendar.DATE, 1);
			dateArr.add(df.format(cal.getTime()));
        }
	}
	
	
}	// 클래스 종료
