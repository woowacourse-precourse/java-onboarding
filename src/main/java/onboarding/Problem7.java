package onboarding;

import java.util.*;

public class Problem7 {
    static class Pair implements Comparable<Pair>{
        public String name;
        public int score;

        public Pair(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.score==o.score){
                return this.name.compareTo(o.name);
            }
            return o.score - this.score;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        HashMap<String, Integer> map=new HashMap<>();
        Set<String> alreadyFriend=new HashSet<>();
        for (List<String> friend : friends) {
            String str1=friend.get(0);
            String str2=friend.get(1);
            if(str1.equals(user)||str2.equals(user)){
                    alreadyFriend.add(str2);
                    alreadyFriend.add(str1);
            }else {
                    map.put(str1, map.getOrDefault(str1, 0)+10);
                    map.put(str2, map.getOrDefault(str2, 0)+10);
            }
        }

        for (String visitor : visitors) {
            if(!alreadyFriend.contains(visitor)){
                map.put(visitor, map.getOrDefault(visitor, 0)+1);
            }
        }

        ArrayList<Pair> arrayList=new ArrayList<>();
        for (String s : map.keySet()) {
            if(!alreadyFriend.contains(s)){
                arrayList.add(new Pair(s, map.get(s)));
            }
        }

        Collections.sort(arrayList);
        ArrayList<String> answer1=new ArrayList<>();
        for (Pair pair : arrayList) {
            answer1.add(pair.name);
        }
        answer=new ArrayList<>(answer1);
        return answer;
    }
}
