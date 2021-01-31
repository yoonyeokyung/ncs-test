package movieinfo;

import java.util.Comparator;

import dto.NowMovieInfoDTO;

public class Charting implements Comparator<NowMovieInfoDTO>{

		@Override
		public int compare(NowMovieInfoDTO o1, NowMovieInfoDTO o2) {
		
			return -(o1.getShowNum() - o2.getShowNum());

		}

}		