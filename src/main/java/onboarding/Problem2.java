package onboarding;

/**
 * 중복 문자 제거 문제
 *
 * 문제 설명 :
 * 암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다.
 * 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
 *
 * "browoanoommnaon"
 * "browoannaon"
 * "browoaaon"
 * "browoon"
 * "brown"
 *
 * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항
 * - cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
 * - cryptogram은 알파벳 소문자로만 이루어져 있다.
 */

public class Problem2 {

    /*
    * 구현 사항
    * 1. isDuplicates : 중복 확인
    * 2. 중복이 있을시 중복을 제거
    * 1,2를 중복이 제거 될 때 까지 반복됨.
    */

    /**
     * 1. 중복이 존재하는지 확인
     * @param str 검사할 문자열
     * @return 문자열에서 중복이 시작되는 지점 반환. 중복이 없을 시 -1.
     */
    static int isDuplicates(String str){

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)) return i;
        }

        return -1;      // 0을 idx번호로 사용할 수 있기 때문에 -1로 반환한다.
    }

    /**
     * 2.
     * @param cryptogram
     * @return
     */
    static String removeDuplicates(String cryptogram){

        String newCryptogram = cryptogram;

        for(;;) {

            int start = isDuplicates(newCryptogram);

            if (start == -1) {
                return newCryptogram;
            }

            int end = start + 1;

            for (; end < newCryptogram.length(); end++) {
                if (newCryptogram.charAt(start) != newCryptogram.charAt(end)) break;
            }
            newCryptogram = newCryptogram.substring(0, start) + newCryptogram.substring(end);
        }


    }

    public static String solution(String cryptogram) {
        String answer = removeDuplicates(cryptogram);
        return answer;
    }
}
