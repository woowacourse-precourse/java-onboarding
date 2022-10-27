package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int targetNumber = i;
            while (targetNumber > 0) {
                if(isThreeSixNine(targetNumber)) clapCount++;
                targetNumber /= 10;
            }
        }
        return clapCount;
    }

    static boolean isThreeSixNine(int number) {
        return (number % 10) == 3 || (number % 10) == 6 || (number % 10) == 9;
    }
}
