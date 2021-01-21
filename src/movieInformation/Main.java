package movieInformation;

public class Main {
	
	public static void main(String[] args) {

		 /* getter setter 활용하는 방법 생각해보기. 유지보수성... 현재 좋지 않음 */		
		String[][] sArr = {{"영화이름0", "감독0", "배우이름0", "조주연|역명0", "출연작품0", "영화줄거리0"},
								{"영화이름1", "감독1", "배우이름1", "조주연|역명1", "출연작품1", "영화줄거리1"},
								{"영화이름2", "감독2", "배우이름2", "조주연|역명2", "출연작품2", "영화줄거리2"}, 
								{"영화이름3", "감독3", "배우이름3", "조주연|역명3", "출연작품3", "영화줄거리3"}, 
								{"영화이름4", "감독4", "배우이름4", "조주연|역명4", "출연작품4", "영화줄거리4"} };
			
		boolean boo = true;		// 숫자값으로 변경 필요 (해당 영화 클릭 시 숫자값 받고 그에 해당하는 배열 출력??)
		if(boo = true) { 
			for(int i = 0; i < sArr.length ; i++) {
			System.out.print(sArr[0][i]);
				
			}
		}
		/* 이건 모두다 실행하게 됨 */
//		for(int i = 0; i < sArr.length ; i++) {
//			for(int j = 0 ; j < sArr[i].length ; j++) {
//				System.out.print(sArr[i][j] + " ");
//			}
//			System.out.println();
//		}
			
			
		}
}
