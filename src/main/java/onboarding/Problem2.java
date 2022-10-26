package onboarding;

public class Problem2 {
    /**
     * @Problem: 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
     * @Example
     * "browoanoommnaon"
     * "browoannaon"
     * "browoaaon"
     * "browoon"
     * "brown"
     */


    /**
     * @Method: deleteContinuousCharacter
     * 문자열을 입력받아 중복된 문제를 삭제한다.
     * TODO: 문자열에서 앞뒤 값이 같은 index의 경우, return할 문자열에 추가하지 않는다.
     */
    private static String deleteContinuousCharacter(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        cryptogram = cryptogram + '!'; // 허수 추가
        char temp = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            char next = cryptogram.charAt(i);
            if (temp != next) {
                sb.append(temp);
                temp = next;
            } else {
                temp = cryptogram.charAt(++i);
            }
        }
        return sb.toString();
    }


    /**
     * @Method: decodeCryptogram
     * deleteContinuousCharacter를 반복하여, 입려받은 cryptogram을 복호화 한다.
     * TODO: 입력한 문자열과, return된 문자열의 길이를 비교하여, 반복 여불을 결정한다.
     * TODO: 중복되는 문자열이 없을 때 까지 반복한다.
     */


    /**
     * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
     * @Method: Solution
     * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
     * TODO: 복호화된 문자열을 return한다.
     */

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
