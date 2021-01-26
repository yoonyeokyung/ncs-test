package dto;

import java.io.Serializable;

public class PaymentDTO implements Serializable{
	
	private String inckName;	// 사용자 이름
	private String movie;		// 영화
	private String time;		// 영화시간
	private String seat;		// 영화 좌석
	private String product;		// 상품 선택
	private String cardName;	// 상품 선택
	private int pay;			// 총가격

	public PaymentDTO() {}

	public String getInckName() {
		return inckName;
	}

	public void setInckName(String inckName) {
		this.inckName = inckName;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public PaymentDTO(String inckName, String movie, String time, String seat, String product, String cardName,
			int pay) {
		super();
		this.inckName = inckName;
		this.movie = movie;
		this.time = time;
		this.seat = seat;
		this.product = product;
		this.cardName = cardName;
		this.pay = pay;
	}

	public PaymentDTO(String inckName, String movie, String time, String cardName, int pay) {
		super();
		this.inckName = inckName;
		this.movie = movie;
		this.time = time;
		this.cardName = cardName;
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "PaymentDTO [inckName=" + inckName + ", movie=" + movie + ", time=" + time + ", seat=" + seat
				+ ", product=" + product + ", cardName=" + cardName + ", pay=" + pay + "]";
	}
	
	
	
	
}
