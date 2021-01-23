package administrator;

public class ProductDTO {
	
	private String productName;				// 상품명
	private int productPrice;				// 상품가격
	private int productSoldQuantity;		// 판매량
	private int productStock;				// 재고
	private int productRevenue = productPrice * productSoldQuantity;	// 매출액 (가격 * 판매량)
	
	public ProductDTO() {
	}
	
		
}
