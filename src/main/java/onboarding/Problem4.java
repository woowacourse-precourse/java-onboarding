/**
 * 클래스 이름
 * - 문제 4
 *
 * 버전정보
 * - openjdk version "11.0.15"
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        int[] conversionTable = new int[26];

        // 알파벳 변환 테이블 초기화
        for (int i = 1; i <= 26; i++) {
            conversionTable[i - 1] = 26 - (2 * i - 1);
        }

        // 변환 시작
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 알파벳이 아니면 변환하지 않는다.
            if(!isAlpha(c)) {
                answer+=c;
                continue;
            }

            // 대문자라면 대문자로 변환, 소문자면 소문자로 변환
            if(isCapital(c)) {
                c += conversionTable[c - 'A'];
                answer+=c;
            } else {
                c += conversionTable[c - 'a'];
                answer+=c;
            }

        }

        return answer;
    }
    // 대문자인지 판별
    private static boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }

    // 알파벳인지 판별
    private static boolean isAlpha(char c) {
        if(c>='a' && c<='z') return true;
        return c >= 'A' && c <= 'Z';
    }

}
