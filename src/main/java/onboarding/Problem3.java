package onboarding;

public class Problem3 {

    public static int checkNum(int num) {
        int clap = 0;
        String numString = String.valueOf(num);

        for (int i = 0; i < numString.length(); i++) {
            if (numString.charAt(i) == '3' || numString.charAt(i) == '6' || numString.charAt(i) == '9') {
                clap ++;
            }
        }
        return clap;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i ++) {
            answer += checkNum(i);
        }

        return answer;
    }
}
