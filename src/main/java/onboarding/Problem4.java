/*----------------------------------------------------------------------------------------
 * Author: 조형준
 * Date: 2022/11/01
 * Objective:
 *   1. word 안의 character 들의 ascii 값을 활용
 *   2. 소문자와 대문자에서 변환하는 과정에서 offset이 달라야 함
 *   3. 글자 외에 공백 등의 문자 등은 변환이 진행되지 않도록 유의
 *   4. 문자 치환 과정에서 substring 메서드를 활용하면 유용
 *---------------------------------------------------------------------------------------*/
package onboarding;

public class Problem4{
    public static String solution(String word) {
        int offset = 0;
        int len = word.length();
        char c;
        for (int i = 0; i < len; i++) {
            c = word.charAt(i);
            if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                if ('A' <= c && c <= 'Z') {
                    offset = 'Z'+'A';
                } else if ('a' <= c && c <= 'z') {
                    offset = 'z'+'a';
                }
                c = (char)(-(int)(word.charAt(i)) + offset);
                word = word.substring(0, i) + c + word.substring(i+1);
            }
        }

        String answer = word;
        return answer;
    }
}
