package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    // 사용자 친구 찾기
    private static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for(List<String> item : friends){
            if(item.contains(user))
                list.add(item.get(1 - item.indexOf(user)));
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    // 친구 관계 추천 찾기
    private static List<Person> findRecommendationFromFriends(String user, List<List<String>> friends, List<String> userFriends) {
        List<String> list = new ArrayList<>();
        for(List<String> item : friends) {
            if(userFriends.contains(item.get(0)) && !item.get(1).equals(user))
                list.add(item.get(1));
            else if(userFriends.contains(item.get(1)) && !item.get(0).equals(user))
                list.add(item.get(0));
        }
        return calculateScore(list, 10);
    }

    // 방문자 추천 찾기
    private static List<Person> findRecommendationFromVisitors(List<String> visitors, List<String> userFriends) {
        List<String> list = new ArrayList<>();
        for(String item : visitors) {
            if(!userFriends.contains(item))
                list.add(item);
        }
        return calculateScore(list, 1);
    }

    // 점수 계산
    private static List<Person> calculateScore(List<String> persons, int score) {
        List<Person> list = new ArrayList<>();
        for(String item : persons.stream().distinct().collect(Collectors.toList())) {
            int frequency = Collections.frequency(persons, item);
            list.add(new Person(item, frequency* score));
        }
        return list;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
