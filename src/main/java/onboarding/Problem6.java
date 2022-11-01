package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> profileMap = new HashMap<String, String>();
        HashSet<String> emails = new HashSet<String>();
        
        for(int i=0; i<forms.size(); i++) {
        	String name = forms.get(i).get(1);
        	
        	if(name.length()<1 || name.length()>19) break;
        	if(forms.get(i).get(0).length()<11 || forms.get(i).get(0).length()>19) break;
        	
        	for(int j=0; j<name.length()-1; j++) {
        		String nameKey = name.substring(j, j+2);
        		if(profileMap.containsKey(nameKey)) {
        			String email = profileMap.get(nameKey);
        			emails.add(email);
        			emails.add(forms.get(i).get(0));        			
        		}
        		profileMap.put(nameKey, forms.get(i).get(0));
        	}
        }
        answer = List.copyOf(emails);
        return answer;
    }
}
