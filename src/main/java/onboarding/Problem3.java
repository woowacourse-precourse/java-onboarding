package onboarding;



public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) answer += check(i);

        return answer;
    }

    static int check(int num) {
        int count = 0;

        while (num > 2) {
            if (num % 10 != 0 && (num % 10) % 3 == 0) {
                count++;
            }
            num /= 10;
        }

        return count;
    }
}