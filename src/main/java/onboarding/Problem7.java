package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> friendList = getTotalUser(friends);

        Set<String> friendNameSet = friendList.keySet();
        List<String> friendNameList = new ArrayList<>();
        Iterator<String> iterator = friendNameSet.iterator();
        while (iterator.hasNext()) {
            friendNameList.add(iterator.next());
        }

        int[][] matrix = fillMatrixByFriend(friends, friendNameList);

        int userIndex = friendNameList.indexOf(user);
        List<Integer> userFriendIndexes = getUserFriendIndexes(matrix, userIndex);

        return answer;
    }

    public static HashMap<String, Integer> getTotalUser(List<List<String>> friends) {
        HashMap<String, Integer> userList = new HashMap<>();

        for (List<String> friend : friends) {
            userList.put(friend.get(0), 0);
            userList.put(friend.get(1), 0);
        }

        return userList;
    }

    public static int[][] fillMatrixByFriend(List<List<String>> friends, List<String> friendNameList) {
        int[][] matrix = new int[friendNameList.size()][friendNameList.size()];

        for (List<String> friend : friends) {
            int x = friendNameList.indexOf(friend.get(0));
            int y = friendNameList.indexOf(friend.get(1));

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        return matrix;
    }

    public static List<Integer> getUserFriendIndexes(int[][] matrix, int userIndex) {
        List<Integer> friendIndexes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[userIndex][i] == 1) {
                friendIndexes.add(i);
            }
        }

        return friendIndexes;
    }
}
