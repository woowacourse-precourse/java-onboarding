package onboarding;

import java.util.*;

public class Problem7 {
    private static final int MAX_SIZE = 5;
    private static final HashMap<String, LinkedList<String>> relation = new HashMap<>();
    private static final HashMap<String, Integer> score = new HashMap<>();
    private static final List<String> answer = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeFriendRelation(friends);
        setAcquaintanceScore(user);
        setVisitorsScore(user, visitors);
        return getResultBySort();
    }

    public static void makeFriendRelation(List<List<String>> friends){
        for(List<String> friend : friends){
            String name1 = friend.get(0);
            String name2 = friend.get(1);
            addNameByKey(name1, name2);
            addNameByKey(name2, name1);
        }
    }

    public static void addNameByKey(String user, String friend){
        if(relation.containsKey(user)){
            relation.get(user).add(friend);
        } else {
            relation.put(user, new LinkedList<String>(Collections.singleton(friend)));
            score.put(user, 0);
        }
    }

    public static void setAcquaintanceScore(String user){
        for(String friend : relation.get(user)){
           for(String name : relation.get(friend)){
               if(!name.equals(user)) score.replace(name, score.get(name) + 10);
           }
        }
    }

    public static void setVisitorsScore(String user, List<String> visitors){
        for(String visitor : visitors){
            if(relation.get(user).contains(visitor)) continue; // 방문자가 이미 친구라면

            if(score.containsKey(visitor)){
                score.replace(visitor, score.get(visitor) + 1);
            }else{
                score.put(visitor, 1);
            }
        }
    }

    public static List<String> getResultBySort(){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(score.entrySet());
        sortData(list); // 점수대로 내림차순 정렬, 점수가 같다면 이름으로 오름차순 정렬
        for(int i = 0; i < MAX_SIZE; i++){
            if(list.get(i).getValue() == 0) return answer;
            answer.add(list.get(i).getKey());
        }
        return answer;
    }

    public static void sortData(List<Map.Entry<String, Integer>> list){
        list.sort(new Comparator<Map.Entry<String, Integer>>() { // 점수로 내림차순 정렬, 점수가 갔다면 이름순으로 정렬
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * -1;
                return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });
    }
}
