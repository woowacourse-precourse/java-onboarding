package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }
        return answer;
    }

    private static void checkNicknames(List<String> nicknames) {
        for (int i = 0; i < nicknames.size()-1; i++) {
            String nowChecking = nicknames.get(i);
            List<String> others = new ArrayList<>(nicknames.subList(i+1,nicknames.size()));
            for (String other : others) {
                boolean doubleTF = isDouble(nowChecking, other);
            }
        }
    }

    private static boolean isDouble(String nowChecking, String otherNickname) {
        boolean doubleTF = false;
        return doubleTF;
    }
}
