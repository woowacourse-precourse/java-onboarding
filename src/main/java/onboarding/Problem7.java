package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    //사용자 친구 찾기
    private static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for(List<String> item : friends){
            if(item.contains(user))
                list.add(item.get(1 - item.indexOf(user)));
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

}
