package onboarding;

public class Problem3 {
    public static int checkClap(int number) {
        int clap = 0;
        for (; number != 0; number /= 10) {
            int value = number % 10;
            if (value == 3 || value == 6 || value == 9)
                clap ++;
        }
        return clap;
    }
    public static int solution(int number) {
        if (number < 1 || number > 10000)
            return -1;
        int answer = 0;
        for (; number > 0; number--)
            answer += checkClap(number);
        return answer;
    }
}
