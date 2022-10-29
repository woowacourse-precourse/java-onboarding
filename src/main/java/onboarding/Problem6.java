package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
       
        
        Map<String, String> map = new HashMap<>();
		
		List<String> answer = new ArrayList<>();
		
		for (List<String> data:forms) {
			
			for (int i=0; i < data.get(1).length()-1; i++) {
				for (int j=i+2; j < data.get(1).length()+1; j++) {
					
					
					if (map.containsKey(data.get(1).substring(i,j))) {
						answer.add(data.get(0));
						if (!answer.contains(map.get(data.get(1).substring(i,j)))) {
							answer.add(map.get(data.get(1).substring(i,j)));
						}
					
						continue;
					}else {
						
					
					map.put(data.get(1).substring(i, j), data.get(0));
					
					
					}
					
				}
			}
		}
		
		Collections.sort(answer);
		return answer;

        
        
        
    }
}
