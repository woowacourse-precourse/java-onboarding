package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        /*숫자 하나씩 대기*/
        for (int i = 1; i <= number; ++i) {
            int clap = i;
            /*숫자 3,6,9 보일 시 손뼉 치기*/
            answer = numberOfClap(clap, answer);
        }

        return answer;
    }

    private static int numberOfClap(int clap, int answer) {
        while (clap != 0) {
            if (clap % 10 == 3 || clap % 10 == 6 || clap % 10 == 9) {
                ++answer;
            }
            clap /= 10;
        }
        return answer;
    }
}