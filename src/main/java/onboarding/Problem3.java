package onboarding;

public class Problem3 {
    /**
     * 손뼉 카운트 메서드
     * @param n 369게임 시 부르는 숫자
     * @return 부르는 숫자에 들어가는 3,6,9의 개수
     */
    public static int countClap(int n) {
        int clap = 0;
        while (n > 0) {
            int r = n % 10;
            n = n / 10;
            if (r == 3 || r == 6 || r == 9) {
                clap++;
            }
        }
        return clap;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int n = 1; n <= number; n++) {
            answer += countClap(n);
        }
        return answer;
    }
}
