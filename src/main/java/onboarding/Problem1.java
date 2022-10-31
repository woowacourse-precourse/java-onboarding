package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
    	try {
	    	int answer = Integer.MAX_VALUE;
	    	List<List<Integer>> userPagesList = new ArrayList<List<Integer>>();
	    	userPagesList.add(pobi);
	    	userPagesList.add(crong);
	    	List<Integer> userMaxList = new ArrayList<Integer>();
	    	for(int i = 0; i<userPagesList.size();i++) {
	    		userMaxList.add(-1);
	    	}
		
    		for(List<Integer> userPages : userPagesList) {
    			if (userPages.size() != 2 || userPages.get(0) <= 2 || userPages.get(0) >= 399 || userPages.get(0) % 2 == 0 || userPages.get(0) + 1 != userPages.get(1)) {
					throw new IllegalArgumentException();
				}					                                                                                                                                                    
    		}
    		
    		for(int index = 0; index<userPagesList.size(); index++) {
    			List<Integer> userPages = userPagesList.get(index);
    			
    			for(Integer page : userPages) {
					int tempPage = page;
					int tempResult = 0;
					while(tempPage!=0) {
						tempResult += tempPage%10;
						tempPage /= 10;
					}
					if(tempResult > userMaxList.get(index)) {
						userMaxList.set(index,tempResult);
					}
					tempPage = page;
					tempResult = 1;
					while(tempPage!=0) {
						tempResult *= tempPage%10;
						tempPage /= 10;
					}
					if(tempResult > userMaxList.get(index)) {
						userMaxList.set(index,tempResult);
					}
				}
    		}
			return answer;
		} catch (IllegalArgumentException e) {
			return -1;
		}
	}
}