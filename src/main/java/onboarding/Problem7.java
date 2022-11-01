package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //기능1. 사용자의 친구 목록
    public static List<String> userFriends(String user, List<List<String>> friends){
        HashSet<String> userFri = new HashSet<>();

        for (List<String> fri: friends) {

            if(fri.get(0).equals(user)){
                userFri.add(fri.get(1));
            } else if (fri.get(1).equals(user)) {
                userFri.add(fri.get(0));
            }
        }

        List<String> userFriends = new ArrayList<>(userFri);

        return userFriends;
    }

    //기능2. 사용자가 모르는 친구 목록
    public static List<String> notFriends(String user, List<String> userFriends, List<List<String>> friends, List<String> visitors){
        HashSet<String> notFri = new HashSet<>();

        for(List<String> fri: friends){
            notFri.add(fri.get(0));
            notFri.add(fri.get(1));
        }
        for(String fri : visitors){
            notFri.add(fri);
        }
        for(String fri : userFriends){
            notFri.remove(fri);
        }
        notFri.remove(user);

        List<String> notFriends = new ArrayList<>(notFri);
        return notFriends;
    }
}
