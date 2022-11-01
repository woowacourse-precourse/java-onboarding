/**
 * 클래스 이름
 * - 문제 4
 *
 * 버전정보
 * - jdk-11.0.17
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 알파벳 변환테이블
        int[] conversionTable = new int[26];

        /*
           알파벳 변환 테이블 초기화
           알파벳이 변하는 차이만큼 저장
           ex) conversionTable[0]에는 'z'-'a' 초기화
         */
        for (int i = 1; i <= 26; i++) {
            conversionTable[i - 1] = 26 - (2 * i - 1);
        }

        return convert(word, conversionTable);
    }

    private static String convert(String word, int[] conversionTable) {
        String reuslt = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 알파벳이 아니면 변환하지 않는다 (제한사항 2)
            if(!isAlpha(c)) {
                reuslt +=c;
                continue;
            }

            // 대문자라면 대문자로 변환, 소문자면 소문자로 변환 (제한사항 3)
            if(isCapital(c)) {
                c += conversionTable[c - 'A'];
                reuslt +=c;
            } else {
                c += conversionTable[c - 'a'];
                reuslt +=c;
            }

        }
        return reuslt;
    }

    private static boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isAlpha(char c) {
        if(c>='a' && c<='z') return true;
        return c >= 'A' && c <= 'Z';
    }
}
