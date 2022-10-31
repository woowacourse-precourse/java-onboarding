package onboarding;


public class Problem4 {
//    기능 요구 사항
//  어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.
//
//  엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
//
//  A	B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
//  Z	Y	X	W	V	U	T	S	R	Q	P	O	N	M	L	K	J	I	H	G	F	E	D	C	B	A
//
//  제한사항
//  word는 길이가 1 이상 1,000 이하인 문자열이다.
//  알파벳 외의 문자는 변환하지 않는다.
//  알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
//
//  실행 결과 예시
//  word	        result
//  "I love you"	"R olev blf"

//    -- 요약 --
//    1. 매개변수 word를 정해진 규칙대로 변환하여 return 할것
//      1-1 A -> Z, C -> Y 이런식
//      1-2 대문자는 대문자로, 소문자는 소문자로
//      1-3 A ~ Z , Z ~ A 역순임.변환할 대 참조할 것
//    2. 알파벳외에 변환 금지
//    3. 1~1000 자 문자열

    public static String solution(String word) {
        String answer = "";
        answer = transWords(word);
        System.out.println("Success");
        return answer;
    }

    public static String transWords(String word) {
//        ASCII A : 65 ~ Z : 90 // a : 97 ~ z : 122
//        UpperCase, LowerCase 메서드 적용
//        대문자) 번환갑과 관계는 대칭이므로 변환전 값 + 변환후 값  = 155
//        소문자) 번환갑과 관계는 대칭이므로 변환전 값 + 변환후 값  = 219


        String result = "";
        for (int index = 0; index < word.length(); index++) {
            int wordCondition =  word.charAt(index);

            if (97 <= wordCondition && wordCondition <= 122) {  //소문자 조건
                result += (char) changeLowerWord(word.charAt(index));

            }
            else if (65 <= wordCondition && wordCondition <= 90) {  // 대문자 조건
                result += (char) changeUpperWord(word.charAt(index));
            }
            else {                                                 // 기타 조건
                result += word.charAt(index);
            }
    }
        return result;
}

    public static int changeUpperWord(int word) {
//        A , Z 합계는 65 + 90 = 155

        int result = 0;
        return result = 155 - word;
    }

    public static int changeLowerWord(int word) {
//        a , z 합계는 97 + 122 = 219
        int result = 0;
        return result = 219 - word;
    }
}
