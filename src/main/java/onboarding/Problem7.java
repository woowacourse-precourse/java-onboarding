package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        int setFriendNameCount = 0;
        for (int i = 0; i < friends.size(); i++) {
            List friendsList = friends.get(i);

//            System.out.println("--------------");
//            System.out.println(friendsList);

            for (int j = 0; j < 2; j++) {
                String FriendName = (String) friendsList.get(j);
                String pairName = getPairName(friendsList, j);
//                System.out.println("--------------");
//                System.out.println(FriendName);
                for (int k = 0; k < friends.size(); k++) {
                    if (k == i) {
                    } else {
                        List otherFriendsList = friends.get(k);         // 기준 친구 리스트와 다른 친구리스트를 비교
                        if (otherFriendsList.contains(FriendName) == true) {
                            System.out.println(otherFriendsList);
                        }
                    }
                }
            }
        }
        List<String> answer = Collections.emptyList();
        return answer;
    }


    private static String getPairName(List friendsList, int j) {

        if (j == 0) {
            j = 1;
        } else if (j == 1) {
            j = 0;
        }
        String pairName = (String) friendsList.get(j);

        return pairName;
    }
}