package onboarding;

/**
 * 청개구리 문제
 *
 * 문제 설명 :
 * 어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.
 * 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
 *
 *  A	B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
 *  Z	Y	X	W	V	U	T	S	R	Q	P	O	N	M	L	K	J	I	H	G	F	E	D	C	B	A
 *
 * 제한사항
 * - word는 길이가 1 이상 1,000 이하인 문자열이다.
 * - 알파벳 외의 문자는 변환하지 않는다.
 * - 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 *
 * @author      scyllacore
 * @version     1.1 2022/10/31
 */

public class Problem4 {
    /*
     * 구현 사항
     * 1. setLetterCaseMappingTable : 대문자,소문자 나눠서 청개구리 사전에 따라 문자 mapping.
     * 2. getChangedString : mapping 배열을 가지고 문자열 변환.
     * 3. solution : 변경시킨 최종 문자열 반환.
     */

    /** 대문자 mapping 사전 */
    static int upperCase[] = new int[26];
    /** 소문자 mapping 사전 */
    static int lowerCase[] = new int[26];

    /**
     * 1. array의 0~25 index 번호는 각 알파벳을 의미하는 수로 사용하고,각 index 안에는 mapping시킬 알파벳을 할당.
     */
    static void setLetterCaseMappingTable() {
        for (int i = 0; i < 26; i++) {
            upperCase[i] = 'Z' - i;
            lowerCase[i] = 'z' - i;
        }
    }

    /**
     * 2. 대문자,소문자,공백을 따져 mapping 배열값에 접근하고, 접근한 index값을 통해 문자열 변환.
     *
     * @param str 원본 문자열.
     * @return 변환된 문자열.
     */
    static String getChangedString(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                newStr += (char) upperCase[ch - 'A'];
            } else if (Character.isLowerCase(ch)) {
                newStr += (char) lowerCase[ch - 'a'];
            } else if (Character.isSpaceChar(ch)) {
                newStr += ' ';
            }
        }

        return newStr;
    }

    /**
     * 3. 최종적으로 변환된 문자열 반환.
     *
     * @param word 원본 문자열.
     * @return 최종 변환된 문자열.
     */
    public static String solution(String word) {
        setLetterCaseMappingTable();
        String answer = getChangedString(word);
        return answer;
    }
}
