package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class Problem7 {
    final static Map<String,Integer> friendsScore = new HashMap<>();//이름-추천 점수 저장
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> userFriends;
        List<Map.Entry<String,Integer>> scoreList; //점수 정렬 위한 리스트

        //사용자의 친구목록 생성
        userFriends = checkUserFriends(friends,user);

        //사용자와 함께 아는 사람 점수계산
        for (List<String> relation:friends) {
            for (String userFriend:userFriends) {
                calculateRelationScore(relation,userFriend,user);
            }
        }

        //방문 기록으로 점수 계산
        for (String visitor:visitors) {
            friendsScore.put(visitor, friendsScore.getOrDefault(visitor, 0) + 1);
        }

        //이미 사용자의 친구인데 점수 계산된 것 제거
        for (String userFriend:userFriends) {
            friendsScore.remove(userFriend);
        }

        scoreList = new LinkedList<>(friendsScore.entrySet());

        Collections.sort(scoreList, new Comparator<>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else {
                    return o1.getKey().compareTo(o2.getKey());//점수 같으면 이름순
                }
            }
        });

        //최대5개 answer로 할당
        for (Map.Entry<String,Integer> nameScore:scoreList) {
            answer.add(nameScore.getKey());
            if (answer.size() == 5) {
                break;
            }
        }

        return answer;
    }

    private static Set<String> checkUserFriends(List<List<String>> friends, String user) {
        Set<String> userFriends = new HashSet<>();

        for (List<String> relation:friends) {
            if (relation.contains(user)) {
                userFriends.add(relation.get(0));
                userFriends.add(relation.get(1));
            }
        }
        userFriends.remove(user);

        return userFriends;
    }

    private static void calculateRelationScore(List<String> relation,String userFriend,String user) {
        if (relation.contains(userFriend)) {
            for (String name:relation) {
                if (name.equals(userFriend) || name.equals(user)) {
                    continue;
                }
                Integer score = friendsScore.getOrDefault(name, 0);
                friendsScore.put(name,score + 10);
            }
        }
    }
}
