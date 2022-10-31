package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String,List<String>> network=getFriendList(friends);


        return answer;
    }

    //친구 목록 생성
    public static Map<String, List<String>> getFriendList(List<List<String>> friends){
        Map<String,List<String>> network=new HashMap<>();
        for(List<String> friend :friends){
            String f1=friend.get(0);
            String f2=friend.get(1);
            if(network.containsKey(f1)){
                network.get(f1).add(f2);
            }
            else{
                network.put(f1,new ArrayList<>(List.of(f2)));
            }

            if(network.containsKey(f2)){
                network.get(f1).add(f1);
            }
            else{
                network.put(f1,new ArrayList<>(List.of(f1)));
            }
        }
        return network;
    }
}
