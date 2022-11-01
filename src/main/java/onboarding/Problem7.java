package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> userList = new HashSet<>();
        for (List<String> list: friends){
            if (map.containsKey(list.get(0))){
                map.get(list.get(0)).add(list.get(1));
            }
            else {
                List <String> friendList = new ArrayList<>();
                friendList.add(list.get(1));
                map.put(list.get(0), friendList);
            }
            if (map.containsKey(list.get(1))){
                map.get(list.get(1)).add(list.get(0));
            }
            else {
                List <String> friendList = new ArrayList<>();
                friendList.add(list.get(0));
                map.put(list.get(1), friendList);
            }
            userList.add(list.get(0));
            userList.add(list.get(1));
        }
        userList.remove(user);
        Map<String, Integer> friendCount = new HashMap<>();
        for(String person:userList){
            friendCount.put(person, 0);
        }
        for(String userFriend: map.get(user)){
            for (String person: userList){
                if (map.get(person).contains(userFriend)){
                    Integer tmp = friendCount.get(person);
                    friendCount.put(person, tmp + 10);
                }
            }
        }
        for(String visitFriend: visitors){
            if (friendCount.containsKey(visitFriend)){
                Integer tmp = friendCount.get(visitFriend);
                friendCount.put(visitFriend, tmp + 1);
            }
            else {
                friendCount.put(visitFriend, 1);
            }
        }
        for(String userFriend: map.get(user)){
            friendCount.remove(userFriend);
        }
        List<Map.Entry<String, Integer>> sortList = new LinkedList<>(friendCount.entrySet());
        sortList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue()==o2.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        List<String> answer = new LinkedList<>();
        int indexLength = 5;
        if (sortList.size() < 5) {
            indexLength = sortList.size();
        }
        for (int i =0;i<indexLength;i++){
            if (sortList.get(i).getValue()!=0){
                answer.add(sortList.get(i).getKey());
            }
        }
        return answer;
    }
}
