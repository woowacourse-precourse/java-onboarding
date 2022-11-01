package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String stringNum = Integer.toString(i);
            answer += clapNumber(stringNum);
        }

        return answer;
    }

    public static int clapNumber(String num) {
        int checkNum = 0;

        for (int j = 0; j < num.length(); j++) {
            if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
                checkNum++;
            }
        }

        return checkNum;
    }
}
