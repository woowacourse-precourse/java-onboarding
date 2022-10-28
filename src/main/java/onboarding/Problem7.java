package onboarding;

import java.util.*;

public class Problem7 {
    public static final int FRIEND_POINT = 20;
    public static final int ZERO_POINT = 0;
    public static final int ONE_POINT = 1;
    public static List<String> userFriend = new ArrayList<>();
    public static Map<String, Integer> sameFriend = new HashMap<>();
    public static String currentUser;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initUser(user);

        searchUserFriend(friends);
        searchSameFriend(friends);
        searchVisitor(visitors);

        List<String> answer = makeOrder();
        return answer;
    }

    public static void initUser(String user) {
        currentUser = user;
    }

    public static List<String> addResult(List<Map.Entry<String, Integer>> listEntries) {
        List<String> result = new ArrayList<>();
        List<String> sameValueList = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < listEntries.size(); i++) {

            if (count >= 5) {
                break;
            }

            Map.Entry<String, Integer> entry = listEntries.get(i);
            int target = entry.getValue();

            for (int j = i + 1; j < listEntries.size(); j++) {
                if (listEntries.get(j).getValue() == target) {
                    sameValueList.add(listEntries.get(j).getKey());
                }
            }
            if (!sameValueList.isEmpty()) {
                sameValueList.add(listEntries.get(i).getKey());
                i+=(sameValueList.size()-1);
                Collections.sort(sameValueList);

                for (int z = 0; z < sameValueList.size(); z++) {
                    result.add(sameValueList.get(z));
                    count++;
                }

                sameValueList.clear();

            } else {
                result.add(entry.getKey());
                count++;
            }
        }

        return result;
    }

    private static List<String> makeOrder() {
        List<Map.Entry<String, Integer>> listEntries = new ArrayList<Map.Entry<String, Integer>>(sameFriend.entrySet());

        Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        return addResult(listEntries);
    }

    private static void searchVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if(!isSameWithUserFriend(visitor)) {
                checkNameInSameFriend(visitor);
                addNameInSameFriend(visitor,ONE_POINT);
            }
        }
    }

    public static void searchSameFriend(List<List<String>> friends) {
        for (List<String> list : friends) {
            checkUserFriends(list);
        }
    }

    private static void checkUserFriends(List<String> list) {
        for (String name : list) {
            checkSameFriend(name);
        }
    }

    private static void checkSameFriend(String name) {
        if (!isSameWithUser(name) && !isSameWithUserFriend(name)) {
            checkNameInSameFriend(name);
            addNameInSameFriend(name, FRIEND_POINT);
        }
    }

    private static void addNameInSameFriend(String name, int point) {
        sameFriend.put(name, sameFriend.get(name) + point);
    }

    private static void checkNameInSameFriend(String name) {
        if (!isContainName(name)) {
            sameFriend.put(name, ZERO_POINT);
        }
    }

    private static boolean isContainName(String name) {
        return sameFriend.containsKey(name);
    }

    public static boolean isSameWithUserFriend(String name) {
        return userFriend.contains(name);
    }

    public static boolean isSameWithUser(String name) {
        return name.equals(currentUser);
    }

    public static void searchUserFriend(List<List<String>> friends) {
        for (List<String> list : friends) {
            findUserFriends(list);
        }
    }

    public static void findUserFriends(List<String> list) {
        for (String friend : list) {
            addUserFriend(friend, list);
        }
    }

    public static void addUserFriend(String friend, List<String> list) {
        if (checkUserFriend(friend, list)) {
            userFriend.add(friend);
        }
    }

    public static boolean checkUserFriend(String friend, List<String> list) {
        return (list.contains(currentUser) && !friend.equals(currentUser));
    }
}