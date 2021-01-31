package administrator;

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
		System.out.println("4. 상품 삭제");
		System.out.println("5. 상품목록 초기화");

		System.out.print("메뉴 선택 : ");
		int num = sc.nextInt();

		switch(num) {
		case 1 :
			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a);
			}
			break;

		case 2 :
			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a.getProductNum()+ ". " + a.getProductName());
			}

			System.out.print("변경을 원하시는 상품의 숫자를 선택하세요 : ");
			String test_selectProd = sc.next();
			sc.nextLine();

			System.out.print("새 상품의 이름을 입력하세요 : ");
			String changeName = null;
			changeName = sc.nextLine();

			ProductDTO b = null;
			for(ProductDTO a : pDAO.readDB()) {
				if(test_selectProd.equals(a.getProductNum())) {
					a.setProductName(changeName);
					b = a;
				}
			}

			pDAO.prodUpdate(b);

			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a);
			}
			break;

		case 3 : 
			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a.getProductNum()+ ". " + a.getProductName() + " / " + a.getProductPrice() + "원 ");
			}

			System.out.print("변경을 원하시는 상품의 숫자를 선택하세요 : ");
			String selectProd = sc.next();
			sc.nextLine();

			System.out.print("새 상품의 가격을 입력하세요 : ");
			int changePrice = sc.nextInt();
			sc.nextLine();

			ProductDTO c = null;
			for(ProductDTO a : pDAO.readDB()) {
				if(selectProd.equals(a.getProductNum())) {
					a.setProductPrice(changePrice);
					c = a;
				}
			}

			pDAO.prodUpdate(c);

			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a);
			}
			break;

		case 4 :
			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a.getProductNum()+ ". " + a.getProductName());
			}

			System.out.print("삭제를 원하는 상품의 번호를 선택해주세요 : ");
			String removeNum = sc.next();
			sc.nextLine();

			ProductDTO d = null;
			for(ProductDTO a : pDAO.readDB()) {
				if(removeNum.equals(a.getProductNum())) {
					d = a;
					continue;
				} 
			}

			pDAO.prodRemove(d);

			for(ProductDTO a : pDAO.readDB()) {
				System.out.println(a);
			}

			break;

		case 5 : 
			pDAO.prodDB();
			break;

		default :
			System.out.println("숫자를 다시 입력하세요");
			new ProductManage().productManage();
		}

	}
}
