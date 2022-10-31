package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String num = "";
        char n = 0;

        for (int i = 1; i <= number; i++) {
            num = Integer.toString(i);
            for (int j = 0; j < num.length(); j++) {
                n = num.charAt(j);
                if (n == '3' || n == '6' || n == '9') {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
