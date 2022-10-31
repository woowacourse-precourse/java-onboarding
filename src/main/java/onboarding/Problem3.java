package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int num = 1; num <= number; num++) {
            String numStr = String.valueOf(num);
            int tmp = num;
            for (int j = 0; j < numStr.length(); j++) {
                int n = tmp % 10;
                if (n == 3 || n == 6 || n == 9) {
                    answer += 1;
                }
                tmp /= 10;
            }
        }
        return answer;
    }
}
