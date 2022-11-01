package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    public static boolean isContainUser(String user, List<String> friend) {
        if (friend.contains(user)) {
            return true;
        }
        return false;
    }

    public static String getFriendName(String user, List<String> friend) {
        if (user.equals(friend.get(0))) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }

    public static Set<String> getFriendSet(String user, List<List<String>> friends){
        Set<String> friendSet = new HashSet<>();

        for (List<String> friend: friends) {
            if (isContainUser(user, friend)) {  // user가 있는 친구 목록일 경우
                String friendName = getFriendName(user, friend);
                friendSet.add(friendName);
            }
        }

        return friendSet;
    }

    public static boolean isSameFriend(String user, String userFriend, List<String> friend) {
        if (isContainUser(user, friend)) {   // user가 있다면 체크 X
            return false;
        }

        if (!isContainUser(userFriend, friend)) {    // user의 친구가 없다면 false
            return false;
        }

        return true;
    }

    public static String getSameFriendName(String user, Set<String> friendSet, List<String> friend) {
        for (String userFriend : friendSet) {
            if (isSameFriend(user, userFriend, friend)) {
                return getFriendName(userFriend, friend);
            }
        }

        return null;
    }

    public static Map<String, Integer> getFriendsScore(String user, Set<String> friendSet, List<List<String>> friends) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friendName = getSameFriendName(user, friendSet, friend);

            if (friendName == null) {
                continue;
            }

            if (!scoreMap.containsKey(friendName)) {
                scoreMap.put(friendName, 0);
            }
            scoreMap.put(friendName, scoreMap.get(friendName) + 10);
        }

        return scoreMap;
    }

    public static Map<String, Integer> getVisitorScore(List<String> visitors, Set<String> friendSet) {
        Map<String, Integer> scoreMap = new HashMap();

        for (String visitor : visitors) {
            if(friendSet.contains(visitor)) {   // 이미 친구인 사용자는 제외
                continue;
            }

            if (!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 0);
            }
            scoreMap.put(visitor, scoreMap.get(visitor) + 1);
        }

        return scoreMap;
    }

    public static List<Entry<String, Integer>> getSortedEntries(Map<String, Integer> totalScore) {
        List<Entry<String, Integer>> entryList = new ArrayList<>(totalScore.entrySet());
        entryList.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        return entryList;
    }

    public static List<String> getResult(Map<String, Integer> totalScore) {
        List<Entry<String, Integer>> entryList = getSortedEntries(totalScore);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 5 && i < entryList.size(); i++) {    // 5명 미만인 경우도 고려
            String name = entryList.get(i).getKey();
            result.add(name);
        }

        return result;
    }



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> friendSet;
        Map<String, Integer> friendsScore;
        Map<String, Integer> visitorsScore;
        Map<String, Integer> totalScore;

        friendSet = getFriendSet(user, friends);
        friendsScore = getFriendsScore(user, friendSet, friends);
        visitorsScore = getVisitorScore(visitors, friendSet);

        totalScore = friendsScore;
        visitorsScore.forEach((k, v) -> totalScore.merge(k, v, (v1, v2) -> v1 + v2));

        answer = getResult(totalScore);

        return answer;
    }
}
