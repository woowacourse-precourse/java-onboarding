package onboarding;

public class Problem4 {

    /**
     * 주어진 문자열을 거꾸로 뒤집는 함수입니다.
     */
    public static String reverseString(String word) {
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            // 1. 알파벳 대문자
            if (current >= 'A' && current <= 'Z') {
                int index = current - 'A';
                index = 25 - index;
                result += (char)('A' + index);
            }
            // 2. 알파벳 소문자
            else if (current >= 'a' && current <= 'z') {
                int index = current - 'a';
                index = 25 - index;
                result += (char)('a' + index);
            }
            // 3. 그 외 문자
            else result += current;
        }

        return result;
    }
    public static String solution(String word) {
        return reverseString(word);
    }
}





