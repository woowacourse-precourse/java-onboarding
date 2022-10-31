package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String,Integer> recommendPoint = new HashMap<>();
    public static void calculatePoint(String target, Integer point){
        if(!recommendPoint.containsKey(target)){ //add
            recommendPoint.put(target,0);
        }
        recommendPoint.replace(target, recommendPoint.get(target)+ point);
    }

    public static String getAnotherOne(List<String> Options, String one){
        if(Options.indexOf(one) == 0){
            return Options.get(1);
        }
        return Options.get(0);
    }
    public static List<String> getUserFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).contains(user)){
                String userFriend = getAnotherOne(friends.get(i),user);
                userFriends.add(userFriend);
            }
        }
        return userFriends;
    }

    public static List<String> sortByValueThenKey(HashMap<String, Integer> recommendPoint){
        // 1
        List<String> keySet = new ArrayList<>(recommendPoint.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(recommendPoint.get(o1).compareTo(recommendPoint.get(o2)) == 0){
                    return o1.compareTo(o2);
                }
                return recommendPoint.get(o2).compareTo(recommendPoint.get(o1)); //내림차순
            }
        });
        return keySet;
    }
    
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
