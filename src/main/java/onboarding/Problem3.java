package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String num = String.valueOf(i);
            answer += count369(num);
        }
        return answer;
    }

    private static int count369(String num) {
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            int target = num.charAt(i) - '0';
            if (target == 3 || target == 6 || target == 9) {
                count++;
            }
        }
        return count;
    }
}
