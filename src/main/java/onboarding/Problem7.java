package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return topFive(user,friends,visitors);
    }

    static List<String> topFive(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,Integer> score=new HashMap<>();
        Set<String> userFriend=new HashSet<>();
        List<String> result=new ArrayList<>();
        for(List<String> pair : friends){
            if(pair.get(0)==user)userFriend.add(pair.get(1));
            if(pair.get(1)==user)userFriend.add(pair.get(0));
            if(!score.containsKey(pair.get(0)))score.put(pair.get(0),0);
            if(!score.containsKey(pair.get(1)))score.put(pair.get(1),0);
        }
        score=visitScore(userFriend,score,visitors);
        score=friendScore(userFriend,score,friends);
        int[] bigScore=new int[5];
        String[] bigFriend=new String[5];
        for (Map.Entry<String, Integer> candidate : score.entrySet()) {
            if(candidate.getValue()==0)continue;
            if(candidate.getKey()==user)continue;
            for(int i=0; i<5; i++){
                if(bigScore[i]<candidate.getValue()){
                    for(int j=4; j>i; j--){
                        bigScore[j]=bigScore[j-1];
                        bigFriend[j]=bigFriend[j-1];
                    }
                    bigScore[i]=candidate.getValue();
                    bigFriend[i]=candidate.getKey();
                    break;
                }
                else if(bigScore[i]==candidate.getValue()){
                    if(bigFriend[i].compareTo(candidate.getKey())==1){
                        for(int j=4; j>i; j--){
                            bigScore[j]=bigScore[j-1];
                            bigFriend[j]=bigFriend[j-1];
                        }
                        bigScore[i]=candidate.getValue();
                        bigFriend[i]=candidate.getKey();
                        break;
                    }
                }
            }
        }
        for(int i=0; i<5; i++){
            if(bigScore[i]!=0)result.add(bigFriend[i]);
        }
        return result;
    }

    static Map<String,Integer> visitScore(Set<String> userFriend,Map<String,Integer> score, List<String> visitors){
        for(int i=0; i<visitors.size(); i++){
            if(userFriend.contains(visitors.get(i)))continue;
            if(score.containsKey(visitors.get(i))){
                score.put(visitors.get(i),score.get(visitors.get(i))+1);
            }
            else{
                score.put(visitors.get(i),1);
            }
        }
        return score;
    }

    static Map<String,Integer> friendScore(Set<String> userFriend, Map<String,Integer> score,List<List<String>> friends)
    {
        for(List<String> pair : friends){
            if(userFriend.contains(pair.get(0))){
                score.put(pair.get(1),score.get(pair.get(1))+10);
            }
            if(userFriend.contains(pair.get(1))){
                score.put(pair.get(0),score.get(pair.get(0))+10);
            }
        }
        return score;
    }
}
