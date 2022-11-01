package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 이미 user 와 친구인 사람을 저장할 리스트
        List<String> user_friend_list = new ArrayList<>();

        // 이름과 점수를 함께 저장
        Map<String, Integer> map = new TreeMap<>();

        // user 와 친구인 사람들 확인
        for(int i = 0; i < friends.size(); i++){

            List<String> temp = friends.get(i);

            String A = temp.get(0);
            String B = temp.get(1);

            if(A.equals(user)){
                user_friend_list.add(B);
            }
            else if(B.equals(user)){
                user_friend_list.add(A);
            }
        }

        // user 와 친구인 사람들 중에서,
        // 사용자와 함께 아는 친구 수 점수 계산
        for(int i = 0; i < user_friend_list.size(); i++){

            String name = user_friend_list.get(i);
            // System.out.println(name);

            // 추천해 줄 친구가 있는 지 확인
            for(int j = 0; j < friends.size(); j++){
                List<String> temp = friends.get(j);

                String A = temp.get(0);
                String B = temp.get(1);

                // 단, user 및 이미 친구사이는 포함해서는 안된다.
                if(A.equals(name) && !B.equals(user) && !user_friend_list.contains(B)){

                    // 이미 map 에 있다면, 기존 점수에 + 10
                    if(map.containsKey(B)){
                        map.put(B, map.get(B) + 10);
                    }

                    else{
                        map.put(B, 10);
                    }

                }
                else if(B.equals(name) && !A.equals(user) && !user_friend_list.contains(A)){

                    if(map.containsKey(A)){
                        map.put(A, map.get(A) + 10);
                    }
                    else{
                        map.put(A, 10);
                    }
                }
            }

        }

        return answer;
    }
}
