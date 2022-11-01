package onboarding;
/**
 *
 * 친구 추천 알고리즘 - 기능 요구 사항
 *  1. 유저와 직접적인 친구를 찾아 이름 리스트를 반환하는 함수를 만든다.
 *  2. 1번에서 찾은 이름 리스트의 친구들을 찾고 점수를 계산한다.
 *  3. 직접적인 친구를 제외한 방문자들의 리스트를 만들고 계산하는 함수를 만든다.
 */

import com.sun.jdi.connect.spi.TransportService;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends_form, List<String> visitors) {
        List<String> friends_list = new ArrayList<>(); // find list of Already friends
        List<List<String>> friends = new ArrayList<>(friends_form);
        HashMap<String, Integer> friends_score = new LinkedHashMap<>();

        friends = findAlreadyFriends(friends_list, user, friends);
        sort(friends_list);
        calculateScore(friends_score, friends_list, friends);
        System.out.println(friends_score);
        return answer;
    }
    public static List<List<String>> findAlreadyFriends(List<String> friends_list, String user, List<List<String>> friends) {
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
        return friends;
    }
    public static void calculateScore(HashMap<String, Integer> friends_score, List<String> friends_list, List<List<String>> friends) {

        HashSet<String> already_friend_set = new HashSet<>(friends_list);

        // 이미 친구인 사람은 0점: 0점은 추천 X
        for(List<String> friend: friends) {
            if(!friends_score.containsKey(friend.get(0))) {
                friends_score.put(friend.get(1), 0);
            } else if(!friends_score.containsKey(friend.get(1))) {
                friends_score.put(friend.get(0), 0);
            }
        }
        // check name and add 10 points for friends of already friends
        for(List<String> friend : friends) {
            if(!already_friend_set.contains(friend.get(0))) {
                friends_score.put(friend.get(1), friends_score.get(friend.get(1)) + 10);
            } else if(!already_friend_set.contains(friend.get(1))) {
                friends_score.put(friend.get(0), friends_score.get(friend.get(0)) + 10);
            }
        }
    }
}
