package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String,List<String>> friendMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            friendMap.putIfAbsent(friend.get(0),new ArrayList<>());
            friendMap.putIfAbsent(friend.get(1),new ArrayList<>());

            friendMap.get(friend.get(0)).add(friend.get(1));
            friendMap.get(friend.get(1)).add(friend.get(0));
        }

        Map<String,Integer> visitorScore = new HashMap<>();
        for (String friend : friendMap.get(user)) {
            for (String friendFriend : friendMap.getOrDefault(friend,new ArrayList<>())) {
                visitorScore.merge(friendFriend,10,Integer::sum);
            }
        }
        for (String visitor : visitors) {
            visitorScore.merge(visitor,1,Integer::sum);
        }

        for (String friend : friendMap.get(user)) {
            visitorScore.remove(friend);
        }
        visitorScore.remove(user);

        Queue<Score> scores = new PriorityQueue<>();
        scores.addAll(visitorScore.keySet().stream().map(x->new Score(x, visitorScore.get(x))).collect(Collectors.toList()));
        List<String> answer =new ArrayList<>();
        while(!scores.isEmpty()&&answer.size()!=5){
            answer.add(scores.poll().name);
        }
        return answer;
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
