package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuffer sb = Problem2.getStringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            incodeIndexOf(i, sb);
        }
        answer = sb.toString();
        return answer;
    }
    /** 특정 인덱스를 규칙에 맞게 인코딩하는 함수 */
    private static void incodeIndexOf(int index, StringBuffer sb) {
        char indexChar = sb.charAt(index);
        char reversedChar = ' ';
        if ('a' <= indexChar || indexChar <= 'z') {
            reversedChar = (char)('a' + 'z' - indexChar);
        }
        if ('A' <= indexChar || indexChar <= 'Z') {
            reversedChar = (char)('A' + 'Z' - indexChar);
        }
        sb.replace(index, index + 1, String.valueOf(reversedChar));
        return;
    }
}
