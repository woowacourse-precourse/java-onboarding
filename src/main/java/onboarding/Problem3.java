package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int cloneNumber = number;
        int placeValue = 1;

        while (cloneNumber != 0) {
            answer += count369(placeValue, number);
            cloneNumber /= 10;
            placeValue *= 10;
        }
        return answer;
    }

    private static int count369(int placeValue, int number) {
        int dividend = placeValue * 10;
        int count = number / dividend * 3 * placeValue;
        int remainder = number % placeValue;
        int additionalNumber = (number % dividend) / placeValue;

        if (additionalNumber == 9) {
            count += placeValue * 2 + remainder + 1;
        } else if (additionalNumber > 6) {
            count += placeValue * 2;
        } else if (additionalNumber == 6) {
            count += placeValue * 1 + remainder + 1;
        } else if (additionalNumber > 3) {
            count += placeValue * 1;
        } else if (additionalNumber == 3) {
            count += remainder + 1;
        }
        return count;
    }
}
