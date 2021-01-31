package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dto.NowMovieInfoDTO;
import member.MyOutPutStream;

public class MovieInfoDAO {
	
	ObjectOutputStream osOut = null;
	ObjectInputStream osIn = null;

	// insert
	public boolean NowInsert(NowMovieInfoDTO insert) {
		
		boolean yesNo = true;

		try {
			if(new File("DB/NowMovieDB.txt").exists()) {
				osOut = new MyOutPutStream(new BufferedOutputStream(new FileOutputStream("DB/NowMovieDB.txt",true)));
			}else {
				osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/NowMovieDB.txt",true)));
			}
			osOut.writeObject(insert);
			osOut.flush();
		} catch (Exception e) {
			e.printStackTrace();
			yesNo = false;
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
		return yesNo;
	}
	
	// update
	public void NowUpdate(NowMovieInfoDTO update) {
		
		ArrayList<NowMovieInfoDTO> dummy = new ArrayList<NowMovieInfoDTO>();
		
		for(NowMovieInfoDTO m : NowMovieInfo()) {
			if(update.getTitle().equals(m.getTitle())) {
				dummy.add(update);		
			}else {
				dummy.add(m);
			}	
		}
		
		try {
			osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/NowMovieDB.txt",false)));
			
			for(NowMovieInfoDTO up : dummy) {
				osOut.writeObject(up);
				osOut.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
	}
	
	// delete
	public void NowDelete(String title) {
		
		ArrayList<NowMovieInfoDTO> dummy = new ArrayList<NowMovieInfoDTO>();
		
		for(NowMovieInfoDTO m : NowMovieInfo()) {
			if(title.equals(m.getTitle())) {
				continue;
			}else {
				dummy.add(m);
			}	
		}
		
		try {
			osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/NowMovieDB.txt",false)));
			
			for(NowMovieInfoDTO del : dummy) {
				osOut.writeObject(del);
				osOut.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
	}
	
	// select
	public ArrayList<NowMovieInfoDTO> NowMovieInfo(){
		ArrayList<NowMovieInfoDTO> movieInfo = new ArrayList<>();
		try {
			osIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/NowMovieDB.txt")));
			
			while(true) {
				NowMovieInfoDTO selectMovieinfo = (NowMovieInfoDTO)osIn.readObject();
				movieInfo.add(selectMovieinfo);
			}
			
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(osIn != null) try{osIn.close();}catch(IOException e){}	
		}
		return movieInfo;
	}

	public NowMovieInfoDTO NowSelectMovie(String title) {
		NowMovieInfoDTO nowSelectMovie = null;
		
		for(NowMovieInfoDTO n : NowMovieInfo()) {
			if(title.equals(n.getTitle())) {
				nowSelectMovie = n;
			}
		}
		return nowSelectMovie;
	}


	
//	public MovieInfoDTO login(String id, String pw) {
//		
//		MovieInfoDTO NowArray = null;
//
//		for(MovieInfoDTO m : NowMovieInfo()) {
//			NowArray = m;
//		}
//
//		return NowArray;
//	}

}
