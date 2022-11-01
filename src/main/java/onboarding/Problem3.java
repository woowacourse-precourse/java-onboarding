package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        answer = play365Game(number);

        return answer;
    }

    private static int play365Game(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            String str = "" + i;
            sum += checkNumberin365(str);
        }
        return sum;
    }

    private static int checkNumberin365(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char num = str.charAt(i);
            if (num == '3' || num == '6' || num == '9') {
                cnt += 1;
            }
        }
        return cnt;
    }
}
