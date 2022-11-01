package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = makeFriendList(user, friends);
        return answer;
    }

    public static List<String> makeFriendList(String user, List<List<String>> friends){
        List<String> friendList = new ArrayList<>();
        friends.stream()
                .filter(f->f.get(0).equals(user))
                .forEach(f->friendList.add(f.get(1)));
        friends.stream()
                .filter(f->f.get(1).equals(user))
                .forEach(f->friendList.add(f.get(0)));

        return friendList;
    }

}


