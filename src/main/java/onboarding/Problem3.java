package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number+1; i++) {
            int targetNumber = i;
            answer += countThreeSixNine(targetNumber);
        }

        return answer;
    }

    private static int countThreeSixNine(int num) {
        int count = 0;
        String strNum = String.valueOf(num);

        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '3' || strNum.charAt(i) == '6' || strNum.charAt(i) == '9') {
                count++;
            }
        }

        return count;
    }
}
