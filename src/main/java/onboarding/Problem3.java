package onboarding;

public class Problem3 {
    public static int checkClap(int number) {
        int clap = 0;
        while (number != 0) {
            int value = number % 10;
            if (value == 3 || value == 6 || value == 9)
                clap += 1;
            number /= 10;
        }
        return clap;
    }
    public static int solution(int number) {
        int answer = 0;
        while (number > 0) {
            answer += checkClap(number);
            number -= 1;
        }
        return answer;
    }
}
