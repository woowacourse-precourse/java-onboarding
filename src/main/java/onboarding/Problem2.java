package onboarding;

import java.util.ArrayList;

public class Problem2 {

    /** 기능 명세
     * 1. 중복 문자 찾아 삭제하기
     *    - 입력받은 문자열을 문자 배열(cryptoToArr)로 변환
     *    - 문자 배열 안에서 문자를 하나씩 꺼내어 이전 문자(previous)와 비교
     *    - 서로 같은 문자일 경우 : 이전 문자 삭제 후 previous를 그 이전 문자로 변경
     * 2. 결과 배열을 다시 문자열로 만들기
     *    - stringConverter
     */

    public static String decryptor(String cryptogram) {
        char[] cryptoToArr = cryptogram.toCharArray();
        ArrayList<Character> resultList = new ArrayList<Character>();
        char previous = 'A';    // 문제 조건에 입력값은 알파벳 소문자로만 이루어져 있다고 제시되어 있으므로 대문자 'A'로 지정

        for (char current : cryptoToArr) {
            if (previous == current) {
                resultList.remove(resultList.size()-1);
                if (resultList.size() == 0) { break; }  // Index error를 위한 예외처리
                previous = resultList.get(resultList.size()-1);
            }
            else {
                resultList.add(current);
                previous = current;
            }
        }
        return stringConverter(resultList);
    }

    public static String stringConverter(ArrayList<Character> resultList) {
        String str = "";
        for (char c : resultList) { str += c; }
        return str;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
