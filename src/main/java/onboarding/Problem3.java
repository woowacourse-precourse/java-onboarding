package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String numString = Integer.toString(i);
            long clap = numString.chars().filter(ch -> ch == '3' || ch == '6' || ch == '9').count();
            answer += clap;
        }

        return answer;
    }
}
