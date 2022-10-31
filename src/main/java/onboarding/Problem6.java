package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> removeAndSort(List<String> answer){
        Set<String> set = new HashSet<>(answer);
        answer.clear();
        answer.addAll(set);
        return answer;
    }

    public static List<String> addRepeating(List<String> answer,Map<String, List<String>> nicknames){
        for (String keyword: nicknames.keySet()) {
            if((nicknames.get(keyword)).size()>1){
                answer.addAll(nicknames.get(keyword));
            }
        }
        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> nicknames = new HashMap<String, List<String>>();
        for(List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for(int i=0;i<nickname.length()-1;i++) {
                String keyword = nickname.substring(i,i+2);
                nicknames.putIfAbsent(keyword, new ArrayList<String>());
                nicknames.get(keyword).add(email);
            }
        }
        answer = removeAndSort(addRepeating(answer,nicknames));
        return answer;
    }
}
