
package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        int pobiMax = calculationMax(pobi);
		int crongMax = calculationMax(crong);

		if (pobiMax > crongMax)
			answer = 1;
		if (crongMax > pobiMax)
			answer = 2;
		if (crongMax == pobiMax)
			answer = 0;
		if (pobiMax == -1 || crongMax == -1)
			answer = -1;
        
        return answer;
    }
    
	public static int pageOdd(int pageNumber) {
		int odd = 0;
		String pageToString = Integer.toString(pageNumber);
		int[] oddArray = new int[pageToString.length()];
		for (int i = 0; i < oddArray.length; i++) {
			oddArray[i] = pageToString.charAt(i) -'0';
			odd += oddArray[i];
		}
		return odd;
	}
	
	public static int pageEven(int pageNumber) {
		int even = 1;
		String pageToString = Integer.toString(pageNumber);
		int[] evenArray = new int[pageToString.length()];
		for (int i = 0; i < evenArray.length; i++) {
			evenArray[i] = pageToString.charAt(i) - '0';
			even *= evenArray[i];
		}
		return even;
	}
	
	public static int calculationMax(List<Integer> page) {
		int calculationMax = 0;
		int left = page.get(0);
		int right = page.get(1);

		if ((left + 1) != right)
			calculationMax = -1;
		
		List<Integer> score = new ArrayList<>();
		score.add(pageOdd(right));
		score.add(pageEven(right));
		score.add(pageOdd(left));
		score.add(pageEven(left));

		Collections.sort(score);
		calculationMax = score.get(3);
		
		return calculationMax;
	}
}