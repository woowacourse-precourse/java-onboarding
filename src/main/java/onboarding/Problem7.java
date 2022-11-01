package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> map;
    static Map<String, Integer> answerMap;
    static List<String> userFriend;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();
        answerMap = new HashMap<>();
        for (List<String> friend : friends) {
            String person1 = friend.get(0);
            String person2 = friend.get(1);

            List<String> newList = map.getOrDefault(person1, new ArrayList<>());
            newList.add(person2);
            map.put(person1, newList);
            newList = map.getOrDefault(person2, new ArrayList<>());
            newList.add(person1);
            map.put(person2, newList);
        }

        userFriend = map.get(user);

        checkKnowingTogether(user);
        checkVisitors(visitors);

        List<Recommendation> sortList = new ArrayList<>();
        for (String s : answerMap.keySet()) {
            sortList.add(new Recommendation(s, answerMap.get(s)));
        }
        Collections.sort(sortList);
        for(int i=0; i<sortList.size(); i++){
            if(i >4) break;
            answer.add(sortList.get(i).name);
        }

        return answer;
    }
    public static void checkVisitors(List<String> visitors){
        for (String visitor : visitors) {
            if(userFriend != null && userFriend.contains(visitor)) continue;
            answerMap.put(visitor, answerMap.getOrDefault(visitor, 0)+1);
        }
    }
    public static void checkKnowingTogether(String user){
        if(userFriend == null) return;
        for (String s : userFriend) {
            List<String> list = map.get(s);
            for (String s1 : list) {
                if(s1.equals(user)) continue;
                if(userFriend.contains(s1)) continue;
                answerMap.put(s1, answerMap.getOrDefault(s1, 0)+10);
            }
        }
    }
    static class Recommendation implements Comparable<Recommendation>{
        String name;
        int score;
        public Recommendation(String name, int score){
            this.name = name;
            this.score= score;
        }
        @Override
        public int compareTo(Recommendation o1){
            if(o1.score == this.score){
                return this.name.compareTo(o1.name);
            }
            return o1.score - this.score;
        }
    }
}
