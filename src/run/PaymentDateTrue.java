package run;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import dto.ConditionDTO;
import dto.MemberDTO;
import dto.ProductDTO;

public class PaymentDateTrue {

	public static void main(String[] args) {
	
		
		
		ObjectInputStream objIn = null;
		ArrayList<ProductDTO> ProductList = new ArrayList<ProductDTO>();
		ArrayList ProductListName = new ArrayList();
		ArrayList ProductListPrice = new ArrayList();
	
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));
			
			int i = 0;
			while(true) {
				ProductDTO m = (ProductDTO)objIn.readObject();
				System.out.println(m.getProductName());
				ProductList.add(m);
				ProductListName.add(m.getProductName());
				ProductListPrice.add(m.getProductPrice());
			}
			
			
		
		} catch (EOFException e) {
		
			System.out.println("파일 읽기 완료!");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		/* 읽어온 데이터를 담은 배열을 출력해 보자 */
		System.out.println("==============");
		for(int i = 0; i < ProductList.size(); i++) {
			System.out.println(ProductList.get(i));
		}
		System.out.println("==============");
		for(int i = 0; i < ProductListName.size(); i++) {
			System.out.println(ProductListName.get(i));
		}
		System.out.println("==============");
		for(int i = 0; i < ProductListPrice.size(); i++) {
			System.out.println(ProductListPrice.get(i));
		}
		
	}

}
