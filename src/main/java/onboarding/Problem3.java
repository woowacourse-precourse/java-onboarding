package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    private static int countClap(Integer num) {
        String tmpNum = num.toString();
        int clap = (int) tmpNum.chars()
                .filter(ch -> ch == '3' || ch == '6' || ch == '9')
                .count();
        return clap;
    }
}
