package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; ++i)
            answer += String.valueOf(i).chars().filter(e -> e == '3' || e == '6' || e == '9').count();
        return answer;
    }
}
