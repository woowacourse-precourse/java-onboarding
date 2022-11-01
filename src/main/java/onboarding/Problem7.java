package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> getUserList(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allUserSet = new TreeSet<>();
        allUserSet.add(user);

        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            allUserSet.add(friend.get(0));
            allUserSet.add(friend.get(1));
        }
        for (int i = 0; i < visitors.size(); i++) {
            allUserSet.add(visitors.get(i));
        }

        List<String> allUserList = new ArrayList<>(allUserSet);

        return allUserList;
    }
    private static Map<String, Integer> mappingNameToNumber(List<String> allUserList) {
        Map<String, Integer> nameToNumber = new TreeMap<>();

        for (int i = 0; i < allUserList.size(); i++) {
            nameToNumber.put(allUserList.get(i), i + 1);
        }

        return nameToNumber;
    }
    private static Map<Integer, String> mappingNumberToName(List<String> allUserList) {
        Map<Integer, String> numberToName = new TreeMap<>();

        for (int i = 0; i < allUserList.size(); i++) {
            numberToName.put(i + 1, allUserList.get(i));
        }

        return numberToName;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> allUserList = getUserList(user, friends, visitors);

        Map<String, Integer> nameToNumber = mappingNameToNumber(allUserList);
        Map<Integer, String> numberToName = mappingNumberToName(allUserList);


        return allUserList;
    }




}
