package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem7 {
    public static List<String> checkUserFriend(String user, List<List<String>> friends){
        List<String> userFriend = new ArrayList<>();
        List<List<String>> checkF = friends.stream()
                .filter(strings -> strings.contains(user))
                .collect(Collectors.toList());
        for (int i = 0; i < checkF.size(); i++) {
            for (int j = 0; j < checkF.get(i).size(); j++) {
                String name = checkF.get(i).get(j);
                if(!userFriend.contains(name) && !name.contains(user))
                    userFriend.add(name);
            }
        }
        return userFriend;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
