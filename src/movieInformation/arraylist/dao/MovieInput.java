package movieInformation.arraylist.dao;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import dto.PaymentDTO;
import movieInformation.arraylist.dto.MovieDTO;

public class MovieInput {

	public static void main(String[] args) {
		
		ObjectInputStream obmout = null;

	
		try {
			obmout = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/movielist.txt")));
			
			int i = 0;
			 
			while(true) {
				MovieDTO m = (MovieDTO)obmout.readObject();
				System.out.println(m);

				
				}


			
			
		
		} catch (EOFException e) {
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		

	}

}
