package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = countThreeSixNineNumber(number);

        return answer;
    }

    private static int countThreeSixNineNumber(int number) {
        int count = 0;

        for(int i = 1 ; i <= number ; ++i) {
            count += findFactor(i);
        }

        return count;
    }

    private static int findFactor(int number) {
        int count = 0;

        while (number>0) {
            int digit = number % 10;

            if(digit == 3 || digit == 6 || digit == 9)
                count++;

            number /= 10;
        }

        return count;
    }
}
