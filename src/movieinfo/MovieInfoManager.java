package movieinfo;

import java.util.ArrayList;

import dao.MovieInfoDAO;
import dto.NowMovieInfoDTO;

public class MovieInfoManager {
	
	MovieInfoDAO dao = new MovieInfoDAO();

	public boolean NowInsert(String title, String story, String director, String actor, int showNum, String img) {
		NowMovieInfoDTO insert = new NowMovieInfoDTO(title,story,director,actor,showNum,img);
		boolean yesNo = dao.NowInsert(insert);
		
		return yesNo;
	}

	public void NowDelete(String title) {
		dao.NowDelete(title);
	}

	public void NowUpdate(NowMovieInfoDTO update) {
		dao.NowUpdate(update);
	}
	
	public ArrayList<NowMovieInfoDTO> NowShow() {
		ArrayList<NowMovieInfoDTO> nowArray = dao.NowMovieInfo();
		return nowArray;
	}
	
	public NowMovieInfoDTO NowSelectMovie(String title) {
		NowMovieInfoDTO nowSelectMovie = dao.NowSelectMovie(title);
		return nowSelectMovie;
	}

	public void showChart() {
		
	}



}
