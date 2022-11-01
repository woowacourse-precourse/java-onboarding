package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static Map<String, Integer> userMap = new HashMap<String, Integer>();
    public static Map<Integer, String> idMap = new HashMap<Integer, String>();
    public static Map<Integer, Integer> scoreMap = new HashMap<Integer, Integer>();
    public static Map<String, Integer> notFriendMap = new HashMap<String, Integer>();

    public static ArrayList<List<Integer>> friendEdge = new ArrayList<List<Integer>>();
    public static ArrayList<Integer> visitList = new ArrayList<Integer>();

    public static int userId = -1;

    public static void init(String user, List<List<String>> friends, List<String> visitors) {
        userMap.clear();
        friendEdge.clear();
        for (int i = 0; i < 10_003; i++) {
            friendEdge.add(new ArrayList<Integer>());
        }

        userId = getId(user);
        for (List<String> friend : friends) {
            int friend0Id = getId(friend.get(0));
            int friend1Id = getId(friend.get(1));
            friendEdge.get(friend0Id).add(friend1Id);
            friendEdge.get(friend1Id).add(friend0Id);
        }
        for (String visitor : visitors) {
            int visitorId = getId(visitor);
            visitList.add(visitorId);
        }
    }

    public static int getId(String name) {
        if (userMap.containsKey(name)) {
            return userMap.get(name);
        } else {
            int id = userMap.size();
            userMap.put(name, id);
            idMap.put(id, name);
            return id;
        }
    }

    public static int getSameElementCount(List<Integer> list1, List<Integer> list2) {
        int cnt = 0;
        int i = 0;
        int j = 0;
        Collections.sort(list1);
        Collections.sort(list2);
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) == list2.get(j)) {
                cnt++;
                i++;
                j++;
            } else if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return cnt;
    }

    public static boolean checkIsFriend(int a, int b) {
        if (friendEdge.get(a).contains(b))
            return true;
        return false;
    }

    public static void countSameFriend() {
        for (int i = 1; i < userMap.size(); i++) {
            int sameFriendCnt = getSameElementCount(friendEdge.get(userId), friendEdge.get(i));
            scoreMap.put(i, sameFriendCnt * 10);
        }
    }

    public static void countVisitor() {
        for (int i : visitList) {
            if (scoreMap.containsKey(i)) {
                scoreMap.put(i, scoreMap.get(i) + 1);
            } else {
                scoreMap.put(i, 1);
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        init(user, friends, visitors);

        countSameFriend();
        countVisitor();

        for (int i = 1; i < userMap.size(); i++) {
            if (!checkIsFriend(userId, i)) {
                notFriendMap.put(idMap.get(i), scoreMap.get(i));
            }
        }

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(
                notFriendMap.entrySet());
        Collections.sort(list_entries, (o1, o2) -> {
            int compare = o2.getValue().compareTo(o1.getValue());
            if (compare == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return compare;
        });

        for (Map.Entry<String, Integer> entry : list_entries) {
            answer.add(entry.getKey());
        }

        return answer;
    }
}
