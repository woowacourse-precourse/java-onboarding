package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    static Map<String,Long> scores = new HashMap<>();
    static Map<String,String[]> map = new HashMap<>();

    static class Recommend{
        String name;
        Long score;
        public Recommend(String key, Long score) {
            this.name=key;
            this.score=score;
        }
        public String getName(){return name;}
        public Long getScore(){return score;}
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendScore(user,friends);
        visitorScore(user,visitors);
        return sorting();
    }
    public static void insertMap(String key, String value){
        List<String> list = new ArrayList<>(Arrays.asList(map.getOrDefault(key,new String[0])));
        list.add(value);
        map.put(key, list.toArray(String[]::new));
    }
    public static void insertScores(String user, String name, Long score){
        if (Objects.equals(user,name)) return;
        List<String>list= List.of(map.getOrDefault(user,new String[0]));
        if (list.contains(name)) return;
        scores.put(name,scores.getOrDefault(name,0L)+score);
    }
    public static void friendScore(String user, List<List<String>> friends){
        for(List<String>fs:friends){
            insertMap(fs.get(0),fs.get(1));
            insertMap(fs.get(1),fs.get(0));
        }
        for(String userF: map.getOrDefault(user,new String[0])){
            String[] nearF = map.getOrDefault(userF,new String[0]);
            for(String name:nearF){
                insertScores(user,name,10L);
            }
        }
    }
    public static void visitorScore(String user, List<String> visitors){
        Stream<String> stream = visitors.parallelStream();
        Map<String,Long> counter = stream.collect(Collectors.toConcurrentMap(k->k,v->1L,Long::sum));
        for (String name: counter.keySet()){
            insertScores(user,name,counter.get(name));
        }
    }
    public static List<String> sorting(){
        List<Recommend> scoreList = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        for (String key : scores.keySet()){
            scoreList.add(new Recommend(key, scores.get(key)));
        }

        scoreList.sort(Comparator.comparing(Recommend::getScore).reversed().thenComparing(Recommend::getName));
        if(scoreList.size()>5)scoreList=scoreList.subList(0,5);
        for(Recommend r : scoreList){
            ans.add(r.getName());
        }
        return ans;
    }
}
