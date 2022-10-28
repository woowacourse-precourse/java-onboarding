package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }

    static String duplicated(String cryptogram) {

    }
}
/**
 * abcdeee 이렇게 들어오면
 * abcd 로 나와야 함
 * a - b ok
 * b - c ok
 * c - d ok
 * d - e ok
 * e - e no -> 뒤에 한번 더 비교필요 - e 이렇게 되면 또 no -> 뒤에 한번 더 비교
 * 
 */

/**
 * cryptogram으로 들어온 값을 반복문을 통해
 * 순서대로 현재값과 다음값 그리고 또 다음값을 비교해서 다를 때 까지 제거를 하자
 */

/**
 * 원하는 데이터를 입력하면 duplicated 함수를 재귀식으로 동작하게 되면
 * return 을 타고 쭉 들어가서 마지막에 연속된 중복값이 나오지 않는 순간 해당 값을 return 하게 된다.
 */
