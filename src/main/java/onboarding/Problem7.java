package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List> map = new HashMap<>();
    static Map <String, Integer> point = new HashMap<>();
    public static void addFriend(String friend1, String friend2) {
        if(map.get(friend1)==null) {
            List <String> list = new ArrayList<>();
            list.add(friend2);
            map.put(friend1, list);
        }
        else {
            List <String> list = map.get(friend1);
            list.add(friend2);
            map.put(friend1, list);
        }
    }

    public static void addPoint(String curFriend, int addpoint) {
        if(point.get(curFriend)==null){
            point.put(curFriend, addpoint);
        }
        else {
            int curpoint = point.get(curFriend);
            point.put(curFriend, curpoint+addpoint);
        }
    }

    public static void addFriendPoint(String user) {
        List <String> list = map.get(user);
        for(int i=0; i<list.size(); i++) {
            String friend = list.get(i);
            System.out.println("friend "+friend);
            List <String> friendList = map.get(friend);
            for(int j=0; j<friendList.size(); j++) {
                String curFriend = friendList.get(j);
                if(curFriend==user) continue;
                System.out.println("curFriend "+curFriend);
                addPoint(curFriend, 10);
            }
        }
    }

    public static void addVisitorPoint(List <String> visitors) {
        for(int i=0; i<visitors.size(); i++) {
            String visitor = visitors.get(i);
            addPoint(visitor, 1);
        }
    }

    public static void excludeFriend(String user){
        List <String> userfriend1 = map.get(user);
        for(int i=0; i<userfriend1.size(); i++) {
            point.put(userfriend1.get(i), 0);
        }
    }

    public static List<Map.Entry<String, Integer>> sortByKeyAndValue(){
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(point.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                if(obj1.getValue()==obj2.getValue()) {
                    return obj2.getKey().compareTo(obj1.getKey());
                }
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });
        return list_entries;
    }

    public static List <String> convertResultMapToList(List<Map.Entry<String, Integer>> resultmap){
        List <String> answer = new ArrayList <>();
        int cnt=0;
        for(int i=resultmap.size()-1; i>=0; i--) {
            if(resultmap.get(i).getValue()==0) break;
            if(cnt==5) break;
            answer.add(resultmap.get(i).getKey());
            cnt++;
        }
        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        for(int i=0; i<friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);
            addFriend(friend1, friend2);
            addFriend(friend2, friend1);
        }
        addFriendPoint(user);
        addVisitorPoint(visitors);
        excludeFriend(user);
        List<Map.Entry<String, Integer>> resultmap = sortByKeyAndValue();
        List <String> answer = convertResultMapToList(resultmap);

        return answer;
    }
}

