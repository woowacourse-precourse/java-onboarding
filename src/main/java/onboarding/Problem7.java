package onboarding;

import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String,Integer> scoreMap = new HashMap<>();
        HashSet<String> friendsMap = new HashSet<>();

        // 친구를 싹다 업데이트하고
        for(List<String> temp : friends){
            if(temp.get(0).equals(user) || temp.get(1).equals(user)){
                if(temp.get(0).equals(user)){
                    friendsMap.add(temp.get(1));
                }else{
                    friendsMap.add(temp.get(0));
                }
            }
        }

        // 내 친구랑 아는 사람이면 10점
        for(List<String> temp : friends){
            if(friendsMap.contains(temp.get(0)) || friendsMap.contains(temp.get(1))){
                if(friendsMap.contains(temp.get(0))){
                    if(temp.get(1).equals(user)) continue;
                    scoreMap.put(temp.get(1), scoreMap.getOrDefault(temp.get(0),0)+10);
                }else{
                    if(temp.get(0).equals(user)) continue;
                    scoreMap.put(temp.get(0), scoreMap.getOrDefault(temp.get(1),0)+10);
                }
            }
        }

        // visitor를 업데이트한다.
        for(String temp : visitors){
            if(friendsMap.contains(temp)) continue;
            scoreMap.put(temp, scoreMap.getOrDefault(temp,0)+1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());

        List <Node> resList = new ArrayList<Node>();
        for(Map.Entry<String, Integer> entry : entryList){
            resList.add(new Node(entry.getKey(),entry.getValue()));
        }

        Collections.sort(resList);

        int cnt = 5;
        for(Node n : resList){
            if(cnt <= 0) break;
            answer.add(n.name);
            cnt--;
        }

        return answer;
    }
}
class Node implements Comparable<Node>{
    public String name;
    public int value;
    Node(String name, int value){
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        if(this.value == o.value){
            return this.name.compareTo(o.name);
        }
        return o.value - this.value;
    }
}