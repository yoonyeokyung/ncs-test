package movieInformation.arraylist.Movies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import movieInformation.arraylist.dao.SchMoiveOutput;
import movieInformation.arraylist.dto.MovieDTO;

public class SchMovieList {
	
	public static void main(String[] args) {
		/*개봉예정작*/
		SchMoiveOutput prin = new SchMoiveOutput();
		
		/*영화제목, 줄거리, 감독, 배우 순서이다.*/
		prin.print("이 안에 외계인이 있다",
					
				    "\n 2021년 지구, 노란색 액체의 흔적과 함께 인류들이 사라진다.\n"
				    + " 지하 벙커로 간신히 피신한 외계인 연구회 동호회 멤버들. \n"
				    + " 그 와중에 멤버 중 한 명이 규칙에서 벗어나는 기묘한 행동을 시작해 일대 혼란이 벌어지고, \n"
				    + " 단 한 명의 아웃사이더를 찾기 위해 진격을 시작하는데… \n"
				    + " 침공에 살아남았다면 응답하라. 여기는 섹터56! 우리는 함께 모여 문제를 해결해야 한다! \n",
					
				    "최은종 \n",
					
				      "\n 배우 : 조병규 주연 | 도건태 역 \n "
					+ "배우 : 배누리 주연 | 배수진 역 \n "
					+ "배우 : 이현웅 주연 | 민두환 역 \n"
					+ " 배우 : 태항호 주연 | 태하명역 \n");
		
		
		prin.print("톰과 제리", 
				   
				   "\n전 세계가 사랑한 라이벌 콤비 뉴욕을 발칵 뒤집는다! \n"
				   + "생쥐 제리는 성대한 결혼식이 열리게 될 뉴욕의 한 고급 호텔로 이사를 오게 되고, \n"
				   + "이벤트 플래너 카일라는 제리를 잡기 위해서 고양이 톰을 고용한다. \n"
				   + "하지만 우당탕탕 사고뭉치들의 역대급 대소동은 카일라의 커리어는 물론 결혼식과 호텔까지도 위험에 빠뜨리게 되는데… \n",
				   
				   "팀 스토리 (Tim Story) \n", 
				   
				     "\n 배우 : 클로이 모레츠 Chloe Moretz 주연 | 카일라 역 \n "
				   + "배우 : 마이클 페나 Michael Pena 주연| 테렌스 역 \n "
				   + "배우 : 켄 정 Ken Jeong 주연| 재키 역 \n "
				   + "배우 : 카밀라 아프웨드슨 Camilla Arfwedson 조연| 린다 페리보텀 역 \n");
		
		prin.print("호라이즌 라인", 
				
				   "\n 계기판도 GPS도 조종사도 없다!내 안의 생존 본능을 깨워라! \n "
				   + "에메랄드 빛 해안을 낀 열대섬으로 향하던 ‘사라’ 이륙 후 두근거림도 잠시 멀쩡했던 조종사는 심정지로 정신을 잃고 \n "
				   + "흔들리는 기체로 인해 고장 난 계기판과 GPS! \n"
				   + " 메이데이! 메이데이! 메이데이! 구조를 외치는 중에도 추락하는 비행기. 생존확률 0%? 욕 터지는 고공 분투가 시작된다 \n", 
				
				   "마이클 마키마인(Mikael Marcimain) \n",
				   
				     "\n 배우 : 알렉산더 드레이먼 Gal Gadot 주연 | 잭슨 역 \n "
				   + "배우 : 앨리슨 윌리암스 Allison Williams 주연 | 사라 역 \n "
				   + "배우 : 키스 데이빗 Keith David 주연 | 와이먼 역 \n "
				   + "배우 : 주메인 헌터 Jumayn Hunter 조연 | 사무엘 역 \n");

		
		}
	}

