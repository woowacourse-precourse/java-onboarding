package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // user의 친구 리스트
        List<String> userFriendsList = new ArrayList<>();
        for(int i=0; i<friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                userFriendsList.add(friends.get(i).get(1));
            } else if(friends.get(i).get(1).equals(user)) {
                userFriendsList.add(friends.get(i).get(0));
            }
        }

        // key: 아이디 / value: 점수
        Map<String, Integer> scoreMap = new HashMap<>();

        // user의 친구의 친구 : 10점
        for(String userFriend : userFriendsList) {
            for(int i=0; i<friends.size(); i++) {
                String nameA = friends.get(i).get(0);
                String nameB = friends.get(i).get(1);

                if(nameA.equals(user) || nameB.equals(user)) break;

                if(nameA.equals(userFriend)) {
                    if(!scoreMap.containsKey(nameB)) { // map에 이름이 없을 경우
                        scoreMap.put(nameB, 10);
                    } else { // map에 이름이 존재할 경우
                        int val = scoreMap.get(nameB);
                        val += 10;
                        scoreMap.put(nameB, val);
                    }
                } else if(nameB.equals(userFriend)) {
                    if(!scoreMap.containsKey(nameA)) { // map에 이름이 없을 경우
                        scoreMap.put(nameA, 10);
                    } else { // map에 이름이 존재할 경우
                        int val = scoreMap.get(nameA);
                        val += 10;
                        scoreMap.put(nameA, val);
                    }
                }
            }
        }

        return answer;
    }
}
