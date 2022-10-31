package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answerSet = new HashSet<String>();
        Map<String,Set<String>> wordMap = new HashMap<String,Set<String>>();
        for(List<String> form : forms) {
        	if(form.get(1).length() == 1) {
        		continue;
        	}
        	for(int pieceSize = 2; pieceSize<=form.get(1).length(); pieceSize++) {
        		for(int i = 0; i+pieceSize<=form.get(1).length(); i++) {
        			if(wordMap.containsKey(form.get(1).substring(i,i+pieceSize))){
        				Set<String> emailSet = wordMap.get(form.get(1).substring(i,i+pieceSize));
        				emailSet.add(form.get(0));
        			}else {
        				Set<String> set = new HashSet<String>();
        				set.add(form.get(0));
        				wordMap.put(form.get(1).substring(i,i+pieceSize), set);
        			}
        		}
        	}
        }
        List<String> answerList = new ArrayList<String>(answerSet);
        Collections.sort(answerList);
        return answerList;
    }
}
