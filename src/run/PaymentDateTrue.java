package run;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import dto.PaymentDTO;

public class PaymentDateTrue {

	public static void main(String[] args) {
		
		ObjectInputStream objIn = null;
		PaymentDTO[] inputMembers = new PaymentDTO[5];
		
	
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/payment.txt")));
			
			int i = 0;
			while(true) {
				PaymentDTO m = (PaymentDTO)objIn.readObject();
				System.out.println(m);
				inputMembers[i++] = m;
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
		
			System.out.println(inputMembers[0]);
			System.out.println(inputMembers[1]);
		
		
//		ObjectInputStream in = null;
//
//		try {
//
//		 in = new ObjectInputStream(new FileInputStream("DB/test.txt"));
//		 	while(true) {
//				PaymentDTO m = (PaymentDTO) in.readObject();
//				System.out.println(m);
//		 	}
//		} catch (EOFException e) {
//			System.out.println("파일 다 읽음");
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		} finally {
//			if(in != null) {
//			try {
//				in.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			}
//		}
	}

}
