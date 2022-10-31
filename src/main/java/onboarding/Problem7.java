package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String,List<String>> friendMap;
    static Map<String, Integer> visitorScore;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initFriendRelation(friends);
        Map<String, Integer> visitorScore = getVisitorScore(user, visitors);
        Queue<Score> scores = getSCorePriorityQueue(visitorScore);
        return getAnswerList(scores);
    }

    private static List<String> getAnswerList(Queue<Score> scores) {
        List<String> answer =new ArrayList<>();
        while(!scores.isEmpty()&&answer.size()!=5){
            answer.add(scores.poll().name);
        }
        return answer;
    }

    private static Queue<Score> getSCorePriorityQueue(Map<String, Integer> visitorScore) {
        Queue<Score> scores = new PriorityQueue<>();
        scores.addAll(visitorScore.keySet().stream().map(x->new Score(x, visitorScore.get(x))).collect(Collectors.toList()));
        return scores;
    }

    private static Map<String, Integer> getVisitorScore(String user, List<String> visitors) {
        visitorScore= new HashMap<>();
        calculateFriendFriend(user);
        calculateVisitor(visitors);
        removeUserFriend(user);
        removeUser(user);
        return visitorScore;
    }
    private static void calculateFriendFriend(String user) {
        for (String friend : friendMap.get(user)) {
            for (String friendFriend : friendMap.getOrDefault(friend,new ArrayList<>())) {
                visitorScore.merge(friendFriend,10,Integer::sum);
            }
        }
    }
    private static void calculateVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            visitorScore.merge(visitor,1,Integer::sum);
        }
    }


    private static void removeUserFriend(String user) {
        for (String friend : friendMap.get(user)) {
            removeUser(friend);
        }
    }

    private static void removeUser(String user) {
        visitorScore.remove(user);
    }


    private static void initFriendRelation(List<List<String>> friends) {
        friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            friendMap.putIfAbsent(friend.get(0),new ArrayList<>());
            friendMap.putIfAbsent(friend.get(1),new ArrayList<>());

            friendMap.get(friend.get(0)).add(friend.get(1));
            friendMap.get(friend.get(1)).add(friend.get(0));
        }
    }
}
class Score implements Comparable<Score>{
    String name;
    int value;

    public Score(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(Score o) {
        return o.value==this.value?name.compareTo(o.name):o.value-this.value;
    }
}
