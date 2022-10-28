package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> friendsWithUser = new ArrayList<>();
    public static Map<String, Integer> sameFriendWithUser = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        addFriendsWithUser(user, friends);
        findSameFriendWithUser(user, friends);
        findVisitor(visitors);

        List<String> answer = makeOrder();
        return answer;
    }

    public static List<String> addResult(List<Map.Entry<String, Integer>> listEntries) {
        List<String> result = new ArrayList<>();
        List<String> sameValueList = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < listEntries.size(); i++) {

            if(count>=5){
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
        List<Map.Entry<String, Integer>> listEntries = new ArrayList<Map.Entry<String, Integer>>(sameFriendWithUser.entrySet());

        Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        return addResult(listEntries);
    }

    private static void findVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (!friendsWithUser.contains(visitor)) {
                if (sameFriendWithUser.containsKey(visitor)) {
                    sameFriendWithUser.replace(visitor, sameFriendWithUser.get(visitor) + 1);
                } else {
                    sameFriendWithUser.put(visitor, 1);
                }
            }

        }
    }

    public static void findSameFriendWithUser(String user, List<List<String>> friends) {
        for (List<String> list : friends) {
            for (String friendWithUser : friendsWithUser) {
                if (list.contains(friendWithUser)) {
                    for (String friend : list) {
                        if (!friend.equals(user) && !friend.equals(friendWithUser)) {
                            if (sameFriendWithUser.containsKey(friend)) {
                                sameFriendWithUser.replace(friend, sameFriendWithUser.get(friend) + 20);
                            } else {
                                sameFriendWithUser.put(friend, 20);

                            }
                        }
                    }
                }
            }
        }
    }

    public static void addFriendsWithUser(String user, List<List<String>> friends) {
        for (List<String> list : friends) {
            if (list.contains(user)) {
                for (String friend : list) {
                    if (!friend.equals(user)) {
                        friendsWithUser.add(friend);
                    }
                }
            }
        }
    }
}