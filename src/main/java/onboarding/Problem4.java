/*
 *기능목록
 * 1. 문자 변환하는 함수
 * 2. 해석한 단어 만드는 함수
 */
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static String convertWord(String word) {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            newWord += charReturnConvert(word.charAt(i));
        }
        return newWord;
    }

    public static char charReturnConvert(char c) {
        if (c >= 65 && c <= 90) {
            return (char) (155 - c);
        } else if (c >= 97 && c <= 122) {
            return (char) (219 - c);
        }
        return c;
    }
}
