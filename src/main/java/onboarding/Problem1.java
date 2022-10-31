package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if((pobi.size()!=2)||(crong.size()!=2)) {
        	return -1;
        }else if(pobi.get(0)==1||crong.get(0)==1
        		||pobi.get(1)==400||crong.get(1)==400) {
        	return -1;
        }else if((pobi.get(1)-pobi.get(0)!=1)||(crong.get(1)-crong.get(0)!=1)){
        	return -1;
        }else if(pobi.get(0)%2!=1||crong.get(0)%2!=1) {
        	return -1;
        }
        
        List<Integer> pobi_left_nums = getElements(pobi.get(0));
        List<Integer> pobi_right_nums = getElements(pobi.get(1));
        
        int pobi_left_max = getMaxValue(pobi_left_nums);
        int pobi_right_max = getMaxValue(pobi_right_nums);
        int pobi_max = Math.max(pobi_left_max, pobi_right_max);
        
        List<Integer> crong_left_nums = getElements(crong.get(0));
        List<Integer> crong_right_nums = getElements(crong.get(1));
        
        int crong_left_max = getMaxValue(crong_left_nums);
        int crong_right_max = getMaxValue(crong_right_nums);
        int crong_max = Math.max(crong_left_max, crong_right_max);
        
        if(pobi_max>crong_max) {
        	return 1;
        }else if(pobi_max<crong_max) {
        	return 2;
        }else {
        	return 0;
        }
    }
    
    private static List<Integer> getElements(int num){
    	List<Integer> elements = new ArrayList<>();
    	while(num!=0) {
    		elements.add(num%10);
    		num = num/10;
    	}
    	
    	return elements;
    }
    
    private static int getMaxValue(List<Integer> elements) {
    	int addVal = 0;
    	int dotVal = 1;
    	
    	for(int element : elements) {
    		addVal += element;
    		dotVal *= element;
    	}
    	
    	return (addVal>dotVal ? addVal : dotVal);
    }
}