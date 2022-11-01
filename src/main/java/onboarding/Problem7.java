package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> user_friends=new HashSet<>(); // 사용자의 친구들을 담은 Set
        Map<String,Integer> recommended_friends=new HashMap<>(); // (추천되는 친구:추천 점수) 형태의 Map
        for(List<String> i:friends){ // 사용자의 친구 구하기
            if(i.get(0).equals(user)){
                user_friends.add(i.get(1));
            }
            else if (i.get(1).equals(user)) {
                user_friends.add(i.get(0));
            }
        }
        System.out.println(user_friends);
        for(List<String> i:friends){ // 사용자와 함께 아는 친구의 수 한 명 당 추천 점수 +10
            if(!user_friends.contains(i.get(0)) && !i.get(0).equals(user) && !recommended_friends.containsKey(i.get(0))){
                recommended_friends.put(i.get(0),0);
            }
            if(!user_friends.contains(i.get(1)) && !i.get(1).equals(user) && !recommended_friends.containsKey(i.get(1))){
                recommended_friends.put(i.get(1),0);
            }
            if(user_friends.contains(i.get(0)) && recommended_friends.containsKey(i.get(1))){
                recommended_friends.put(i.get(1),recommended_friends.get(i.get(1))+10);
            }
            else if (user_friends.contains(i.get(1)) && recommended_friends.containsKey(i.get(0))) {
                recommended_friends.put(i.get(0),recommended_friends.get(i.get(0))+10);
            }
        }
        System.out.println(recommended_friends);
        for(String i:visitors){ // 사용자의 타임 라인에 방문한 횟수 당 추천 점수 +1
            if(!recommended_friends.containsKey(i) && !user_friends.contains(i)){
                recommended_friends.put(i,0);
            }
            if(recommended_friends.containsKey(i))
                recommended_friends.put(i,recommended_friends.get(i)+1);
        }
        System.out.println(recommended_friends);

        answer = new ArrayList<>(recommended_friends.keySet());
        answer.sort(new Comparator<String>(){
            public int compare(String s1, String s2) {
                if (recommended_friends.get(s1) > recommended_friends.get(s2)) return -1;
                else if (recommended_friends.get(s1) < recommended_friends.get(s2)) return 1;
                else {
                    return s1.compareTo(s2);
                }
            }
        });
        return answer;
    }
}
