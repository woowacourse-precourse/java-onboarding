package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int count369(Integer num) {
        String numString = num.toString();

        int cnt = 0;
        for (char numChar : numString.toCharArray()) {
            if (include369(numChar)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean include369(char num) {
        return num == '3' || num == '6' || num == '9';
    }
}
