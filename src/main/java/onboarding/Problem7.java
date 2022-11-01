package onboarding;

import java.util.*;

public class Problem7 {

    HashMap<String, ArrayList<String>> friendGraph = new HashMap<>();
    Map<String, Integer> knownList = new HashMap();
    Set<String> friendList = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p7 = new Problem7();
        p7.makeFriendGraph(friends);
        p7.findKnownPeople(user);
        p7.findVisitors(user, visitors);

        return null;
    }

    private void makeFriendGraph(List<List<String>> friends){
        for(List<String> list : friends){
            String friend1 = list.get(0);
            String friend2 = list.get(1);
            addFriendToGraph(friend1, friend2);
            addFriendToGraph(friend2, friend1);
        }
    }

    private void addFriendToGraph(String friend1, String friend2){
        if(friendGraph.containsKey(friend1)){
            friendGraph.get(friend1).add(friend2);
        }
        else{
            ArrayList<String> list1 = new ArrayList<>();
            list1.add(friend2);
            friendGraph.put(friend1, list1);
        }
    }

    private void findKnownPeople(String user){
        ArrayList<String> friends = friendGraph.get(user);
        friendList.addAll(friends);
        for(String friend : friends){
            for(String people : friendGraph.get(friend)){
                if(people.equals(user) || friendList.contains(people)) continue;        // 만약 본인이고 친구이면 통과
                if(knownList.containsKey(people)){
                    Integer score = knownList.get(people);
                    knownList.replace(people, score, score+10);
                }
            else{
                    knownList.put(people, 10);
                }
            }
        }
    }

    private void findVisitors(String user, List<String> visitors){
        for(String visitor : visitors){
            if(visitor.equals(user) || friendList.contains(visitor)) continue;
            if(knownList.containsKey(visitor)){
                Integer score = knownList.get(visitor);
                knownList.replace(visitor, score, score+1);
            }
            else knownList.put(visitor, 1);
        }
    }
}
