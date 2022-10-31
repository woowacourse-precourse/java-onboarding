package onboarding;

import java.util.List;


class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		if(exception(pobi) || exception(crong)) { //하나라도 틀리면 -1
			answer = -1;
			return answer;
		}
		int pobiHighScore = scoreCompare(addHighScore(pobi),multiHighScore(pobi));
		int crongHighScore = scoreCompare(addHighScore(crong),multiHighScore(crong));
		//각자 수 가져와서 더하기 따로 곱하기 따로 함수 만들어서 높은수 추출
		if(pobiHighScore > crongHighScore) {
			return answer = 1;
		}else if(pobiHighScore < crongHighScore) {
			return answer = 2;
		}else if(pobiHighScore == crongHighScore) {
			return answer = 0;
		}
		
		//점수비교 후 1,2,0 return 만들고
		return answer;
	}
	
	public static boolean exception(List<Integer> pageList) { //예외를 true로
		int leftPage = pageList.get(0);
		int rightPage = pageList.get(1);
		
		if(rightPage - leftPage != 1 && leftPage / 2 != 1 && rightPage / 2 != 0) return true;
		return false;
	}
	public static int addScore(int page) {
		int hun = page / 100; // 백
		int ten = (page / 10) % 10; // 십
		int one = page % 10; // 일*/
		return hun+ten+one;
	}
	public static int multiScore(int page) {
		int length = (int)(Math.log10(page)+1);
		int hun = page / 100; // 백
		int ten = (page / 10) % 10; // 십
		int one = page % 10; // 일*/
		int multi = 0;
		if(length == 3) { //자릿수에 따른 곱하기
			multi = hun*ten*one;//100의자리 아니면 곱했을때 무조
		}else if(length == 2) {
			multi = ten*one;
		}else {
			multi = page;//100의자리 아니면 곱했을때 무조
		}
		return multi;
	}
	public static int addHighScore(List<Integer> page) {
		int leftPage=page.get(0);
	    int rightPage=page.get(1);
	    
	    int LScore = addScore(leftPage);
	    int RScore = addScore(rightPage);
	    int HighSco = (LScore < RScore) ? RScore : LScore;
		return HighSco;
	}
	public static int multiHighScore(List<Integer> page) {
		int leftPage=page.get(0);
	    int rightPage=page.get(1);
	    
	    int LScore = multiScore(leftPage);
	    int RScore = multiScore(rightPage);
	    int HighSco = (LScore < RScore) ? RScore : LScore;
		return HighSco;
	}
	public static int scoreCompare(int A,int B) {
		int HighSco = (A < B) ? B : A;
		return HighSco;
	}
	
	public static int makePage() { //makePage와 동시 3~398까지 추출
		
        int Page = (int) (Math.random() * (398+1)-3)+3; //(최대+1)-최소)+최소 3~398
        do {
        	Page = (int) (Math.random() * (398+1)-3)+3;
        }while(Page <= 1 || Page >= 400); //조건 충족 시 리셋
        return Page;
	}
   
    }
/*
 * 랜덤번호 3~398 첫,막페이지 x **
 * 나온번호 올수짝수 구분 후 홀수 +1 짝수 -1 **
 * 나온 두 수 *페이지 번호의 각 자리 숫자를 모두 더함 || 모두 곱해 가장 큰 수를 구한다. **
 * 더하거나 곱한 수 큰수로 비교 **
 * 포비 win = 1, 크롱 win = 2, 무승부 = 0, 각 페이지 차가 1이 아니면 -1 ex) 99,102 = -1 
 */