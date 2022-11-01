package onboarding;

import java.util.ArrayList;
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
    }
}
