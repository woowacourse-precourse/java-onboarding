package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    //친구 관계 정보를 이용하여 각 유저별 친구목록을 만드는 기능
    public static HashMap<String, Set<String>> getFriendList(List<List<String>> friends) {
        //이름,친구목록 을 가지는 HashMap 생성
        HashMap<String, Set<String>> friendList = new HashMap<>();
        //친구목록을 생성해주는 부분
        for (List<String> currentFriendshipInfo : friends) {
            String friendA = currentFriendshipInfo.get(0);
            String friendB = currentFriendshipInfo.get(1);
            if (!friendList.containsKey(friendA)) {
                Set<String> tempSet = new HashSet<>();
                tempSet.add(friendB);
                friendList.put(friendA, tempSet);
            }
            if (!friendList.containsKey(friendB)) {
                Set<String> tempSet = new HashSet<>();
                tempSet.add(friendA);
                friendList.put(friendB, tempSet);
            }
            //A와 B가 친구라면 , B와 A도 친구이므로 각각 서로를 친구목록에 추가해준다.
            friendList.get(friendA).add(friendB);
            friendList.get(friendB).add(friendA);
        }

        return friendList;
    }


}
