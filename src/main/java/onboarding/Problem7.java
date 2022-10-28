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
        List<String> ans = Collections.emptyList();
        friendScore(user,friends);
        visitorScore(user,visitors);
        ans=sorting();
        return ans;
    }
    public static void insertMap(String key, String value){
        if(map.containsKey(key)) {
            List<String> list = new ArrayList<>(Arrays.asList(map.get(key)));
            list.add(value);
            map.put(key, list.toArray(String[]::new));
        }
        else {
            String[] list = new String[]{value};
            map.put(key, list);
        }
    }
    public static void friendScore(String user, List<List<String>> friends){
        for(List<String>fs:friends){
            insertMap(fs.get(0),fs.get(1));
            insertMap(fs.get(1),fs.get(0));
        }
        for(String userF: map.getOrDefault(user,new String[0])){
            String[] nearF = map.getOrDefault(userF,new String[0]);
            for(String name:nearF){
                if (Objects.equals(name, user))continue;
                List<String> list=new ArrayList<>(List.of(userF));
                if (list.contains(name))continue;
                if(scores.containsKey(name)) scores.put(name,scores.get(name)+10);
                else{ scores.put(name, 10L);}
            }
        }
    }
    public static void visitorScore(String user, List<String> visitors){
        Stream<String> stream = visitors.parallelStream();
        Map<String,Integer> counter = stream.collect(Collectors.toConcurrentMap(k->k,v->1,Integer::sum));
        for (String name: counter.keySet()){
            if (Objects.equals(name, user))continue;
            List<String>list= List.of(map.getOrDefault(user,new String[0]));
            if(list.contains(name))continue;
            if(scores.containsKey(name)) scores.put(name,scores.get(name)+counter.get(name));
            else{ scores.put(name, Long.valueOf(counter.get(name)));}
        }
    }
    public static List<String> sorting(){
        List<Recommend> list = new ArrayList<>();
        for (String key : scores.keySet()){
            list.add(new Recommend(key, scores.get(key)));
        }
        list.sort(Comparator.comparing(Recommend::getScore).reversed().thenComparing(Recommend::getName));
        List<String> ans = new ArrayList<>();
        if(list.size()>5)list=list.subList(0,5);
        for(Recommend r : list){
            ans.add(r.getName());
        }
        return ans;
    }
}
