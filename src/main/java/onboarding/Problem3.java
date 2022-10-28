package onboarding;

public class Problem3 {

    private static final int[] threeSixNine = {3, 6, 9};

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += solveNumber(i);
        }
        return answer;
    }

    private static int solveNumber(int num) {
        int count = 0;
        while (num > 0) {
            int check = num % 10;

            for (int s : threeSixNine) {
                if (check == s) {
                    count++;
                }
            }

            num = num / 10;
        }
        return count;
    }

}
