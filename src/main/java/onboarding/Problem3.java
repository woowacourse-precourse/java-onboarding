package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
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