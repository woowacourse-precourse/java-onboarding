package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> getAll(List<List<String>> friends, List<String> visitors) {
        List<String> all_name = new ArrayList<>();

        for(int i=0;i<friends.size();i++) {
            if(!all_name.contains(friends.get(i).get(0))) {
                all_name.add(friends.get(i).get(0));
            }
            if(!all_name.contains(friends.get(i).get(1))) {
                all_name.add(friends.get(i).get(1));
            }
        }
        for(String visitor: visitors) {
            if(!all_name.contains(visitor)) {
                all_name.add(visitor);
            }
        }
        return all_name;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}