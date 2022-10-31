package onboarding;

/**
 * @작성자 rjsah09
 * @작성일 2022.10.31
 *
 * @수정내역
 * */

public class Problem4 {
    public static String solution(String word) {
        String answer = getAnswer(word);
        return answer;
    }

    private static char getReversed(char c) {
        int diff;

        if(Character.isUpperCase(c)) {
            diff= c - (int)'A';
            return (char)('Z' - diff);

        } else {
            diff = c - (int)'a';
            return (char)('z' - diff);
        }
    }

    private static String getAnswer(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(Character.isAlphabetic(c)) {
                answer += getReversed(c);
            } else {
                answer += c;
            }
        }

        return answer;
    }
}
