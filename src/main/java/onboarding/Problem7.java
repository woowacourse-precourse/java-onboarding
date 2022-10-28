package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> getAllUsersName(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allUsersNameSet = new LinkedHashSet<>();
        allUsersNameSet.add(user);

        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            allUsersNameSet.add(friend.get(0));
            allUsersNameSet.add(friend.get(1));
        }

        for (int i = 0; i < visitors.size(); i++) {
            allUsersNameSet.add(visitors.get(i));
        }

        List<String> allUserNameList = new ArrayList<>(allUsersNameSet);

        return allUserNameList;
    }
}
