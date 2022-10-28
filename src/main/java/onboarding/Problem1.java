package onboarding;

import java.util.List;

class Problem1 {
	
	/* 기능 구현 리스트 
	 * 1. 예외검사 - 페이지 수가 1~400 인지 검사하고 / 오른쪽페이지수 - 왼쪽페이지수 = 1 인지 검사 / 시작면 마지막 면이 아닌지 검사 
	 * 2. 왼쪽,오른쪽 페이지 수의 Max(각자리수의 합 / 각자리수의 곱) 구현  
	 * 3. 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1 구현  
	***/
	
	
	//1. 예외검사 - 페이 수가 1~400 인지 검사하고 / 오른쪽페이지수 - 왼쪽페이지수 = 1 인지 검사 / 시작면 마지막 면이 아닌지 검사	
		public static boolean exceptionCheck(List<Integer> pageNumber) {
			// false - 예외 없음
			// true - 예외 발생
			int leftPage = pageNumber.get(0);
			int rightPage = pageNumber.get(1);
			
			// 페이지 수가 1~400 인지 검사 / 시작면 , 마지막면 인지 아닌지 검사
			if (leftPage < 2 || rightPage > 399) {
				return true;
			}
				
			// 페이지 수가 연속적인지 검사  
			if (rightPage - leftPage != 1) {
				return true;
			}
		return false;
		}
		
		
		// 2. 각자리수의 max(합 , 곱) 구현  
		public static int getMax(int pageNum) {
			int sum = 0;
			int multiplication = 1;
			
			while (pageNum != 0) {
				sum += pageNum % 10;
				multiplication *= pageNum % 10;
				pageNum /= 10;
			}
			return Math.max(sum, multiplication);	
		}	
		
		// 3. 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1 구현  
	    public static int solution(List<Integer> pobi, List<Integer> crong) {
	        // 예외 발생시 -1 리턴 
	    	if (exceptionCheck(pobi) || exceptionCheck(crong))
	        	return -1;
	    	// 포비 
	        int pobiLeft = getMax(pobi.get(0));
	        int pobiRight = getMax(pobi.get(1));
	        int maxPobi = Math.max(pobiLeft, pobiRight);
	        // 크롱
	        int crongLeft = getMax(crong.get(0));
	        int crongRight = getMax(crong.get(1));
	        int maxCrong = Math.max(crongLeft, crongRight);
	        
	        if (maxPobi == maxCrong) {
	        	return 0;
	        } else if (maxPobi > maxCrong) {
	        	return 1;
	        } else if (maxPobi < maxCrong) {
	        	return 2;
	        }
	        return -1;
	    }
}