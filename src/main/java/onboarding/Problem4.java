package onboarding;


/**
 * 요구사항
 * word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
 * 알파벳 외의 문자는 변환하지 않는다.
 * 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 * | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
 * | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
 * | Z | Y | X | W | V | U | T | S | R | Q | P | O | N | M | L | K | J | I | H | G | F | E | D | C | B | A |
 */

/**
 * 설계
 * 주어진 String 를 char 단위로 나눈다
 * char 를 소문자 또는 대문자 일 때 위의 표대로 변환
 * 변환된 char를 Stringbuilder 에 추가한다.
 * 최종 변환된 String return
 */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = reverse(word);
        return answer;
    }

    public static String reverse(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<word.length(); i++) {
            char nowChar = word.charAt(i);

            if (nowChar>='A' && nowChar<='Z')
                sb.append((char)((char)155 - nowChar));
            else if (nowChar>='a' && nowChar<='z')
                sb.append((char)((char)219 - nowChar));
            else
                sb.append(nowChar);
        }

        return sb.toString();
    }
}
