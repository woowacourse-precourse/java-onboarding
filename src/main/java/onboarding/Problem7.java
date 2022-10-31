package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class Problem7 {
    private static final int FRIEND_COUNT_POINT = 10;
    private static final int VISITOR_COUNT_POINT = 1;

    public static List<String> solution(String myUser, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendGraph = createFrinedGraph(friends);
        List<String> myFriendList = friendGraph.getOrDefault(myUser, Collections.emptyList());
        Map<String, Integer> friendPoint = new HashMap<>(); // [(andole , 20), (jun, 20), (bedi, 3)]

        // 사용자와 함께 아는 친구의 수 => 10점 추가
        calculateFriendCountPoint(myUser, friendPoint, myFriendList, friendGraph);
        // 방문 횟수 => 1점 추가
        calculateVisitingCountPoint(myUser, visitors, friendPoint, myFriendList);

        return friendPoint.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer> ::getValue).reversed() // 점수 큰 순
                        .thenComparing(Map.Entry<String, Integer>::getKey)) // 사전 순
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void calculateFriendCountPoint(String myUser, Map<String, Integer> friendPoint, List<String> myFriendList, Map<String, List<String>> friendGraph){
        if(myFriendList.isEmpty()){
            return;
        }
        for(String other : friendGraph.keySet()){ // donut, andole, jun, shakevan, mrko(x)
            countFriend(myUser, other, friendPoint, myFriendList, friendGraph);
        }
    }

    public static void countFriend(String myUser, String other, Map<String, Integer> friendPoint, List<String> myFriendList, Map<String, List<String>> friendGraph){
        if (myUser.equals(other)){ //본인 = mrko
            return;
        }
        if (myFriendList.contains(other)){ // 이미 친구 = donut, shakevan
            return;
        }
        for (String othersFriend : friendGraph.get(other)){ // andole의 친구 목록, jun의 친구 목록 iteration
            checkHaveSameFriendAndIncreasePoint(other, othersFriend, friendPoint,  myFriendList);
        }
    }

    public static void checkHaveSameFriendAndIncreasePoint(String other, String othersFriend, Map<String, Integer> friendPoint, List<String> myFriendList){
        if (myFriendList.contains(othersFriend)){ // mrko의 친구 목록 중 andole의 친구가 있다면, andole에게 10점 추가
            if (!friendPoint.containsKey(other)){
                friendPoint.put(other, FRIEND_COUNT_POINT);
                return;
            }
            friendPoint.put(other, friendPoint.get(other) + FRIEND_COUNT_POINT);
        }
    }

    public static void calculateVisitingCountPoint(String myUser, List<String> visitors, Map<String, Integer> friendPoint, List<String> myFriendList){
        for (String visitor: visitors){
            countVisiting(visitor, myUser, friendPoint, myFriendList);
        }
    }

    public static void countVisiting(String visitor, String myUser, Map<String, Integer> friendPoint, List<String> myFriendList){
        if (visitor.equals(myUser)){ // 본인
            return;
        }
        if(myFriendList.contains(visitor)){ // 이미 친구
            return;
        }
        if(friendPoint.containsKey(visitor)){
            friendPoint.put(visitor, friendPoint.get(visitor) + VISITOR_COUNT_POINT);
            return;
        }
        friendPoint.put(visitor, VISITOR_COUNT_POINT);
    }

    public static Map<String, List<String>> createFrinedGraph(List<List<String>> friends){
        Map<String, List<String>> friendGraph = new HashMap<>();
        for (List<String> friendRelation : friends){
            String userA = friendRelation.get(0), userB = friendRelation.get(1);
            addToGraph(friendGraph, userA, userB);
        }
        return friendGraph;
    }

    public static void addToGraph(Map<String, List<String>> friendGraph ,String userA, String userB){
        // userA가 friendGraph의 key값으로 이미 있을 경우 -> userB를 List에 추가한다.
        // 없다면 userA를 key값에 추가하고 리스트를 새로 생성 후 userB를 추가한다.
        if(friendGraph.containsKey(userA)){
            friendGraph.get(userA).add(userB);
        }
        if(!friendGraph.containsKey(userA)){
            friendGraph.put(userA, new ArrayList<>(List.of(userB)));
        }
        // userB에 대해 반복
        if(friendGraph.containsKey(userB)){
            friendGraph.get(userB).add(userA);
        }
        if(!friendGraph.containsKey(userB)){
            friendGraph.put(userB, new ArrayList<>(List.of(userA)));
        }
    }
}
