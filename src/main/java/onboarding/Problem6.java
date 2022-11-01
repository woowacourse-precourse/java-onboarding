package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
    	if(forms.size()<=1 && forms.size()>=10000) return null;
    	List<String> answer=new ArrayList<>();
    	List<String> nick=new ArrayList<>();
    	HashMap<String, String> map=new HashMap<>();
    	
    	for(int i=0;i<forms.size();i++) {
    		map.put(forms.get(i).get(1),forms.get(i).get(0));
    		nick.add(forms.get(i).get(1));
    	}
    	for(int i=0;i<nick.size();i++) {
    		for(int j=0;j<nick.size()-1;j++) {
    			if(contain(nick.get(i), nick.get(j)) && i!=j && !answer.contains(map.get(nick.get(i)))) {
    				answer.add(map.get(nick.get(i)));
    			}
    		}
    	}
    	Collections.sort(answer);
        return answer;
    }
	public static boolean contain(String nick, String part) {
    	for(int i=0;i<part.length()-1;i++) {
    		if(nick.contains(part.substring(i, i+2))){
    			return true;
    		}
    	}
    	return false;
    }
}
