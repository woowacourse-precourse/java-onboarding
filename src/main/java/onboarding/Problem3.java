package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] clapCount = new int[10];

        for (int i = 1; i <= number; i++) {
            String[] numberSeat = String.valueOf(i).split("");
            for (int j = 0; j < numberSeat.length; j++) {
                ++clapCount[Integer.parseInt(numberSeat[j])];
            }
        }

        return 0;
    }
}
