package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int totalNumberOfClaps = 0;

        for (int i = 1; i <= number; i++) {
            int currentNum = i;

            while (currentNum != 0) {
                boolean isContain = isContainThreeSixNine(currentNum);

                totalNumberOfClaps += countNumberOfClaps(isContain);

                currentNum /= 10;
            }
        }

        return totalNumberOfClaps;
    }

    public static boolean isContainThreeSixNine(int number) {
        return number % 10 == 3 || number % 10 == 6 || number % 10 == 9;
    }

    public static int countNumberOfClaps(boolean bool) {
        int count = 0;

        if (bool) {
            count++;
        }

        return count;
    }
}