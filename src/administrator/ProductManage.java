package administrator;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductManage {

	public void productManage() {

		ProductDTO pDTO = new ProductDTO();
		ProductDAO pDAO = new ProductDAO();
		
		pDTO.prodNumSelect();
		pDTO.prodNameSelect();
		pDTO.prodPriceSelect();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 상품정보 조회 ");
		System.out.println("2. 상품명 수정 ");
		System.out.println("3. 상품가격 수정 ");
		System.out.println("4. 상품목록 초기화");
		
		System.out.print("메뉴 선택 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 :
			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a);
			}
			break;
						
		case 2 :
			for(int i = 0; i < pDTO.prodNameArr.size() ; i++) {
				System.out.println((i+1) + "." + pDTO.prodNameArr.get(i));
			}
			
			System.out.print("변경을 원하시는 상품의 숫자를 선택하세요 : ");
			String test_selectProd = sc.next();
			sc.nextLine();
			
			System.out.print("새 상품의 이름을 입력하세요 : ");
			String changeName = null;
			changeName = sc.nextLine();
			
			ProductDTO c = null;
			for(ProductDTO a : pDAO.readDB()) {
				if(test_selectProd.equals(a.getProductNum())) {
					a.setProductName(changeName);
					c = a;
				}
			}
			
			pDAO.prodUpdate(c);
			
			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a);
			}
			break;
			
		case 3 : 
			for(int i = 0; i < pDTO.prodNameArr.size() ; i++) {
				System.out.println((i+1) + "." + pDTO.prodNameArr.get(i));
			}
			
			System.out.print("변경을 원하시는 상품의 숫자를 선택하세요 : ");
			String selectProd = sc.next();
			sc.nextLine();
				
			System.out.print("새 상품의 가격을 입력하세요 : ");
			int changePrice = sc.nextInt();
			sc.nextLine();
			
			ProductDTO b = null;
			for(ProductDTO a : pDAO.readDB()) {
				if(selectProd.equals(a.getProductNum())) {
					a.setProductPrice(changePrice);
					b = a;
				}
			}
			
			pDAO.prodUpdate(b);
			
			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a);
			}
			break;
			
		case 4 : 
			pDAO.prodDB();
			break;
		
		default :
			System.out.println("숫자를 다시 입력하세요");
			new ProductManage().productManage();
		}
	
	}
}
