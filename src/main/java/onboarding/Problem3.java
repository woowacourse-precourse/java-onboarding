package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int count = 0;
        int tmp = 0;

        for (int i = 1; i <= number; i++) {
            tmp = i;
            while (tmp > 0) {
                if (tmp % 10 == 3 ||
                        tmp % 10 == 6 ||
                        tmp % 10 == 9) {
                    count++;
                }
                tmp /= 10;
            }
        }
        System.out.println(count);
        answer = count;

        return answer;
    }
}
