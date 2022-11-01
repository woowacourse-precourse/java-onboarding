package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        List<String> friend = new ArrayList<String>();
        List<String> friendCnt = new ArrayList<String>();
        List<String> visitorCnt = new ArrayList<String>();

        List<List<String>> score = List.of();


        for (int i = 0; i < friends.size(); i++){   // 유저 친구 리스트에 저장
            List<String> friendMatch = friends.get(i);

            String userId1 = friendMatch.get(0);
            String userId2 = friendMatch.get(1);

            if (user.equals(userId1)){  // 유저랑 같으면 유저 친구 리스트에 저장
                friend.add(userId2);

            } else if(user.equals(userId2)){
                friend.add(userId1);
            }
        }

        // friendCnt에 친구의 친구 저장
        for (int i = 0; i < friends.size(); i++){   // friendCnt에 친구의 친구 저장
            List<String> friendMatch = friends.get(i);

            String userId1 = friendMatch.get(0);
            String userId2 = friendMatch.get(1);

            for (int j = 0; j < friend.size(); j++){
                if (user.equals(userId1) || user.equals(userId2)){
                    break;
                } else if (friend.get(j).equals(userId1)){
                    friendCnt.add(userId2);
                } else if(friend.get(j).equals(userId2)){
                    friendCnt.add(userId1);
                }
            }


        }

        // visitorCnt에 방문자 저장
        for (int i = 0; i < visitors.size(); i++){

            visitorCnt.add(visitors.get(i));

            for (int j = 0; j < friend.size(); j++){
                if (friend.get(j).equals(visitors.get(i))){     // 친구와 방문자가 같으면 포함X
                    visitorCnt.remove(friend.get(j));
                }
            }

        }

        // 점수 합산
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : friendCnt) {
            Integer cnt = map.get(str);
            if (cnt == null) {
                map.put(str, 10);
            } else {
                map.put(str, cnt + 10);
            }
        }

        for (String str : visitorCnt) {
            Integer cnt = map.get(str);
            if (cnt == null) {
                map.put(str, 1);
            } else {
                map.put(str, cnt + 1);
            }
        }

        // 정렬
        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((score1, score2) -> map.get(score2).compareTo(map.get(score1)));

        for (String key : keySet) {
            answer.add(key) ;
        }

        return answer;
    }
}
