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
		
		pDTO.prodNameSelect();
		pDTO.prodPriceSelect();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 상품정보 조회 ");
		System.out.println("2. 상품목록 수정 ");
		System.out.println("3. 상품목록 초기화 ");
		System.out.print("메뉴 선택 : ");
		int change = sc.nextInt();
		
		switch(change) {
					
		case 1 :
			ObjectInputStream objIn = null;	
			
			try {
				objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));

				while(true) {
					System.out.println((ProductDTO)objIn.readObject());
				}	
			} catch (EOFException e) {

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		
		case 2 :
			for(int i = 0; i < pDTO.prodNameArr.size() ; i++) {
				System.out.println((i+1) + "." + pDTO.prodNameArr.get(i));
			}
			
			System.out.print("변경을 원하시는 상품의 숫자를 선택하세요 : ");
			int selectProd = sc.nextInt();
			sc.nextLine();
				
				System.out.print("새 상품의 가격을 입력하세요 : ");
				String changeName = null;
				int changePrice = 0;
				changePrice = sc.nextInt();
				sc.nextLine();
				pDTO.setProductName(pDTO.prodNameArr.get(selectProd-1));
				pDTO.setProductPrice(changePrice);
				pDAO.prodUpdate(pDTO);
				
				
			break;
			
		case 3 : 
			pDAO.prodDB();
			break;
		
		default :
			System.out.println("숫자를 다시 입력하세요");
			new ProductManage().productManage();
		}
		
			
		
		
	
	}
	
}
