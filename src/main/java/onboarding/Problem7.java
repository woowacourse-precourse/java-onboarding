package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> search_friends(String user, List<List<String>> friends ) { //특정 user 와 친구인 유저들을 반환
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < friends.size() ; i++) {
            if(friends.get(i).get(0).equals(user)) {
                answer.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                answer.add(friends.get(i).get(0));
            }
        }
        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> friends_map = new HashMap<String, Integer>(); // 각 유저와 점수를 넣을 map 선언
        int i = 0;
        int j = 0;
        int cnt = 0;
        for(i = 0; i < friends.size() ; i++) { // friends 로 주어진 유저들의 아이디를 key 로 가지게 하여 value 를 0으로 초기화
            friends_map.put(friends.get(i).get(0), 0);
            friends_map.put(friends.get(i).get(1), 0);
        }
        for(j = 0; j < visitors.size() ; j ++) { // visitors 로 주어진 유저들의 아이디를 key 로 가지게 하여 value 를 0으로 초기화
            friends_map.put(visitors.get(j), 0);
        }

        friends_map.remove(user); //본인의 아이디는 제거


        // 친구관계에 대한 점수계산
        List<String> user_friends = search_friends(user, friends);
        for(i = 0; i < user_friends.size(); i++) {
            for (String friend_friend :search_friends(user_friends.get(i), friends)) {
                if(!friend_friend.equals(user)) {
                    friends_map.put(friend_friend, friends_map.get(friend_friend) + 10);
                }
            }
        }

        for(j = 0; j < visitors.size(); j++) { //타임 라인 방문에 대한 점수계산
            friends_map.put(visitors.get(j), friends_map.get(visitors.get(j)) + 1);
        }

        List<Map.Entry<String, Integer>> friends_list = new LinkedList<>(friends_map.entrySet());
        friends_list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        }); //List 로 바꿔 내림차순 정렬, 점수 같을 경우 이름순

        for(int k = 0; k < friends_list.size(); k++) {
            if(!user_friends.contains(friends_list.get(k).getKey()) && friends_list.get(k).getValue() != 0) { //이미 친구인 경우와 점수가 0점일 경우 저장안함
                answer.add(friends_list.get(k).getKey());
                cnt ++;
                if (cnt >=5) {
                    break;  // 5명 넘어가면 멈춤
                }
            }
        }
        return answer;
    }
}
