package onboarding;

/**
 * @Problem: 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
 */
public class Problem4 {
    /**
     * @Method: changeAlphabet
     * 아스키 코드를 기반은로 각 문자를 수정한다.
     * 1. 소문자의 경우 122 - (char - 97)
     * 2. 대문자의 경우 90 - (char - 65)
     * 3. 나머지 값에 대해서는 그대로
     */


    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            char next;

            // 1. 소문자의 경우 122 - (char - 97)
            if (97 <= temp && temp <= 122){
                next = (char) (122 - (temp - 97));
            }

            // 2. 대문자의 경우 90 - (char - 65)
            else if(65 <= temp && temp <= 90) {
                next = (char) (90 - (temp - 65));
            }

            // 3. 나머지 값에 대해서는 그대로
            else {
                next = temp;
            }
            answer.append(next);
        }
        return answer.toString();
    }
}
