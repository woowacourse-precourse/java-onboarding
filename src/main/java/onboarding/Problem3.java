package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = countNum(number);
        return answer;
    }
    private static int countNum(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int current = i;
            while (current != 0) {
                int remainder = current % 10;
                if(remainder == 3 || remainder == 6 || remainder == 9) {
                    answer++;
                }
                current /= 10;
            }
        }
        return answer;
    }
}
