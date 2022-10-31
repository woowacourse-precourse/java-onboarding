package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Iterator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        String[] nick_arr = new String[forms.size()];
        int[] index = new int[forms.size()+1];
        List<String>email = new ArrayList<>();
        
        int start = 0;
        int end = 2;
        
        for(int i=0;i<forms.size();i++) {
        	nick_arr[i]=forms.get(i).get(1);
        }
        
        for(int i=0;i<nick_arr.length-1;i++) {
        	while(end!=nick_arr[i].length()) {
        		String s = nick_arr[i].substring(start++,end++);
        		for(int j=i+1;j<nick_arr.length;j++) {
        			if(forms.get(j).get(1).contains(s)) {
        				index[i]+=1;
        				index[j]+=1;
        			}
        		}
        		
        	}
        	start=0;
        	end=2;
        }
        
        for(int i=0;i<index.length;i++) {
        	if(index[i]!=0) {
        		email.add(forms.get(i).get(0));
        	}
        }
        Collections.sort(email);
        Set<String> set = new HashSet<>();
        for(int i=0;i<email.size();i++) {
        	set.add(email.get(i));
        }
        
        String[] email_arr = new String[set.size()];
        Iterator iter = set.iterator();
        int k=0;
        while(iter.hasNext()) {
        	email_arr[k] = iter.next().toString();
        	k++;
        }
        answer = List.of(email_arr);
        
        return answer;
    }
}
