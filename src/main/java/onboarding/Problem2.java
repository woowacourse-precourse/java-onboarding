/*-----------------------------------------------------------
 * Author: 조형준
 * Date: 2022/11/01
 * Objective:
 *   1. cryptogram의첫 문자부터 마지막-1 문자들을 바로 다음 문자와 비교하여 같은지 다른지
 *      판별하도록 함
 *   2. 같을 경우 둘을 지우고 해당 위치부터가 아닌 한 글자 앞부터 다시 비교할 수 있도록 작성
 *-----------------------------------------------------------*/
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char c1, c2;
        String s1, s2;
        int del_count = 0;
        int len = cryptogram.length();

        for (int i = 0; i < len - 1; i++) {
            c1 = cryptogram.charAt(i);
            c2 = cryptogram.charAt(i + 1);
            if (c1 == c2) {
                s1 = String.valueOf(c1);
                s2 = String.valueOf(c2);
                cryptogram = cryptogram.replaceFirst(s1 + s2, "");
                len -= 2; //이미 지나온 바로 앞글자가 중복 문자로서 지워질 수 있으므로(i++ 고려)
                del_count++;
                i -= 2;
            }
        }
        String answer = cryptogram;
        return answer;
    }
}
