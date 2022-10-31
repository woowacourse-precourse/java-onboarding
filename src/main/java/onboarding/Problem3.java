package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += check369(i);
        }

        return answer;
    }

    public static int check369(int n) {
        String number = Integer.toString(n);

        int clap = 0;
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                clap += 1;
            }
        }

        return clap;
    }
}
