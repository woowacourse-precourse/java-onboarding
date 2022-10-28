package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = removeDuplicate(cryptogram);
        return answer;
    }

    // 중복 문자열이 없을때까지 중복 문자열 제거
    private static String removeDuplicate(String str) {

        boolean isDup = false;
        char preChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && isSame(preChar, str.charAt(i))) {
                str = str.substring(0,i-1) + str.substring(i+1);
                isDup = true;
                break;
            }
            preChar = str.charAt(i);
        }
        if (isDup) str = removeDuplicate(str);
        return str;
    }

    private static boolean isSame(char origin, char target) {
        return origin == target;
    }
}
