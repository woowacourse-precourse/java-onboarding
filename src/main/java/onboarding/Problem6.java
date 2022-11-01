package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (List<String> e : forms) {
            ArrayList<String> cutNameList = cutNickname(e.get(1));
            for (String cutName : cutNameList) {
                Boolean matchResult = isThereMatch(cutName);
                if (matchResult) {
                    answer.add(e.get(0));
                }
            }
        }
        return answer;
    }

    private static Boolean isThereMatch(String cutName) {
        String regex = ".*("+cutName+")+.*";
        for (List<String> e : forms) {
            System.out.println(e);
            String nickname = e.get(1);
            Boolean result = nickname.matches(regex);
            if (result) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> cutNickname(String nickname) {
        ArrayList<String> cutNameList = new ArrayList<> ();
        for (int i = 0; i < nickname.length() - 1; i++) {
            cutNameList.add(nickname.substring(i, i + 2));
        }
        return cutNameList;
    }
}
