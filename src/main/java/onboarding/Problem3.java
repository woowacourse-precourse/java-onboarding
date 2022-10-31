package onboarding;

public class Problem3 {

    //3, 6, 9 포함 갯수 찾기
    private static int cntClap(int number) {
        int cnt = 0;

        while(number > 0) {
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                cnt++;
            }
            number /= 10;
        }
        return cnt
    }

    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += cntClap(i);
        }
        return answer;
    }
}
