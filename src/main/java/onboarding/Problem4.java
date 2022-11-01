package onboarding;

/**
 * 기능 목록
 * 1. 문자를 변환하는 기능
 *      1. 대문자라면 155에서 아스키 코드를 빼 반환하는 기능
 *      2. 소문자라면 219에서 아스키 코드를 빼 반환하는 기능
 *      3. 문자가 아니라면 그냥 반환하는 기능
 * 2. 변환된 문자를 합치는 기능
 */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // 문자를 변환하는 기능
    private static char changeSubWord(char subWord) {
        char changedSubWord = 0;
        if (Character.isUpperCase(subWord)) {
            changedSubWord = (char) (155 - (int) subWord);
        } else if (Character.isLowerCase(subWord)) {
            changedSubWord = (char) (219 - (int) subWord);
        } else {
            changedSubWord = subWord;
        }
        return changedSubWord;
    }
}
