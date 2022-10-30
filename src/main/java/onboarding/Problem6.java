package onboarding;

import java.util.List;
import java.util.HashSet;

public class Problem6 {
    static HashSet<String> twoWordPartOfNickname = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
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
            twoWordPartOfNickname.add(twoWord);
        }
    }
}
