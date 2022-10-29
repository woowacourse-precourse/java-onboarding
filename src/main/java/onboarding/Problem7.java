package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static List<String> findAcquaintance(String user,List<String> findFreinds,List<List<String>> friends){
        List<String> result=new ArrayList<>();
        for(String friend:findFreinds){
            result.addAll(findFriends(friend,friends));
            result.remove(user);
        }
        return result;
    }
    public static List<String> findFriends(String user,List<List<String>> friends){
        List<String> result=new ArrayList<>();
        for(List<String> friend:friends){
            if(friend.contains(user)) {
                addFriend(friend.indexOf(user),result,friend);
            }
        }
        return result;
    }
    public static void addFriend(int index,List<String> result,List<String> freind){
        if(index==0)
            result.add(freind.get(1));
        if(index==1)
            result.add(freind.get(0));
    }
    public static Map<String,Integer> friendScoreCalculator(List<String> acquaintance){
        Map<String,Integer> result=new HashMap<>();
        for(String name:acquaintance){
            if(result.get(name)!=null)
                result.put(name, result.get(name)+10);
            result.putIfAbsent(name, 10);
        }
        return result;
    }
    public static Map<String,Integer> visitScoreCalculator(Map<String,Integer> scores,List<String> visitors){
        for(String name:visitors){
            if(scores.get(name)!=null)
                scores.put(name, scores.get(name)+1);
            scores.putIfAbsent(name, 1);
        }
        return scores;
    }

    public static List<String> result(Map<String,Integer> scores,List<String> friends){
        List<String> result = new ArrayList<>();
        for(String name:friends){
            scores.remove(name);
        }
        List<Map.Entry<String,Integer>> entries=new ArrayList<>(scores.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : entries) {
            result.add(entry.getKey());
        }
        return result;
    }

}
