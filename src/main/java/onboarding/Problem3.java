package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapNumber = 0;

        int answer = 0;
        return answer;
    }

    public static int countMultipleOf3(int targetNumber){
        int numberOfDigit = 0;
        int numberOfMultipleOf3 = 0;
        while(targetNumber > 0){
            numberOfDigit = targetNumber % 10;
            targetNumber /= 10;
            if(numberOfDigit%3 == 0) numberOfMultipleOf3++;
        }
        return numberOfMultipleOf3;
    }
}
