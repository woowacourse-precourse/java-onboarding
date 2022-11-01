package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, Set<String>> map = new HashMap<>();
        for (List<String> form : forms){
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 2; i < nickname.length(); i++){
                for (int j = 0; j < nickname.length(); j++){
                    if (i + j > nickname.length())
                        break;
                    String subStr = nickname.substring(j, i + j);
                    if (map.containsKey(subStr)){
                        map.get(subStr).add(email);
                    }
                    else {
                        Set<String> emailSet = new HashSet<>();
                        emailSet.add(email);
                        map.put(subStr, emailSet);
                    }
                }
            }
        }

        Set<String> emailSet = new HashSet<>();
        for (String key : map.keySet()) {
            Set<String> emails = map.get(key);
            if (emails.size() <= 1)
                continue;;
            for (String email : emails)
                emailSet.add(email);
        }

        answer = new ArrayList<>(emailSet);
        Collections.sort(answer);

        return answer;
    }
}
