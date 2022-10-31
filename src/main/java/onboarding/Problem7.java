package onboarding;

import java.util.*;

public class Problem7 {

    static class Name {
        String id;

        Name(String id) throws Exception {
            if (!isValidId(id)) {
                throw new Exception("잘못된 ID");
            }
            this.id = id;
        }

    }

    static boolean isValidIdLength(int n) {
        return n >= 1 && n <= 30;
    }

    static boolean isValidId(String s) {
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            result = isSmallLetter(s.charAt(i), result);
        }
        return result;
    }

    private static boolean isSmallLetter(char c, boolean result) {
        if (!result) {
            return false;
        }

        return c >= 'a' && c <= 'z';
    }

    static boolean isValidFriendsListLength(int n) {
        return n >= 1 && n <= 10_000;
    }

    static boolean isValidVisitorsListLength(int n) {
        return n >= 1 && n <= 10_000;
    }

    static HashMap<String, HashSet<String>> hashMap = new HashMap<>();
    static HashSet<String> userFriends = new HashSet<>();
    static HashMap<String, Integer> answerMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Name name;
        try {
            name = new Name(user);
        } catch (Exception e) {
            return Collections.emptyList();
        }
        user = name.id;
        if (!isValidFriendsListLength(friends.size())) return Collections.emptyList();
        if (!isValidVisitorsListLength(visitors.size())) return Collections.emptyList();

        for (List<String> friend : friends) {
            putHashMap(friend, user);
        }

        for (Map.Entry<String, HashSet<String>> stringHashSetEntry : hashMap.entrySet()) {
            countDuplicateFriends(stringHashSetEntry);
        }

        for (String visitor : visitors) {
            visitorScore(visitor);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(answerMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue()-o2.getValue()>0) {
                    return -1;
                } else if (o1.getValue() - o2.getValue() < 0) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());

            }
        });
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
            answer.add(stringIntegerEntry.getKey());
        }

        return answer;
    }

    private static void countDuplicateFriends(Map.Entry<String, HashSet<String>> stringHashSetEntry) {
        if (userFriends.contains(stringHashSetEntry.getKey())) {
            return;
        }
        HashSet<String> hashSet = stringHashSetEntry.getValue();
        for (String s : hashSet) {
            duplicateFriendsScore(stringHashSetEntry.getKey(), s);
        }
    }

    private static void duplicateFriendsScore(String nonFriends, String otherUser) {
        if (userFriends.contains(otherUser)) {
            int temp = answerMap.getOrDefault(nonFriends, 0) + 10;
            answerMap.put(nonFriends, temp);
        }
    }

    private static void putHashMap(List<String> strings, String user) {
        String a = strings.get(0);
        String b = strings.get(1);
        if (a.equals(user)) {
            userFriends.add(b);
            return;
        } else if (b.equals(user)) {
            userFriends.add(a);
            return;
        }

        HashSet<String> temp = hashMap.getOrDefault(a, new HashSet<>());
        temp.add(b);
        hashMap.put(a, temp);

        temp = hashMap.getOrDefault(b, new HashSet<>());
        temp.add(a);
        hashMap.put(b, temp);
    }

    private static void visitorScore(String s) {
        if(!userFriends.contains(s))
        {
            int temp = answerMap.getOrDefault(s,0)+1;
            answerMap.put(s, temp);
        }
    }
}
