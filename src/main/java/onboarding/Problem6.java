package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int count = 0;
        Map<String,Set<String>> same_word_map = new HashMap<>();
        for(List<String> form : forms) {
        	String email = form.get(0);
        	String name = form.get(1);
        	count += name.length()-1;
        	
        	for(int i=0;i<name.length()-1;i++) {
        		String part_name = name.substring(i, i+2);
        		if(!same_word_map.containsKey(part_name)) {
        			same_word_map.put(part_name, new HashSet<>());
        		}
        		
        		Set<String> email_list = same_word_map.get(part_name);
        		email_list.add(email);
        	}
        }
        
        Set<String> email_set = new HashSet<>(count);
        
        
        for(Entry<String,Set<String>> entry : same_word_map.entrySet()) {
        	if(entry.getValue().size()>1) {
        		email_set.addAll(entry.getValue());
        	}
        }
        
        List<String> answer = new ArrayList<>(email_set.size());
        for(String email : email_set) {
        	answer.add(email);
        }
        
        answer.sort((a,b)->{
        	if(a.compareTo(b)>0) {
        		return 1;
        	}else if(a.compareTo(b)<0) {
        		return -1;
        	}else {
        		return 0;
        	}
        });
        
        return answer;
    }
}
