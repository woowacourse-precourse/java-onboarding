package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> frdList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);

            if (frdList.containsKey(first)) {
                List<String> temp = frdList.get(first);
                temp.add(second);
                frdList.put(first, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(second);
                frdList.put(first, temp);
            }

            if (frdList.containsKey(second)) {
                List<String> temp = frdList.get(second);
                temp.add(first);
                frdList.put(second, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(first);
                frdList.put(second, temp);
            }
        }
        System.out.println(frdList);

        Map<String, Integer> scoreMap = new HashMap<>();

        List<String> userFriends = new ArrayList<>();
        Map<String, List<String>> notFriends = new HashMap<>();

        userFriends = frdList.get(user);

        Iterator<String> iter = frdList.keySet().iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            if(!userFriends.contains(key) && (key != user)){
                notFriends.put(key, frdList.get(key));
            }
        }

        Iterator<String> iter2 = notFriends.keySet().iterator();
        while(iter2.hasNext()) {
            String key2 = iter2.next();
            int score = 0;

            for(String userFriend : userFriends){
                if(notFriends.get(key2).contains(userFriend)){
                    score +=10;
                }
                scoreMap.put(key2, score);
            }
        }

        System.out.println(userFriends);
        System.out.println(notFriends);
        System.out.println(scoreMap);



        return answer;
    }
}

/**
 * 기능 요구사항
 * 1. friends별 친구 저장
 * 2. score 계산
 *  - 함께 아는 친구 score 계산
 *  - 방문자 score 계산
 *      - user의 친구 제외해야함
 * 3. 추천 친구 정렬
 * **/