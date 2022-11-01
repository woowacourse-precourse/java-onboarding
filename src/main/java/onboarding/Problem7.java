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

        // visitor : 1점
        // user의 친구 제외
        for(String visitor : visitors) {
            if(!userFriendsList.contains(visitor)) {
                System.out.println(visitor);
                if(!scoreMap.containsKey(visitor)) { // map에 이름이 없을 경우
                    scoreMap.put(visitor, 1);
                } else { // map에 이름이 존재할 경우
                    int val = scoreMap.get(visitor);
                    val++;
                    scoreMap.put(visitor, val);
                }
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        entryList.sort((o1,o2) -> o2.getValue().compareTo(o1.getValue())); //내림차순 정렬
        int cnt = 1;
        for(Map.Entry<String, Integer> entry : entryList) {
            if(cnt < 6) {
                answer.add(entry.getKey());
                cnt++;
            } else {
                break;
            }
        }

        return answer;
    }
}
