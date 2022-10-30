package onboarding;

import onboarding.problem7.Problem7Validation;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        if (Problem7Validation.problem7Validation(user, friends, visitors)) {
            answer = getFiveRecommendIdList(user, friends, visitors);
        }
        return answer;
    }

    private static List<String> getFiveRecommendIdList(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userSet = makeUserSet(user, friends, visitors);
        System.out.println("userSet = " + userSet);
        return null;
    }

    private static Set<String> makeUserSet(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allUserSet = new HashSet<>();
        addUserSetByUser(allUserSet, user);
        addUserSetByFriends(allUserSet, friends);
        addUserSetByVisitors(allUserSet, visitors);
        return allUserSet;
    }

    private static void addUserSetByUser(Set<String> allUserSet, String user) {
        allUserSet.add(user);
    }

    private static void addUserSetByFriends(Set<String> allUserSet, List<List<String>> friends) {
        for (List<String> friendList : friends) {
            addUserSetByUserList(allUserSet, friendList);
        }
    }

    private static void addUserSetByUserList(Set<String> allUserSet, List<String> friendList) {
        for (String friend : friendList) {
            addUserSetByUser(allUserSet, friend);
        }
    }

    private static void addUserSetByVisitors(Set<String> allUserSet, List<String> visitors) {
        addUserSetByUserList(allUserSet, visitors);
    }


}
