package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	List<String> nickNames = new ArrayList<>();
    	Set<String> emails = new TreeSet<>();
    	for(int i=0; i<forms.size(); i++) {
    		nickNames.add(forms.get(i).get(1));
    	}
    	
    	for(int i=0; i<nickNames.size(); i++) {
    		for(int j=0; j<nickNames.size(); j++) {
    			for(int a=0; a<nickNames.get(i).length()-1; a++) {
    				for(int b=0; b<nickNames.get(j).length()-1; b++) {
    					if(i!=j&&nickNames.get(i).charAt(a)==nickNames.get(j).charAt(b)
    						&&nickNames.get(i).charAt(a+1)==nickNames.get(j).charAt(b+1)) {
    						emails.add(forms.get(i).get(0));
    						emails.add(forms.get(j).get(0));
    					}
    				}
    			}
    		}
    	}
    	List<String> emailsList = new ArrayList<>(emails);
    	return emailsList; 
    }	
}