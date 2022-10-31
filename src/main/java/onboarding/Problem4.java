/**
 * 기능 요구사항 :
 * word가 매개변수로 주어질 때, 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성한다.
 * <p>
 * 제한사항 :
 * 1. word는 길이가 1 이상 1000 이하인 문자열이다.
 * 2. 알파벳 외의 문자는 변환하지 않는다.
 * 3. 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 * <p>
 * 기능 목록 :
 * 1. String reverseWord(String word) 메서드 : 매개변수로 주어진 word를 청개구리 사전을 통해 변환한다.
 * 2. char reverseChar(char character) 메서드 : 매개변수로 주어진 character가 알파벳이라면, 청개구리 사전을 통해 변환한다.
 * 3. int checkAlphabet(char character) 메서드 : 매개변수로 주어진 character가 알파벳인지 판별하고, 알파벳이 아니라면 -1, 알파벳 대문자라면 0, 알파벳 소문자라면 1을 반환한다.
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = reverseWord(word); // 변환 완료된 문자열 저장
        return answer;
    }

    /**
     * 매개변수 word에 포함되어 있는 영어 알파벳을 청개구리 사전에 의해 변환하는 메서드
     *
     * @return 변환이 완료된 String 클래스 인스턴스를 반환
     */
    private static String reverseWord(String word) {
        String reversedWord = new String("");

        for (char c : word.toCharArray()) {
            reversedWord += reverseChar(c);
        }

        return reversedWord;
    }

    /**
     * 매개변수 character를 청개구리 사전에 의해 변환하는 메서드, 알파벳만을 변환함(A ~ Z, a ~ z)
     * 대문자 변환 : 155 - 변환할 알파벳 ascii code == 변환된 알파벳 ascii code
     * 소문자 변환 : 219 - 변환할 알파벳 ascii code == 변환된 알파벳 ascii code
     *
     * @return 변환이 완료된 char형 데이터
     */
    private static char reverseChar(char character) {
        if (checkAlphabet(character) == 0) {
            return (char) (155 - character);
        } else if (checkAlphabet(character) == 1) {
            return (char) (219 - character);
        } else {
            return character;
        }
    }

    /**
     * 매개변수로 주어진 charater가 알파벳인지, 알파벳이라면 소문자인지 대문자인지 판별함
     *
     * @return 알파벳이 아니라면 -1, 알파벳 대문자라면 0, 알파벳 소문자라면 1을 반환
     */
    private static int checkAlphabet(char character) {
        if (65 <= character && character <= 90) {
            return 0; // character가 대문자인 경우
        } else if (97 <= character && character <= 122) {
            return 1; // character가 소문자인 경우
        } else {
            return -1; // character가 알파벳이 아닌 경우
        }
    }

}
