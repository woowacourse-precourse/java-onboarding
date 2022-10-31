package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if((pobi.get(0) == pobi.get(1) - 1) && crong.get(0) == crong.get(1) - 1) {
        	ArrayList<Integer> pobi_list = new ArrayList<>();
        	ArrayList<Integer> crong_list = new ArrayList<>();
        	int pobipobi = pobi.get(1);
        	int crongcrong = crong.get(1);
        	int max_pobi;
        	while(pobipobi > 0) {
        		pobi_list.add(pobipobi % 10);
        		pobipobi /= 10;
        	}
        	while(crongcrong > 0) {
        		crong_list.add(crongcrong % 10);
        		crongcrong /= 10;
        	}
        	for(int i = 0; i<pobi_list.size(); i++) {
        		
        		if(pobi_list.get(i) < 2) {
        			max_pobi = 0;
        			for(int j = 0; j<pobi_list.size(); j++) {
        				max_pobi += pobi_list.get(j);
        			}
        		}else {
        			int flag = 0;
        			for(int k = 1; k<pobi_list.size(); k++) {
        				if(pobi_list.get(k) == 0) {
        					flag = 1;
        					break;
        				}
        			}
        			if(flag != 1) {
        				max_pobi = 1;
        				if(pobi_list.get(0) == 0) {
        					pobi_list.set(0, 9);
        					pobi_list.set(1, pobi_list.get(1) - 1);
        				}
            			for(int j = 0; j<pobi_list.size(); j++) {
            				max_pobi *= pobi_list.get(j);
            			}
        			}
        			
        			
        		}
        	}
        }else answer = -1;
        return answer;
    }
}