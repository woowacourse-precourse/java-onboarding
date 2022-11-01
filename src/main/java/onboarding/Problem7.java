package onboarding;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 기능 구현 목록
 * 1. user의 친구 목록 뽑기
 * 2. user 친구의 친구들을 뽑기. -> 키-값의 형태로 저장하기 위해 해시맵에 저장.
 * 3. 친구의 친구 순회 하면서 score 합산
 * 4. visitors 중 친구가 아닌 사람들만 스코어에 넣기
 * 5. score 순서대로 정렬. 점수가 같다면 이름순으로 정렬
 */
public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    static HashMap<String, Integer> nonFriends = new HashMap<>();
    static List<Map.Entry<String, Integer>> entryList;

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
    private static void AddFrinedsScore(List<List<String>> friends, String user){
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
    }
    private static void AddVisitorScore(List<String> visitors){
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
    }
    private static void SortByScore(){
        entryList = new LinkedList<>(nonFriends.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue()){
                    return o2.getValue() - o1.getValue();
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // user의 친구 목록 추가
        for (List<String> friend : friends){
            if (friend.get(0).equals(user)){
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)){
                userFriends.add(friend.get(0));
            }
        }

        AddFrinedsScore(friends, user);
        AddVisitorScore(visitors);
        SortByScore();

        int count = 0;
        for (Map.Entry<String, Integer> ans : entryList){
            if (count == 5) break;
            answer.add(ans.getKey());
            count++;
        }

        return answer;
    }
}
