package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashSet<String> userlist = new HashSet<>();
        HashSet<String> friendlist = new HashSet<>();
        HashMap<String, Integer> recommendlist = new HashMap<>();

        //1) user를 제외한 나머지 회원들의 이름 목록(HashSet)
        for(int i=0; i<friends.size(); i++){
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);
            userlist.add(name1);
            userlist.add(name2);
        }
        for(String name : visitors) userlist.add(name);
        userlist.remove(user);


        return answer;
    }
}