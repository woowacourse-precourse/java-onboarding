package onboarding;

import java.util.*;

public class Problem7 {
    private static final int FRIEND_POINT = 10;
    private static final int VISIT_POINT = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!isValidate(user, friends, visitors)) {
            return Collections.emptyList();
        }
        return getAnswer(user, friends, visitors);
    }

    /**
     * 제한사항을 검증하는 기능
     */

    private static boolean isValidate(String user, List<List<String>> friends, List<String> visitors) {
        return (validateUser(user) &&
                validateFriends(friends) &&
                validateVisitors(visitors) &&
                isFriendToRecommendExist(user, friends, visitors)
        );
    }

    private static boolean validateUser(String user) {
        return (validateUserLength(user) && validateUserNickname(user));
    }

    private static boolean validateUserLength(String user) {
        return (user != null && user.length() > 0 && user.length() < 31);
    }

    private static boolean validateUserNickname(String user) {
        for (char ch : user.toCharArray()) {
            if (!isLowerAlpha(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerAlpha(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private static boolean validateFriends(List<List<String>> friends) {
        return (validateFriendsSize(friends.size()) &&
                validateEachFriend(friends) &&
                validateDuplicated(friends));
    }

    private static boolean validateFriendsSize(int size) {
        return (size > 0 && size < 10001);
    }

    private static boolean validateDuplicated(List<List<String>> friends) {
        Set<List<String>> dup = new HashSet<>();
        for (List<String> friend : friends) {
            if (dup.contains(friend)) {
                return false;
            }
            dup.add(friend);
        }
        return true;
    }

    private static boolean validateEachFriend(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (!validateFriendSize(friend.size())) {
                return false;
            }
            String id1 = friend.get(0);
            String id2 = friend.get(1);
            if (!validateUser(id1) || !validateUser(id2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateFriendSize(int size) {
        return (size == 2);
    }

    private static boolean validateVisitors(List<String> visitors) {
        return (validateVisitorsSize(visitors.size()) && validateVisitor(visitors));
    }

    private static boolean validateVisitorsSize(int size) {
        return (size >= 0 && size <= 10000);
    }

    private static boolean validateVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (!validateUser(visitor)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFriendToRecommendExist(String user, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (friend.get(1).equals(user)) {
                return true;
            }
        }
        return visitors.size() != 0;
    }

    /**
     * 추천친구 반환하는 기능
     */
    private static List<String> getAnswer(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> results = makeRecommendList(user, friends, visitors);
        results.sort(new RecommendListCompare());
        List<String> answer = new ArrayList<>();

        for (List<String> result : results) {
            answer.add(result.get(0));
            if (answer.size() == 5) {
                break;
            }
        }
        return answer;
    }

    private static List<List<String>> makeRecommendList(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> recommendList = new ArrayList<>();

        for (String friendToRecommend : getFriendsToRecommend(user, friends, visitors)) {
            List<String> result = new ArrayList<>();
            setFriendPoint(user, result, friendToRecommend, friends);
            setVisitPoint(result, visitors);
            recommendList.add(result);
        }
        return recommendList;
    }

    private static void setFriendPoint(String user, List<String> result, String friendToRecommend, List<List<String>> friends) {
        List<String> freindsList = getFreindsList(user, friends);
        for (List<String> friend : friends) {
            String target = friend.get(1);
            if (result.contains(friendToRecommend) && friendToRecommend.equals(target)) {
                String point = result.get(1);
                replacePoint(result, point, FRIEND_POINT);
                continue;
            }
            if (freindsList.contains(friend.get(0)) && friendToRecommend.equals(target)) {
                firstAdd(result, target, FRIEND_POINT);
            }
        }
    }

    private static void setVisitPoint(List<String> result, List<String> visitors) {
        for (String visitor : visitors) {
            if (result.contains(visitor)) {
                String point = result.get(1);
                replacePoint(result, point, VISIT_POINT);
                continue;
            }
            if (result.size() == 0) {
                firstAdd(result, visitor, VISIT_POINT);
            }
        }
    }

    private static List<String> getFreindsList(String user, List<List<String>> friends) {
        List<String> friendsList = new ArrayList<>();
        for (List<String> friend : friends) {
            String getFirst = friend.get(0);
            String getSecond = friend.get(1);

            String result = getFriend(user, getFirst, getSecond);
            addWithoutDup(friendsList, result);
        }
        return friendsList;
    }

    private static String getFriend(String user, String first, String second) {
        if (user.equals(first)) {
            return second;
        }
        if (user.equals(second)) {
            return first;
        }
        return "";
    }

    private static List<String> getFriendsToRecommend(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendsToRecommend = new ArrayList<>();
        for (List<String> friend : friends) {
            String candidate = friend.get(1);
            addWithoutDup(friendsToRecommend, candidate);
        }
        for (String visitor : visitors) {
            addWithoutDup(friendsToRecommend, visitor);
        }
        friendsToRecommend.remove(user);
        friendsToRecommend.removeAll(getFreindsList(user, friends));
        return friendsToRecommend;
    }

    private static class RecommendListCompare implements Comparator<List<String>> {

        @Override
        public int compare(List<String> list1, List<String> list2) {
            int point1 = toInt(list1.get(1));
            int point2 = toInt(list2.get(1));
            if (point1 != point2) {
                return Integer.compare(point2, point1);
            }
            String name1 = list1.get(0);
            String name2 = list2.get(0);
            return name1.compareTo(name2);
        }
    }

    private static void addWithoutDup(List<String> list, String target) {
        if (target.equals("")) {
            return;
        }
        list.remove(target);
        list.add(target);
    }

    private static void replacePoint(List<String> list, String point, int pointToAdd) {
        int intPoint = toInt(point);
        String newPoint = String.valueOf(intPoint + pointToAdd);
        list.remove(point);
        list.add(newPoint);
    }

    private static void firstAdd(List<String> list, String name, int point) {
        String sPoint = String.valueOf(point);
        list.add(name);
        list.add(sPoint);
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
