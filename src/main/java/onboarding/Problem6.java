package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
int[] index = new int[10000];
		
		char[] tmp; //s.toCharArray();;
		char c;
		String name;
		String mail;
		String sub;
		int i, j, g;
		
		/*
		 * List<List<String>> forms = List.of( List.of("jm@email.com", "제이엠"),
		 * List.of("jason@email.com", "제이슨"), List.of("woniee@email.com", "워니"),
		 * List.of("mj@email.com", "엠제이"), List.of("nowm@email.com", "이제엠") );
		 */
		
		

		List<List<String>> form = forms;
    	List<String> result = new ArrayList();
    	
    	String[] temp = new String[10000];

    	for(i = 0; i < forms.size(); i++) {
    		name = form.get(i).get(1);
    		mail = form.get(i).get(0);
    		
    		for(j = 0; j < name.length() - 1; j++) {
    			
    			sub = "" + name.charAt(j) + name.charAt(j+1);
    		
    			for(g = 0; g < forms.size(); g++) {
    				if(forms.get(g).get(1).equals(name)) {
    					continue;
    					}
    				if(forms.get(g).get(1).contains(sub) && !result.contains(forms.get(g).get(0))) {
    				result.add(forms.get(g).get(0));
    				}
    			}
    		
    		
    		}
    		Collections.sort(result);
    	}
    	return result;
    }
}
