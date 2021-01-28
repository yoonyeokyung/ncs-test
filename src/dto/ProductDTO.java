package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6812653877897433384L;
	private String productName;				// 상품명
	private int productPrice;				// 상품가격
	
	public List<String> prodNameArr = new ArrayList<String>();
	public List<Integer> prodPriceArr = new ArrayList<Integer>();
	
	public ProductDTO() {
	}

	public ProductDTO(String productName, int productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
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
		return "ProductDTO [productName=" + productName + ", productPrice=" + productPrice + "]";
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
