package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = new ArrayList<>();
        Map<String,Integer> matchingScore = new HashMap<>();
        matchingScore=fof(user,friendList,matchingScore,friends);
        matchingScore=score(friendList,matchingScore,visitors);
        return scoreSort(matchingScore);
    }
    private static Map<String,Integer> fof(String user,List<String> friendList,Map<String,Integer> matchingScore,List<List<String>> friends){
        //fof == friend of friend
        for (List<String> list:  friends) {
            if(user==list.get(1)) friendList.add(list.get(0));
        }
        for (List<String> list:  friends) {
            if(user == list.get(1)) continue;
            else if(friendList.contains(list.get(1))){
                matchingScore.replace(list.get(1),matchingScore.get(list.get(1))+10);
            }
            else{
                matchingScore.put(list.get(1),10);
            }
        }
        return matchingScore;
    }
    private static Map<String,Integer> score(List<String> friendList,Map<String,Integer> matchingScore,List<String> visitors){
        for (String vt : visitors) {
            if(friendList.contains(vt)) continue;
            else if(matchingScore.containsKey(vt)){
                matchingScore.replace(vt,matchingScore.get(vt)+1);
            }
            else{
                matchingScore.put(vt,1);
            }
        }
        return matchingScore;
    }

    private static List<String> scoreSort(Map<String,Integer> matchingScore){
        List<String> answer = new ArrayList<>();
        List<Map.Entry<String, Integer>> sorting;
        sorting =new LinkedList<>(matchingScore.entrySet());
        sorting.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                return m2.getValue() - m1.getValue();
            }
        });
        for(Map.Entry<String, Integer> entry : sorting){
            answer.add(entry.getKey());
        }
        return answer;
    }
}
