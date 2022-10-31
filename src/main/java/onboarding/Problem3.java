package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += clap(i);
        }

        return answer;
    }

    public static int clap(int number){
        int claps = 0;
        while (number > 0){
            int digit = number % 10;
            if (digit % 3 == 0 && digit != 0) {
                claps += 1;
            }
            number /= 10;
        }
        return claps;
    }
}
