package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDTO;

public class ProductDAO {

	public static void main(String[] args) {
		
		ProductDTO pDTO = new ProductDTO();
		pDTO.prodNameSelect();
		pDTO.prodPriceSelect();
		
		ObjectOutputStream objOut = null;
		
		try {
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/productDB.txt")));
		
			List<ProductDTO> list = new ArrayList<ProductDTO>();
			
			for(int i = 0; i < pDTO.prodNameArr.size(); i++) {
				String productName = pDTO.prodNameArr.get(i);
				int productPrice = pDTO.prodPriceArr.get(i);
				ProductDTO p = new ProductDTO(productName, productPrice);
				list.add(p);
			}
		
			for(int i = 0 ; i < list.size() ; i++) {
				objOut.writeObject(list.get(i));
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
//		ObjectInputStream objIn = null;	
//
//		try {
//			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));
//
//			int i = 0;
//			while(true) {
//				System.out.println((ProductDTO)objIn.readObject());
//			} 
//
//		} catch (EOFException e) {
//			System.out.println("읽기 완료");
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if(objIn != null) {
//				try {
//					objIn.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		
		
		
	}	// main 종료

}	// class 종료
