package onboarding;

public class Problem3 {
    public static int countClap(int number) {
        return (int) String.valueOf(number)
                .chars()
                .filter(o -> o == '3' || o == '6' || o == '9')
                .count();
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            answer += countClap(i);
        }

        return answer;
    }
}
