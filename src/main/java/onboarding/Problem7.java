package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.Map.Entry.*;

public class Problem7 {
    private static final int FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //방문자, 친구의 친구 리스트 생성
        List<String> visitorList = getVisitorList(friends, visitors);
        List<String> friendOfFriendList = getFriendOfFriendList(user, friends);

        //이름과 점수 리스트 생성
        Map<String, Integer> nameAndScore = getNameAndScoreList(visitorList, friendOfFriendList);

        List<String> answer = new ArrayList<>();
        nameAndScore.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.<String, Integer>comparingByValue())
                        .thenComparing(comparingByKey()))
                .limit(5)
                .filter(list -> list.getValue() != 0)
                .forEach(list -> answer.add(list.getKey()));

        return answer;
    }

    private static List<String> getVisitorList(List<List<String>> friends, List<String> visitors) {
        Set<String> friendList = getFriendList(friends);
        return getFilteredVisitorList(visitors, friendList);
    }

    private static Map<String, Integer> getNameAndScoreList(List<String> visitorList, List<String> friendOfFriendList) {
        Map<String, Integer> nameAndScore = new HashMap<>();
        setScore(friendOfFriendList, nameAndScore, FRIEND_SCORE);
        setScore(visitorList, nameAndScore, VISITOR_SCORE);
        return nameAndScore;
    }

    private static void setScore(List<String> friendOfFriendList, Map<String, Integer> nameAndScore, int score) {
        friendOfFriendList.forEach(name -> scoreSetting(nameAndScore, score, name));
    }

    private static void scoreSetting(Map<String, Integer> nameAndScore, int score, String name) {
        if (nameAndScore.containsKey(name)) {
            Integer integer = nameAndScore.get(name) + score;
            nameAndScore.replace(name, integer);
        }
        if (!nameAndScore.containsKey(name)) {
            nameAndScore.put(name, score);
        }
    }

    private static List<String> getFilteredVisitorList(List<String> visitors, Set<String> friendList) {
        List<String> visitorList = new ArrayList<>(visitors);
        return visitorList.stream().filter(name -> !friendList.contains(name)).collect(Collectors.toList());
    }

    private static List<String> getFriendOfFriendList(String user, List<List<String>> friends) {
        List<String> friendOfFriendList = new ArrayList<>();
        friends.forEach(name -> friendOfFriendList.add(name.get(1)));
        return friendOfFriendList.stream().filter(name -> !name.equals(user)).collect(Collectors.toList());
    }

    private static Set<String> getFriendList(List<List<String>> friends) {
        Set<String> friendList = new HashSet<>();
        friends.forEach(name -> friendList.add(name.get(0)));
        return friendList;
    }
}
