package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem6 {

    private static ArrayList<String> duplicatedUserList;

    public static List<String> solution(List<List<String>> forms) {
        duplicatedUserList = new ArrayList<>();

        findDuplicatedUser(makeUserMap(forms));
        Collections.sort(duplicatedUserList);

        return duplicatedUserList.stream().distinct().collect(Collectors.toList());
    }

    private static void findDuplicatedUser(Map<String, Set<String>> userMap) {
        for (String user : userMap.keySet()) {
            compareUsers(userMap, user);
        }
    }

    private static void compareUsers(Map<String, Set<String>> userMap, String comparator) {
        Set<String> userSubChars, comparatorChars;

        for (String user : userMap.keySet()) {
            userSubChars = userMap.get(user);
            comparatorChars = userMap.get(comparator);

            boolean checkDuplication = findDuplicationByNicknameSet(userSubChars, comparatorChars);

            if (user.equals(comparator) || !checkDuplication) continue;

            duplicatedUserList.add(user);
            duplicatedUserList.add(comparator);
        }
    }

    private static boolean findDuplicationByNicknameSet(Set<String> setA, Set<String> setB) {
        Set<String> setC = new HashSet<>(setA);
        setC.retainAll(setB);

        return setC.size() >= 1;
    }

    private static Map<String, Set<String>> makeUserMap(List<List<String>> users) {

        Map<String, Set<String>> userMap = new HashMap<>();
        String email, nickname;

        for (List<String> user : users) {
            email = user.get(0);
            nickname = user.get(1);

            if (nickname.length() == 1) continue;

            userMap.put(email, createNicknameCharSet(nickname));
        }
        return userMap;
    }

    private static Set<String> createNicknameCharSet(String nickname) {
        Set<String> nicknameSet = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            nicknameSet.add(nickname.substring(i, i + 2));
        }

        return nicknameSet;
    }
}
