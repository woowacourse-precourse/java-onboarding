package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> map=new HashMap<>();
        for (List<String> friend : friends) {
            String str1=friend.get(0);
            String str2=friend.get(1);
            if(str1.equals(user)||str2.equals(user)){
                if(!str1.equals(user)){
                    map.put(str1, 10);
                }
                if(!str2.equals(user)){
                    map.put(str2,10);
                }
            }
        }
        for (String visitor : visitors) {
            map.put(visitor, map.getOrDefault(visitor, 0)+1);
        }
        ArrayList<Pair> arrayList=new ArrayList<>();
        for (String s : map.keySet()) {
            arrayList.add(new Pair(s, map.get(s)));
        }
        Collections.sort(arrayList);

        for (Pair pair : arrayList) {
            System.out.println(pair.name+" "+pair.score);
        }
        return answer;
    }
}
