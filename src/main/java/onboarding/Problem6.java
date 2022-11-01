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
            String checkingNickname = nicknames.get(i);
            List<String> checkingNicknameSlices = devideIntoTwo(checkingNickname);
            List<String> others = new ArrayList<>(nicknames.subList(i+1,nicknames.size()));
            for (String other : others) {
                for (String nowChecking : checkingNicknameSlices) {
                    boolean tf = isDuplicated(nowChecking, other);
                }
            }
        }
    }

    private static boolean isDuplicated(String nowChecking, String otherNickname) {
        boolean tf = otherNickname.contains(nowChecking);
        return tf;
    }

    private static List<String> devideIntoTwo(String nickname) {
        List<String> twoLetters = new ArrayList<>();
            for (int i = 0; i < nickname.length() - 1; i++) {
                String slicedStr = nickname.substring(i, i + 1);
                if (!twoLetters.contains(slicedStr)) {
                    twoLetters.add(slicedStr);
                }
            }
        return twoLetters;
    }
}
