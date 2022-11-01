package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static final int FIRST_FRIEND = 0;
    public static final int SECOND_FRIEND = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        if (!verificationTotalCheck(user, friends, visitors)) {
            return answer = List.of("Check Restrictions");
        }

        User target = new User(user, friends, visitors);
        target.setUserFriends();

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
        if (!id.matches(isLowerAlphaRegex)) {
            return false;
        }
        if (id.length() < 1 || id.length() > 30) {
            return false;
        }
        return true;
    }

    public static class User {
        String user;
        List<List<String>> friends;
        List<String> visitors;
        List<String> userFriends;

        User(String user, List<List<String>> friends, List<String> visitors) {
            this.user = user;
            this.friends = friends;
            this.visitors = visitors;
        }

        private void setUserFriends() {
            userFriends = new ArrayList<>();

            for (List<String> friend : friends) {
                String firstFriend = friend.get(FIRST_FRIEND);
                String secondFriend = friend.get(SECOND_FRIEND);

                if (firstFriend.equals(user)) {
                    userFriends.add(secondFriend);
                    continue;
                }
                if (secondFriend.equals(user)) {
                    userFriends.add(firstFriend);
                }
            }
        }
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
