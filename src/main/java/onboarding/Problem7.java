package onboarding;

import java.util.*;


public class Problem7 {
    private static int _first_user = 0;
    private static int _second_user = 1;
    private static int _visitor_point = 1;
    private static int _friend_point = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> usersPoint = new HashMap<>();

        List<String> userFriendList = getFriendList(user, friends);
        calcFriendPoint(user, userFriendList, friends, usersPoint);
        calcVisitorPoint(user, userFriendList, visitors, usersPoint);

        return getRecommendedList(usersPoint);
    }

    private static void calcFriendPoint(String user, List<String> myFriends
            , List<List<String>> friends, HashMap<String, Integer> usersPoint) {
        for (String myFriend : myFriends) {
            List<String> ffList = getFriendList(myFriend, friends);
            for (String ff : ffList) {
                if (user != ff && !isFriend(ff, myFriends)) {
                    setPoint(usersPoint, ff, _friend_point);
                }
            }
        }
    }

    private static void calcVisitorPoint(String user, List<String> myFriends
            , List<String> visitors, HashMap<String, Integer> usersPoint) {
        for (String visitor : visitors) {
            if (user != visitor && !isFriend(visitor, myFriends)) {
                setPoint(usersPoint, visitor, _visitor_point);
            }
        }
    }

    private static List<String> getRecommendedList(HashMap<String, Integer> usersPoint) {
        List<String> ret = new ArrayList<>();
        List<Map.Entry<String, Integer>> entry = sortRecommendedList(usersPoint);

        for(Map.Entry<String, Integer> entryElement: entry) {
            ret.add(entryElement.getKey());
            if (ret.size() == 5) {
                break;
            }
        }
        return ret;
    }

    private static List<String> getFriendList(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (isFriend(user, friend)) {
                myFriends.add(getMyFriend(user, friend));
            }
        }
        return myFriends;
    }

    private static String getMyFriend(String user, List<String> friend) {
        if (friend.get(_first_user) == user) {
            return friend.get(_second_user);
        }
        return friend.get(_first_user);
    }

    private static boolean isFriend(String user, List<String> friends) {
        for (String friend : friends) {
            if (friend == user) {
                return true;
            }
        }
        return false;
    }

    private static List<Map.Entry<String, Integer>> sortRecommendedList(HashMap<String, Integer> usersPoint) {
        List<Map.Entry<String, Integer>> entry = new ArrayList<>(usersPoint.entrySet());

        entry.sort((o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });
        return entry;
    }

    private static void setPoint(HashMap<String, Integer> usersPoint, String user, Integer n) {
        if (usersPoint.get(user) != null) {
            int point = usersPoint.get(user);
            usersPoint.put(user, point + n);
        } else {
            usersPoint.put(user, n);
        }
    }
}

