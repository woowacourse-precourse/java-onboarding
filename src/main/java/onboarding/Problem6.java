package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	
        List<String> answer = new ArrayList<String>();
        String email, nickname, nickname2 = null;
        int result = 0;

    	for(int i = 0 ; i < forms.size()-1 ; i ++) {
    		nickname = forms.get(i).get(1);
    		
    		for(int j = 0 ; j < forms.size() ; j++) {
    			nickname2 = forms.get(j).get(1);
    			
    			if(nickname != nickname2) {
    				result = equals(nickname,nickname2);
    				
    				if(result == 1) {
    					email = forms.get(j).get(0);
    					answer.add(email);
    				}
    			}
    		}
        	List<String> newList = answer.stream().distinct().collect(Collectors.toList());
        	Collections.sort(newList);
        	
        	answer = newList;	
		} 
		return answer; 
    }
     
    // 글자 비교
    public static int equals(String nickname1, String nickname2) {
    	int result = 0;
    	String a = null;
		for(int i = 0; i < nickname1.length()-1; i++) {
			a = nickname1.substring(i,i+2);
			System.out.println(a);
			for(int j = 0; j < nickname2.length()-1; j++) {
					String b = nickname2.substring(j,j+2);
					if(a.contains(b)) {
						result = 1;
						break;
					}
			}
			if(result == 1) {
				break;
			}
		}
		return result;
    }
}
