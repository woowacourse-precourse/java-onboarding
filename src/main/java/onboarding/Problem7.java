package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        LinkedHashMap<String, Integer> countingMap = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {
            List friendsList = friends.get(i);

//            System.out.println("--------------");
//            System.out.println(friendsList);

            for (int j = 0; j < 2; j++) {
                String friendName = (String) friendsList.get(j);
                String pairName = getPairName(friendsList, j);
//                System.out.println("--------------");
//                System.out.println(friendName);
//                System.out.println(pairName);
                for (int k = 0; k < friends.size(); k++) {
                    if (k == i) {
                    } else {
                        List otherFriendsList = friends.get(k);
                        if (otherFriendsList.contains(friendName) == true && otherFriendsList.contains(user) == true) {
                            break;
                        } else if ( pairName == user){
                            break;
                        }else if (otherFriendsList.contains(pairName) == true && otherFriendsList.contains(user) == true) {
                            countingMap.merge(friendName, 10, (integer, integer2) -> integer + integer2);
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