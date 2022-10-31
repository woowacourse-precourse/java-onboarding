package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    static HashMap<String, Integer> twoWordPartOfNickname = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> answerSet = new HashSet<>();
        createTwoWordPartOfNicknameSet(forms);

        for (List<String> form : forms) {
            if (!isRightInput(form)) {
                continue;
            }
            String email = form.get(0);
            String nickname = form.get(1);
            for (String twoWord : twoWordPartOfNickname.keySet()) {
                if (twoWordPartOfNickname.get(twoWord) == 1) {
                    continue;
                }
                if (nickname.contains(twoWord)) {
                    answerSet.add(email);
                }
            }
        }
        List<String> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        return answer;
    }

    private static boolean isRightEmailDomain (String domain) {
        String rightDomain = "email.com";
        if (domain.equals(rightDomain)) {
            return true;
        }
        return false;
    }

    private static boolean isRightEmailAddress (String address) {
        if (address.length() > 0 && address.length() < 10) {
            return true;
        }
        return false;
    }

    private static boolean isRightNicknameLength (String nickname) {
        if (nickname.length() > 0 && nickname.length() < 20) {
            return true;
        }
        return false;
    }

    private static boolean isRightInput (List<String> crew) {
        boolean isRight = true;
        String[] email = crew.get(0).split("@");
        String emailAddress = email[0];
        String emailDomain = email[1];
        String nickname = crew.get(1);
        isRight &= isRightEmailAddress(emailAddress);
        isRight &= isRightEmailDomain(emailDomain);
        isRight &= isRightNicknameLength(nickname);
        return isRight;
    }

    private static void createTwoWordPartOfNickname (String nickname) {
        if (nickname.length() < 2) {
            return;
        }
        for (int i = 0 ; i < nickname.length() - 1; i++) {
            String twoWord = nickname.substring(i, i+2);
            if (twoWordPartOfNickname.containsKey(twoWord)) {
                twoWordPartOfNickname.put(twoWord, twoWordPartOfNickname.get(twoWord)+1);
            }
            else {
                twoWordPartOfNickname.put(twoWord, 1);
            }
        }
    }

    private static void createTwoWordPartOfNicknameSet (List<List<String>> crews) {
        for (List<String> crew : crews) {
            if (!isRightInput(crew)) {
                continue;
            }
            String nickname = crew.get(1);
            createTwoWordPartOfNickname(nickname);
        }
    }
}