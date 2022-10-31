package onboarding;

import onboarding.exceptions.LengthException;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> result;
    static String userName;

    static ArrayList<String> common;
    static void stringLengthCheck(String strIn) throws LengthException {
        if (strIn.length() < 1 || strIn.length() > 30) {
            throw new LengthException();
        }
    }
    static void friendsLengthCheck(List<List<String>> listIn) throws LengthException {
        if (listIn.size() > 10000) {
            throw new LengthException();
        }
    }
    static void visitorsLengthCheck(List<String> listIn) throws LengthException {
        if (listIn.size() > 10000) {
            throw new LengthException();
        }
    }

    static void visitorsCheck(List<String> visitors) {
        try {
            visitorsLengthCheck(visitors);
            for (String targetName : visitors) {
                stringLengthCheck(targetName);
                if (!common.contains(targetName)) {
                    result.putIfAbsent(targetName, 0);
                    result.put(targetName, result.get(targetName) + 1);
                }
            }
        } catch (LengthException e) {
            System.err.println("check the length of visitors or elements in visitors");
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
        try {
            friendsLengthCheck(friends);
            List<String[]> notCommon = commonCheck(friends);

            for (String[] notI : notCommon) {
                stringLengthCheck(notI[0]);
                stringLengthCheck(notI[1]);
                if (common.contains(notI[0]) && !common.contains(notI[1])) {
                    result.putIfAbsent(notI[1], 0);
                    result.put(notI[1], result.get(notI[1]) + 10);
                } else if (!common.contains(notI[0]) && common.contains(notI[1])) {
                    result.putIfAbsent(notI[0], 0);
                    result.put(notI[0], result.get(notI[0]) + 10);
                }
            }
        } catch (LengthException e) {
            System.err.println("check the length of friends or elements in friends");
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
        try {
            result = new HashMap<>();
            common = new ArrayList<>();
            stringLengthCheck(user);
            userName = user;
            friendsCheck(friends);
            visitorsCheck(visitors);

            return sorter();
        } catch (LengthException e) {
            System.err.println("check the length of user: " + user);
            return Collections.emptyList();
        }
    }
}
