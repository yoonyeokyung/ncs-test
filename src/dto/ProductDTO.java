package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3762752264199912460L;
	private	String productNum;				// 상품번호
	private String productName;				// 상품명
	private int productPrice;				// 상품가격
	
	public List<String> prodNumArr = new ArrayList<String>();
	public List<String> prodNameArr = new ArrayList<String>();
	public List<Integer> prodPriceArr = new ArrayList<Integer>();
	
	public ProductDTO() {
	}

	public ProductDTO(String productNum, String productName, int productPrice) {
		this.productNum = productNum;
		this.productName = productName;
		this.productPrice = productPrice;
	}


	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	
	@Override
	public String toString() {
		return "ProductDTO [productNum=" + productNum + ", productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}

	public void prodNumSelect() {
		prodNumArr.add("1");
		prodNumArr.add("2");
		prodNumArr.add("3");
		prodNumArr.add("4");
		prodNumArr.add("5");
		prodNumArr.add("6");
		prodNumArr.add("7");
		prodNumArr.add("8");
		prodNumArr.add("9");
		
	}
	
	public void prodNameSelect() {
		prodNameArr.add("오리지널 팝콘 (M)");
		prodNameArr.add("오리지널 팝콘 (L)");
		prodNameArr.add("캬라멜 팝콘 (M)");
		prodNameArr.add("캬라멜 팝콘 (L)");
		prodNameArr.add("반반 팝콘 (L)");
		prodNameArr.add("버터 오징어 구이");
		prodNameArr.add("콜라/사이다/환타 (M)");
		prodNameArr.add("콜라/사이다/환타 (L)");
		prodNameArr.add("에이드(자몽/레몬)(M)");
	}
	
	public void prodPriceSelect() {
		prodPriceArr.add(5000);
		prodPriceArr.add(7000);
		prodPriceArr.add(6000);
		prodPriceArr.add(8000);
		prodPriceArr.add(9000);
		prodPriceArr.add(5000);
		prodPriceArr.add(3000);
		prodPriceArr.add(5000);
		prodPriceArr.add(5000);
		
	}
		
}
