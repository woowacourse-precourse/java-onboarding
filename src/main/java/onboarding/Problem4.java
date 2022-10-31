package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 기능 구현
 * 1. 소문자 알파벳 반대로, 대문자 알파벳 반대로 된 문자열 변수 생성.
 * 2. 대문자인지 소문자인지 판별
 * 3. 인덱스를 통해 알맞은 문자로 넣어주기
 * 4. 알파벳이 아니라면 문자열에 넣기
 */
public class Problem4 {
    static String alphabet = "zyxwvutsrqponmlkjihgfedcba";
    static int gap = 'A' - 'a'; /** 소문자에서 갭을 더하면 대문자가 됨. */
    public static String solution(String word) {
        String answer = "";
        char letter;

        for (int i = 0; i < word.length(); i++){
            letter = word.charAt(i);
            if (!Character.isAlphabetic(letter)){
                answer += letter;
            } else if (Character.isUpperCase(letter)){
                answer += (char)(alphabet.charAt(word.charAt(i) - 'A') + gap);
            } else {
                answer += alphabet.charAt(word.charAt(i) - 'a');
            }
        }
        return answer;
    }
}
