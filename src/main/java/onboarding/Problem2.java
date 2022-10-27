package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 오류 시 error 반환은 스스로 판단하여 구현한 것.
        if (!isValidate(cryptogram)) {
            return "error";
        }
        String answer = "answer";
        return answer;
    }

    /**
     * 제한사항 검증하는 기능
     */
    public static boolean isValidate(String cryptogram) {
        return (validateLength(cryptogram) && isLowerCase(cryptogram));
    }

    private static boolean validateLength(String cryptogram) {
        int length = cryptogram.length();
        return (length > 0 && length < 1001);
    }

    private static boolean isLowerCase(String cryptogram) {
        char[] cryptoTemp = cryptogram.toCharArray();
        for (char ch : cryptoTemp) {
            if (!isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerCase(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }
}
