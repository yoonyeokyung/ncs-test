package movieInformation.arraylist.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import movieInformation.arraylist.dto.MovieDTO;

public class AscendingOutput {
	
	public void print(String movie, String story, String director, String actor, String review,
			int visitors) {

		ObjectOutputStream obmout = null;
		try {

			if (new File("DB/movielist.txt").exists()) {
				System.out.println("DB텍스트가 있습니다.");
				/* 기존에 파일이 있을 경우 */
				obmout = new MyOutputStream(new BufferedOutputStream(new FileOutputStream("DB/movielist.txt", true)));
			} else {
				System.out.println("DB텍스트가 없네요.");
				/* 기존에 파일이 없을 경우 */
				obmout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/movielist.txt")));
			}


			MovieDTO paDto = new MovieDTO(movie, story, director, actor, review, visitors);
			obmout.writeObject(paDto);
			System.out.println("파일 저장 성공!");

		} catch (FileNotFoundException e) {
			
			System.out.println("성공");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (obmout != null) {
				try {
					obmout.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}		// method 종료.
}			// Class 종료.