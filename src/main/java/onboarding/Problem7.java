package onboarding;

import javax.swing.*;
import java.util.*;
import java.util.logging.Handler;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> friendInfo = makeFriendInfo(friends);
        System.out.println(friendInfo);
        return answer;
    }
    // 1. HashMap에 유저마다 친구정보 저장
    public static HashMap<String, List<String>> makeFriendInfo(List<List<String>> friends) {
        HashMap<String, List<String>> friendInfo = new HashMap<>();
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);
            toHash(friendInfo, userA, userB);
            toHash(friendInfo, userB, userA);
        }
        return friendInfo;
    }
    
    // 1-1. HashMap에 유저가 있다면 연장, 없다면 추가
    private static void toHash(HashMap<String, List<String>> friendInfo, String userA, String userB) {
        if (!friendInfo.containsKey(userA)) {
            friendInfo.put(userA, new ArrayList<String>(List.of(userB)));
        } else {
            List<String> originInfo = friendInfo.get(userA);
            originInfo.add(userB);
            friendInfo.replace(userA, originInfo);
        }
    }
}
