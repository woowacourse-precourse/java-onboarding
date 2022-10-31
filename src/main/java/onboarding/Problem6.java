package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
	static int[] parent;
    public static List<String> solution(List<List<String>> forms) {
        return solve(forms);
    }
    
    static List<String> solve(List<List<String>> forms){
    	HashMap<String, String> inf = new HashMap<String, String>();
    	HashMap<String, String> check = new HashMap<String, String>();
    	ArrayList<String> cName = new ArrayList<>();
    	List<String> result = new ArrayList<>();
    	
    	for(int i = 0; i < forms.size(); i++) {
    		String mail = forms.get(i).get(0);
    		String uname = forms.get(i).get(1);
    		
    		inf.put(uname, mail);
    	}
    	
    	for(int i = 0; i < forms.size(); i++) {
    		String name = forms.get(i).get(1);
    		for(int j = 0; j < name.length()-1 ; j++) {
    			String subName = name.substring(j, j+2);
    			if(!check.containsKey(subName)){
    				check.put(subName, name);
    			}else if(check.containsKey(subName)) {
    				if(!cName.contains(name)) {
    					cName.add(name);
    				}
    				if(!cName.contains(check.get(subName))) {
    					cName.add(check.get(subName));
    				};
    				
    			}
    		}
    	}
    	
    	for(int i = 0; i < cName.size(); i++) {
    		result.add(inf.get(cName.get(i)));
    	}
    	
    	Collections.sort(result);
    	return result;
    }
   
}
