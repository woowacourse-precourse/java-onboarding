package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();


        List<String> emailList = new ArrayList<>(emailSet);
        Collections.sort(emailList);
        return emailList;
    }

    private static boolean isDuplicated(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            if (name2.contains(name1.substring(i, i+2)))
                return true;
        }
        return false;
    }
}
