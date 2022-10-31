package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int[] count = new int[10];
        int num;

        for (int i = 1; i <= number; i++) {
            num = i;
            while ( num > 0) {
                count[num % 10]++;
                num /= 10;
            }
        }

        answer = count[3] + count[6] + count[9];
        return answer;
    }
}
