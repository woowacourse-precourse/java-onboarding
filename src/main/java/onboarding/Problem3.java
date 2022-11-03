package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = getGameResult(number);
        return answer;
    }

    public static int getGameResult(int number) {
        int count = 0;
        for(int i = 1; i <= number; i++) {
            count += countClapsPerANumber(i);
        }
        return count;
    }

    public static int countClapsPerANumber(int number) {
        int count = 0;
        for(int temp = number; temp > 0; temp /= 10) {
            int placeValue = temp % 10;
            count += (placeValue == 3 || placeValue == 6 || placeValue == 9) ? 1 : 0;
        }
        return count;
    }
}