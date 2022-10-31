package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Point.calcFriendsPoint(user, friends);
        return answer;
    }
}

class Point{
    static LinkedHashMap<> point = new LinkedHashMap();

    static void calcFriendsPoint(String user, List<List<String>> friends) {
        Map<String, String> friendsInfo = new TreeMap<>();

//        Deprecated
        for (List<String> emailObject : friends) {
            String baseUser = emailObject.get(0);
            String matchFriends = emailObject.get(1);
            friendsInfo.put(baseUser, matchFriends);
        }


        int[] scoreTable = new int[friends.size()];
        int[][] friendsInfoTable = getFriendsInfoTable(friends);
        int userIndex = getUserIndex(user, countFriends(friends));
        for (int i = 0; i < friendsInfoTable.length; i++) {
            if(friendsInfoTable[userIndex][i] == 1) {
                scoreTable[i] += 10;
            }
        }

    }

    private static int getUserIndex(String user, Object[] friendsInfoTable) {
        for (int i = 0; i < friendsInfoTable.length; i++) {
            if(friendsInfoTable[i].equals(user)){
                return i;
            }
        }
        return -1;
    }

    private static Object[] countFriends(List<List<String>> friends) {
        HashSet<String> countFriendsSet = new HashSet<String>();
        for (List<String> emailObject : friends) {
            countFriendsSet.add(emailObject.get(0));
            countFriendsSet.add(emailObject.get(1));
        }
        return countFriendsSet.toArray();
    }

        private static int[][] getFriendsInfoTable(List<List<String>> friends) {
            int[][] arr = new int[friends.size()][friends.size()];

            for (List<String> emailObject : friends) {
                String baseUser = emailObject.get(0);
                String matchFriends = emailObject.get(1);
                Object[] objects = countFriends(friends);
                int baseIndex = -1;
                int matchIndex = -1;
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i].equals(baseUser)) {
                        baseIndex = i;
                    }
                    if (objects[i].equals(matchFriends)) {
                        matchIndex = i;
                    }
                    if (baseIndex != -1 & matchIndex != -1) {
                        arr[baseIndex][matchIndex] = 1;
                        arr[matchIndex][baseIndex] = 1;
                    }
                }
            }
        return arr;
        }
    }