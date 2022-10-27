package onboarding;

import java.util.List;


class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
	}
	
	public static int makePage() { //makePage와 동시 2~399까지 추출
        int Page = (int) (Math.random() * (399-2))+2;
        do {
        	Page = (int) (Math.random() * (399-2))+2;
        }while(Page <= 1 || Page >= 400); //조건 충족 시 리셋
        return Page;
	}
    public static void main(String[] args){
    	
       int pobiPage = makePage();
       int crongPage = makePage()+2;
        
        
        
        int pobiL;
        int pobiR;
        int crongL;
        int crongR;
    }
}


/*
 * 랜덤번호 2~399 **
 * 나온번호 올수짝수 구분 후 홀수 +1 짝수 -1
 * 나온 두 수 *페이지 번호의 각 자리 숫자를 모두 더함 || 모두 곱해 가장 큰 수를 구한다.
 * 더하거나 곱한 수 큰수로 비교
 * 포비 win = 1, 크롱 win = 2, 무승부 = 0, 각 페이지 차가 1이 아니면 -1 ex) 99,102 = -1
 */