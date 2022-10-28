package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> result;
    static String userName;

    static ArrayList<String> common;

    static void visitorsCheck(List<String> visitors) {
        for (String targetName : visitors) {
            if (!common.contains(targetName)) {
                result.putIfAbsent(targetName, 0);
                result.put(targetName, result.get(targetName) + 1);
            }
        }
    }

    static List<String[]> commonCheck(List<List<String>> friends) {
        ArrayList<String[]> output = new ArrayList<>();

        for (List<String> friend : friends) {
            String[] curInfo = friend.toArray(new String[0]);
            if (curInfo[0].equals(userName)) {
                common.add(curInfo[1]);
            } else if (curInfo[1].equals(userName)) {
                common.add(curInfo[0]);
            } else {
                output.add(curInfo);
            }
        }
        return output;
    }

    static void friendsCheck(List<List<String>> friends) {
        List<String[]> notCommon = commonCheck(friends);

        for (String[] notI : notCommon) {
            if (common.contains(notI[0]) && !common.contains(notI[1])) {
                result.putIfAbsent(notI[1], 0);
                result.put(notI[1], result.get(notI[1]) + 10);
            } else if (!common.contains(notI[0]) && common.contains(notI[1])) {
                result.putIfAbsent(notI[0], 0);
                result.put(notI[0], result.get(notI[0]) + 10);
            }
        }
    }

    static List<String> sorter() {
        ArrayList<String> output = new ArrayList<>(result.keySet());
        output.sort(new Comparator<String>() {
            int temp;
            @Override
            public int compare(String o1, String o2) {
                if (result.get(o1) > result.get(o2)) {
                    temp = -1;
                } else if (result.get(o1).equals(result.get(o2))) {
                    temp = o1.compareTo(o2);
                }
                return temp;
            }
        });
        int len = output.size();
        if (len > 5) {
            for (int i = 5; i < len; i++) {
                output.remove(i);
            }
        }
        return output;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();
        result = new HashMap<>();
        common = new ArrayList<>();
        userName = user;
        friendsCheck(friends);
        visitorsCheck(visitors);

        return sorter();
    }
}
