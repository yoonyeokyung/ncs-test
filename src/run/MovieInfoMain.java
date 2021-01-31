package run;

import java.util.Scanner;

import dto.ExMovieInfoDTO;
import dto.NowMovieInfoDTO;
import movieinfo.MovieInfoManager;

public class MovieInfoMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MovieInfoManager movieManager = new MovieInfoManager();
		
		int no;
		String title;
		String story;
		String director;
		String actor;
		int showNum;
		String img;
		
		System.out.println("1. 차트");
		System.out.println("2. 현재상영작");
		System.out.println("3. 상영예정작");
		System.out.println("0. 종료");
		while(true) {
			System.out.print("번호를 입력해주세요");
			no = sc.nextInt();
			sc.nextLine();
				switch(no) {
				case 1 : 
					int cNum = 0;
					for(NowMovieInfoDTO m : movieManager.showChart()){
						if(cNum < 5) {
							System.out.println(m);
						}
						cNum++;
					}
					break;
				case 2 : 
					while(true) {
						System.out.println("1. 추가");
						System.out.println("2. 수정");
						System.out.println("3. 삭제");
						System.out.println("4. 출력");
						System.out.println("0. 종료");
		
						System.out.print("번호를 입력해주세요");
						no = sc.nextInt();
						sc.nextLine();
						switch(no) {
						case 1 : 
							System.out.print("제목 : ");
							title = sc.nextLine();
							System.out.print("줄거리 : ");
							story = sc.nextLine();
							System.out.print("감독 : ");
							director = sc.nextLine();
							System.out.print("배우 : ");
							actor = sc.nextLine();
							System.out.print("관람수 : ");
							showNum = sc.nextInt();
							sc.nextLine();
							System.out.print("이미지경로 : ");
							img = sc.nextLine();
							if(movieManager.NowInsert(title,story,director,actor,showNum,img)) {
								System.out.println("성공");
							}else {
								System.out.println("실패");
							}				
							break;
						case 2 : 
							int i = 1;
							for(NowMovieInfoDTO m : movieManager.NowShow()){
								System.out.println(i+m.getTitle());
								i++;
							}
							System.out.println("변경할 영화의 제목을 입력 : ");
							title = sc.nextLine();
							NowMovieInfoDTO nup = movieManager.NowSelectMovie(title);
							System.out.println("변경할 영화 : " + nup.getTitle());
							System.out.println("1.이미지경로");
							System.out.println("2.줄거리");
							System.out.println("3.감독");
							System.out.println("4.배우");
							System.out.println("5.관람수");
							System.out.println("0.종료");
							System.out.print("변경할 번호 : ");
							no = sc.nextInt();
							sc.nextLine();
							switch(no) {
							case 1 :
								System.out.print("변경할 이미지경로 : ");
								img = sc.nextLine();
								nup.setImg(img);
								movieManager.NowUpdate(nup);
								break;
							case 2 :
								System.out.print("변경할 줄거리 : ");
								story = sc.nextLine();
								nup.setStory(story);
								movieManager.NowUpdate(nup);
								break;
							case 3 :
								System.out.print("변경할 감독 : ");
								director = sc.nextLine();
								nup.setDirector(director);
								movieManager.NowUpdate(nup);
								break;
							case 4 :
								System.out.print("변경할 배우 : ");
								actor = sc.nextLine();
								nup.setActor(actor);
								movieManager.NowUpdate(nup);
								break;
							case 5 :
								System.out.print("변경할 관람수 : ");
								showNum = sc.nextInt();
								nup.setShowNum(showNum);
								movieManager.NowUpdate(nup);
								break;

							case 0 :
								return;
							default : System.out.println("번호 잘못됨");
							}
							System.out.println("변경 성공");
							break;
						case 3 : 
							i = 1;
							for(NowMovieInfoDTO m : movieManager.NowShow()){
								System.out.println(i+m.getTitle());
								i++;
							}
							System.out.println("삭제할 영화의 제목을 입력 : ");
							title = sc.nextLine();
							movieManager.NowDelete(title);
							System.out.println("삭제완료");
							break;
						case 4 : 
							for(NowMovieInfoDTO m : movieManager.NowShow()){
								System.out.println(m);
							}
							break;
						case 0 : return;
						default : System.out.println("잘못된 번호");
					}
					}
				case 3 : 
					while(true) {
						System.out.println("1. 추가");
						System.out.println("2. 수정");
						System.out.println("3. 삭제");
						System.out.println("4. 출력");
						System.out.println("0. 종료");
	
						System.out.print("번호를 입력해주세요");
						no = sc.nextInt();
						sc.nextLine();
						switch(no) {
							case 1 : 
								System.out.print("제목 : ");
								title = sc.nextLine();
								System.out.print("줄거리 : ");
								story = sc.nextLine();
								System.out.print("감독 : ");
								director = sc.nextLine();
								System.out.print("배우 : ");
								actor = sc.nextLine();
								System.out.print("이미지경로 : ");
								img = sc.nextLine();
								if(movieManager.ExInsert(title, story, director, actor, img)) {
									System.out.println("성공");
								}else {
									System.out.println("실패");
								}
								break;
							case 2 : 
								int i = 1;
								for(ExMovieInfoDTO m : movieManager.ExShow()){
									System.out.println(i+m.getTitle());
									i++;
								}
								System.out.println("변경할 영화의 제목을 입력 : ");
								title = sc.nextLine();
								ExMovieInfoDTO eup = movieManager.ExSelectMovie(title);
								System.out.println("변경할 영화 : " + eup.getTitle());
								System.out.println("1.이미지경로");
								System.out.println("2.줄거리");
								System.out.println("3.감독");
								System.out.println("4.배우");
								System.out.println("0.종료");
								System.out.print("변경할 번호 : ");
								no = sc.nextInt();
								sc.nextLine();
								switch(no) {
								case 1 :
									System.out.print("변경할 이미지경로 : ");
									img = sc.nextLine();
									eup.setImg(img);
									movieManager.ExUpdate(eup);
									break;
								case 2 :
									System.out.print("변경할 줄거리 : ");
									story = sc.nextLine();
									eup.setStory(story);
									movieManager.ExUpdate(eup);
									break;
								case 3 :
									System.out.print("변경할 감독 : ");
									director = sc.nextLine();
									eup.setDirector(director);
									movieManager.ExUpdate(eup);
									break;
								case 4 :
									System.out.print("변경할 배우 : ");
									actor = sc.nextLine();
									eup.setActor(actor);
									movieManager.ExUpdate(eup);
									break;
								case 0 :
									return;
								default : System.out.println("번호 잘못됨");
								}
								System.out.println("변경 성공");
								break;
							case 3 : 
								i = 1;
								for(ExMovieInfoDTO m : movieManager.ExShow()){
									System.out.println(i+m.getTitle());
									i++;
								}
								System.out.println("삭제할 영화의 제목을 입력 : ");
								title = sc.nextLine();
								movieManager.ExDelete(title);
								System.out.println("삭제완료");
								break;
							case 4 : 
								for(ExMovieInfoDTO m : movieManager.ExShow()){
									System.out.println(m);
								}
								break;
							case 0 : return;
							default : System.out.println("잘못된 번호");
						}
					}
				case 0 : return;
				default : System.out.println("잘못된 번호");
			}
		}
	}

}
