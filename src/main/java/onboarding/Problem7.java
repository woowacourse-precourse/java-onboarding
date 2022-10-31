package onboarding;

import java.util.*;

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

        // 방문자 목록을 탐색하여 이미 친구인 사람 및 자기 자신을 제외하고 추천 대상에 저장해둔다.
        for(String visitor : visitors){
            if(!already_friends.contains(visitor) && !visitor.equals(user)){
                if(recommand.containsKey(visitor))
                    recommand.put(visitor, recommand.get(visitor) + 1);
                else recommand.put(visitor, 1);
            }
        }

        // 점수를 기준으로 내림차순하여 결과에 저장해둔다.
        answer = sort_recommand(recommand);

        return answer;
    }
    // 추천 점수 테이블에 대한 내림차순 정렬
    private static ArrayList<String> sort_recommand(HashMap<String, Integer> recommand){
        ArrayList<String> result = new ArrayList<>();

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(recommand.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<String, Integer> entry : entries){
            result.add(entry.getKey());
        }

        return result;
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
}
