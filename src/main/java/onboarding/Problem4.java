package onboarding;

/**
 * 기능 요구사항
 * a. 문자를 주어진 사전(Z~A)으로 변환
 *
 * 제한 사항
 * - word는 길이가 1 이상 1,000 이하인 문자열
 * - 알파벳 외의 문자는 변환 X
 * - 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환
 */
public class Problem4 {

    /**
     * a. 문자를 주어진 사전(Z~A)으로 변환
     * @param character
     * @return 청개구리 사전으로 변환된 문자 반환
     */

    static char convert(char character){
        char res = character;
        if(Character.isLowerCase(res)){
            res = (char) ('z' - (res - 'a'));
        }else if(Character.isUpperCase(res)){
            res = (char) ('Z' - (res - 'A'));
        }
        return res;
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            answer.append(convert(word.charAt(i)));
        }

        return answer.toString();
    }
}