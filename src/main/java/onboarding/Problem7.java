package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = recommendNewFriend(user,friends, visitors);
        return answer;
    }

    private static List<String> recommendNewFriend(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> score = findFriendOfFriend(user, friends);
        List<String> userFriends = findUserFriends(user, friends);
        score = scoreVisitor(userFriends, visitors, score);

        return chooseFiveUser(score);
    }

    private static List<String> chooseFiveUser(Map<String, Integer> score) {

        int count = 0;
        List<String> answer = new ArrayList<>();

        score = sortHashMap(score);
        Set<String> scoreKeySet = score.keySet();

        Iterator<String> iterator = scoreKeySet.iterator();
        while (iterator.hasNext()) {
            if(count == 5) break;
            answer.add(iterator.next());
            count += 1;
        }
        return answer;
    }

    private static Map<String, Integer> scoreVisitor(List<String> userFriends, List<String> visitors, Map<String, Integer> score) {

        ArrayList<String> visitorsExceptFriends = excludeFriendFromVisitor(userFriends, visitors);
        for (String i : visitorsExceptFriends) {
            if (!score.containsKey(i)) {
                score.put(i, 0);
            }
            score.put(i, score.get(i) + 1);
        }
        return score;
    }

    private static ArrayList<String> excludeFriendFromVisitor(List<String> userFriends, List<String> visitors) {

        ArrayList<String> visitorsExceptFriends = new ArrayList<>(visitors);
        for (String i : userFriends) {
            if (visitorsExceptFriends.contains(i)) {
                visitorsExceptFriends.remove(i);
            }
        }
        return visitorsExceptFriends;
    }

    private static Map<String, Integer> findFriendOfFriend(String user, List<List<String>> friends) {

        Map<String, Integer> score = new HashMap<>();
        List<String> userFriends = findUserFriends(user, friends);

        for (List friend : friends) {
            if (!friend.contains(user)) {
                checkEachSide(score, userFriends, friend, 0, 1);
                checkEachSide(score, userFriends, friend, 1, 0);
            }
        }
        return score;
    }

    private static void checkEachSide(Map<String, Integer> score, List<String> userFriends, List friend, int left, int right) {
        if (userFriends.contains(friend.get(left)) && !userFriends.contains(friend.get(right))) {
            if (!score.containsKey(friend.get(right))) {
                score.put((String) friend.get(right), 0);
            }
            score.put((String) friend.get(right), score.get(friend.get(right)) + 10);
        }
    }

    private static List<String> findUserFriends(String user, List<List<String>> friends) {

        List<String> userFriends = new ArrayList<>();
        for (List i : friends) {
            if (i.get(0).equals(user)) userFriends.add((String) i.get(1));
            if (i.get(1).equals(user)) userFriends.add((String) i.get(0));
        }
        return userFriends;
    }

    private static Map<String, Integer> sortHashMap(Map<String, Integer> unsortedMap) {

        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>((e1, e2) -> {
            int res = e1.getValue().compareTo(e2.getValue());
            if (res == 0)
                return e1.getKey().compareTo(e2.getKey());
            return res * -1;
        });

        sortedSet.addAll(unsortedMap.entrySet());

        Map<String, Integer> sortedLinkedHashMap = new LinkedHashMap<>();
        for (var entry : sortedSet) sortedLinkedHashMap.put(entry.getKey(), entry.getValue());

        return sortedLinkedHashMap;
    }
}
