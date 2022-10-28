package onboarding;

/** 구현해야 할 기능
 * number를 String으로 변환
 * String에서 3 or 6 or 9 카운트
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i<= number; i++) {
            String numToStr = String.valueOf(i);

            for(int j = 0; j< numToStr.length(); j++) {
                if(numToStr.charAt(j) == '3' || numToStr.charAt(j) == '6' || numToStr.charAt(j) == '9')
                    answer++;
            }
        }
        return answer;
    }
}
