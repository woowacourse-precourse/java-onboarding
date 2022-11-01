package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 사용자를 정의하기 위한 Class
 */
class User {
    private String name;
    private Set<String> friends;

    public String getName() {
        return name;
    }

    public Set<String> getFriends() {
        return friends;
    }

    public void addFriend(String friend){
        this.getFriends().add(friend);
    }

    public User(String name) {
        this.name = name;
        this.friends = new HashSet<>();
    }
}

public class Problem7 {

    private static Map<String, Integer> recommendedFriend = new HashMap<>();
    private static User member;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 사용자의 id
        member = new User(user);
        // 친구관계 중 사용자가 포함되어 있는 리스트를 filter
        List<List<String>> userFriends = friends.stream()
                .filter( s -> s.contains(user))
                .collect(Collectors.toList());
        // 사용자의 친구 목록에 추가
        setFriends(userFriends);
        // 친구관계 중 사용자가 포함되어 있지 않은 리스트들 filter -> 사용자의 친구의 친구 즉 사용자와는 아직 친구가 아니다.
        List<List<String>> notUserFriends = friends.stream()
                .filter( s -> !s.contains(user))
                .collect(Collectors.toList());
        // 친구의 친구들의 score을 매긴다.
        scoredFriendOfFriends(notUserFriends);
        // 방문자들의 score을 매긴다.
        scoredVisitors(visitors);
        // point순으로 정렬한 후 출력
        List<String> answer = recommendedFriend.entrySet().stream()
                .sorted(Comparator.comparing(Entry::getValue , Comparator.reverseOrder()))
                .map(s -> s.getKey())
                .collect(Collectors.toList());

        return answer;
    }

    /**
     * 사용자의 친구목록을 기재한다. 이 때 친구관계중 [ 사용자, 친구1 ], [ 친구2, 사용자] 이런 경우를 방지하기 위해
     * 조건문 처리를 해준 후 친구1, 친구2를 사용자의 친구 목록에 추가한다.
     */

    private static void setFriends(List<List<String>> userFriends){
        for(List<String> friends : userFriends){
            if(friends.get(0) != member.getName()){
                member.addFriend(friends.get(0));
            }
            if(friends.get(1) != member.getName()){
                member.addFriend(friends.get(1));
            }
        }
    }

    /**
     * 사용자 친구의 친구들의 점수를 매긴다.
     */

    private static void scoredFriendOfFriends(List<List<String>> friends){
        for(List<String> friend : friends){
            List<String> friendOfFriend =
                    friend.stream()
                            .filter( s -> !member.getFriends().contains(s))
                            .collect(Collectors.toList());
            calculateScore(friendOfFriend.get(0), 10);
        }
    }

    private static void calculateScore(String user, int point){
        if(isExist(user)){
            int value = recommendedFriend.get(user);
            recommendedFriend.replace(user, value + point);
        }
        else{
            recommendedFriend.put(user, point);
        }
    }

    private static boolean isExist(String user){
        return recommendedFriend.containsKey(user);
    }

    private static void scoredVisitors(List<String> visitors){
        List<String> filterFriend = visitors.stream()
                .filter( s -> !member.getFriends().contains(s))
                .collect(Collectors.toList());
        for(String visitor : filterFriend){
            calculateScore(visitor, 1);
        }
    }
}
