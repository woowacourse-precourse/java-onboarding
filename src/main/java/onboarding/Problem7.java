package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = findUserFriends(user, friends);
        List<Person> friendList = findRecommendationFromFriends(user, friends, userFriends);
        return answer;
    }

    private static List<String> findUserFriends(String user, List<List<String>> friends){
        List<String> list = new ArrayList<>();
        for(List<String> item : friends){
            if(item.contains(user))
                list.add(item.get(1 - item.indexOf(user)));
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
    private static List<Person> findRecommendationFromFriends(String user, List<List<String>> friends, List<String> userFriends){
        List<String> list = new ArrayList<>();
        for(List<String> item : friends){
            if(userFriends.contains(item.get(0)) && !item.get(1).equals(user))
                list.add(item.get(1));
            else if(userFriends.contains(item.get(1)) && !item.get(0).equals(user))
                list.add(item.get(0));
        }
        return new ArrayList<>();
    }

    static class Person{
        String name;
        int score;

        public Person(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}
