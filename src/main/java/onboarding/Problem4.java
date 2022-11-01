package onboarding;

/**
 * 기능목록
 * 1. 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 청개구리 사전을 기반으로 문자를 변환해주는 기능
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += changeWord(word.charAt(i));
        }
        return answer;
    }

    /**
     * 기능 1
     * @param word
     * @return 변환된 문자
     */
    private static char changeWord(char word) {
        int num = (int)word;
        if (num >= 65 && num <= 90) {
            int temp = num-65;
            num = 90-temp;
        }
        if (num >= 97 && num <= 122) {
            int temp = num-97;
            num = 122-temp;
        }
        return (char) num;

    }
}
