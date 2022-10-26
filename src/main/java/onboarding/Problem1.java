package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	// 0, 1, 2, -1은 모두 의미를 가지는 값이므로 로직 상 반환될 수 없는 값으로 초기화한다.
        int answer = Integer.MAX_VALUE;

        // 페이지 값이 유효하지 않을 경우 -1을 반환하고 수행을 종료한다.
        if (!isValid(pobi.get(0), pobi.get(1)) || !isValid(crong.get(0), crong.get(1))) {
        	return -1;
        }
        
        // getScore 메소드를 이용해 pobi, crong의 점수를 얻는다.
        int pobiScore = getScore(pobi.get(0), pobi.get(1));
        int crongScore = getScore(crong.get(0), crong.get(1));
        
        // 점수가 0일 경우 정상적으로 점수를 얻지 못한 것이므로 예외처리한다.
        if (pobiScore == 0 || crongScore == 0) {
        	answer = -1;
        }

        // pobi, crong의 점수를 비교해 반환할 값을 answer에 담는다.
        if (pobiScore == crongScore) {
        	answer = 0;
        } else if (pobiScore > crongScore) {
        	answer = 1;
	    } else if (pobiScore < crongScore) {
	    	answer = 2;
	    } 
        
        return answer;
    }
    
    /**
     * 두 정수가 유효한 입력값인지 확인한다.
     * @param number1
     * @param number2
     * @return 유효하면 true, 아니면 false
     */
    private static boolean isValid(Integer number1, Integer number2) {
    	
    	return (number1 != null && number2 != null) && Math.abs(number1 - number2) == 1 ? true : false;
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
   private static int getScore(int leftPage, int rightPage) {
	   int score = 0;
	   
	   int leftPageValue = Math.max(getSumOfDigits(leftPage), getMultipliedOfDigits(leftPage));
	   int rightPageValue = Math.max(getSumOfDigits(rightPage), getMultipliedOfDigits(rightPage));
	   
	   return Math.max(leftPageValue, rightPageValue);
   }
}