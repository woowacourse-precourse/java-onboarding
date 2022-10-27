
package onboarding;

/**
 * 문제 분석
 * 1. 청개구리 사전을 보면 다음과 같은 규칙을 따른다.
 *          - 기존 문자(알파벳)의 사전순으로 몇번째 위치하는지 찾는다.
 *          - 알파벳의 사전 역순기준으로 위에서 구한 위치의 알파벳이 청개구리 사전의 출력값이다.
 * 2. 1번에서 구한 규칙을 로직화 하면 다음과 같다.
 *          - inputIndex(기존 문자의 사전순 인덱스) : 기존 알파벳 - ('A' or 'a')
 *          - outputResult(청개구리 사전의 출력값) : ('Z' or 'z') - InputIndex
 *          위 로직을 이용하여 기능을 구현할수가 있다.
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] outputResult = word.toCharArray();
        int inputIndex;
        for (int i = 0; i < outputResult.length; i++) {
            char ch = outputResult[i];
            if (ch >= 'A' && ch <= 'Z') {
                inputIndex = ch - 'A';
                outputResult[i] = (char) ('Z' - inputIndex);
            }else if(ch >= 'a' && ch <= 'z'){
                inputIndex = ch - 'a';
                outputResult[i] = (char) ('z' - inputIndex);
            }
        }
        answer = String.valueOf(outputResult);
        return answer;
    }
}
