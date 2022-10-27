package onboarding;

public class Problem3 {
    public static int checkTotalClapCount(int number) {
        int totalCount = 0;
        for(int i = 1; i <= number; i ++) {
            totalCount += clapCount(i);
        }
        return totalCount;
    }
    public static int clapCount(int number) {
        int count = 0;
        int currentDigit = 0;
        while(number > 0) {
            currentDigit = number % 10;
            count += checkThreeSixNine(currentDigit);
            number /= 10;
        }
        return count;
    }
    public static int checkThreeSixNine(int number) {
        if(number == 3 || number == 6 || number == 9) {
            return 1;
        }
        return 0;
    }
    public static int solution(int number) {
        int answer = checkTotalClapCount(number);
        return answer;
    }
}
