package administrator;

public class ProductListAndPrice {		// 제품 정보만 가져올 메소드
	
	ProductDTO[] products = new ProductDTO[9];
	
	public void ProductDTO() {
		products[0] = new ProductDTO("오리지널 팝콘 (M)", 5000);
		products[1] = new ProductDTO("오리지널 팝콘 (L)", 7000);	
		products[2] = new ProductDTO("캬라멜 팝콘 (M)", 6000);		
		products[3] = new ProductDTO("캬라멜 팝콘 (L)", 8000);		
		products[4] = new ProductDTO("반반 팝콘 (L)", 9000);		
		products[5] = new ProductDTO("버터 오징어 구이", 5000);		
		products[6] = new ProductDTO("콜라/사이다/환타 (M)", 3000);		
		products[7] = new ProductDTO("콜라/사이다/환타 (L)", 5000);		
		products[8] = new ProductDTO("에이드(자몽/레몬) (M)", 5000);		
	
	}
}		// class 종료
