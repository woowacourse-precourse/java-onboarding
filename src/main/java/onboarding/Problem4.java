package onboarding;

public class Problem4 {
    public static String solution(String word) {
        /*
        조건 1 : word는 길이가 1이상 1000 이하인 문자열이다.
        조건 2 : 알파벳 외의 문자는 변환하지 않는다
        조건 3 : 알파벳 대문자는 대문자로, 소문자는 소문자로 변환한다.
        A	B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
        Z	Y	X	W	V	U	T	S	R	Q	P	O	N	M	L	K	J	I	H	G	F	E	D	C	B	A

        구현 메서드
        조건 1 :  word의 길이가 1이상 1000이하로 주어진다.
        검증 1 : word에 알파벳과 띄어쓰기 외 문자는 변환하지 않는다.
        검증 2 : 대문자는 대문자로, 소문자는 소문자로 변환한다. >> 아스키코드로 판별
         */

        String answer = "";

        //검증 1,2
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                answer += (char) ('A' + 'Z' - (word.charAt(i)));
            } else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                answer += (char) ('a' + 'z' - word.charAt(i));
            } else {
                answer += word.charAt(i);
            }
        }

        return answer;
    }
}


