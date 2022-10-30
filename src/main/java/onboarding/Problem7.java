package onboarding;

import java.util.*;

public class Problem7 {


    /**
     * 기능 정리
     * 1. friends정보를 가지고 HashMap<String,Set<String>을 사용하여 친구 관계 그래프 구현 후, user와 친구 관계인 node삭제 (후 user node 삭제 -> 삭제하면 안됨).
     * 2. 그리고 HashMap<String,Integer>을 사용하여 남은 node를 가지고 친 구관계 score 계산, visitors에 대해 score도 계산.
     * 4. HashMap<String,Integer>의 정보를 친구 정보 객체에 넣고 내림 정렬시킴.
     * */

    static Map<String, Set<String>> friendsGraph = new HashMap<>();
    static Map<String, Integer> friendsScore = new HashMap<>();

    //1. 기능1
    static void setFriendsGraph(List<List<String>> friends,String user){

        for(int i=0; i<friends.size(); i++){

            String friendsA = friends.get(i).get(0);
            String friendsB = friends.get(i).get(1);

            Set<String> innerSet = new HashSet<>();

            if(!friendsGraph.containsKey(friendsA)){ friendsGraph.put(friendsA,innerSet);}
            if(!friendsGraph.containsKey(friendsB)){ friendsGraph.put(friendsB,innerSet);}

            friendsGraph.get(friendsA).add(friendsB); // map은 put , set은 add를 사용한다.
            friendsGraph.get(friendsB).add(friendsA);
        }

        friendsGraph.get(user).forEach((removeFriends)->{
            friendsGraph.remove(removeFriends);
        });

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer =
        return answer;
    }
}
