package onboarding;

import java.util.List;


class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		if(exception(pobi) || exception(crong)) { //하나라도 틀리면 -1
			answer = -1;
			return answer;
		}
		int pobiHighScore = scoreCompare(addHighScore(pobi),multiHighScore(crong));
		int crongHighScore;
		//각자 수 가져와서 더하기 따로 곱하기 따로 함수 만들어서 높은수 추출
		//추출한 수 비교하는 함수 하나 더 만듬
		//더하기,곱하기 비교
		//점수비교 후 1,2,0 return 만들고
		return answer;
	}
	
	public static boolean exception(List<Integer> pageList) { //예외를 true로
		int leftPage = pageList.get(0);
		int rightPage = pageList.get(1);
		
		if(rightPage - leftPage != 1) return true;
		if(leftPage / 2 != 1 ) return true;
        if(rightPage / 2 != 0 ) return true;
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
	public static int Odd_L_HighScore(int Page) {
		int PageL = 0;
		
		if(Page % 2 == 1) {//홀수
			PageL = Page;
	    }else {//짝수
	    	PageL = Page-1;
	    }
		int length = (int)(Math.log10(PageL)+1);//int자리수
		
		int hun = PageL / 100; // 백
		int ten = (PageL / 10) % 10; // 십
		int one = PageL % 10; // 일*/
		
		int plusL = 0;
		int multiL = 0;
		
		if(length == 3) { //자릿수에 따른 곱하기
			plusL = hun+ten+one;
			multiL = hun*ten*one;//100의자리 아니면 곱했을때 무조
		}else if(length == 2) {
			plusL = ten+one;
			multiL = ten*one;
		}else {
			plusL = PageL;
			multiL = PageL;//100의자리 아니면 곱했을때 무조
		}

		int HighSco = (plusL < multiL) ? multiL : plusL;
		return HighSco;
	}
	public static int Even_R_HighScore(int Page) {
        int PageR = 0;
        
		if(Page % 2 == 0) {//짝수
			PageR = Page;
	    }else {//짝수
	    	PageR = Page+1;
	    }
		int length = (int)(Math.log10(PageR)+1);//int자리수
		
		int hun = PageR / 100; // 백
		int ten = (PageR / 10) % 10; // 십
		int one = PageR % 10; // 일*/
		
		int plusR = 0;
		int multiR = 0;
		
		if(length == 3) { //자릿수에 따른 곱하기
			plusR = hun+ten+one;
			multiR = hun*ten*one;//100의자리 아니면 곱했을때 무조
		}else if(length == 2) {
			plusR = ten+one;
			multiR = ten*one;
		}else {
			plusR = PageR;
			multiR = PageR;//100의자리 아니면 곱했을때 무조
		}
		
		int HighSco = (plusR < multiR) ? multiR : plusR;
		return HighSco;
	}
	public static int HighScore(int LScore,int RScore) {
		int HighSco = (LScore < RScore) ? RScore : LScore;
		return HighSco;
	}
	public static int whoWin(int pobiScore,int crongScore) {
		int HighSco = 0;
		if(pobiScore > crongScore) {
			System.out.println(1);
		}else if(pobiScore < crongScore) {
			System.out.println(2);
		}else if(pobiScore == crongScore) {
			System.out.println(0);
		}
		return HighSco;
	}
	public static int makePage() { //makePage와 동시 3~398까지 추출
		
        int Page = (int) (Math.random() * (398+1)-3)+3; //(최대+1)-최소)+최소 3~398
        do {
        	Page = (int) (Math.random() * (398+1)-3)+3;
        }while(Page <= 1 || Page >= 400); //조건 충족 시 리셋
        return Page;
	}
    public static void main(String[] args){
    	
    	int pobiPage = makePage();
    	System.out.println(pobiPage+ " pobiPage");
    	int crongPage = makePage();
    	System.out.println(crongPage+ " crongPage");
    	
    	int pobiLScore = Odd_L_HighScore(pobiPage);
    	int pobiRScore = Even_R_HighScore(pobiPage);
    	int crongLScore = Odd_L_HighScore(crongPage);
    	int crongRScore = Even_R_HighScore(crongPage);
       
    	int pobiScore = HighScore(pobiLScore,pobiRScore);
    	System.out.println(pobiScore);
    	int crongScore = HighScore(crongLScore,crongRScore);
    	System.out.println(crongScore);
    	whoWin(pobiScore,crongScore);
    	}
    }
/*
 * 랜덤번호 3~398 첫,막페이지 x **
 * 나온번호 올수짝수 구분 후 홀수 +1 짝수 -1 **
 * 나온 두 수 *페이지 번호의 각 자리 숫자를 모두 더함 || 모두 곱해 가장 큰 수를 구한다. **
 * 더하거나 곱한 수 큰수로 비교 **
 * 포비 win = 1, 크롱 win = 2, 무승부 = 0, 각 페이지 차가 1이 아니면 -1 ex) 99,102 = -1 
 */