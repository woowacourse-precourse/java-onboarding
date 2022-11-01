package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

    	List<String> answer = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        
        for(List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for(int i=0;i<nickname.length()-1;i++) {
                String keyword = nickname.substring(i,i+2);
                if(map.containsKey(keyword)) {
                    answer.add(email);
                    if(!answer.contains(map.get(keyword))) {
                        answer.add(map.get(keyword));
                    }
                    break;
                }
                map.put(keyword, email);
            }
        }
        return answer;
    }
}
