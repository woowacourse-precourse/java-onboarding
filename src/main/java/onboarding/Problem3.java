package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int n = 0; n <= number; n++) {
            String str = Integer.toString(n);
            int count = (int) str.chars().filter(s -> s == '3' || s == '6' || s == '9').count();
            answer += count;
        }
        return answer;
    }
}
