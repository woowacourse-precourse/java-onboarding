package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;
        for (int i = 1; i <= number; i++) {
            clap += count369(i);
        }
        return clap;
    }

    private static int count369(int num) {
        int cnt = 0;

        while(num>0) {
            int a = num % 10;
            if(a != 0 && a % 3 == 0) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }
}
