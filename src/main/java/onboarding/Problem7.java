package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriends = new ArrayList<>();
        HashMap<String,Integer> graph = new HashMap<String, Integer>();
        for(int i=0; i<friends.size(); i++){
            String f0 = friends.get(i).get(0) ; String f1 = friends.get(i).get(1);
            if (f0==user) myFriends.add(f1); else if(f1==user) myFriends.add(f0);
        }
        for(int i=0; i<friends.size(); i++){
            String f0 = friends.get(i).get(0) ; String f1 = friends.get(i).get(1);
            if (f0==user||f1==user) continue;
            if (myFriends.contains(f0)){
                graph.put(f1, graph.containsKey(f1) ? graph.get(f1)+10 : 10);
            }
            if (myFriends.contains(f1)){
                graph.put(f0, graph.containsKey(f0) ? graph.get(f0)+10 : 10);
            }
        }
        for(int i=0; i<visitors.size(); i++){
            String tempVisitor = visitors.get(i);
            if (myFriends.contains(tempVisitor)) continue;
            graph.put(tempVisitor, graph.containsKey(tempVisitor) ? graph.get(tempVisitor)+1 : 1);
        }
        List<Map.Entry<String,Integer>> temp = new LinkedList<>(graph.entrySet());
        temp.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> answer = new ArrayList<String>();
        for(int i=0; i<5; i++){
            if(temp.size() <= i) break;
            answer.add(temp.get(i).getKey());
        }
        return answer;
    }
}
