package onboarding;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem2 {
    /**
     * 암호문을 input으로 전달하면 복호화하여 리턴하는 메서드이다.
     *
     * @param : String, 암호문
     * @return : String, 복호화된 문자열
     */
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);
        return answer;
    }

    /**
     * 암호문을 복호화하는 메서드이다.
     *
     * @param : String, 암호문
     * @return : String, 복호화된 문자열
     */
    public static String decrypt(String encrypt) {
        boolean isNotEnd = true;

        while (isNotEnd) {
            StringBuilder result = new StringBuilder();
            boolean[] isDeleted = new boolean[encrypt.length()];
            isNotEnd = false;

            for (int idx = 1, size = encrypt.length(); idx < size; idx++) {
                if (encrypt.charAt(idx - 1) == encrypt.charAt(idx)) {
                    isDeleted[idx - 1] = true;
                    isDeleted[idx] = true;
                    isNotEnd = true;
                }
            }

            for (int idx = 0, size = encrypt.length(); idx < size; idx++) {
                if (isDeleted[idx] == false) result.append(encrypt.charAt(idx));
            }

            encrypt = result.toString();
        }

        return encrypt;
    }
}
