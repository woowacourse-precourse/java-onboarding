package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
*   구현 기능
*   1. user의 친구 리스트를 만들어주는 기능
*   2. 친구 리스트에 있는 친구의 친구를 찾아주는 기능
*   3. 사용자와 함께 아는 친구의 점수를 추가해주는 기능
*   4. 방문자 점수를 추가해주는 기능
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
*   구현 기능
*   1. user의 친구 리스트 만드는 기능
*   2. 친구의 친구 찾는 기능
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
    public static String findMyFriends( String myname, List<String> friends){
        String myfriend = "";
        if(friends.contains(myname)){
            if(friends.get(0).equals(myname)) {
                myfriend= friends.get(1);
            }
            else if(friends.get(1).equals(myname)){
                myfriend = friends.get(0);
            }
        }
        return myfriend;
    }

    public static List<String> findUserFrinds(String user, List<List<String>> friends){
        List<String> userfriends= new ArrayList<>();
        for (int i=0; i< friends.size(); i++) {
            String uesrfriend = findMyFriends(user, friends.get(i));
            if (!uesrfriend.isEmpty()) {
                userfriends.add(findMyFriends(user, friends.get(i)));
            }
        }
        return userfriends;
    }

}
