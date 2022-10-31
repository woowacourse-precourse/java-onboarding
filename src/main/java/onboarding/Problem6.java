package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
		List<String> answer = new ArrayList<>();
		
		for (List<String> data:forms) {
			
			for (int i=0; i < data.get(1).length()-1; i++) {
				for (int j=i+2; j < data.get(1).length()+1; j++) {
					
					String subNick = data.get(1).substring(i,j);
					String email = data.get(0);
					
					if (map.containsKey(subNick)) {
						answer.add(email);
						if (!answer.contains(map.get(subNick))) {
							answer.add(map.get(subNick));
						}
						continue;
					}
					
					map.put(subNick, email);
				}
			}
		}
		Collections.sort(answer);
		
		return answer;

    }
}
