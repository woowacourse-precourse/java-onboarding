/*
 *기능목록
 * 1. 문자 변환하는 함수
 * 2. 해석한 단어 만드는 함수
 */
package onboarding;

public class Problem4 {

    public static String solution(String word) {
        return convertWord(word);
    }

    public static String convertWord(String word) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            newWord.append(charReturnConvert(word.charAt(i)));
        }
        return newWord.toString();
    }

    public static char charReturnConvert(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + 'Z' - c);
        } else if (c >= 'a' && c <= 'z') {
            return (char) ('a' + 'z' - c);
        }
        return c;
    }
}
