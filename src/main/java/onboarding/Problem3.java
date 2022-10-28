package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int[] ints = fillinArrayNumbers(number);

        return answer;
    }

    private static int[] fillinArrayNumbers(int number) {
        int[] tmp = new int[number];

        for (int i = 1; i <= number; i++) {
            tmp[i - 1] = i;
        }

        return tmp;
    }
}
