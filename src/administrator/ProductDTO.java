package administrator;

public class ProductDTO {
	
	private String productName;				// 상품명
	private int productPrice;				// 상품가격
	private int productSoldQuantity;		// 판매량
	private int productStock;				// 재고
	private int productRevenue = productPrice * productSoldQuantity;	// 매출액 (가격 * 판매량)
	
	public ProductDTO() {
	}
	
	public ProductDTO(String productName, int productPrice, int productSoldQuantity, int productStock,
			int productRevenue) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSoldQuantity = productSoldQuantity;
		this.productStock = productStock;
		this.productRevenue = productRevenue;
	}

	public ProductDTO(String productName, int productPrice) {
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

	public int getProductSoldQuantity() {
		return productSoldQuantity;
	}

	public void setProductSoldQuantity(int productSoldQuantity) {
		this.productSoldQuantity = productSoldQuantity;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getProductRevenue() {
		return productRevenue;
	}

	public void setProductRevenue(int productRevenue) {
		this.productRevenue = productRevenue;
	}

	public void printProducts() {
		System.out.println(productName + " : " + productPrice + "원");
	}
	
}
