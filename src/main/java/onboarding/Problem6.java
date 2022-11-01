package onboarding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    
    private static Map<String, List<String>> getOverlapMap(List<List<String>> list){
    	Map<String, List<String>> overlapMap = new HashMap<>();
    	
    	for(int i = 0; i < list.size(); i++) {
    		for(int j = 0; j < list.get(i).get(1).length() - 1; j++) {
    			String s = list.get(i).get(1).substring(j, j + 2);
    			if(!overlapMap.containsKey(s)) {
    				overlapMap.put(s, new LinkedList<>());
    				removeOverlap(overlapMap.get(s));
    			}
    			overlapMap.get(s).add(list.get(i).get(0));
    		}
    	}
    	
    	return overlapMap;
    }
    
    private static List<String> removeOverlap(List<String> list){
    	return list.stream().distinct().collect(Collectors.toList());
    }
}