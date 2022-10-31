package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }
    
    private static int count369(int i) {
        int count = 0;
        while (i != 0) {
            if (is369(i)) {
                count++;
            }
            i /= 10;
        }
        return count;
    }

    private static boolean is369(int num) {
        return num % 10 != 0 && num % 10 % 3 == 0;
    }
}
