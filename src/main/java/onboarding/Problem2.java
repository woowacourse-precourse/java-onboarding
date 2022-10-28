package onboarding;

// 기능 목록
// 1. 문자열을 분석하기 위해 문자열을 배열로 변환하는 기능.
// 2. 배열에서 연속된 중복된 문자들을 제거하는 기능.
// 2-1. 반복문을 사용해 String cryptogram 을 char[] gram_char 로 변경
// 2-2. gram_char 의 요소들을 비교하면서 연속되면서 중복되는 문자들을 찾는다
// 2-3. 제거한다.
// 3. 배열을 다시 문자열로 변환한 뒤 결과를 반환한다.

public class Problem2 {
    public static String solution(String cryptogram) {

        char[] gram_char = new char[cryptogram.length()];

        // char배열로 만듬
        for (int i =0; i < gram_char.length; i++) {
            gram_char[i] = cryptogram.charAt(i);
        }

        String answer = "answer";
        return answer;
    }
}
