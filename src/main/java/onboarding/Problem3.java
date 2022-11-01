package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = checkEachValue(number);
        return answer;
    }

    private static int checkEachValue(int number) {

        int sumCountClap = 0;

        for (int i = 1; i < number + 1; i++) {
            sumCountClap += isSatisfiedCondition(i);
        }

        return sumCountClap;
    }

    private static int isSatisfiedCondition(int uncheckNumber) {

        int countClap = 0;

        do{
            int remainder = uncheckNumber % 10;
            if(remainder == 3 || remainder == 6 || remainder == 9) countClap += 1;
            uncheckNumber /= 10;
        } while (uncheckNumber != 0);

        return countClap;
    }
}
