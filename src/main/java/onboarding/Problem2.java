package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = removeDuplicate(cryptogram);

        return answer;
    }

    // 중복 문자 제거
    private static String removeDuplicate(String str) {

        char lastChar = 0;
        boolean isRemoved = false;

        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && lastChar == str.charAt(i)) {
                str = str.substring(0, i - 1) + str.substring(i + 1);
                isRemoved = true;
                break;
            }
            lastChar = str.charAt(i);
        }

        if (isRemoved)
            str = removeDuplicate(str);

        return str;
    }
}