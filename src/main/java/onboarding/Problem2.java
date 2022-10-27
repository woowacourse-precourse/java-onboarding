package onboarding;

/*
    기능 명세
    1. delete_duplicate(String code) : 중복되는 문자를 제거하는 메소드
 */

public class Problem2 {
    public static String delete_duplicate(String code) {
        if (code.length() == 0) return code;

        boolean duplicate = false;
        boolean [] duplicate_idx = new boolean[code.length()];
        char previous = code.charAt(0);

        for (int i = 1; i < code.length(); i++) {
            char now = code.charAt(i);
            if (previous == now) {
                duplicate_idx[i - 1] = true;
                duplicate_idx[i] = true;
                duplicate = true;
            }
            previous = now;
        }

        StringBuilder newCode = new StringBuilder();

        for (int i = 0; i < code.length(); i++)
            if (!duplicate_idx[i]) newCode.append(code.charAt(i));

        if (!duplicate) return code;
        else return delete_duplicate(newCode.toString());
    }

    public static String solution(String cryptogram) {
        return delete_duplicate(cryptogram);
    }
}
