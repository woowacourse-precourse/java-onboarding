
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
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
}