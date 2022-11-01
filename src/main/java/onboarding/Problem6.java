package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        for (List<String> e : forms) {
            Boolean matchResult = isThereMatch(e.get(1));
        }

        return answer;
    }

    private static Boolean isThereMatch(String keyword) {
        String regex = ".*("+keyword+")+.*";
        for (List<String> e : forms) {
            System.out.println(e);
            String nickname = e.get(1);
            Boolean result = nickname.matches(regex);
            if (result == true) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> cutNickname(String nickname) {
        ArrayList<String> cutNameList = new ArrayList<> ();
        for (int i = 0; i < nickname.length() - 1; i++) {
            cutNameList.add(nickname.substring(i, i+2));
        return cutNameList;
    }
}
