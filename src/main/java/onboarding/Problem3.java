package onboarding;

public class Problem3 {
    public static int countNumber(int number) {
        int count = 0;
        int dividedNumber = number;
        while(dividedNumber != 0) {
            int digit = dividedNumber % 10;
            if(digit == 3 | digit == 6 | digit == 9) {
                count = count + 1;
            }
            dividedNumber = dividedNumber / 10;
        }

        return count;
    }

    public static boolean checkInput(int number) {
        if(number < 1 || number > 10000) {
            return false;
        }

        return true;
    }

    public static int solution(int number) {
        if(!checkInput(number)) {
            return 0;
        }

        int answer = 0;
        for(int i = 1 ; i <= number ; i++) {
            answer = answer + countNumber(i);
        }
        return answer;
    }
}
