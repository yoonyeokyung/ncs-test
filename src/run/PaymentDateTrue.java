package run;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import dto.PaymentDTO;

public class PaymentDateTrue {

	public static void main(String[] args) {
//		OutputStream out = null;
//		ObjectOutputStream oout = null;
//
//		try{
//		out = new FileOutputStream("test.txt");
//		oout = new ObjectOutputStream(out);
//
//		Member m1 = new Member(1, "root", "root123");
//		oout.writeObject(m1); // Member의 객체를 Object화 하여 3개의 객체를 저장
//
//		Member m2 = new Member(2, "root", "root123");
//		oout.writeObject(m2);
//
//		Member m3 = new Member(3, "root", "root123");
//		oout.writeObject(m3);
//
//		System.out.println("파일 저장 성공!");
//		}catch (Exception e) {
//		e.printStackTrace();
//		}finally{
//		try{
//		oout.close();
//		// 리소스(oout)를 해제할 때는 최종적으로 생성된 리소스만 해제하면,
//		// 그 리소스(oout)가 사용하고 있던 다른 리소스(out)들도 순차적으로 해제됨
//		}catch (IOException e){
//		e.printStackTrace();
//		}
//		}
		InputStream in = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream("test.txt");
			oin = new ObjectInputStream(in);

			while (true) {
				PaymentDTO m = (PaymentDTO) oin.readObject();
				System.out.println(m);
			}
		} catch (EOFException e) {
			System.out.println("파일 다 읽음");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
