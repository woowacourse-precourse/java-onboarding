package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	// 0, 1, 2, -1은 모두 의미를 가지는 값이므로 로직 상 반환될 수 없는 값으로 초기화한다.
        int answer = Integer.MAX_VALUE;

        // TODO getScore 메소드를 이용해 pobi, crong의 점수를 얻는다.
        // TODO pobi, crong의 점수를 비교해 반환할 값을 answer에 담는다.
        
        return answer;
    }
    

    /**
     * 주어진 정수를 이루는 각 자리 수의 합을 반환한다.
     * @param number
     * @return 각 자리 수의 합
     */
    private static int getSumOfDigits(int number) {
    	int result = 0;
    	
    	while (number != 0) {
    		result += number%10;
    		number /= 10;
    	}
    	
    	return result;
    }
    
    /**
     * 주어진 정수를 이루는 각 자리 수의 곱을 반환한다.
     * @param number
     * @return 각 자리 수의 곱
     */
    private static int getMultipliedOfDigits(int number) {
    	int result = 1;
    	
    	while (number != 0) {
    		result *= number%10;
    		number /= 10;
    	}
    	
    	return result;
    }
    
   /**
    * 주어진 각 페이지로 계산한 값을 비교해 정한 점수를 반환한다.
    * @param pages
    * @return
    */
   private static int getScore(List<Integer> pages) {
	   int score = 0;
	   
	   for (Integer page : pages) {
		   // TODO 입력값이 잘못될 일 없으면 필요없는 if문. 고민해볼 것
		   if (page != null) {
			   // 페이지 번호를 꺼내서 각 자리 수의 합, 각 자리 수의 곱 중 큰 값을 택한다.
			   int pageValue = Math.max(getSumOfDigits(page), getMultipliedOfDigits(page));
			   // 최종적으로 왼쪽 페이지 번호의 값, 오른쪽 페이지 번호의 값 중 더 큰 값이 score에 저장된다.
			   score = Math.max(pageValue, score);
		   }
	   }
	   
	   return score;
   }
}