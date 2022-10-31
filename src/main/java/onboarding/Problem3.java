package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 0; i <= number; i++) answer += clapCounter(i);
        return answer;
    }

    private static int clapCounter(int num) { // 박수 횟수 return
        int clap = 0;
        while (num != 0) {
            int i = num % 10;
            if (i == 3 || i == 6 || i == 9) clap++;
            num /= 10;
        }
        return clap;
    }
}


