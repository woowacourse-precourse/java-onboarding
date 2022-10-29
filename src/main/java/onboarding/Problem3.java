package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int totalClapCount = 0;
        for (int i = 1; i <= number; i++) {
            totalClapCount += getClapCount(i);
        }

        return totalClapCount;
    }

    private static int getClapCount(int number) {
        int[] clapCount = new int[10];

        String[] numberSeat = String.valueOf(number).split("");

        for (int j = 0; j < numberSeat.length; j++) {
            ++clapCount[Integer.parseInt(numberSeat[j])];
        }

        return clapCount[3] + clapCount[6] + clapCount[9];
    }
}
