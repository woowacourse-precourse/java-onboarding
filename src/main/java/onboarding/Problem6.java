package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String,List<Integer>> map = new HashMap<>();
        String temp = "";
        int cnt = 0;
        
        for(List<String> list:forms) {
        	for(int i=0;i<list.get(1).length()-1;i++) {
        		temp = list.get(1).substring(i,i+2);
        		if(!map.keySet().contains(temp)) {
        			List<Integer> newList = new ArrayList<>();
            		map.put(temp,newList);
        		}
            	map.get(temp).add(cnt);
        	}
        	cnt++;
        }
        for(String key:map.keySet()) {
        	if(map.get(key).size()>1) {
        		for(int a:map.get(key)) {
        			answer.add(forms.get(a).get(0));
        		}
        	}
        }
        answer.sort(null);
        return answer;
    }
}
