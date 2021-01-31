package movieinfo;

import java.util.ArrayList;

import dao.MovieInfoDAO;
import dto.ExMovieInfoDTO;
import dto.NowMovieInfoDTO;

public class MovieInfoManager {
	
	MovieInfoDAO dao = new MovieInfoDAO();

	/* 차트 */
	public ArrayList<NowMovieInfoDTO> showChart() {
		ArrayList<NowMovieInfoDTO> chartArray = dao.chartMovieInfo();
		return chartArray;
	}
	
	/* NowMovie */
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

	/* ExMovie */
	public boolean ExInsert(String title, String story, String director, String actor, String img) {
		ExMovieInfoDTO insert = new ExMovieInfoDTO(title,story,director,actor,img);
		boolean yesNo = dao.ExInsert(insert);
		
		return yesNo;
	}

	public void ExUpdate(ExMovieInfoDTO update) {
		dao.ExUpdate(update);
		
	}

	public void ExDelete(String title) {
		dao.ExDelete(title);
		
	}

	public ArrayList<ExMovieInfoDTO> ExShow() {
		ArrayList<ExMovieInfoDTO> exArray = dao.ExMovieInfo();
		return exArray;
	}

	public ExMovieInfoDTO ExSelectMovie(String title) {
		ExMovieInfoDTO exSelectMovie = dao.ExSelectMovie(title);
		return exSelectMovie;
	}



}
