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
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import dto.ConditionDTO;

public class ConditionDAO {

	public static void main(String[] args) {

		ConditionDTO cDTO = new ConditionDTO();
		cDTO.movieSelect();
		cDTO.areaSelect();
		cDTO.dateSelect();
		cDTO.timeSelect();
		cDTO.seatSelect();

		ObjectOutputStream objOut = null;

		try {
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/conditionDB.txt")));

			List<ConditionDTO> list = new ArrayList<ConditionDTO>();

			for(int i = 0 ; i < cDTO.movieArr.size() ; i++) {
				for(int k = 0 ; k < cDTO.movieArr.size() ; k++) {
					for(int d = 0 ; d < cDTO.movieArr.size() ; d++) {
						for(int t = 0 ; t < cDTO.movieArr.size() ; t++) {
							for(int s = 0 ; s < cDTO.movieArr.size() ; s++) {
								String movieTitle = cDTO.movieArr.get(i);
								String area = cDTO.areaArr.get(k);
								String date = cDTO.dateArr.get(d);
								String showTime = cDTO.timeArr.get(t);
								String seat = cDTO.seatArr.get(s);
								ConditionDTO c = new ConditionDTO(movieTitle, area, date, showTime, seat);
								list.add(c);

							}
						}
					}
				}
			}		

			for(int i = 0 ; i < list.size() ; i++) {
				objOut.writeObject(list.get(i));
			}
		
		} catch (EOFException e) {	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
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
//			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/conditionDB.txt")));
//
//			int i = 0;
//			while(true) {
//				System.out.println((ConditionDTO)objIn.readObject());
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
//
//

	}	// main 종료

}	// class 종료