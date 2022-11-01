package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends_form, List<String> visitors) {
        List<String> friends_list = new ArrayList<>();
        List<List<String>> friends = new ArrayList<>(friends_form);
        HashMap<String, Integer> friends_score = new LinkedHashMap<>();

        findAlreadyFriends(friends_list, user, friends);
        calculateScoreTen(friends_score, friends_list, friends);
        calculateScoreOne(visitors, friends_list, friends_score);
        return selectForAnswer(friends_score);
    }
    public static void findAlreadyFriends(List<String> friends_list, String user, List<List<String>> friends) {
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                friends_list.add(friends.get(i).get(1));
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
        for(List<String> friend: friends) {
            if(!friends_score.containsKey(friend.get(0))) {
                friends_score.put(friend.get(1), 0);
            } else if(!friends_score.containsKey(friend.get(1))) {
                friends_score.put(friend.get(0), 0);
            }
        }

        for(List<String> friend : friends) {
            if(already_friend_set.contains(friend.get(0))) {
                friends_score.put(friend.get(1), friends_score.get(friend.get(1)) + 10);
            } else if(already_friend_set.contains(friend.get(1))) {
                friends_score.put(friend.get(0), friends_score.get(friend.get(0)) + 10);
            }
        }
    }
    public static void calculateScoreOne(List<String> visitors_list,List<String> friends_list,HashMap<String,Integer> friends_score){
        List<String> visitors = new ArrayList<>(visitors_list);
        visitors.removeAll(friends_list);
        for(String visitor:visitors) {
            if(!friends_score.containsKey(visitor)) {
                friends_score.put(visitor, 1);
            }else{
                friends_score.put(visitor, friends_score.get(visitor) + 1);
            }
        }
    }
    public static List<String> selectForAnswer(HashMap<String, Integer> friends_score) {
        friends_score.values().removeAll(Collections.singleton(0));
        Map<String, Integer> result = friends_score.entrySet().stream()
            .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed().thenComparing(Map.Entry::getKey))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (a,b)->b, LinkedHashMap::new));

        List<String> answer = new ArrayList<>();

        for(String key:result.keySet()) {
            if(answer.size() == 5)
                return answer;
            answer.add(key);
        }
        return answer;
    }
}
