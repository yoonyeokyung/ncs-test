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

import dto.ConditionDTO;
import dto.PaymentDTO;
import dto.ProductDTO;
import ticketingAndPayment.MyOutputStream;

public class PaymentDAO {

	Scanner sc = new Scanner(System.in);

	/* 상품 부분 받아오기 */
	String productchoice = "";
	int priceProduct = 0;
	ArrayList<ProductDTO> ProductList = new ArrayList<ProductDTO>(); // 정보 다받아오기
	ArrayList ProductListName = new ArrayList(); // 이름만 받아오기
	ArrayList ProductListPrice = new ArrayList(); // 가격만 받아오기
	ArrayList<ConditionDTO> MovieList = new ArrayList<ConditionDTO>(); // 영화 정보 다 받아오

	ArrayList movieTitle = new ArrayList(); // 영화이름
	ArrayList area = new ArrayList(); // 영화 장수
	ArrayList date = new ArrayList(); // 날짜
	ArrayList showTime = new ArrayList(); // 시간
	ArrayList seat = new ArrayList(); // 좌석

	/* 상품목록 */
	public ArrayList ProductListName() {

		ObjectInputStream objIn = null;

		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));

			int i = 0;
			while (true) {
				ProductDTO m = (ProductDTO) objIn.readObject();
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

	/* 영화 관력 데이터 가져오기 */
	public ArrayList MovieList() { // 영화 이름 리턴
		ObjectInputStream objIn = null;

		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/conditionDB.txt")));

			int i = 0;
			while (true) {
				ConditionDTO m = (ConditionDTO) objIn.readObject();

				MovieList.add(m);
				movieTitle.add(m.getMovieTitle());
				area.add(m.getArea());
				date.add(m.getDate());
				showTime.add(m.getShowTime());
				seat.add(m.getSeat());
			}

		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (objIn != null) {
				try {
					objIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		int count = 0;
		ArrayList movieTitle2 = new ArrayList();
		movieTitle2.add(movieTitle.get(0));
		for (int i = 0; i < movieTitle.size(); i++) {
			if (!(movieTitle2.get(count).equals(movieTitle.get(i)))) {
				movieTitle2.add(movieTitle.get(i));
				count += 1;
			}
		}
		return movieTitle2;
	}

	public ArrayList MovieListArea(String getmovieTitle) {
		ArrayList areaList = new ArrayList();
		int countArea = 0;
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(getmovieTitle)) {
				areaList.add(area.get(i));
				break;
			}
		}
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(getmovieTitle)) {
				if (!(areaList.get(countArea).equals(area.get(i)))) {
					countArea += 1;
					areaList.add(area.get(i));
				}
			}
		}
		return areaList;
	}

	public int moviePrice(int choiceMovie) {
		int price;
		price = 7000;
		return price;
	}

//	date
	/* time */
	public ArrayList movieDate(String getmovieTitle, String movidArea) {
		ArrayList dateList = new ArrayList();
		int count = 0;
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(getmovieTitle)) {
				if (area.get(i).equals(movidArea)) {
					dateList.add(date.get(i));
					break;
				}
			}
		}
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(getmovieTitle)) {
				if (area.get(i).equals(movidArea)) {
					if (!(date.get(i).equals(dateList.get(count)))) {
						dateList.add(date.get(i));
						count += 1;
					}
				}
			}
		}
		return dateList;
	}

	public ArrayList movieTime(String movie, String movidArea, String movieDate) {
		ArrayList timeList = new ArrayList();
		int count = 0;
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(movie)) {
				if (area.get(i).equals(movidArea)) {
					if (date.get(i).equals(movieDate)) {
						timeList.add(showTime.get(i));
						break;
					}
				}
			}
		}
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(movie)) {
				if (area.get(i).equals(movidArea)) {
					if (date.get(i).equals(movieDate)) {
						if (!(showTime.get(i).equals(timeList.get(count)))) {
							timeList.add(showTime.get(i));
							count += 1;
						}
					}
				}
			}
		}
		return timeList;
	}

	/* seat */
	public ArrayList movieSeat(String movie, String movidArea, String movieDate, String movieTime) {
		ArrayList seatList = new ArrayList();
		int count = 0;
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(movie)) {
				if (area.get(i).equals(movidArea)) {
					if (date.get(i).equals(movieDate)) {
						if (showTime.get(i).equals(movieTime)) {
							seatList.add(seat.get(i));
							break;
						}
					}
				}
			}
		}
		for (int i = 0; i < movieTitle.size(); i++) {
			if (movieTitle.get(i).equals(movie)) {
				if (area.get(i).equals(movidArea)) {
					if (date.get(i).equals(movieDate)) {
						if (showTime.get(i).equals(movieTime)) {
							if (!(showTime.get(i).equals(seatList.get(count)))) {
								seatList.add(seat.get(i));
								count += 1;
							}
						}
					}
				}
			}
		}

		return seatList;
	}

	public int movieSeatPrice(int choiceNumber, int price) {

		int moviePrice = 0;

		moviePrice += choiceNumber * price;
		return moviePrice;
	}

	/* product */
	public String productTitle(String choiceProduct, int choiceProductPrice, int choiceConut) {
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

	/* 현재 시간 + 이름 */
	public String toDay() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar time = Calendar.getInstance();

		String formatTime = format1.format(time.getTime()) + "송준원";
		return formatTime;
	}

	/* 영화정보 입출력 */
	public String print(String nickName, String movie, String area, String time, String seat, String viewer,
			int ticketPrice, String product, String productPrice, String cardName, String cardDiscount, int pay,
			String toDay) {

		ObjectOutputStream objOut = null;
		String print = "예매완료";
		try {

			if (new File("DB/test.txt").exists()) {
				/* 기존에 파일이 있을 경우 */
				objOut = new MyOutputStream(new BufferedOutputStream(new FileOutputStream("DB/payment.txt", true)));
			} else {
				/* 기존에 파일이 없을 경우 */
				objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/payment.txt")));
			}
			PaymentDTO paDto = new PaymentDTO(nickName, movie, area, time, seat, viewer, ticketPrice, product,
					productPrice, cardName, cardDiscount, pay, toDay);
			objOut.writeObject(paDto);
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
		return print;
	}

}
