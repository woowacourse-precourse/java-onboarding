package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
		
		int pobiLeft = pobi.get(0);
		int pobiRight = pobi.get(1);
		int crongLeft = crong.get(0);
		int crongRight = crong.get(1);
		
		//예외 사항 체크
		if(CheckPage(pobiLeft,pobiRight)||CheckPage(crongLeft,crongRight))
			return -1;
		
		//페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 본인의 점수로 한다.
		int pobiMaxNum = Math.max(GetMaxNum(pobiLeft), GetMaxNum(pobiRight));
		int crongMaxNum = Math.max(GetMaxNum(crongLeft), GetMaxNum(crongRight));
		
		//포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0을 출력한다.
		if(pobiMaxNum > crongMaxNum)
			return 1;
		else if(pobiMaxNum < crongMaxNum)
			return 2;
		else 
			return 0;
	}
	
	private static boolean CheckPage(int leftPage, int rightPage) {
		//페이지 입력 형식 확인
		
		if(leftPage % 2 == 0 || leftPage < 1 || leftPage > 400)
			return true;
		
		if(rightPage % 2 == 1 || rightPage < 1 || rightPage > 400)
			return true;
		
		if(rightPage - leftPage != 1)
			return true;
		
		return false;
	}
	
	private static int GetMaxNum(int page) {
		//페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
		
		int addNum = 0;
		int multplyNum = 1;
		
		while(page > 0) {
			addNum += page%10;
			multplyNum *= page%10;
			page /= 10;
		}
		
		return Math.max(addNum, multplyNum);
	}
}