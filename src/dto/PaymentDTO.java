package dto;

import java.io.Serializable;

public class PaymentDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1786173601363444283L;
	private String inckName;	// 사용자 이름
	private String movie;		// 영화
	private String time;		// 영화시간
	private String seat1;		// 영화 좌석
	private String seat2;		// 영화 좌석
	private String seat3;		// 영화 좌석
	private String seat4;		// 영화 좌석
	private String seat5;		// 영화 좌석
	private String product;		// 상품 선택
	private String product2;		// 상품 선택
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

	public String getSeat1() {
		return seat1;
	}

	public void setSeat1(String seat1) {
		this.seat1 = seat1;
	}

	public String getSeat2() {
		return seat2;
	}

	public void setSeat2(String seat2) {
		this.seat2 = seat2;
	}

	public String getSeat3() {
		return seat3;
	}

	public void setSeat3(String seat3) {
		this.seat3 = seat3;
	}

	public String getSeat4() {
		return seat4;
	}

	public void setSeat4(String seat4) {
		this.seat4 = seat4;
	}

	public String getSeat5() {
		return seat5;
	}

	public void setSeat5(String seat5) {
		this.seat5 = seat5;
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

	public PaymentDTO(String inckName, String movie, String time, String seat1,String seat2,String seat3,String seat4,String seat5, String product, String cardName,
			int pay) {
		super();
		this.inckName = inckName;
		this.movie = movie;
		this.time = time;
		this.seat1 = seat1;
		this.seat2 = seat2;
		this.seat3 = seat3;
		this.seat4 = seat4;
		this.seat5 = seat5;
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
	public PaymentDTO(String inckName, String seat1,String seat2,String seat3,String seat4,String seat5) {
		super();
		this.inckName = inckName;
		this.seat1 = seat1;
		this.seat2 = seat2;
		this.seat3 = seat3;
		this.seat4 = seat4;
		this.seat5 = seat5;
	}

	public PaymentDTO(String inckName, String product, String product2) {
		super();
		this.inckName = inckName;
		this.product = product;
		this.product2 = product2;
	}

	@Override
	public String toString() {
		return "PaymentDTO [inckName=" + inckName + ", movie=" + movie + ", time=" + time + ", seat1=" + seat1
				+ ", seat2=" + seat2 + ", seat3=" + seat3 + ", seat4=" + seat4 + ", seat5=" + seat5 + ", product="
				+ product + ", cardName=" + cardName + ", pay=" + pay + "]";
	}

	
	
	
	
	
}
