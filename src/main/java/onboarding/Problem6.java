package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        List<String> names = new ArrayList<>();
        
        for(List<String> list : forms) {
        	emails.add(list.get(0));
        	names.add(list.get(1));
        }
        
        for(int i = 0; i < names.size() - 1; i++) {
        	String name = names.get(i);
        	
        	for(int j = i + 1; j < names.size(); j++) {
        		int k = 0;
        		while(k < name.length()-1) {
        			int l = k + 2;
        			String temp = name.substring(k, l);
        			String otherName = names.get(j);
        			if(otherName.contains(temp)) {
        				answer.add(emails.get(i));
        				answer.add(emails.get(j));
        			}
        			k++;
        		}
        	}
        }
        
        TreeSet<String> treeSet = new TreeSet<>(answer);
        answer = new ArrayList<>(treeSet);
        
        return answer;
    }
}
