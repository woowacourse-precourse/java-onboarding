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
	public static int PageL(int A) {
		int L = A;
		int PageL;
		if(L % 2 == 1) {//홀수
			PageL = L;
    		} else {//짝수
    		PageL = L+1;
    		}
		return PageL;
	}
	public static int PageR(int A) {
		int R = A;
		int pageR;
		if(R % 2 == 1) {//홀수
			pageR = R;
    		} else {//짝수
    		pageR = R-1;
    		}
		return pageR;
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
    	 System.out.println(pobiL);
         System.out.println(pobiR);
         System.out.println(crongL);
         System.out.println(crongR);
    	
    	}
    	
        
    }



/*
 * 랜덤번호 3~398 첫,막페이지 x **
 * 나온번호 올수짝수 구분 후 홀수 +1 짝수 -1 **
 * 나온 두 수 *페이지 번호의 각 자리 숫자를 모두 더함 || 모두 곱해 가장 큰 수를 구한다.
 * 더하거나 곱한 수 큰수로 비교
 * 포비 win = 1, 크롱 win = 2, 무승부 = 0, 각 페이지 차가 1이 아니면 -1 ex) 99,102 = -1
 */