package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();

        makeMap(user, friends, map);


        List<String> user_friend= new ArrayList<>();
        user_friend=map.get(user);
        Map<String, Integer> friend_score = new HashMap<>();

        userFriendDelete(map, user_friend); // 사용자 친구는 항목에서 제거 (추천할 필요 없으니)



        return answer;
    }

    private static void userFriendDelete(Map<String, List<String>> map, List<String> user_friend) {
        for(String s: user_friend){
            map.remove(s);
        }
    }

    private static void makeMap(String user, List<List<String>> friends, Map<String, List<String>> map) {
        List<String> user_list = new ArrayList<>();
        user_list.add(user);
        map.put(user, new ArrayList<>());

        for(int i = 0; i< friends.size(); i++){
            user_list.add(friends.get(i).get(0));
            user_list.add(friends.get(i).get(1));
        } //map(친구: 친구1, 친구2, 친구3) 중 친구 부분을 만들기 위한 과정

        Set<String> set = new HashSet<>(user_list);
        List<String> result= new ArrayList<>(set); // 중복되어있는 친구 이름 중복된 이름 제거

        for(int i=0; i<result.size(); i++){
            map.put(result.get(i), new ArrayList<>());
        }

        for(int i = 0; i< friends.size(); i++){
            String friend1= friends.get(i).get(0);
            String friend2= friends.get(i).get(1);

            map.get(friend1).add(friend2);
            map.get(friend2).add(friend1); // 친구1,2,3 추가 (양방향적으로)
        }
    }
}
