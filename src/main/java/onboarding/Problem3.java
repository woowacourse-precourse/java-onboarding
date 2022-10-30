package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = countClap(number);

        return answer;
    }

    private static int count1Digit(int number){
        int clap = number / 3;

        return clap;
    }

    private static int count2Digits(int number){
        int clap = 0;
        int rest = number % 10;
        int ten = number / 10;

        clap += count1Digit(rest);
        if (ten == 0)
            return clap;

        clap += ten * 3;
        if (ten % 3 == 0) {
            clap += rest + 1 + (ten / 3 - 1) * 10;
        } else {
            clap += ten / 3 * 10;
        }

        return clap;
    }

    private static int count3Digits(int number){
        int clap = 0;
        int rest = number % 100;
        int hundred = number / 100;

        clap += count2Digits(rest);

        if (hundred == 0)
            return clap;

        clap += hundred * 3;
        if (hundred % 3 == 0) {
            clap += rest + 1 + (hundred / 3 - 1) * 100;
        } else {
            clap += hundred / 3 * 100;
        }

        return clap;
    }
    private static int count4Digits(int number){
        int clap = 0;
        int rest = number % 1000;
        int thousand = number / 1000;

        clap += count3Digits(rest);

        if (thousand == 0)
            return clap;

        if (thousand % 3 == 0) {
            clap += rest + 1 + (thousand / 3 - 1) * 100;
        } else {
            clap += thousand / 3 * 100;
        }

        return clap;
    }

    private static int countClap(int number) {
        if(number == 10000)
            return count4Digits(9999);

        return count4Digits(number);
    }

}
