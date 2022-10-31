package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n <= number; n++) {
            answer += checkCount(n);
        }

        return answer;


    public static int checkCount(int number) {
        int count = 0;

        while (number != 0) {
            if ((number % 10) != 0 && ((number % 10) % 3) == 0) {
                count += 1;
            }
            number /= 10;
        }

        return count;
    }

}
