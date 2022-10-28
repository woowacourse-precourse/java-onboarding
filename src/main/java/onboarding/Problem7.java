package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //user의 친구 리스트
        Set<String> friendList = getFriendList(friends);
        //user의 친구의 친구 리스트
        List<String> friendOfFriendList = getFriendOfFriendList(user, friends);
        //이름과 점수
        Map<String, Integer> nameAndScore = new HashMap<>();
        //친구의 친구 점수 셋팅
        setScore(friendOfFriendList, nameAndScore, FRIEND_SCORE);
        //방문자 제거 추가Filtered visitor list
        List<String> visitorList = getFilteredVisitorList(visitors, friendList);
        //방문자 점수 셋팅
        setScore(visitorList, nameAndScore, VISITOR_SCORE);

        //Friend recommendation
        List<Entry<String, Integer>> recommendationList = new LinkedList<>(nameAndScore.entrySet());

        sortByScoreAndName(recommendationList);

        List<String> answer = new ArrayList<>();
        recommendationList.stream().limit(5).filter(list -> list.getValue() != 0).forEach(list -> answer.add(list.getKey()));

        return answer;
    }

    private static void sortByScoreAndName(List<Entry<String, Integer>> list) {
        list.sort((first, second) -> {
            int comparison = (first.getValue() - second.getValue()) * -1;
            return comparison == 0 ? first.getKey().compareTo(second.getKey()) : comparison;
        });
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
