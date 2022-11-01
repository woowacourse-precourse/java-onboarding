package onboarding;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> emailList = createOverlapEmailList(forms);
        
        answer = getListMaximumSizeOnMap(overlapMap);
        answer.sort(Comparator.naturalOrder());
        
        return answer;
    }
    
    private static List<String> createOverlapEmailList(List<List<String>> list){
    	Set<String> unitOfNickname = new HashSet<>();
    	List<String> res = List.of();
    	
    	for(int i = 0; i < list.size(); i++) {
    		for(int j = 0; j < list.get(i).get(1).length() - 1; j++) {
    			String s = list.get(i).get(1).substring(j, j + 2);
    			if(!unitOfNickname.contains(s)) {
    				unitOfNickname.add(s);
    				continue;
    			}
    			res.add(list.get(i).get(0));
    		}
    	}
    	
    	return res;
    }
    
    private static List<String> removeOverlapEmail(List<String> list){
    	return list.stream().distinct().collect(Collectors.toList());
    }
    
    private static List<String> getListMaximumSizeOnMap(Map<String, List<String>> map){
    	int maxSize = 0;
    	List<String> list = List.of();
    	
    	for(String s : map.keySet()) {
    		if(maxSize < map.get(s).size()) {
    			maxSize = map.get(s).size();
    			list = map.get(s);
    		}
    	}
    	
    	return list;
    }
}