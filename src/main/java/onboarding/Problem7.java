package onboarding;

import java.util.*;

public class Problem7 {
    static final int friendScore = 10;
    static final int visitorScore = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getResult(user, friends, visitors);

        return answer;
    }

    static List<String> getResult(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = getFriendsMap(friends);
        Map<String, Integer> scoreMap = new HashMap<>();
        List<String> userFriends = getUserFriends(friendsMap, user);
        List<String> result;

        setFriendsPoint(friendsMap, userFriends, scoreMap);
        getVisitorsPoint(scoreMap, visitors);
        result = getValidatedScoreMap(scoreMap, userFriends);

        return result;
    }

    static Map<String, List<String>> getFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<>();

        friends.stream()
            .forEach(friend -> inputFriendsToMap(friendsMap, friend));

        return friendsMap;
    }

    static void inputFriendsToMap(Map<String, List<String>> friendsMap, List<String> friendList) {
        String friend1 = friendList.get(0);
        String friend2 = friendList.get(1);

        inputFriendToMap(friendsMap, friend1, friend2);
        inputFriendToMap(friendsMap, friend2, friend1);
    }

    static void inputFriendToMap(Map<String, List<String>> friendsMap, String friend1, String friend2) {
        List<String> defaultList = new ArrayList<>();
        List<String> friend1Value = friendsMap.getOrDefault(friend1, defaultList);

        friend1Value.add(friend2);
        friendsMap.put(friend1, friend1Value);
    }

    static List<String> getUserFriends(Map<String, List<String>> friendsMap, String user) {
        List<String> emptyList = new ArrayList<>();
        Optional<List<String>> optionalUserFriends = Optional.ofNullable(friendsMap.remove(user));
        List<String> userFriends = optionalUserFriends.orElse(emptyList);

        return userFriends;
    }

    static void setFriendsPoint(Map<String, List<String>> friendsMap, List<String> userFriends, Map<String, Integer> scoreMap) {
        friendsMap.entrySet().stream()
                .forEach(e -> processScore(e.getKey(), e.getValue(), userFriends, scoreMap));
    }

    static void processScore(String name, List<String> friendsList, List<String> userFriends, Map<String, Integer> scoreMap) {
        int count = (int) friendsList.stream()
                .filter(friend -> userFriends.contains(friend))
                .count();

        scoreMap.put(name, count * friendScore);
    }

    static void getVisitorsPoint(Map<String, Integer> scoreMap, List<String> visitors) {
        visitors.stream()
                .forEach(v -> scoreMap.put(v, scoreMap.getOrDefault(v,0) + visitorScore));
    }

    static List<String> getValidatedScoreMap(Map<String, Integer> scoreMap, List<String> userFriends) {
        List<Map.Entry<String, Integer>> sortedScoreList = sortScoreMap(scoreMap, userFriends);
        List<String> exceptedScoreList = getExceptedScoreList(sortedScoreList, userFriends);
        List<String> lengthUnderFiveScoreList = limitLengthUnderFive(exceptedScoreList);

        return lengthUnderFiveScoreList;
    }

    static List<Map.Entry<String, Integer>> sortScoreMap(Map<String, Integer> scoreMap, List<String> userFriends) {
        List<Map.Entry<String, Integer>> scoreEntries = new LinkedList<>(scoreMap.entrySet());

        Collections.sort(scoreEntries, scoreComparator);

        return scoreEntries;
    }

    public static Comparator<Map.Entry<String, Integer>> scoreComparator = new
            Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                    if(m1.getValue() >  m2.getValue()){
                        return -1;
                    } else if (m1.getValue() ==  m2.getValue()) {
                        return m1.getKey().compareTo(m2.getKey());
                    }

                    return 1;
                }
            };

    static List<String> getExceptedScoreList(List<Map.Entry<String, Integer>> sortedScoreEntries, List<String> userFriends) {
        List<String> exceptedScoreList = new ArrayList<>();

        sortedScoreEntries.stream()
                .filter(e -> !(userFriends.contains(e.getKey())))
                .filter(e -> e.getValue() != 0)
                .forEach(e -> exceptedScoreList.add(e.getKey()));

        return exceptedScoreList;
    }

    static List<String> limitLengthUnderFive(List<String> sortedScoreList) {
        if (sortedScoreList.size() > 5) {
            List<String> subList = new ArrayList<>(sortedScoreList.subList(0,5));
            return subList;
        }

        return sortedScoreList;
    }
}
