package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, String> m = new HashMap<>();
        List<List<String>> friendsOfUser= friends.stream().filter(f -> f.get(0)==user || f.get(1)==user).collect(Collectors.toList());
        for(List<String> f :friendsOfUser){
            if(f.get(0)==user) m.put(user,f.get(1));
        }
        return answer;
    }

    public static boolean isUser(String s,String user){
        if(user==s) return true;
        return false;

    }
}
