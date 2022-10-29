package onboarding;

public class Problem3 {

    public static int solution(int number) {
        if (number <= 2) {
            return 0;
        }

        int howManyNums = countHowManyNums(number);;
        return howManyNums;
    }

    private static int countHowManyNums(int number) {
        int tmpHowManyNums = 0;
        String strNumber = "";

        for (int i = 3; i <= number; i++) {
            strNumber = String.valueOf(i);
            for (int j = 0; j < strNumber.length(); j++) {
                if (strNumber.charAt(j) == '3' || strNumber.charAt(j) == '6' || strNumber.charAt(j) == '9') {
                    tmpHowManyNums++;
                }
            }
        }

        return tmpHowManyNums;
    }
}
