package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            for (int i = 0; i < name.length() - 1; i++) {
                String subName = name.substring(i, i+2);
                if(userMap.containsKey(subName)){
                    if(!((userMap.get(subName)) == email)){
                        result.add((userMap.get(subName)));
                        result.add(email);
                    }
                }
                userMap.put(subName,email);
            }
        }
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }
}
