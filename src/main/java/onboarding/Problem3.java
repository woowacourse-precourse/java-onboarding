package onboarding;

public class Problem3 {
    public static int solution(int number) {
        /*
         * 기능 요구 사항
         * 2. 1번 메서드를 반복해서 사용하여 1 ~ number 까지의 전체 3, 6, 9 개수를 카운트
         * */
        int answer = 0;
        return answer;
    }

    /*
     * 기능 요구 사항
     * 1. 특정 숫자에 포함된 3, 6, 9의 갯수를 세기
     * */

    private static int count_369(int now_number) {
        int count = 0;
        while (now_number > 0) {
            int tmp = now_number % 10;
            if(tmp == 3 || tmp == 6 || tmp == 9) count ++;
            now_number /= 10;
        }
        return count;
    }
}
