package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
    	int answer = Integer.MAX_VALUE;
    	List<List<Integer>> userPagesList = new ArrayList<List<Integer>>();
    	userPagesList.add(pobi);
    	userPagesList.add(crong);
    	List<Integer> userMaxList = new ArrayList<Integer>();
    	for(int i = 0; i<userPagesList.size();i++) {
    		userMaxList.add(-1);
    	}
    	return answer;			
	}
}