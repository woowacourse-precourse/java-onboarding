package onboarding;

public class Problem2 {
    public static String solve(String code) {
        if (code.length() == 0) {
            return code;
        }

        boolean findContinuous = false;
        boolean[] continuous = new boolean[code.length()];
        char previousCharacter = code.charAt(0);

        for (int i = 1; i < code.length(); i++) {
            char nowCharacter = code.charAt(i);

            if (previousCharacter == nowCharacter) {
                continuous[i - 1] = true;
                continuous[i] = true;
                findContinuous = true;
            }

            previousCharacter = nowCharacter;
        }

        StringBuilder newCode = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            if (!continuous[i]) {
                newCode.append(code.charAt(i));
            }
        }

        if (!findContinuous) { // 연속된 문자열을 찾지 못했으면
            return code;
        } else { // 연속된 문자열을 찾았으면
            return solve(newCode.toString());
        }
    }

    public static String solution(String cryptogram) {
        return solve(cryptogram);
    }
}
