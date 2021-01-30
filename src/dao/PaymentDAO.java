package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import dto.PaymentDTO;
import dto.ProductDTO;
import ticketingAndPayment.MyOutputStream;

public class PaymentDAO {

	Scanner sc = new Scanner(System.in);

	/* 상품 부분 받아오기 */
	String productchoice = "";
	int priceProduct = 0;
	ArrayList<ProductDTO> ProductList = new ArrayList<ProductDTO>();		// 정보 다받아오기
	ArrayList ProductListName = new ArrayList();							// 이름만 받아오기
	ArrayList ProductListPrice = new ArrayList();							// 가격만 받아오기
	
	/* 상품목록 */
	public ArrayList ProductListName() {
		
		ObjectInputStream objIn = null;
			
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
		
		return ProductListName;
	}
	

	
	

	/* movie */
	public String movieTitle(int choiceMovie) {

		String[] movielist = { "신세계", "해리포터" };
		return movielist[choiceMovie - 1];
	}

	public int moviePrice(int choiceMovie) {
		int price;

		if (choiceMovie == 1) {
			price = 7000; // 신세계 가격
		} else {
			price = 5000; // 해리포터 가격
		}

		return price;
	}

	

	/* time */
	public String movieDate(int choicetimne) {

		String[] moviedate = { "25일/월", "26일/화", "27일/수", "28일/목", "29일/금", "30일/토", "31일/일" };
		return moviedate[choicetimne];
	}

	public int movieTime(int choicetimne) {

		int[] moviedate = { 12, 13, 14, 15, 16, 17, 18 };
		return moviedate[choicetimne];
	}
	
	/* seat */
	public int movieSeat(int choiceNumber, int price) {

		int moviePrice = 0;
			
		moviePrice += choiceNumber * price;
		return moviePrice;
	}
	
	/* product */
	public String productTitle(String choiceProduct ,int choiceProductPrice, int choiceConut) {
		int ProductPrice = (int) ProductListPrice.get(choiceProductPrice - 1);
		int price = ProductPrice * choiceConut;
		productchoice += choiceProduct + " ";
//		ProductListPrice(choiceProductPrice - 1)
				
		priceProduct += price;
		return productchoice;
	}

	





	public int productPrice() {
		return priceProduct;
	}
	
	/* card */
	public Double cardDiscount(int choiceCard) {
		Double[] cardListDiscount = { 3.0, 5.0, 1.0, 2.0 };
		
		return cardListDiscount[choiceCard - 1];
	}
	
	
	/* 현재 시간 + 이름*/
	public String toDay() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		
		Calendar time = Calendar.getInstance();
		       
		String formatTime = format1.format(time.getTime())+"송준원";
		return formatTime;
	}


	/* 영화정보 입출력 */
	public String print(String nickName, String movie, String time, String seat, String viewer, int ticketPrice,
			String product, String productPrice, String cardName, String cardDiscount, int pay, String toDay) {

		ObjectOutputStream objOut = null;
		String print = "예매완료";
		try {

			if (new File("DB/test.txt").exists()) {
				System.out.println("있을 때");
				/* 기존에 파일이 있을 경우 */
				objOut = new MyOutputStream(new BufferedOutputStream(new FileOutputStream("DB/payment.txt", true)));
			} else {
				System.out.println("없을 때");
				/* 기존에 파일이 없을 경우 */
				objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/payment.txt")));
			}

			PaymentDTO paDto = new PaymentDTO(nickName, movie, time, seat, viewer, ticketPrice, product, productPrice, cardName, cardDiscount, pay, toDay);
			objOut.writeObject(paDto);
			System.out.println("파일 저장 성공!");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
//		try {
//			out = new FileOutputStream("test.txt");
//			oout = new ObjectOutputStream(out);			
//
//			
//		
//			PaymentDTO paDto = new PaymentDTO(inckName, movie, time + "시", cardName, pay);
//
//			oout.writeObject(paDto); //저장
//			
//			System.out.println("파일 저장 성공!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				oout.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		return print;
	}

	
	

	

}
