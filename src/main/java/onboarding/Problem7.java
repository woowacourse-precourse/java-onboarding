package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 모든 유저의 친구 관계 저장
        HashMap<String, ArrayList<String>> friend_map = get_friendsMap(friends);
        // 추천할 대상과 점수를 저장
        HashMap<String, Integer> recommand = new HashMap<>();
        // 추천을 받는 대상(= user)의 친구 관계를 탐색하여 이미 친구인 사람을 저장
        ArrayList<String> already_friends = friend_map.get(user);

        // 친구 관계를 탐색하여 이미 친구인 사람 및 자기 자신을 제외하고 추천 대상에 저장해둠.
        for(String friend : friend_map.keySet()){
            if(!already_friends.contains(friend) && !friend.equals(user))
                recommand.put(friend, 10);
        }

        return answer;
    }

    // 모든 유저의 친구 관계를 Map에 저장
    private static HashMap<String, ArrayList<String>> get_friendsMap(List<List<String>> friends){
        HashMap<String, ArrayList<String>> friend_map = new HashMap<>();

        for(List<String> friend : friends){
            if(!friend_map.containsKey(friend.get(0))) {
                friend_map.put(friend.get(0), new ArrayList<>());
                friend_map.get(friend.get(0)).add(friend.get(1));
            }
            else friend_map.get(friend.get(0)).add(friend.get(1));

            if(!friend_map.containsKey(friend.get(1))){
                friend_map.put(friend.get(1), new ArrayList<>());
                friend_map.get(friend.get(1)).add(friend.get(0));
            }
            else friend_map.get(friend.get(1)).add(friend.get(0));
        }

        return friend_map;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");

        solution(user, friends, visitors);
    }
}
