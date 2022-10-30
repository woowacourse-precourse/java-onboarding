package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> userFriends = findUserFriends(user, friends);
        //Map<String, Integer> score = findFriendOfFriend(user, friends);


        return answer;
    }

    private static ArrayList<String> excludeFriendFromVisitor(List<String> userFriends, List<String> visitors) {

        ArrayList<String> visitorsExceptFriends = new ArrayList<>(visitors);
        for (String i : userFriends) { //방문자 중 친구 제외
            if (visitorsExceptFriends.contains(i)) {
                visitorsExceptFriends.remove(i);
            }
        }
        return visitorsExceptFriends;
    }

    private static Map<String, Integer> findFriendOfFriend(String user, List<List<String>> friends) {

        Map<String, Integer> score = new HashMap<>();
        List<String> userFriends = findUserFriends(user, friends);

        for (List i : friends) {
            if (!i.contains(user)) {
                if (userFriends.contains(i.get(0)) && !userFriends.contains(i.get(1))) {
                    if (!score.containsKey(i.get(1))) {
                        score.put((String) i.get(1), 0);
                    }
                    score.put((String) i.get(1), score.get(i.get(1)) + 10);
                }
                if (userFriends.contains(i.get(1)) && !userFriends.contains(i.get(0))) {
                    if (!score.containsKey(i.get(0))) {
                        score.put((String) i.get(0), 0);
                    }
                    score.put((String) i.get(0), score.get(i.get(0)) + 10);
                }
            }

        }
        return score;
    }

    private static List<String> findUserFriends(String user, List<List<String>> friends) {

        List<String> userFriends = new ArrayList<>();
        for (List i : friends) {
            if (i.get(0).equals(user)) userFriends.add((String) i.get(1));
            if (i.get(1).equals(user)) userFriends.add((String) i.get(0));
        }
        return userFriends;
    }
}
