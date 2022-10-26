package onboarding;

public class Problem3 {

    /** 기능 명세
     * 1. 게임하기
     *    - 숫자를 문자열로 바꾼 후, '3', '6', '9' 문자가 나오는 횟수를 충합하여 최종 박수 횟수 출력
     */

    public static int game(int number) {
        String numToStr;
        int clapCnt = 0;

        for (int i=1; i<number+1; i++){
            numToStr = Integer.toString(i);
            clapCnt += counter(numToStr, '3')
                     + counter(numToStr, '6')
                     + counter(numToStr, '9');
        }
        return clapCnt;
    }

    public static long counter(String numToStr, char ch) {
        return numToStr.chars().filter(c-> c == ch).count();
    }

    public static int solution(int number) {
        int answer = game(number);
        return answer;
    }
}
