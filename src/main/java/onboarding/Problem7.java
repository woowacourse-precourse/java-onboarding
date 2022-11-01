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
/**
 * Programs should be written for people to read, and only incidentally for machine to execute
 */

public class Problem7 {
    // 추천 친구 목록
    private static Map<String, Integer> recommendedFriend = new HashMap<>();
    // 사용자를 정의함
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
     * 사용자가 포함되어 있지않은 친구관계중 사용자와 이미 친구인 상대를 제외한 친구의 친구의 점수를 계산한다.
     */

    private static void scoredFriendOfFriends(List<List<String>> notUserFriends){
        for(List<String> friends : notUserFriends){
            List<String> friendOfFriend =
                    friends.stream()
                            // filter를 이용해 사용자와 친구 관계인 상대를 제외한 나머지 한명을 collect한다.
                            .filter( s -> !member.getFriends().contains(s))
                            .collect(Collectors.toList());
            calculateScore(friendOfFriend.get(0), 10); //기능 요구사항에 맞게 친구의 친구에게 10점 부여.
        }
    }

    /**
     * 사용자와 함께 아는 친구의 수 = 10점
     * 사용자의 타임 라인에 방문한 횟수 = 1점
     * 사용자(User)에게 위의 조건에 맞추어 점수(Point)를 부여한다.
     */

    private static void calculateScore(String user, int point){
        if(isExist(user)){ // 이미 친구추천 목록에 있던 친구
            int value = recommendedFriend.get(user);
            recommendedFriend.replace(user, value + point);
        }
        else{ // 친구추천 목록에 새로 갱신되는 친구
            recommendedFriend.put(user, point);
        }
    }

    /**
     * 해당 친구(user)가 이미 친구추천 목록에 있는지 확인한다.
     */

    private static boolean isExist(String user){
        return recommendedFriend.containsKey(user);
    }

    /**
     * 방문자 중에 사용자와 이미 친구이것을 filter 그리고 점수 부여
     */

    private static void scoredVisitors(List<String> visitors){
        List<String> filterFriend = visitors.stream()
                .filter( s -> !member.getFriends().contains(s))
                .collect(Collectors.toList());
        for(String visitor : filterFriend){
            calculateScore(visitor, 1);
        }
    }
}
