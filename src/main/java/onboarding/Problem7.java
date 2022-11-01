package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        if (!verificationTotalCheck(user, friends, visitors)) {
            return answer = List.of("Check Restrictions");
        }

        HashMap<String, Integer> friendMap = getTotalUser(friends);

        Set<String> friendNameSet = friendMap.keySet();
        List<String> friendNameList = new ArrayList<>();
        Iterator<String> iterator = friendNameSet.iterator();
        while (iterator.hasNext()) {
            friendNameList.add(iterator.next());
        }

        int[][] matrix = fillMatrixByFriend(friends, friendNameList);

        int userIndex = friendNameList.indexOf(user);
        List<Integer> userFriendIndexes = getUserFriendIndexes(matrix, userIndex);
        List<String> userFriendList = changeIndexesToName(userFriendIndexes, friendNameList);

        List<Integer> matchFriendIndexes = matchFriendList(matrix, userFriendIndexes);
        List<String> matchFriendString = changeIndexesToName(matchFriendIndexes, friendNameList);

        friendMap = giveTenPoint(matchFriendString, friendMap);
        friendMap = giveOnePoint(visitors, friendMap);
        friendMap = deleteUserAndUserFriend(friendMap, userFriendList, user);

        answer = sortByScoreAndName(friendMap);

        if (answer.size() > 5) {
            answer = answer.subList(0, 5);
        }

        return answer;
    }

    public static boolean verificationTotalCheck(String user, List<List<String>> friends, List<String> visitors) {
        if (!verificationCheckAboutUser(user)) {
            return false;
        }
        if (!verificationCheckAboutFriends(friends)) {
            return false;
        }
        if (!verificationCheckAboutVisitors(visitors)) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutUser(String user) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutFriends(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutVisitors(List<String> visitors) {
        if (visitors.size() > 10000) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutID(String id) {
        String isLowerAlphaRegex = "^[a-z]*$";
        if(!id.matches(isLowerAlphaRegex)) {
            return false;
        }
        if(id.length() < 1 || id.length() > 30) {
            return false;
        }
        return true;
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
            if (matrix[userIndex][i] == 1) {
                friendIndexes.add(i);
            }
        }

        return friendIndexes;
    }

    public static List<Integer> matchFriendList(int[][] matrix, List<Integer> friendIndexes) {
        List<Integer> matchFriedIndexes = new ArrayList<>();

        for (Integer friendIndex : friendIndexes) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][friendIndex] == 1) {
                    matchFriedIndexes.add(i);
                }
            }
        }

        return matchFriedIndexes;
    }

    public static List<String> changeIndexesToName(List<Integer> indexes, List<String> nameList) {
        List<String> names = new ArrayList<>();

        for (Integer index : indexes) {
            names.add(nameList.get(index));
        }

        return names;
    }

    public static HashMap<String, Integer> giveTenPoint(List<String> nameList, HashMap<String, Integer> friendMap) {
        for (String name : nameList) {
            friendMap.put(name, friendMap.getOrDefault(name, 0) + 10);
        }
        return friendMap;
    }

    public static HashMap<String, Integer> giveOnePoint(List<String> visitors, HashMap<String, Integer> friendMap) {
        for (String visitor : visitors) {
            friendMap.put(visitor, friendMap.getOrDefault(visitor, 0) + 1);
        }
        return friendMap;
    }

    public static HashMap<String, Integer> deleteUserAndUserFriend(HashMap<String, Integer> friendMap,
                                                                   List<String> frinedNameList, String user) {
        friendMap.put(user, 0);
        for (String friendName : frinedNameList) {
            friendMap.put(friendName, 0);
        }
        return friendMap;
    }

    public static List<String> sortByScoreAndName(HashMap<String, Integer> friendMap) {
        List<Integer> scoreList = new ArrayList(friendMap.values());
        Collections.sort(scoreList, Collections.reverseOrder());

        List<String> sortedList = new ArrayList<>();
        for (Integer score : scoreList) {
            if (score != 0) {
                List<String> nameList = findNameByValue(friendMap, score);
                for (String name : nameList) {
                    {
                        if (!sortedList.contains(name)) {
                            sortedList.add(name);
                        }
                    }
                }
            }
        }

        return sortedList;
    }

    public static List<String> findNameByValue(HashMap<String, Integer> friendMap, int score) {
        List<String> nameList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : friendMap.entrySet()) {
            if (entry.getValue().equals(score)) {
                nameList.add(entry.getKey());
            }
        }

        Collections.sort(nameList);
        return nameList;
    }
}
