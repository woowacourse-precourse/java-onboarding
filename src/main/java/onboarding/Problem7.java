package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        Map<String, Integer> scoreMap = new HashMap<>();
        for(List <String> friend : friends){
            String id_A = friend.get(0);
            String id_B = friend.get(1);
            if(Objects.equals(id_A, user)){
                userFriends.add(id_B);
            }
            if(Objects.equals(id_B, user)){
                userFriends.add(id_A);
            }
            ArrayList<String> aList = map.getOrDefault(id_A, new ArrayList<>());
            aList.add(id_B);
            ArrayList<String> bList = map.getOrDefault(id_B, new ArrayList<>());
            bList.add(id_A);
            map.put(id_A, aList);
            map.put(id_B, bList);
        }
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            String curUser = entry.getKey();
            if(userFriends.contains(curUser) || Objects.equals(curUser, user)) continue;
            ArrayList<String> curUserFriends = entry.getValue();
            int friendScore = 0;
            int visitScore = Collections.frequency(visitors, curUser);
            for(String curUserFriend : curUserFriends){
                if(userFriends.contains(curUserFriend)) friendScore += 10;
            }
            scoreMap.put(curUser, friendScore + visitScore);
        }
        List<String> distinctVisitors = visitors.stream().distinct().collect(Collectors.toList());
        for(String distinctVisitor : distinctVisitors){
            if(!userFriends.contains(distinctVisitor) && !scoreMap.containsKey(distinctVisitor)){
                int visitScore = Collections.frequency(visitors, distinctVisitor);
                scoreMap.put(distinctVisitor, visitScore);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(Objects.equals(o2.getValue(), o1.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                }
                else{
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        int recommendSize = Math.min(entryList.size(), 5);
        for(int i = 0; i < recommendSize; i++){
            answer.add(entryList.get(i).getKey());
        }
        return answer;
    }
}
