package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += ClapNum(i);
        }

        return answer;
    }

    static int ClapNum(int num) {
        int clap_num = 0;

        while (num > 0) {
            if ((num % 10) != 0 && (num % 10) % 3 == 0) clap_num += 1;
            num /= 10;
        }

        return clap_num;
    }
}
