package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); //반환용 리스트
        List<String> realFriends = new ArrayList<>(); //사용자와 이미 친구인 리스트
        List<String> withFriends = new ArrayList<>(); //친구의 친구 리스트(사용자와 친구X) -> +10점
        List<String> visitFriends = new ArrayList<>(); //방문자 리스트 -> +1점

        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(1))) {
                realFriends.add(friends.get(i).get(0));
            }
            if (user.equals(friends.get(i).get(0))) {
                realFriends.add(friends.get(i).get(1));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < realFriends.size(); j++) {
                if (realFriends.get(j).equals(friends.get(i).get(0)) && !user.equals(friends.get(i).get(1))) {
                    if (!realFriends.contains(friends.get(i).get(1)))
                        withFriends.add(friends.get(i).get(1));
                }
                if (realFriends.get(j).equals(friends.get(i).get(1)) && !user.equals(friends.get(i).get(0))) {
                    if (!realFriends.contains(friends.get(i).get(0)))
                        withFriends.add(friends.get(i).get(0));
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!realFriends.contains(visitors.get(i))) {
                visitFriends.add(visitors.get(i));
            }
        }

        return answer;
    }
}