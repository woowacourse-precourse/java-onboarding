package onboarding;

import java.util.List;


class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		
		return answer;
	}
	
	public static int makePage() { //makePage와 동시 3~398까지 추출
		
        int Page = (int) (Math.random() * (398+1)-3)+3; //(최대+1)-최소)+최소 3~398
        do {
        	Page = (int) (Math.random() * (398+1)-3)+3;
        }while(Page <= 1 || Page >= 400); //조건 충족 시 리셋
        return Page;
	}
	public static int Odd_Even_N_HighScore(int Page) { //홀수 짝수,점수
		int PageL = 0;
        int PageR = 0;
		int length = (int)(Math.log10(PageL)+1);
		if(Page % 2 == 1) {//홀수
			PageL = Page;
			PageR = Page+1;
	    }else {//짝수
	    	PageL = Page-1;
	    	PageR = Page;
	    }
		int hun1 = PageL / 100; // 백
		int ten1 = (PageL / 10) % 10; // 십
		int one1 = PageL % 10; // 일*/
		int hun2 = PageR / 100; // 백
		int ten2 = (PageR / 10) % 10; // 십
		int one2 = PageR % 10; // 일*/
		int plusL = hun1+ten1+one1;
		int multiL = hun1*ten1*one1;
		int plusR = hun2+ten2+one2;
		int multiR = hun2*ten2*one2;
		int PageLSco = (plusL < multiL) ? multiL : plusL;
		int PageRSco = (plusR < multiR) ? multiR : plusR;
		int HighSco = (PageLSco < PageRSco) ? PageRSco : PageLSco;
			
		return HighSco;
	}
	
    public static void main(String[] args){
    	
    	int pobiPage = makePage();
    	int crongPage = makePage();
    	
    	int pobiL = 0;
        int pobiR = 0;
        int crongL = 0;
        int crongR = 0;

        if(pobiPage % 2 == 1) {//홀수
    		pobiL = pobiPage;
    		pobiR = pobiPage+1;
    		} else {//짝수
    		pobiL = pobiPage-1;
    		pobiR = pobiPage;
    		}
    	if(crongPage % 2 == 1) {//홀수
    		crongL = crongPage;
    		crongR = crongPage+1;
    		} else {//짝수
    		crongL = crongPage-1;
    		crongR = crongPage;
    		}
    	/*int hun = i / 100; // 백
		int ten = (i / 10) % 10; // 십
		int one = i % 10; // 일*/
    	 
         
    	
    	}
    	
        
    }



/*
 * 랜덤번호 3~398 첫,막페이지 x **
 * 나온번호 올수짝수 구분 후 홀수 +1 짝수 -1 **
 * 나온 두 수 *페이지 번호의 각 자리 숫자를 모두 더함 || 모두 곱해 가장 큰 수를 구한다.
 * 더하거나 곱한 수 큰수로 비교
 * 포비 win = 1, 크롱 win = 2, 무승부 = 0, 각 페이지 차가 1이 아니면 -1 ex) 99,102 = -1
 */