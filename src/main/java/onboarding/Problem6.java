package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {             
        HashSet<String> deduplication = new HashSet<>();
        Map<String, String> map = new HashMap<>();        
        
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            
            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);
                
                if(map.containsKey(key)){
                        deduplication.add(map.get(key));
                        deduplication.add(email);                    
                } else {
                    map.put(key, email);
                }
            }
        }
        
        List<String> answer = deduplication.stream()
                .sorted()
                .collect(Collectors.toList());
        
        return answer;
    }
}
