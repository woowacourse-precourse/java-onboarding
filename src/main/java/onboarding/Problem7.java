package onboarding;

import java.util.*;

/**
 * 기능 구현 목록
 * a. user의 친구 목록 뽑기
 * b. user 친구의 친구들을 뽑기. -> 키-값의 형태로 저장하기 위해 해시맵에 저장.
 * c. 친구의 친구 순회 하면서 score 합산
 * d. visitors 중 친구가 아닌 사람들만 스코어에 넣기
 * e. score 순서대로 정렬. 점수가 같다면 이름순으로 정렬
 */
public class Problem7 {
    static List<String> userFriends;
    static HashMap<String, Integer> nonFriends;

    private static void isNewFriend(List<String> friends, String userFriend){
        if (friends.get(0).equals(userFriend)){
            if (nonFriends.containsKey(friends.get(1))){
                nonFriends.put(
                        friends.get(1),
                        nonFriends.get(friends.get(1)) + 10
                );
            } else {
                nonFriends.put(friends.get(1), 10);
            }
        } else if (friends.get(1).equals(userFriend)){
            if (nonFriends.containsKey(friends.get(0))){
                nonFriends.put(
                        friends.get(0),
                        nonFriends.get(friends.get(0)) + 10
                );
            } else {
                nonFriends.put(friends.get(0), 10);
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        userFriends = new ArrayList<>();
        nonFriends = new HashMap<>();
        // user의 친구 목록 추가
        for (List<String> friend : friends){
            if (friend.get(0).equals(user)){
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)){
                userFriends.add(friend.get(0));
            }
        }

        // 친구의 친구 목록 추가, score 합산
        for (List<String> friend : friends){
            for (int j = 0; j < userFriends.size(); j++) {
                if (friend.contains(user)) {
                    continue;
                }
                if (userFriends.contains(friend.get(0)) && userFriends.contains(friend.get(1))){
                    continue;
                }

                isNewFriend(friend, userFriends.get(j));
            }
        }

        for (String visitor : visitors){
            if (userFriends.contains(visitor)){
                continue;
            }
            if (nonFriends.containsKey(visitor)){
                nonFriends.put(
                        visitor,
                        nonFriends.get(visitor) + 1
                );
            } else {
                nonFriends.put(visitor, 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(nonFriends.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(!Objects.equals(o1.getValue(), o2.getValue())){
                    return o2.getValue() - o1.getValue();
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        int count = 0;
        for (Map.Entry<String, Integer> ans : entryList){
            if (count == 5) break;
            answer.add(ans.getKey());
            count++;
        }

        return answer;
    }
}