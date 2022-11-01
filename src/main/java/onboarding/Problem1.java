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
    				int sumByDigit = getSumByDigit(page);
					if(sumByDigit > userMaxList.get(index)) {
						userMaxList.set(index,sumByDigit);
					}
					int productByDigit = getProductByDigit(page);
					if(productByDigit > userMaxList.get(index)) {
						userMaxList.set(index,productByDigit);
					}
				}
    		}
    		
			if(userMaxList.get(0) == userMaxList.get(1)) {
				answer = 0;
			}else {
				answer = userMaxList.get(0) > userMaxList.get(1) ? 1 : 2;
			}

			return answer;
		} catch (IllegalArgumentException e) {
			return -1;
		}
	}
	
	public static int getSumByDigit(int number) {
		int result = 0;
		while(number!=0) {
			result += number%10;
			number /= 10;
		}
		return result;
	}
	
	public static int getProductByDigit(int number) {
		int result = 1;
		while(number!=0) {
			result *= number%10;
			number /= 10;
		}
		return result;
	}
}