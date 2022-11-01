package onboarding;

import java.util.*;

public class Problem7 {
    private static final int SWAP = 1;
    private static final int NO_SWAP = -1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, Set<String>> friendsMap = new HashMap<>();
        Set<String> people = new HashSet<>();

        parseFriends(friends, friendsMap, people);
        initScore(scoreMap, people);
        countScore(scoreMap, user, friendsMap, visitors);
        removeAlreadyFriends(scoreMap, user, friendsMap.get(user));
        answer = sortAnswer(scoreMap);
        return answer;
    }

    private static List<String> sortAnswer(Map<String, Integer> scoreMap) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        List<String> keyList = new ArrayList<>(scoreMap.keySet());

        for (String key : scoreMap.keySet()) {
            if (scoreMap.get(key) == 0)
                scoreMap.remove(key);
        }
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) // 오름차순이면 SWAP
                    return SWAP;
                else if (o1.getValue() > o2.getValue())
                    return NO_SWAP;
                else // score 같을 경우
                    if (o1.getKey().compareTo(o2.getKey()) > 0) // 역 사전순이면 SWAP
                        return SWAP;
                    else if (o1.getKey().compareTo(o2.getKey()) < 0)
                        return NO_SWAP;
                return NO_SWAP;
            }
        });
        if (keyList.size() > 5)
            keyList = keyList.subList(0, 5);
        return keyList;
    }

    private static void countScore(Map<String, Integer> scoreMap, String user,
                                   Map<String, Set<String>> friendsMap, List<String> visitors) {
        Set<String> userFriends;
        Set<String> candidateFriends;
        int numOfCommonFriends;

        // 얕은 복사로 인해 friendsMap 객체가 변경된다. 이후 사용하지 않기 때문에 괜찮음
        for (String candidate : scoreMap.keySet()) {
            userFriends = friendsMap.get(user);
            candidateFriends = friendsMap.get(candidate);
            candidateFriends.retainAll(userFriends);
            numOfCommonFriends = candidateFriends.size();
            scoreMap.put(candidate, scoreMap.get(candidate) + numOfCommonFriends * 10);
        }
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }
    }
    private static void removeAlreadyFriends(Map<String, Integer> scoreMap,
                                       String user, Set<String> alreadyFriends) {
        scoreMap.remove(user);
        for (String person : alreadyFriends)
            scoreMap.remove(person);
    }
    private static void initScore(Map<String, Integer> scoreMap, Set<String> people) {
        for (String person : people) {
            scoreMap.put(person, 0);
        }
    }
    private static void putInFriendsMap(Map<String, Set<String>> friendsMap, String a, String b) {
        if (friendsMap.containsKey(a))
            friendsMap.get(a).add(b);
        else
            friendsMap.put(a, new HashSet<>(List.of(b)));
    }
    private static void parseFriends(List<List<String>> friends,
                                     Map<String, Set<String>> friendsMap, Set<String> people) {
        for (List<String> couple : friends) {
            String a = couple.get(0);
            String b = couple.get(1);
            putInFriendsMap(friendsMap, a, b);
            putInFriendsMap(friendsMap, b, a);
            people.add(a);
            people.add(b);
        }
    }
}
