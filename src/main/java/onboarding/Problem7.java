package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); //반환용 리스트
        List<String> realFriends = new ArrayList<>(); //사용자와 이미 친구인 리스트
        List<String> withFriends = new ArrayList<>(); //친구의 친구 리스트(사용자와 친구X) -> +10점
        List<String> visitFriends = new ArrayList<>(); //방문자 리스트 -> +1점
        Map<String, Integer> friendScore = new HashMap<>(); //친구들의 추천 점수를 저장하는 맵 생성
        List<Map.Entry<String, Integer>> mapSort = new LinkedList<>(friendScore.entrySet());
        //현재 정렬이 안되어있는 추천친구들(Map)이기 때문에 리스트로 담기 위해 이렇게 생성
        List<String> sorts = new ArrayList<>();
        //나중에 같은 점수끼리 정렬용으로 사용하기 위해 빈 리스트 생성
        Map<List<String>, Integer> returnMap = new HashMap<>();
        //점수별로 정리해서 반환할 Map을 받기 위해 생성

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

        for (int i = 0; i < withFriends.size(); i++) {
            if (!friendScore.keySet().contains(withFriends.get(i))) {
                friendScore.put(withFriends.get(i), 10);
            } else {
                friendScore.put(withFriends.get(i), friendScore.get(withFriends.get(i)) + 10);
            }
        }
        //친구의 친구인 경우 +10점을 주는 것이다

        for (int i = 0; i < visitFriends.size(); i++) {
            if (!friendScore.keySet().contains(visitFriends.get(i))) {
                friendScore.put(visitFriends.get(i), 1);
            } else {
                friendScore.put(visitFriends.get(i), friendScore.get(visitFriends.get(i)) + 1);
            }
        }
        //방문자의 경우는 +1점

        return answer;
    }
}