package onboarding;
/**
 *
 * 친구 추천 알고리즘 - 기능 요구 사항
 *  1. 유저와 직접적인 친구를 찾아 이름 리스트를 반환하는 함수를 만든다.
 *  2. 1번에서 찾은 이름 리스트의 친구들을 찾고 점수를 계산한다.
 *  3. 현재 유저와 친구를 제외한 방문자들의 리스트를 만들고 계산하는 함수를 만든다.
 *  4. 최소 한명에서 최대 5명을 출력한다.
 */

import com.sun.jdi.connect.spi.TransportService;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends_form, List<String> visitors) {
        List<String> friends_list = new ArrayList<>(); // get list of Already friends
        List<List<String>> friends = new ArrayList<>(friends_form); // change ClassType
        HashMap<String, Integer> friends_score = new LinkedHashMap<>(); // 순서보장

        findAlreadyFriends(friends_list, user, friends);
        calculateScoreTen(friends_score, friends_list, friends);
        calculateScoreOne(visitors, friends_list, friends_score);
        return selectForAnswer(friends_score);
    }
    public static void findAlreadyFriends(List<String> friends_list, String user, List<List<String>> friends) {
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                friends_list.add(friends.get(i).get(1)); // friends inside there is
                friends.remove(friends.get(i));
            }
            if(friends.get(i).get(1).equals(user)) {
                friends_list.add(friends.get(i).get(0));
                friends.remove(friends.get(i));
            }
        }
        friends_list.remove(user);
    }
    public static void calculateScoreTen(HashMap<String, Integer> friends_score, List<String> friends_list, List<List<String>> friends) {

        HashSet<String> already_friend_set = new HashSet<>(friends_list);
        // 이미 친구인 사람은 0점: 0점은 추천 X
        for(List<String> friend: friends) {
            if(!friends_score.containsKey(friend.get(0))) {
                friends_score.put(friend.get(1), 0);
            } else if(!friends_score.containsKey(friend.get(1))) {
                friends_score.put(friend.get(0), 0);
            }
        }
        // check name and add 10points for friends of already friends
        for(List<String> friend : friends) {
            if(already_friend_set.contains(friend.get(0))) {
                friends_score.put(friend.get(1), friends_score.get(friend.get(1)) + 10);
            } else if(already_friend_set.contains(friend.get(1))) {
                friends_score.put(friend.get(0), friends_score.get(friend.get(0)) + 10);
            }
        }
    }
    public static void calculateScoreOne(List<String> visitors_list,List<String> friends_list,HashMap<String,Integer> friends_score){
        List<String> visitors = new ArrayList<>(visitors_list); //Type change
        visitors.removeAll(friends_list); // left except current friend of user
        for(String visitor:visitors) {
            if(!friends_score.containsKey(visitor)) {
                friends_score.put(visitor, 1);
            }else{
                friends_score.put(visitor, friends_score.get(visitor) + 1);
            }
        }
    }
    public static List<String> selectForAnswer(HashMap<String, Integer> friends_score) {
        // value 0 인 원소들 삭제
        friends_score.values().removeAll(Collections.singleton(0));
        // 점수기준 내림차순 정렬 + 동점인 경우 이름정렬
        Map<String, Integer> result = friends_score.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                        .reversed().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a,b)->b, LinkedHashMap::new));

        // 5개 출력
        List<String> answer = new ArrayList<>();

        for(String key:result.keySet()) {
            if(answer.size() == 5)
                return answer;
            answer.add(key);
        }
        return answer;
    }

}
