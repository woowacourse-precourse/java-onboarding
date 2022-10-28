package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int n = 0; n <= number; n++){
            String strN = Integer.toString(n);
            long count = strN.chars()
                    .filter(ch -> ch == '3' || ch == '6' || ch == '9')
                    .count();
            answer += count;
        }

        return answer;
    }
}
